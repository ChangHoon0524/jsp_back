<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Forward 처리결과</h1>
	<h3>전달된 이름은 <%= request.getAttribute("forwardName") %>입니다.</h3>
	<!-- jsp 표현식 : 자바 코드를 직접 실행하는 방식 -->
	<h3>전달된 이름은 ${forwardName}입니다.</h3>
	<!-- EL 표현식 : JSP에서 자바 코드만 꺼내서 쓰는 방식-->
</body>
</html>