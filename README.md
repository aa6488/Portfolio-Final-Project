# COCO 프로젝트 (협업 일정관리 및 커뮤니티 웹 프로젝트)

<p align="center">
  <br>
  <img src="./images/메인.jpg">
  <br>
</p>

## 프로젝트 소개

- COCO 프로젝트는 자신의 아이디어를 구상하고 팀원을 모아 서로가 협동 및 협력하여 Project를 만드는
  개발자들의 일정관리 및 협업 환경을 제공해주는 서비스와 더불어 개발자들의 정보 공유 게시판 및 프로젝트 추천, 자유 게시글을 만들 수 있는 웹페이지 프로젝트 입니다.


  
- 진행기간 : 2024년 01월 18일 → 2024년 02월 26일 의 기간동안 진행했습니다.

<br>

## 팀원소개 & 기능

- COCO 프로젝트는 총 3가지 페이지로 구성되어있으며 협업을위한 페이지, 커뮤니티를위한 페이지, 관리자 페이지 로 나눠져있습니다.<br>
  저는 그중 협업을위한 페이지를 담당하게 되었습니다.

<p align="center">
  <br>
  <img src="./images/팀원기능.jpg">
  <br>
</p>

<br>


## ERD CLOUD
<p align="center">
  <br>
  <img src="./images/ERD.jpg">
  <br>
</p>

## 기술 스택

<p align="center">
  <br>
  <img src="./images/기술스택.jpg">
  <br>
</p>

<br>

## 내 기능 구현 주요 이미지 

### 1. 프로젝트 생성, 수정
<br>
<img width="800px;" src="https://github.com/aa6488/Portfolio-Final-Project/assets/150643187/2ce340a0-504a-4c47-9463-ae002cdb4b31">
<br><br>

**1.** 원하는 프로젝트를 생성할수 있고, 생성시 DB에 반영되며 왼쪽 프로젝트 목록에 추가되게 되고, 기본이미지는 모자쓴 캐릭터 입니다. (이미지 추가가 가능합니다)<br><br>
**2.** 프로젝트를 수정하게되면 DB에 반영되고 이미지 또한 수정이 가능합니다. (기존 이미지있을시 DB에서 삭제, 서버에 저장된 이미지 삭제 -> 새로운 이미지 추가)<br><br>
 

<hr>

### 2. 프로젝트 개별 기능 완성도 퍼센트 
<br>
<img width="800px;" src="https://github.com/aa6488/Portfolio-Final-Project/assets/150643187/5eed6804-bce5-426b-a441-0050a99a31df"> 
<br><br>

**1.** **프로젝트 별로 맡은 기능을 추가**할수 있고 **완성도 퍼센트를 그래프로** 나타나게 만들었습니다<br><br>
**2.** 완성도 퍼센트를 수정할수 있고 삭제 또한 가능하게 됩니다. (해당 기능들은 Oracle DB 에 저장됩니다.)<br><br>
**3.** DB에 저장된 퍼센트는 해당 프로젝트 메인페이지 에서 front영역, back영역, (front+back : 전체영역) 으로 달성도를 평균치로 나타내게 만들었습니다. 

<hr>



### 3. 프로젝트 ToDo List 작성
<br>
<img width="800px;" src="https://github.com/aa6488/Portfolio-Final-Project/assets/150643187/24d6b85e-108e-4dcf-9356-f7b42f217ffc"> 
<br><br>

**1.** **캘린더 TO DO List** 를 **월단위, 일단위 계획**을 세울수 있게 만들어놓았습니다.<br><br>
**2.** **DB에 저장된 월, 일단위 일정은 메인페이지에서 한번에 볼수있게** 만들어 놓았습니다.<br><br>

<hr>

### 4. 팀 공지 게시판, 그림판 작성
<br>
<img width="800px;" src="https://github.com/aa6488/Portfolio-Final-Project/assets/150643187/19d0d168-3512-4abb-9427-c8631e74d915"> 
<br><br>

**1.** 팀단위 공지를 게시할수있는 게시판을 만들어놓았고, 기본적인 CRUD 만 가능합니다.<br><br>
**2.** 홈페이지에 자체 그림판을 구현해 개인 pc에 저장할수있게 만들어놓았습니다.<br><br>

### 5. 유효성 검사
<br>
<img width="800px;" src="https://github.com/aa6488/Portfolio-Final-Project/assets/150643187/dd1a15a7-6c0c-4406-90c0-206e82bd7b46"> 
<br><br>

**1.** **상위 1,2,3,4 구현기능에 대해 입력값 전부에 대해 null 체크와 DB테이블 크기에 맞는지에 대한 유효성 검사를 추가했습니다**.<br><br>

<hr>

### 6. AOP 설정 
<br>
<img width="800px;" src="https://github.com/aa6488/Portfolio-Final-Project/assets/150643187/abac5c27-0716-4803-bebe-7777b840b590">
<br><br>

**1.** **협업페이지 접근시 로그인된 유저인지 판단하기위해 인터셉터 설정**을 했습니다. <br><br>
**2.** 프로젝트의 각 기능에 접근하기위해 **프로젝트 생성, 참여 여부를 확인**하기위해 인터셉터 설정을 했습니다. <br><br>
**3.** **리소스 낭비를 방지**하기위해 해당되는 페이지, 기능 Controller 에 접근하기전에 **인터셉터 처리를 preHandle 메서드**에 구현했습니다. <br><br>


<hr>

### 7. 프로젝트 별 구분방법
<br>
<img width="800px;" src="https://github.com/aa6488/Portfolio-Final-Project/assets/150643187/108d223f-7de4-418a-be61-ab5a48812633">
<br><br>

**1.** **프로젝트별로 기능을 구분하기위해 Session 을 사용**했습니다. **프로젝트 목록을 선택시 DB에 저장되어있는 프로젝트 PK 값으로 Session 을 생성**하게됩니다.<br><br>
**2.** 이후 **프로젝트 관련 기능들은 생성된 Session 을 바탕으로 DB에 저장되고 꺼내**오게 됩니다.<br><br>

<hr>

### 8. 알림, 채팅

**1.** 프로젝트 알림, 채팅은 **github wiki에 자세히 설명**해두었습니다.

<br><br>


<hr>

## 내 기능 구현 영상
#### 상세 기능 설명은 각 페이지별 링크 연결해두었습니다.
####  [1. 프로젝트 생성 & 사용자 초대 & (월간,일간)일정등록 및 초대알림(알림부분 마지막설명)](https://github.com/aa6488/Portfolio-Final-Project/wiki/%F0%9F%93%83-%EA%B8%B0%EB%8A%A5-%EC%83%81%EC%84%B8%EC%84%A4%EB%AA%85#1-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%83%9D%EC%84%B1)

<img width="100px;" src="https://github.com/aa6488/Portfolio-Final-Project/blob/master/gif/%EC%83%9D%EC%84%B1%EC%B4%88%EB%8C%80%EC%9D%BC%EC%A0%95%EB%93%B1%EB%A1%9D2.gif"> 

<hr>

<br>

#### [2. 프로젝트 기능분담 ](https://github.com/aa6488/Portfolio-Final-Project/wiki/%F0%9F%93%83-%EA%B8%B0%EB%8A%A5-%EC%83%81%EC%84%B8%EC%84%A4%EB%AA%85#4-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EA%B8%B0%EB%8A%A5%EB%B6%84%EB%8B%B4)
<img width="100px;" src="https://github.com/aa6488/Portfolio-Final-Project/blob/master/gif/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EA%B8%B0%EB%8A%A5%EB%B6%84%EB%8B%B4.gif"> 

<hr>

<br>

#### [3. 프로젝트 팀공지게시판, 그림판 API](https://github.com/aa6488/Portfolio-Final-Project/wiki/%F0%9F%93%83-%EA%B8%B0%EB%8A%A5-%EC%83%81%EC%84%B8%EC%84%A4%EB%AA%85#5-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%8C%80-%EA%B3%B5%EC%A7%80%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B7%B8%EB%A6%BC%ED%8C%90-api)
<img width="100px;" src="https://github.com/aa6488/Portfolio-Final-Project/blob/master/gif/%EA%B3%B5%EC%A7%80%EA%B7%B8%EB%A6%BC%ED%8C%90.gif"> 

<hr>

<br>

#### [4. 프로젝트 수정, 인터셉터처리, 글자 수 제한](https://github.com/aa6488/Portfolio-Final-Project/wiki/%F0%9F%93%83-%EA%B8%B0%EB%8A%A5-%EC%83%81%EC%84%B8%EC%84%A4%EB%AA%85#6-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%88%98%EC%A0%95%EC%82%AD%EC%A0%9C-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%B2%98%EB%A6%AC-%EA%B8%80%EC%9E%90-%EC%88%98-%EC%A0%9C%ED%95%9C)
<img width="100px;" src="https://github.com/aa6488/Portfolio-Final-Project/blob/master/gif/%EC%88%98%EC%A0%95%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0%EC%B2%98%EB%A6%AC.gif"> 

<hr>

<br>

#### [5. 프로젝트 진행,완료,초대,초대참가 알림](https://github.com/aa6488/Portfolio-Final-Project/wiki/%F0%9F%93%83-%EA%B8%B0%EB%8A%A5-%EC%83%81%EC%84%B8%EC%84%A4%EB%AA%85#7-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%95%8C%EB%A6%BC)
<img width="100px;" src="https://github.com/aa6488/Portfolio-Final-Project/blob/master/gif/%EC%A7%84%ED%96%89%EC%99%84%EB%A3%8C%EC%B4%88%EB%8C%80%EC%B4%88%EB%8C%80%EC%B0%B8%EA%B0%80.gif"> 

<hr>

<br>

#### [6. 프로젝트 신청,신청참가 알림](https://github.com/aa6488/Portfolio-Final-Project/wiki/%F0%9F%93%83-%EA%B8%B0%EB%8A%A5-%EC%83%81%EC%84%B8%EC%84%A4%EB%AA%85#7-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%95%8C%EB%A6%BC)
<img width="100px;" src="https://github.com/aa6488/Portfolio-Final-Project/blob/master/gif/%EC%8B%A0%EC%B2%AD%EC%8B%A0%EC%B2%AD%EC%B0%B8%EA%B0%80.gif"> 

<hr>

<br>

#### [7. 채팅웹 ](https://github.com/aa6488/Portfolio-Final-Project/wiki/%F0%9F%93%83-%EA%B8%B0%EB%8A%A5-%EC%83%81%EC%84%B8%EC%84%A4%EB%AA%85#8-%EC%B1%84%ED%8C%85)
<img width="100px;" src="https://github.com/aa6488/Portfolio-Final-Project/blob/master/gif/%EC%B1%84%ED%8C%85.gif"> 

<hr>

<br>


## 배운 점 & 아쉬운 점

<p align="justify">

- 이번 프로젝트는 아쉬움만 남았던것 같다, 물론 배운점도 확실히 있다고 생각하지만 아쉬움이 더 큰것같다. <br>
먼저 Wiki 설명에도 있지만 알림 부분에서 간단한 부분을 생각하지못하고 구현을 안해놓았었다, 내가 만든 로직이 잘 실행되는지 확인을 하며 진행하였지만 미처 생각하지 못했었던 부분을 프로젝트 발표 전일에 팀원들과 알게되었고 바로 수정을 했던 경험이있다. 이런 부분들이 자주 발생하게되면 결국 서비스의 질이 떨어지게되고 좋지않은 서비스, 아예 서비스를 하지못하는 상황이 발생한다고 생각한다, 이번 프로젝트에 했던 이 경험으로 항상 기초단위부터 고려를 하면서 차근차근 진행해야겠다.

- 학원과정의 마지막 finalProject를 진행하면서 첫번째 프로젝트였던 semiProject 할때 아쉬웠던 부분을 다시한번 반복했다, 마지막 프로젝트라고 생각을 하다보니 해보고싶다고 생각했던 부분들을 이것저것 많이 넣게되었고 그 결과 프로젝트 마감까지 시간이 부족해 나 자신과 타협을 해야했었다 <Strong>(그림판API를 사용해 채팅서버로 바로 보내기 || 게시판에 등록하기, 1:다수 채팅 뿐 아니라 1:1 채팅 구현)</Strong>. <br> 프로젝트를 많이 해보지않아서 설계부분에서 많이 부족한부분때문에 그런것인지, 내 자신이 욕심이 많아서 그런것인지. 지금생각하기엔 두가지 다 해당되는것같다 <br> 지금까진 짧다면 짧고 길다면 길다고할수있는 6개월의 교육과정을 수료하면서 2개의 프로젝트를 진행하였지만 앞으로 개발자로써 진행할 수많은 프로젝트들 에서 첫 프로젝트때 느꼈던 부분들을 항상 되짚어봐야겠다.

- <strong>작성일 2024-03-07 이희수</strong> 

</p>

<br>

## 프로젝트 유스케이스
<p align="center">
  <br>
  <img src="./images/유스케이스1.jpg">
  <br>
</p>
<p align="center">
  <br>
  <img src="./images/유스케이스2.jpg">
  <br>
</p>
<p align="center">
  <br>
  <img src="./images/유스케이스3.jpg">
  <br>
</p>
<p align="center">
  <br>
  <img src="./images/유스케이스4.jpg">
  <br>
</p>
<p align="center">
  <br>
  <img src="./images/유스케이스5.jpg">
  <br>
</p>

