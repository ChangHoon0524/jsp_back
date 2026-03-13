package com.example.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.member.dao.MemberDAO;

public class CheckIdOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		String memberId = request.getParameter("memberId");
		boolean isAvailable = memberDAO.checkId(memberId);
				
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println(isAvailable);
		try(PrintWriter out = response.getWriter()){
			out.print("{\"available\" : " + isAvailable + "}");
			out.flush();
		}
		
		// Result 객체 반환 (json 응답 처리 후 페이지 이동 없음)
		result.setPath(null);
		result.setRedirect(false);
		return result;
	}

}
