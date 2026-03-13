package com.example.app.member;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.dao.MemberDAO;
import com.example.app.dto.MemberDTO;

public class LoginOkController implements Execute{

	@Override
	public Result Excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		
		System.out.println(memberId);
		System.out.println(memberPw);	
		memberDTO = memberDAO.login(memberId, memberPw);

		// 로그인 성공 시와 실패 시 조건
		if(memberDTO != null) {
			// 로그인 성공 시 세션에 사용자 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("memberDTO", memberDTO);
			// 쿠키에 사용자 ID 계산
			Cookie cookie = new Cookie("memberId", memberId);
			// 유효기간 1일
			cookie.setMaxAge(60*60*24);
			
			result.setPath(request.getContextPath());
			result.setRedirect(true);
		}
		else {
			// 로그인 실패 시 로그인 페이지로 이동
			result.setPath(request.getContextPath()+"/member/login.me");
			result.setRedirect(true);
		}
		return result;
	}

}
