package com.servlet.input;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>회원정보 입력</h2>");
		out.print("<form  method='post' action='" + request.getContextPath() + "/output'>");
		out.print("이름 : <input type='text' name='name'><br>");
		out.print("나이 : <input type='text' name='age'><br>");
		out.print("아이디 : <input type='text' name='id'><br>");
		out.print("비밀번호 : <input type='text' name='pw'><br>");
		out.print("<input type='submit' value='전송'><br>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
