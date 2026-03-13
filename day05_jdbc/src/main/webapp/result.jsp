<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 결과</h1>
	아이디 : <%= request.getAttribute("userId") %><br>
	비밀번호 : <%= request.getAttribute("userPw") %><br>
	이름 : <%= request.getAttribute("userName") %><br>
	나이 : <%= request.getAttribute("userAge") %><br>
	성별 : <%= request.getAttribute("userGender") %><br>
</body>
</html>