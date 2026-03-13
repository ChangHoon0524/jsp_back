package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Result;

/**
 * Servlet implementation class MemberFrontController
 */
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		
	}

	// get과 post를 구분하지 않고 사용
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 조건문을 통해 분기 처리
		System.out.println("Member 서블릿 실행!!");

		// request.getContextPath() URL 루트 경로를 의미
		System.out.println(request.getContextPath()); // "/mvc"
		// request.getRequestURI()는 현재 요청의 URI를 보여준다
		System.out.println(request.getRequestURI());
		// 우리가 필요한 것은 전체 URI에서 ContextPath를 제외시킨 부분
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);
		// .getContentLength() : 요청 데이터의 크기(Byte) 반환
		// .getContextPath().length() : 프로젝트 루트 경로의 길이 반환
		// .substring(request.getContextPath().length()) : 프로젝트 경로를 제거하고 실제 요청만 추출
		Result result = null;
		switch (target) {
		case "/member/join.me" -> {
			System.out.println("join 경로 진입");
			result = new Result();
			result.setPath("/app/member/join.jsp");
			result.setRedirect(false);
//    	  request.getRequestDispatcher("/app/member/join.jsp").forward(request, response);    	  
			System.out.println("join 페이지 이동완료");
		}
		// OK가 필요한 이유 : 회원가입 페이지로 단순히 이동하는 것과
		// 회원가입 서비스가 완료되었을 때 회원가입을 처리하는 url을 나누기 위함
		case "/member/joinOk.me" -> {
			System.out.println("회원가입 경로 진입!!");
			result = new JoinOkController().Excute(request, response);
		}
		case "/member/login.me" -> {
			System.out.println("login");
			result = new Result();
			result.setPath("/app/member/login.jsp");
			result.setRedirect(false);
//    	  request.getRequestDispatcher("/app/member/login.jsp").forward(request, response);
			System.out.println("login 페이지 이동완료");
		}
		case "/member/loginOk.me" -> {
			System.out.println("로그인 경로 진입");
			result = new LoginOkController().Excute(request, response);
			System.out.println("로그인 완료");
		}
		}

		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}

		}
	}
}