package com.servlet.output;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutputServlet
 */
@WebServlet("/output")
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// request는 사용자가 입력한 폼 데이터를 가지고 있다.
		// 폼 데이터를 꺼내는 방법은 getParameter(데이터이름)을 사용하면 된다
		// 데이터의 이름은 input 태그의 name속성에 입력한 값과 동일
		// 반환타입은 문자열
		
		String name = request.getParameter("name");
		System.out.println(name);
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println(age);
		
		// 화면에 값을 나오게 하기
		// name이라는 변수와 age라는 변수에 입력값을 담아둔 것을 활용한다
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>결과창</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h3>이름 : " + name + "</h3>");
		out.print("<h3>나이 : " + age + "</h3>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// post 방식인 경우 getParameter()를 호출하기 전에 인코딩 방식을 설정해야 한글깨짐 오류가 없다.
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		System.out.println(name);
		int age = Integer.parseInt(request.getParameter("userAge"));
		System.out.println(age);
		
		// 화면에 값을 나오게 하기
		// name이라는 변수와 age라는 변수에 입력값을 담아둔 것을 활용한다
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>결과창</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h3>이름 : " + name + "</h3>");
		out.print("<h3>나이 : " + age + "</h3>");
		out.print("</body>");
		out.print("</html>");
	}

}
