<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/member/join.me" method="get">
		<button>회원가입</button>
	</form>
	<a href="http://localhost:8888/member/login.me">로그인하러가기</a>
</body>
</html>