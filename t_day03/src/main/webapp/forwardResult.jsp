<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Forward 처리 결과</h1>
	<h3>전달된 이름은 <%= request.getAttribute("forwardName") %>입니다</h3>
	<!-- jsp 표현식 : 자바코드를 직접 실행하는 방식 -->
	<h3>전달된 이름은 ${forwardName}입니다</h3>
	<!-- EL 표현식 : JSP에서 자바 코드없이 값만 꺼내는 문법 -->
</body>
</html>