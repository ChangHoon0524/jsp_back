package com.example.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;

public class LogoutOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  Result result = new Result();
	      request.getSession().invalidate(); //세션 무효화
	      result.setPath("/member/login.me");
	      result.setRedirect(true);
	      
	      return result;
	}

}
