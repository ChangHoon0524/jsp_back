package com.example.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.member.dao.MemberDAO;
import com.example.app.member.dto.MemberDTO;

public class LoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		int memberNumber = 0;
		Result result = new Result();
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		String remember = request.getParameter("remember");
		HttpSession session = request.getSession();
		String path = null;
		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPassword(memberPassword);
		
		// 쿼리문 실행 메소드 호출
		memberNumber = memberDAO.login(memberDTO);
		
		if(memberNumber != -1) {
			path = "/member/join.me";
			session.setAttribute("memberNumber", memberNumber);
			System.out.println("세션값 : " + memberNumber);
			if(remember != null) {
				Cookie cookie = new Cookie("memberId", memberId);
				cookie.setMaxAge(60*60*24); // 1일
				response.addCookie(cookie);
			}else {
				// 체크 해제 시 쿠키 삭제
				Cookie cookie = new Cookie("memberId", "");
				cookie.setMaxAge(0);
	            response.addCookie(cookie);
			}
		}else {
			path="/member/login.me?login=fail";
		}
		result.setRedirect(true);
		result.setPath(path);
		return result;
	}

}
