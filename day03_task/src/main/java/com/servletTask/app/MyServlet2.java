package com.servletTask.app;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
enum Gender{
	MALE("남자"),FEMALE("여자"),NONE("선택안함");
	private String korean;
	Gender(String korean){
		this.korean = korean;
	}
	public String getGenderKorean(int value) {
		switch(value) {
		case 1 -> {return Gender.MALE.korean;}
		case 2 -> {return Gender.FEMALE.korean;}
		default -> {return Gender.NONE.korean;}
		}		
	}
}
/**
 * Servlet implementation class MyServlet2
 */
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("forwardUserName");
		String strAge = request.getParameter("forwardUserAge");
		int age = Integer.parseInt(strAge);
		int radioValue = Integer.parseInt(request.getParameter("forwardGender"));
		Gender gender = Gender.NONE; 
		String koreanGender = gender.getGenderKorean(radioValue);
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("koreanGender", koreanGender);
		request.setAttribute("korAge", age - 1);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("redirectUserName");
		String strAge = request.getParameter("redirectUserAge");
		int age = Integer.parseInt(strAge);
		int radioValue = Integer.parseInt(request.getParameter("redirectGender"));
		Gender gender = Gender.NONE; 
		String koreanGender = gender.getGenderKorean(radioValue);
		
		response.sendRedirect(request.getContextPath() + "/result.jsp?redirectName=" 
				+ URLEncoder.encode(name, "UTF-8") + "&redirectAge=" + age + "&redirectGender="+URLEncoder.encode(koreanGender, "UTF-8"));
	}

}
