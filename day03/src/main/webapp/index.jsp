<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>GET/POST 예제</h1>
	<form method="get" action="${pageContext.request.contextPath}/handler ">
		<label for="name">이름(GET)</label>
		<input type="text" id="name" name="userName"><br>
		<button type="submit">GET 요청</button>
	</form>
	<form method="post" action="${pageContext.request.contextPath }/handler">
		<label for="id">아이디(POST)</label>
		<input type="text" id="id" name="userId"><br>
		<label for="pw">비밀번호(POST)</label>
		<input type="password" id="pw" name="userPw"><br>
		<button type="submit" >POST 요청</button>
	</form>
	
	<h1>forward/redirect 예제</h1>
	<form method="post" action="${pageContext.request.contextPath}/forwardHandler">
		<label for="forwardName">foward 이름 : </label>
		<input type="text" id="forwardName" name="forwardName">
		<button type="submit">FORWARD 요청</button>
	</form>
	
	<form method="post" action="${pageContext.request.contextPath}/redirectHandler">
		<label for="redirectName">redirect 이름 : </label>
		<input type="text" id="redirectName" name="redirectName">
		<button type="submit">REDIRECT 요청</button>
	</form>
</body>
</html>