<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }"/>
</head>
<body>
 <h1>회원가입</h1>
   <main>
      <form action="/member/loginOk.me" method="post">
         <div class="id">
            id : <input type="text" name="memberId" />
         </div>
         <div class="pw">
            pw : <input type="password" name="memberPw" />         
         </div>
         <div class="btn">
            <button>로그인</button>
         </div>
      </form>
   </main>
</body>
</html>