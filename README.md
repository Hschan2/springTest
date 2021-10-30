# Spring Boot로 웹 출시까지

* 해당 Repository 삭제 예정
  * EverythingAboutJava Repository로 이동 예정

## 개발 단계
1. 프로젝트 환경 설정하기
    * Spring과 Spring Boot의 차이점
    * Chocolate 윈도우 패키지 매니저 설치
    * OpenJDK8 설치
    * Spring Boot Restful API 생성
2. Thymeleaf를 이용한 화면 작성하기
    * 표준 HTML 문법으로 작성
3. Thymeleaf의 기본 익히기
    * 텍스트 작성 방법
    * 표준 표현 문법
    * 태그 속성값 지정 방법
    * 반복문과 조건문
    * 템플릿 레이아웃 작성 방법
    * 지역 변수
    * 문법 우선순위
    * 인라이닝 (Inlining)
    * 기타 유틸리지 오브젝트 사용 방법
4. Thymeleaf를 이용하여 레이아웃 만들기
    * Git 연동을 통한 소스 관리
    * Bootstrap 반응형 웹 사이트 구성
    * Fragment 이용하여 공통 화면 레이아웃 구성
5. JPA를 이용하여 게시판 조회하기
    * MariaDB 설치 및 테이블 생성
    * Spring Boot에서 MariaDB 데이터 소스 설정
    * Model, Repository 클래스 생성 및 어노테이션 설정
    * 게시판 데이터 조회 후 화면 출력
6. Thymeleaf에서 Form 전송하기
    * Spring Boot와 Thymeleaf 사용하여 Form 전송 방법
    * Form 유효값 체크하는 Validator 작성
    * JPA로 DB에 데이터 추가 및 수정
7. JPA를 이용하여 RESTful API 작성하기
    * JPA로 MariaDB 데이터 조작를 위한 컨트롤러 생성
    * Postman으로 HTTP 요청을 통해 CRUD 데이터 조작
8. JPA를 이용하여 페이지 처리하기
    * JPA의 Page 클래스를 이용하여 페이지 처리
9. JPA를 이용하여 검색 기능 만들기
    * JPA의 Page 클래스를 이용하여 검색 기능 구현
10. Spring Security를 이용하여 로그인 처리하기
    * 사용자 테이블 생성 후 Spring Security를 적용하여 인증 및 권한 처리
    *  로그인, 회원가입, 로그아웃, 페이지 권한 처리
11. JPA를 이용하여 @OneToMany 관계 설정하기
    * @OneToMany, @ManyToOne 어노테이션을 이용하여 양방향 매핑 설정
    * Cascade, OrphanRemoval 속성을 이용하여 매핑된 데이터 조작
12. JPA를 이용하여 조회 방법 (FetchType) 설정하기
    * 서로 연관된 두 테이블 간 조회 방법 설정 (Eager, Lazy)
    * [N + 1 문제와 해결 방법 코드](https://github.com/mygodcoder/myhome/tree/%2311)
13. 권한에 맞는 화면 구성하기
    * 사용자 권한에 따라 UI 다르게 구성 (Thymeleaf)
14. 권한에 맞는 API 호출하기
    * 사용자 권한에 따라 API 제한
    * @Secured, @RolesAllowed, @PreAuthorize 혹은 새로운 어노테이션을 생성하여 접근 권한 설정
15. JPA를 이용하여 Custom Query 만들기
    * Query 어노테이션을 이용하여 JPQL 작성
    * Query 어노테이션을 이용하여 SQL 작성
    * QueryDSL을 이용하여 쿼리 작성
    * JdbcTemplate을 이용하여 쿼리 작성
    * Custom Repository를 이용하여 쿼리 작성

### [강의 링크](https://www.youtube.com/watch?v=8zjLIsqt8so&list=PLPtc9qD1979DG675XufGs0-gBeb2mrona&index=35)