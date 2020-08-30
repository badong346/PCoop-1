# 프로젝트 협업 관리 사이트 : PCoop

### 수행기간
  > 2020년 06월 26일 ~ 2020년 07월 20일
  > 
### 개발 목표
  > 팀원들과 프로젝트 단위로 일정 및 업무 리스트 공유, 목적별 채팅 분할, 공동 드라이브 사용이 가능한 사이트를 구현
  > 
### 개발 환경

  > 서버

apache-tomcat-8.5.55

Java EE IDE

Eclipse (2019-12)

Database

Oracle SQL Developer

사용언어

Java, HTML, CSS, JavaScript, JSP, SQL

라이브러리

jQuery(3.5.1)

BootStrap(4.5.0)

프레임워크

Spring MVC Framework

버전관리

Git
### sidebar-left.jsp의 내비게이션 부분에 리스트 추가 방법
  > sidebar-left.jsp: 내비게이션 메뉴의 해당 .navcontents에 이름 추가(ex. class="navtitle backup")<br>
  > 본인 jsp: 해당 기능 class에 jquery로 태그 append<br>
  > (ex. $(".backup".append("<div></div>");)<br>
  > 제가 먼저 해 봤는데 동작 잘돼요. 만약에 안 되거나 모르겠으면 저한테 질문 주세요.
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE5MDY0Njg0MTJdfQ==
-->