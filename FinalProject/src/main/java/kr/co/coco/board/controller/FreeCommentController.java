package kr.co.coco.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.coco.board.model.dto.DeclarationDTO;
import kr.co.coco.board.model.dto.FreeCommentDTO;
import kr.co.coco.board.model.service.FreeCommentService;
import kr.co.coco.board.model.service.FreeCommentServiceImpl;
import kr.co.coco.boardPush.model.dto.BoardPushDTO;
import kr.co.coco.boardPush.model.service.BoardPushServiceImpl;


@Controller
@RequestMapping("/freeComment")

public class FreeCommentController {

	@Autowired
    private FreeCommentServiceImpl freeCommentService;
	@Autowired
	private BoardPushServiceImpl pushService;

	// 댓글 등록
	@PostMapping("/SubmitRegistr")
	@ResponseBody
	public ResponseEntity<?> registerComment(@RequestBody FreeCommentDTO commentDTO, HttpSession session) {
	    Integer mNo = (Integer) session.getAttribute("no");
	    String mNick = (String) session.getAttribute("nickname");

	    if (mNo == null || mNick == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
	    }

	    // 생성자를 이용하여 세션에서 가져온 닉네임을 설정
	    commentDTO.setFreeCommentWriter(mNick);

	    commentDTO.setFreeCommentDate(new java.sql.Date(System.currentTimeMillis()));
	    commentDTO.setMNo(mNo);

	    try {
	        FreeCommentDTO savedComment = freeCommentService.save(commentDTO);

	        if (savedComment == null) {
	            // 저장 실패 처리
	            Logger logger = LoggerFactory.getLogger(CommentController.class);
	            logger.error("댓글 저장에 실패하였습니다.");
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 저장에 실패하였습니다.");
	        }else {
	        	Map<String, Object> param = new HashMap<>();
	        	param.put("nickname",mNick);
	        	// free_comment_no, free_comment_content
	        	List<BoardPushDTO> pushList = pushService.getFreeList(mNo);
	        	int freeBoardNo = 0;
	        	for(BoardPushDTO dto : pushList) {
	        		param.put("boardContent", dto.getPushContent());
	        		param.put("boardNo", dto.getComment_no());
	        		freeBoardNo = dto.getMNo();
	        	}
	        	// free_no를 통해서 free 게시판에 작성자 no를 가져와야함
	        	int getPushFreeNo = pushService.getPushFreeNo(freeBoardNo);
	        	param.put("mNo", getPushFreeNo);
	        	int freePushEnroll = pushService.freePushEnroll(param);
	        }

	        // 댓글 등록 후에 해당 게시글의 댓글 수 증가
	        freeCommentService.increaseCommentCount(savedComment.getFreeNo());

	        return ResponseEntity.ok(savedComment);

	    } catch (Exception e) {
	        Logger logger = LoggerFactory.getLogger(CommentController.class);
	        logger.error("댓글 저장 중 오류가 발생하였습니다.", e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 저장 중 오류가 발생하였습니다.");
	    }

	}


    // 특정 게시글 댓글 수 반환(새로고침 없이)
    @GetMapping("/count/{freeNo}")
    @ResponseBody
    public int countComments(@PathVariable int freeNo) {
        return freeCommentService.countComments(freeNo);
    }

    // 특정 게시글 댓글 수 업데이트
    @PostMapping("/updateCommentCount/{freeNo}")
    @ResponseBody
    public int updateCommentCount(@PathVariable int freeNo) {
        int commentCount = countComments(freeNo);

        // 업데이트된 댓글 수를 반환
        return commentCount;
    }

    // 댓글 삭제
    @DeleteMapping("/deleteComment/{freeCommentNo}")
    public ResponseEntity<String> deleteComment(@PathVariable int freeCommentNo) {

        // 댓글 삭제 전에 해당 게시글의 번호 가져오기
        int freeNo = getFreeNoFromComment(freeCommentNo);

        freeCommentService.deleteById(freeCommentNo);

        // 댓글 삭제 후에 해당 게시글의 댓글 수 업데이트
        freeCommentService.decreaseCommentCount(freeNo);

        return ResponseEntity.ok("댓글이 삭제되었습니다.");
    }

    
  //댓글 신고하기
  	@PostMapping("/reportComment")
  	public ResponseEntity<?> reportComment(@RequestBody DeclarationDTO declarationDto, HttpSession session) {
  		try {

  			Integer mNo = (Integer) session.getAttribute("no");

  			// 사용자 번호 세팅
  			declarationDto.setMNo(mNo);

  			// 신고 처리 로직 수행
  			boolean isSuccessful = freeCommentService.freeReportComment(declarationDto);

  			// 신고 처리 결과에 따른 응답
  			if (isSuccessful) {
  				// 신고 처리 성공 시 응답
  				return ResponseEntity.ok().build();
  			} else {
  				// 신고 처리 실패 시 응답
  				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("실패했음.");
  			}
  		} catch (Exception e) {
  			// 에러 발생 시 응답
  			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  		}
  	}
  	
  	
  	// 댓글 수정하기
  	@PostMapping("/updateComment")
  	public ResponseEntity<?> updateComment(@RequestBody FreeCommentDTO freeCommentDao) {
  	    int freeCommentNo = freeCommentDao.getFreeCommentNo();
  	    String commentContent = freeCommentDao.getFreeCommentContent();
  	    
  	    System.out.println("freeCommentNo: " + freeCommentNo);
  	    System.out.println("commentContent: " + commentContent);
  		
  	  FreeCommentDTO isUpdated = freeCommentService.updateComment(freeCommentNo, commentContent);

  	    if (isUpdated  != null) {
  	        return ResponseEntity.ok().build();
  	    } else {
  	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 수정에 실패하였습니다.");
  	    }
  	}



  	// 댓글 번호로 게시글 번호 가져오기
  	private int getFreeNoFromComment(int freeCommentNo) {
  		return freeCommentService.getFreeNoFromComment(freeCommentNo);
  	}
	
}