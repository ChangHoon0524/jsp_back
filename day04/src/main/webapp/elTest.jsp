<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 연산자 사용</h1>
	<h2>10 + 5 = %{10 + 5}</h2>
	<h2> 10 % 3 = ${10 % 3 }</h2>
	<h2>10 mod 3 = ${10 mod 3 }</h2>
	
	<!-- 비교 연산자 -->
	<h2> 10 > 5 : ${10 > 5}</h2>
	<h2> 10 gt 5 : ${10 gt 5 }</h2>
	
	<h2>10 < 5 ${10 <5 }</h2>
	<h2>10 lt 5 : ${10 lt 5 }</h2>
	
	<h2>10 eq 10 : ${10 eq 10 }</h2>
	<h2>10 ne 10 : ${10 ne 10 }</h2>
	
	<!-- 논리 연산자 -->
	<h2> true && true :: ${true && true }</h2>
	<h2> true and true : ${true and true }</h2>
	<h2> !true : ${!true }</h2>
	<h2> not true : ${not true }</h2>
	
	<!-- empty 연산자 -->
	<h2>empty null : ${empty null }</h2> <!-- empty null : true -->
	<h2>empty '' : ${empty '' }</h2><!-- empty '' : true -->
	
	<!-- 문자열 비교 eq 권장 -->
	<h2>'홍길동' eq '홍길동' : ${'홍길동' eq '홍길동' }</h2> <!-- '홍길동' eq '홍길동' : true -->
	
	<!-- 삼항연산자 -->
	<!-- 조건식 ? 참 일때의 값 : 거짓일 때의 값 -->
	<h2>나이 판별 : ${20 >= 19 ? '성인' : '미성년자' }</h2>
	
	<!-- EL 내부 형변환 규칙 -->
	<!-- 1. 숫자 연산시 - 숫자로 변환 가능하면 숫자로 계산 -->
	<h1>${"10" + 5 }</h1>
	<h1>${"10" eq 10 }</h1>
	<%-- <h1>${"abc" + 10 }</h1> --%> <!-- 숫자로 변환 불가능 시 예외 발생 : (NumberFormat Exception) -->
	<h1>${null + 10 }</h1>
	<h1>${empty null }</h1> <!-- true -->
	<h1>${null =="" }</h1> <!-- false -->
</body>
</html>