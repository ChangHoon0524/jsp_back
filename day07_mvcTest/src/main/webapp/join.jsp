<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="join" method="post">
		아이디 : <input type="text" name="userId"><br>
		비밀번호 :<input type="text" name="userPw"><br>
		이름 : <input type="text" name="userName"><br>
		나이 : <input type="text" name="userAge"><br>
		성별 :		
		 선택안함 <input type="radio" name="userGender" value="N">
		 남자<input type="radio" name="userGender" value="M">
		 여자<input type="radio" name="userGender" value="F">
		 <br>
		 <button>회원가입</button>		 		
	</form>
</body>
</html>