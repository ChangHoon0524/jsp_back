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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("userId", request.getParameter("userId"));
		request.setAttribute("userPw", request.getParameter("userPw"));
		request.setAttribute("userName", request.getParameter("userName"));
		request.setAttribute("userAge", request.getParameter("userAge"));
		request.setAttribute("userGender", request.getParameter("userGender"));
		
		//SqlSessionFactory의 openSession()을 사용하면 sqlSession을 가져온다
		//openSession()에 true를 넣어줘야 auto commit이 된다
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
//		sqlSession.commit();
//		sqlSession.rollback();
		
		//Mapper에 넘겨줄 map 만들기
		Map<String, String> usersMap = new HashMap<>();
		usersMap.put("userId", request.getParameter("userId"));
		usersMap.put("userPw", request.getParameter("userPw"));
		usersMap.put("userName", request.getParameter("userName"));
		usersMap.put("userAge", request.getParameter("userAge"));
		usersMap.put("userGender", request.getParameter("userGender"));
		
		//sqlSession에는 insert, select, update, delete 메소드가 존재한다
		//매개변수로 미리 작성한 sql문의 위치만 알려주면 된다
		//sql문 mapper.xml파일에 위치를 작성한다(우리는 아직 없으므로 Mapper.xml 만들러간다)
		
		//+++++++++++++++++++++++++++++++++++++++++++
		//이제 insert에 우리가 만든 쿼리문 위치를 알려주고 넘겨줄 데이터를 작성한다(map)
		sqlSession.insert("users.join", usersMap);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

}









