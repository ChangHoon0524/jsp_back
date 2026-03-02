package com.servlet.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPostHandler
 */
public class GetPostHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPostHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      String name = request.getParameter("userName");
	      System.out.println("입력한 userName 값 : " + name);
	      response.setContentType("text/html;charset=UTF-8");
	      response.getWriter().print("<h1>GET 요청 처리</h1>");
	      response.getWriter().print("<p>이름 : " + name + "</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      String email = request.getParameter("userEmail");
	      System.out.println("입력한 userEmail값 : " + email);
	      response.setContentType("text/html;charset=UTF-8");
	      response.getWriter().print("<h1>POST요청 처리</h1>");
	      response.getWriter().print("<p>이메일 : " + email + "</p>");
	   
	}

}
