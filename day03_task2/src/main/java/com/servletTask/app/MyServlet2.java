package com.servletTask.app;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
	
	public String getGenderKorean(String value) {
		try {
				return Gender.valueOf(value.trim().toUpperCase()).korean;
			}
		catch(Exception e) {
			return Gender.NONE.korean;
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
//		int radioValue = Integer.parseInt(request.getParameter("forwardGender"));
		String radioValue = request.getParameter("forwardGender");
		Gender gender = Gender.NONE; 
		String koreanGender = gender.getGenderKorean(radioValue);
		String[] colors = request.getParameterValues("color");
	      if(colors == null) {
	          colors = new String[0];
	       }
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("koreanGender", koreanGender);
		request.setAttribute("korAge", age - 1);
		request.setAttribute("colors", colors);
		
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
//		int radioValue = Integer.parseInt(request.getParameter("redirectGender"));
		String strRadioValue = request.getParameter("redirectGender");
		System.out.println("["+ strRadioValue +"]");
		Gender gender = Gender.NONE; 
		String koreanGender = gender.getGenderKorean(strRadioValue);
		response.sendRedirect(request.getContextPath() + "/result.jsp?redirectName=" 
				+ URLEncoder.encode(name, StandardCharsets.UTF_8.toString()) 
				+ "&redirectAge=" + age 
				+ "&redirectGender="+URLEncoder.encode(koreanGender, StandardCharsets.UTF_8.toString()));
	}

}
