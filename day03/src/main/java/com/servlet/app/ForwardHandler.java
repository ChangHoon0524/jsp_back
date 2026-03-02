package com.servlet.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardHandler
 */
public class ForwardHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("forwardName");
		// getParameter : 사용자가 보낸 데이터 꺼내기
		request.setAttribute("forwardName", name);	// forwardName : key, name : value
		// setAttribute : 서버가 처리중에 만들어서 잠시 보관하는 데이터 / request 객체 안에 데이터를 저장하는 기능
		// 기본 문법 : setAttribute("key", value);
		// 꺼낼 때 : request.getAttribute("key");
		// jsp에서는 ${requestScope.key} => ${key}
		
		request.getRequestDispatcher("/forwardResult.jsp").forward(request, response);
	}

}
