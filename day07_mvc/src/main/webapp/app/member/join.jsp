<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/login.css" />
</head>
<body>
   <h1>회원가입</h1>
   <main>
      <form action="/member/joinOk.me" method="post">
         <div class="id">
            id : <input type="text" name="memberId" />
         </div>
         <div class="pw">
            pw : <input type="password" name="memberPw" />         
         </div>
         <div class="name">
            name : <input type="text" name="memberName" />
         </div>
         <div class="age">
            age : <input type="text" name="memberAge" />         
         </div>         
         <div class="gender">
            <div>
            남자 : <input type="radio" name="memberGender" value="M" />
            </div>
            <div>
            여자 : <input type="radio" name="memberGender" value="F" />
            </div>
            <div>
            선택안함 : <input type="radio" name="memberGender" value="N" />
            </div>         
         </div>
         <div class="btn">
            <button>회원가입</button>
         </div>
      </form>
   </main>
</body>
</html>