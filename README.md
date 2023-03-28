# multicampus_MVC_TodoList
멀티캠퍼스에서 진행한 것들을 총 정리하는 MVC 패턴의 Todo 게시판 

~ 2023/03/27

기본적인 CRUD와 페이징 처리, 검색 기능을 추가한 Todo 게시판 구현

git연동

현재 부족한 점 : 검색 후 페이징 이동이 정상적으로 처리되지 않음

앞으로 추가하고 싶은 것

:파일 업로드 
 로그
 유효성 검사(검색, CRUD)
 동적 쿼리
 필터링

2023/03/27

검색 후 페이징 이동이 정상적으로 처리되지 않음 >> 해결 완료

git 연동 완료

2023/03/28

logback을 이용한 로깅처리 완료.
- ControllerAdvice를 활용해 컨트롤러단에서의 Excepetion 처리
- logback의 appender를 파일로 분리
- file apperder를 이용해 error log만 따로 저장

