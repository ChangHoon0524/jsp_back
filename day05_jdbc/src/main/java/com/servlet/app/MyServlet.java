package com.servlet.app;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
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
		try {
			request.setCharacterEncoding("UTF-8");
			
			String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
			String userName = request.getParameter("userName");
			int userAge = Integer.parseInt(request.getParameter("userAge")); 
			String userGender = request.getParameter("userGender");
			
			// JDBC 시작
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 커넥션 객체 생성
			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"jsp",
					"1234"
					);
			// 쿼리문(회원가입 Insert)
			String sql = "INSERT INTO TBL_USER VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPw);
			ps.setString(3, userName);
			ps.setInt(4, userAge);
			ps.setString(5, userGender);
			
			ps.executeUpdate();
			ps.close();
			
			connection.close();
			
			
//		request.setAttribute("userId", userId);
//		request.setAttribute("userPw", userPw);
//		request.setAttribute("userName", userName);
//		request.setAttribute("userAge", userAge);
//		request.setAttribute("userGender", userGender);
//		
			// forward 결과.jsp
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
