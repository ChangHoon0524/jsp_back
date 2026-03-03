<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<form method="get" action="${pageContext.request.contextPath}/ForwardServlet">
		<label for="name">이름(GET)</label>
		<input type="text" id="name" name="userName"><br>
		<label for="age">나이(GET)</label>
		<input type="text" id="age" name="userAge"><br>
		<button type="submit">GET/Forward 요청</button>
	</form>
	
	<form method="get" action="${pageContext.request.contextPath}/RadioServlet">
		<label for="name">이름(GET/Forward/Radio)</label>
		<input type="text" id="namePost" name="forwardUserName"><br>
		<label for="age">나이(GET/Forward/Radio)</label>
		<input type="text" id="agePost" name="forwardUserAge"><br>
		<input type="radio" id="male" name="forwardGender" value="male">
		<label for="male">남자</label>
		<input type="radio" id="female" name="forwardGender" value="female">
		<label for="female">여자</label>
		<input type="radio" id="none" name="forwardGender" value="none">
		<label for="notSelect">선택안함</label><br>
		
      <input type="checkbox" name="color" value="red">빨강
      <input type="checkbox" name="color" value="green">초록
      <input type="checkbox" name="color" value="blue">파랑<br>
		
		
		<button type="submit">GET/Forward/Radio 요청</button>
	</form>
	
		<form method="post" action="${pageContext.request.contextPath}/RadioServlet">
		<label for="name">이름(GET/Redirect/Radio)</label>
		<input type="text" id="namePost" name="redirectUserName"><br>
		<label for="age">나이(GET/Redirect/Radio)</label>
		<input type="text" id="agePost" name="redirectUserAge"><br>
		<input type="radio" id="male" name="redirectGender" value="male">
		<label for="male">남자</label>
		<input type="radio" id="female" name="redirectGender" value="female">
		<label for="female">여자</label>
		<input type="radio" id="none" name="redirectGender" value="none">
		<label for="notSelect">선택안함</label><br>
		<button type="submit">GET/Redirect/Radio 요청</button>
	</form>
	<jsp:include page="footer.jsp">
</body>
</html>