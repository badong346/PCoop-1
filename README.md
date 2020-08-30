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
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTI2NDQ3MzYwMSwtMTI5MzA2MDY3NCwyNz
I5ODAzMjddfQ==
-->