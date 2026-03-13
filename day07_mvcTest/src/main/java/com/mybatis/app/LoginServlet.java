package com.mybatis.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession();
		// .openSession(); => 조회
		// .openSession(true); => 삽입, 삭제, 수정

		Map<String, String> userMap = new HashMap<>();
		userMap.put("userId", userId);
		userMap.put("userPw", userPw);

		// selectOne : 단 건 조회
		Map<String, String> user = sqlSession.selectOne("user.login", userMap);
		System.out.println("조회 결과 : " + user);

		if (user != null) {
			HttpSession session = request.getSession();

			System.out.println("꺼내온 id : " + user.get("USERID"));
			System.out.println("꺼내온 name : " + user.get("USERNAME"));
//		         별칭 붙였을 때
//		         DB 조회 결과 : {USERID=kdt, USERNAME=철수}
//		         꺼내온 id : kdt
//		         꺼내온 name : 철수

//		         별칭을 붙이지 않았을 때 
//		         {userPw=1234, userId=kdt}
//		         DB 조회 결과 : {USER_ID=kdt, USER_NAME=철수}
//		         꺼내온 id : null
//		         꺼내온 name : null

			session.setAttribute("userId", user.get("USERID"));
			session.setAttribute("userName", user.get("USERNAME"));

			System.out.println("세션 ID : " + session.getAttribute("userId"));
			System.out.println("세션 name : " + session.getAttribute("userName"));

//		         {userPw=1234, userId=kdt}
//		         DB 조회 결과 : {USERID=kdt, USERNAME=철수}
//		         꺼내온 id : kdt
//		         꺼내온 name : 철수
//		         세션 ID : null
//		         세션 name : null

//		         DB 조회 결과 : {USERID=kdt, USERNAME=철수}
//		         꺼내온 id : kdt
//		         꺼내온 name : 철수
//		         세션 ID : kdt
//		         세션 name : 철수
		}
		else {
			response.getWriter().print("fail");
		}
	}

}
