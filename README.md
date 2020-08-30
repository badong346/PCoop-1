# 프로젝트 협업 관리 사이트 : PCoop

### 수행기간
  > 2020년 06월 26일 ~ 2020년 07월 20일
  > 
### 개발 목표
  > 팀원들과 프로젝트 단위로 일정 및 업무 리스트 공유, 목적별 채팅 분할, 공동 드라이브 사용이 가능한 사이트를 구현
  > 
### 개발 환경

  > 서버 : apache-tomcat-8.5.55
사용언어 : Java, HTML, CSS, JavaScript, JSP, SQL
Database : Oracle SQL Developer
IDE : Eclipse (2019-12)
라이브러리 :  jQuery(3.5.1), BootStrap(4.5.0)
프레임워크 :  Spring MVC Framework
버전관리 : Git


# 구현 기능
 
### 전체페이지
 >• 회원가입 / 로그인 / 프로젝트 생성 / 프로젝트 참가
 • 공지사항 게시판 : 관리자 회원만 작성, 수정, 삭제 / 비회원도 조회 가능
 • 회원 가입 과정에서 이메일 인증
 • 로그인 시 쿠기를 사용한 이메일 기억하기 구현
 • mybatis를 활용하여 DB 연결
 • AOP와 Session을 이용하여 프로젝트별 접근 권한 조정
 • jQuery를 활용한 반응형 웹 구현

### 프로젝트
>• 생성(인원수, 프로젝트명)
• 초대하기(고유코드 이메일 전송)
• 가입신청
• 가입 수락(팀장)

### 할 일 리스트
>• 칸반 보드와 유사한 형식으로 구성
• ‘할 일 리스트’를 여러 개 추가할 수 있으며, 리스트 내에 ‘할 일 카드’를 생성
•  ‘할 일 카드’에는 제목, 상세내용, 일정 등을 추가 할 수 있으며 완료 유무를 체크 할 수 있음
• ‘할일 카드’의 완료 수에 따른 프로젝트 진행률을 하단에서 실시간으로 확인 가능

### 캘린더
>• 일정을 추가, 수정, 삭제, 조회 가능
• 월간, 주간, 일간 형태로 전환

### 채팅
>• 프로젝트 생성시 팀 채팅방이 생성
• 회원별 1:1 채팅방
•  파일 업로드, 이모티콘, 코드 업로드 등이 가능
• 파일 목록만을 따로 볼 수 있음

### 백업
>• 50mb 이하의 파일을 업로드 가능하며, 파일 디렉토리를 생성 할 수 있음, 압축파일을 업로드시 압축해제가 되며 텍스트 파일 형식은 미리 보기가 가능


# DB 설계
>[AQueryTool](https://aquerytool.com/) 에서 제공하는 기능으로 데이터베이스를 설게하였습니다.
>
![image](https://user-images.githubusercontent.com/61821190/91650632-eb42db80-eabc-11ea-9f26-9d135ff84270.png)


# 담당 역할

>•  프로젝트 주제 선정
•  기능 기획
•  할 일 리스트 관련 테이블 설계
• 기능 기획, DB 설계, 회원 가입 및 인증 기능 구현
•  할 일 리스트 관련 기능 전체 구현 및 테스트
•  AOP를 이용한 회원 및 프로젝트 권한 체크


### 참여도/기여도

>• 참여도 : 100%
>- 프로젝트 주제 선정, 기획, DB설계, 기능 구현, 반응형 웹 등 모든 과정 참여

>• 기여도 : 20% (팀 구성원 : 5명)
>- 회원가입, 이메일 인증
>- ‘할일리스트’ 생성/수정/삭제/조회/스타일변경
>- ‘할일카드’ 생성/수정/삭제/조회/완료유무
>- 프로젝트 진행률바
>- 주간 일정 기능 연동
>- 드래그앤드롭 방식으로 정렬변경
>- AOP를 이용한 로그인/프로젝트 체크



# 화면 설명

### 회원가입
>• 이메일 인증 : 이메일 입력시 가입되지 않는 이메일이면, 해당 이메일로 6자리의 랜덤 숫자가 전송되며 전송된 숫자를 입력해야 회원 가입 가능, 중복 제출을 차단하는 기능 구현
• 회원가입 : 비밀번호가 일치하고 정규식을 통과한 경우 사용가능하다는 문자가 출력되며 가입 가능
![image](https://user-images.githubusercontent.com/61821190/91650840-ab312800-eabf-11ea-99f8-ab097521ddc7.png)

### 로그인
>• 로그인 : 이메일과 비밀번호로 로그인, ‘email 기억하기’ 체크크박스 선택시 쿠키로 이메일을 기억
![image](https://user-images.githubusercontent.com/61821190/91650842-ad938200-eabf-11ea-9fe0-e7064ac5d0b5.png)

### To-do List 초기 페이지
>• 프로젝트 진입 후 사이드바를 통해 To-do List 페이지로 진입 가능
• 데이터가 존재하지 않을 시 자동으로 도움말 리스트 출력
• + 버튼 : 리스트를 추가 가능하며 내부에 항목들을 넣을 수 있음
• 하단의 주간 일정표는 숨기거나 일일 일정으로 변경 가능
• ‘할 일 항목’ 완료시 하단의 '진행률 바'로 표시

![image](https://user-images.githubusercontent.com/61821190/91650965-6908e600-eac1-11ea-9279-3aa93f5ffa1d.png)


### To-do List 리스트 및 항목 추가/변경/수정/삭제
>• 스타일 : 리스트 별로 색상을 수정 할 수 있음
• 리스트 이름 및 스타일과 카드 이름, 상세내용, 일정, 완료유무는 프로젝트 별로 수정, 변경, 삭제, 조회 가능

![image](https://user-images.githubusercontent.com/61821190/91650955-555d7f80-eac1-11ea-9380-d2e6020b5e6c.png)

### To-do List 리스트 및 항목 정렬
>• 정렬 : ‘드래그 앤 드롭’ 방식으로 드롭하는 순간 모든 변경된 위치가 DB에 저장
• ‘할일리스트’ 간위치 변경, ‘할일카드’ 간위치 변경, 리스트가 다른 카드 간 이동 가능
![image](https://user-images.githubusercontent.com/61821190/91650974-a40b1980-eac1-11ea-9aee-d509e1e4e1ef.png)



# 참여소감

> 코딩을 본격적으로 배운지 4달 만에 작업하기 시작한 두 번째 팀 프로젝트입니다. 3주 정도의 시간을 갖고 진행을 하였는데, 같은 교육과정의 다른 팀들에 비해 인원은 적고 목표 기능은 많아 프로젝트 초반 기간에는 걱정이 많았습니다. 하지만 팀원들이 모두 성실하고 본인이 맡은 기술들에 욕심이 있어서 만족스러운 결과는 낼 수 있었던 것 같습니다.
>  보이지 않게 고민한 사항들이 많고 이를 극복하기 위한 시도도 많이 있었는데 이런 점을 다른 팀들이 알아봐 준 덕분에 **최우수 프로젝트**로 선정된 것 같아 기쁩니다. 새로운 상황을 겪고 공부하며 많이 성장 할 수 있었던 소중한 시간이었습니다. 특히 팀원에게 맡은 부분의 기능을 알려주기도 하고 또 다른 팀원의 담당 기능들을 배우기도 하며 열정적인 동료들과 작업하는 기회를 얻는 것이 자신의 성장에도 많은 도움이 된다는 것을 알게 되었습니다.

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE1MjA0MTA5OTIsLTI2NDQ3MzYwMSwtMT
I5MzA2MDY3NCwyNzI5ODAzMjddfQ==
-->