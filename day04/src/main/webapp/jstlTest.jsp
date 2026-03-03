<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% 
      pageContext.setAttribute("name", "홍길동");
   %>
   
   <h1>${name}</h1>
   <!-- EL은 자동으로 아래 순서대로 탐색
   1) pageScope -> 2) requestScope -> 3) sessionScope -> 4) ApplicationScope -->
   <h1>${requestScope.name}</h1>
   <h1>${param.name}</h1>
   
   <c:set var='num'>123</c:set>
   <h1><c:out value="${num}"></c:out></h1>
   
   <c:set var="number" value="1234"/>
   <h1><c:out value="${number}"></c:out></h1>
   
   <c:set var='id' value='admin' />
   <c:if test="${id == 'admin'}">
   	<h2> 현재 로그인 된 계정은 <c:out value="${id }"></c:out></h2>
   </c:if>	
   <c:if test="${id == 'member' }">
   	<h2> 현재 로그인 된 계정은 일반계정입니다.</h2>
   </c:if>	
</body>
</html>