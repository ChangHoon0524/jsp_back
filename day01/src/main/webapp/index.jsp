<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕!!</h1>
	<!-- 주석 단축키 : ctrl + shift + / -->
	<!-- method를 get으로 작성하면 폼 데이터를 get 방식으로 서버 전송
		method를 post로 작성하면 폼 데이터를 post로 서버 전송
		즉, method에 get을 쓰면 doGet()메소드가 실행
		폼 태그의 method 속성 생략 시 default는 get방식(가능하면 생략 금지) -->
	<form action="output", method="post">
		<input type="text" name="userName" placeholder="이름작성">
		<input type="text" name="userAge" placeholder="나이작성">
		<button>전송</button>
		<!-- button 태그는 기본 타입이 submit
			submit 버튼은 현재 form 태그의 action에 작성된 경로로 요청(request)를 보낸다
			이 때 request에는 현재 폼에 속해있는 모든 폼 데이터를 가지고 있다 -->
	</form>
</body>
</html>