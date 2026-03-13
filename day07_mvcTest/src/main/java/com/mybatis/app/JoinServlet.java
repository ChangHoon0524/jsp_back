package com.mybatis.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;

/**
 * Servlet implementation class MyServlet
 */
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
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
		
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		
		// Mapper에 넘겨줄 Map 만들기
		Map<String, String> userMap = new HashMap<>();
		userMap.put("userId", request.getParameter("userId"));
		userMap.put("userPw", request.getParameter("userPw"));
		userMap.put("userName", request.getParameter("userName"));
		userMap.put("userAge", request.getParameter("userAge"));
		userMap.put("userGender", request.getParameter("userGender"));
		
		System.out.println(userMap);
		
		sqlSession.insert("user.join", userMap);
	   response.sendRedirect("login.jsp");
	}

}
