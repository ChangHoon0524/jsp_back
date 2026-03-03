<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= request.getAttribute("name") %>님 환영합니다!</h1>
	<h1>현재 나이는 <%= request.getAttribute("age") %>입니다. 만 나이는 <%= request.getAttribute("korAge") %>입니다.</h1>
	<h1>성별 : <%= request.getAttribute("koreanGender") %></h1>
	
	<h1>Redirect 결과</h1>
	<p>redirect Name : ${param.redirectName }</p><br>
	<p>redirect Age : ${param.redirectAge }</p><br>
	<p>redirect Name : ${param.redirectGender }</p><br>
</body>
</html>