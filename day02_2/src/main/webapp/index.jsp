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
   <form action="${pageContext.request.contextPath}/handler" method="get">
      <lable for="name">이름(GET) : </lable>
      <input type="text" id="name" name="userName" placeholder="이름 입력"><br />
      <button type="submit">GET 요청</button>
   </form>
   
   <form action="${pageContext.request.contextPath}/handler" method="post">
      <lable for="email">이메일(post) : </lable>
      <input type="text" id="email" name="userEmail" placeholder="이메일 입력"><br />
      <button type="submit">POST 요청</button>
   </form>   
</body>
</html>