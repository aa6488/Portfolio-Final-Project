package kr.co.coco.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.coco.board.controller.CommentController;
import kr.co.coco.board.model.dao.DeclarationDAO;
import kr.co.coco.board.model.dao.InfoCommentDAO;
import kr.co.coco.board.model.dto.DeclarationDTO;
import kr.co.coco.board.model.dto.InfoCommentDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InfoCommentServiceImpl implements InfoCommentService {

	@Autowired
	private InfoCommentDAO infoCommentDAO;
	
	 @Autowired
		private DeclarationDAO declarationDao;
	
	@Autowired
	public InfoCommentServiceImpl(InfoCommentDAO infoCommentDAO) {
		this.infoCommentDAO = infoCommentDAO;
	}

	// 댓글 저장
	@Override
	public InfoCommentDTO save(InfoCommentDTO commentDTO) {
		return infoCommentDAO.save(commentDTO);
	}

	// 댓글 수 업데이트
	@Override
	public int countComments(int infoNo) {
		return infoCommentDAO.countComments(infoNo);
	}

	// 댓글 삭제
	@Override
	public int deleteById(int id) {
		return infoCommentDAO.delete(id);
	}

	// 댓글 번호로 게시글 번호 가져오기
	@Override
	public int getInfoNoFromComment(int infoCommentNo) {
		return infoCommentDAO.getInfoNoFromComment(infoCommentNo);
	}

	// 댓글 등록 시, info_comment_count 업데이트
	@Override
	public void increaseCommentCount(int infoNo) {
		infoCommentDAO.increaseCommentCount(infoNo);
	}
	
	//댓글 삭제 시, info_comment_count 업데이트
	@Override
	public void decreaseCommentCount(int infoNo) {
		infoCommentDAO.decreaseCommentCount(infoNo);
		
	}

	// 해당 게시글에 연결된 모든 댓글 삭제
	@Override
	public void deleteCommentsByPostId(int infoNo) {
		infoCommentDAO.deleteCommentsByPostId(infoNo);
	}

    // 댓글 수정
	@Override
	public InfoCommentDTO updateComment(int infoCommentNo, String commentContent) {
	    infoCommentDAO.updateComment(infoCommentNo, commentContent);
	    return infoCommentDAO.getCommentById(infoCommentNo);
	}

	//댓글 신고하기 
	@Override
	public boolean reportComment(DeclarationDTO declarationDto) {
		return declarationDao.report(declarationDto);
	}

	




}
