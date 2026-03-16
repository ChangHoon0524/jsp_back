<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원 가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/join.css" />
<!-- 1) 우편번호 API 먼저 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 2) join.js -->
<script src="${pageContext.request.contextPath}/assets/js/member/join.js"></script>
</head>
<body>
   <div class="container">
      <form id="joinForm" action="${pageContext.request.contextPath}/member/joinOk.me" method="POST" data-context-path="${pageContext.request.contextPath}">
         <h2>회원 가입</h2>
         <div class="form-group">
            <label for="id">아이디</label> 
            <input type="text" id="id"
               name="memberId" placeholder="아이디를 입력하세요" required /> 
               <span class="check-msg" id="check-id-msg"></span>
         </div>
         <div class="form-group">
            <label for="password">비밀번호</label> <input type="password"
               id="password" name="memberPassword" placeholder="비밀번호를 입력하세요"
               required /> <span class="check-pw-msg" id="check-pw-msg"></span>
         </div>
         <div class="form-group">
            <label for="passwordConfirm">비밀번호 재확인</label> <input type="password"
               id="passwordConfirm" name="passwordConfirm"
               placeholder="비밀번호를 입력하세요" required /> <span class="check-pw-msg"
               id="check-pw-confirm-msg"></span>
         </div>
         <div class="form-group">
            <label for="name">이름</label> <input type="text" id="name"
               name="memberName" placeholder="이름을 입력하세요" required />
         </div>
         <div class="form-group">
            <label for="phoneNumber">핸드폰번호</label>
            <div>
               <input type="text" id="phoneNumber" name="memberPhoneNumber"
                  placeholder="핸드폰번호를 입력하세요" required />
               <button type="button" id="sendSMSBtn">인증번호 발송</button>
            </div>
            <span id="sms-status"></span>
         </div>

         <div class="form-group">
            <label for="verificationCode">인증번호</label> <input type="text"
               id="verificationCode" name="verification"
               placeholder="인증번호를 입력하세요" required /> <span
               id="verification-status"></span>
         </div>
         <div class="form-group">
            <label for="age">나이</label> <input type="number" id="age"
               name="memberAge" placeholder="나이를 입력하세요" required />
         </div>
         <div class="form-group">
            <label>성별</label>
            <div>
               <input type="radio" id="none" name="memberGender" value="N" checked />
               <label for="none">선택안함</label> 
               <input type="radio" id="male" name="memberGender" value="M" /> 
               <label for="male">남성</label> 
               <input type="radio" id="female" name="memberGender" value="F" /> 
               <label for="female">여성</label>
            </div>
         </div>
         <div class="form-group">
              <label for="postcode">주소</label>
              <div class="inline">
                <input type="text" id="postcode" name="postcode" placeholder="우편번호" readonly required />
                <button type="button" id="searchPostcodeBtn">우편번호 검색</button>
              </div>
         
           <input type="text" id="mainAddress" name="address" placeholder="도로명 또는 지번 주소" readonly required />
         
           <input type="text" id="detailAddress" name="detailAddress" placeholder="상세 주소" />
         </div>
         <div class="form-group">
            <label>약관 동의</label>
            <div class="agree-wrap">
               <label for="agree">회원 가입 약관에 동의합니다.</label> <input type="checkbox"
                  id="agree" name="agree" required />
            </div>
         </div>
         <button type="submit">회원 가입</button>
      </form>
   </div>
</body>
</html>