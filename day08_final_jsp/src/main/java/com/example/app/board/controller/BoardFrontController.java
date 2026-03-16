package com.example.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Result;

/**
 * Servlet implementation class BoardFrontController
 */
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("BoardFrontController 현재 경로 : " + target);
		
		Result result = null;
		switch(target) {
		case "/board/boardListOk.bo" -> {
			System.out.println("게시물 목록 처리 요청");
			result = new BoardListOkController().execute(request, response);
		}
		case "/board/boardReadOk.bo" ->{
			System.out.println("게시물 상세 페이지 처리 요청");
			result = new BoardReadOkController().execute(request, response);
			System.out.println("게시물 상세 페이지 처리 완료");
		}
		case "/board/boardWrite.bo"->{
			System.out.println("게시물 작성 페이지 이동 요청");
			result = new BoardWriteController().execute(request, response);
		}
		}
	}
}
