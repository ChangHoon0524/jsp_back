package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.dao.MemberDAO;
import com.example.app.dto.MemberDTO;

public class JoinOkController implements Execute {

	@Override
	public Result Excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		memberDTO.setMemberId(request.getParameter("memberId"));
		memberDTO.setMemberPassword(request.getParameter("memberPw"));
		memberDTO.setMemberName(request.getParameter("memberName"));
		// parseInt()는 문자열이 숫자가 아닐경우 numberFormatException 발생
		// valueOf() 문자열을 Integer로 바꿔주고, 문자열이 숫자가 아닐 경우 null 반환
		memberDTO.setMemberAge(Integer.valueOf(request.getParameter("memberAge")));
		memberDTO.setMemberGender(request.getParameter("memberGender"));

		memberDAO.join(memberDTO);
		System.out.println(memberDTO + "회원가입완료");
		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/index.jsp");
		return result;
	}

}
