package com.example.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;

public class LoginController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		Cookie[] cookies= request.getCookies();
		// 사용자가 브라우저에서 서버로 요청을 보낼 때 브라우저는 자신이 가지고 있는 쿠키들을 함께 전송
		// request.getCookies() 쿠키들을 배열로 꺼내는 메소드
		if(cookies != null) {
			// 쿠키가 전혀 없는 경우 getCookies()는 null을 반환하므로 먼저 null체크 진행
			for(Cookie cookie : cookies) {
				// 쿠키 배열이 여러개 있을 수 있으므로 for-each문 사용하여 하나씩 꺼낸다
				if(cookie.getName().equals("memberId")) {
					request.setAttribute("memberId", cookie.getValue());
					// 찾은 memberId 쿠키의 값을 request 속성에 넣어준다.
					// ${memberId 형태로 꺼내 쓸 수 있다.
				}
			}
		}
		result.setPath("app/member/login.jsp");
		result.setRedirect(false); // forward처리
		return null;
	}

}
