package com.example.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.member.dao.MemberDAO;
import com.example.app.member.dto.MemberDTO;

public class JoinOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		request.setCharacterEncoding("UTF-8");
		//회원정보 세팅
		memberDTO.setMemberId(request.getParameter("memberId"));
		memberDTO.setMemberPassword(request.getParameter("memberPassword"));
		memberDTO.setMemberName(request.getParameter("memberId"));
		memberDTO.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
		memberDTO.setMemberGender(request.getParameter("memberGender"));
		memberDTO.setMemberPhoneNumber(request.getParameter("memberPhoneNumber"));
		memberDTO.setMemberPostcode(request.getParameter("memberPostcode"));
		memberDTO.setMemberAddress(request.getParameter("address"));
		memberDTO.setMemberDetailAddr(request.getParameter("detailAddress"));
		System.out.println("JoinOkController - MemberDTO :\n" + memberDTO);
		
		//DAO 호출
		memberDAO.join(memberDTO);
		
		result.setPath(request.getContextPath() + "/member/login.me");
		result.setRedirect(true);
		
		return result;
	}
	
}








