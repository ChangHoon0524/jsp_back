<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
   <h1>메인페이지</h1>
   <c:choose>
      <c:when test="${not empty sessionScope.userId}">
         <h1>${sessionScope.userName}님 환영합니다</h1>
      </c:when>
      <c:otherwise>
         <a href="login.jsp">로그인</a>
      </c:otherwise>
   </c:choose>
</body>
</html>