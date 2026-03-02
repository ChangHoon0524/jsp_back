package com.servlet.output;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutputServlet
 */
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
		// 클라이언트가 전송 버튼을 누르면 화면에 000님 환영합니다로 뿌려준다
		// 클라이언트의 요청을 받아 요청에 저장되어있는 데이터를 꺼내어 클라이언트에 보내준다
		// 클라이언트에게 데이터를 보내려면 응답을 전달한다
		// response를 활용하여 클라이언트에게 데이터를 보내줄 수 있다
//		response.setContentType("text/html;charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print("<h1>" + request.getParameter("name") + "님 환영합니다.</h1>");
//		out.close();
//      여전히 서블릿 방식을 이용하고 있는 코드(OutputServlet에서 바로 HTML을 출력)
	      
//      파라미터를 받기 -> request 저장 -> result.jsp로 forward
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// POST 한글 처리(반드시 먼저 처리)
		request.setCharacterEncoding("UTF-8");
		
		// 폼 데이터
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// request에 저장
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
		// result.jsp로 이동
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		// 지금 요청(request)를 그대로 가지고 result.jsp로 내부 이동
		// /output 경로 그대로
	}

}
