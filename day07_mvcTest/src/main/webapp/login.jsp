<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login" method="post">
		<label for="userId">아이디</label>
		<input type="text" id="userId" name="userId"><br>
		<label for="userPw">비밀번호</label>
		<input type="text" id="userPw" name="userPw"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>