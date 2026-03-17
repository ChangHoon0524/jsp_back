package com.example.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.board.dao.BoardDAO;
import com.example.app.board.dto.BoardDTO;
import com.example.app.file.dao.FileDAO;
import com.example.app.file.dto.FileDTO;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

public class BoardUpdateOkController implements Execute{

   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {


      BoardDAO boardDAO = new BoardDAO();
      BoardDTO boardDTO = new BoardDTO();
      FileDAO fileDAO = new FileDAO();
      Result result = new Result();
      
      final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
      final int FILE_SIZE = 1024 * 1024 * 5;
      
      //MultipartParser 실행
      MultipartParser parser = new MultipartParser(request, FILE_SIZE);
      parser.setEncoding("utf-8");
      System.out.println("MultipartParser 초기화 완료");
      
      int boardNumber = 0;
      boolean isFileUpload = false;
      
      //파일, 텍스트 데이터 처리
      Part part;
      while((part = parser.readNextPart()) != null) {
         System.out.println("Part : " + part.getClass().getSimpleName());
         
         if(part.isParam()) {
            //텍스트 파라미터 처리
            ParamPart paramPart = (ParamPart) part;
            String paramName = paramPart.getName();
            String paramValue = paramPart.getStringValue();
            
            System.out.println("파라미터 : " + paramName + " = " + paramValue);
            
            if("boardNumber".equals(paramName)) {
               boardNumber = Integer.parseInt(paramValue);
               boardDTO.setBoardNumber(boardNumber);
            }else if("boardTitle".equals(paramName)) {
               boardDTO.setBoardTitle(paramValue);
            }else if("boardContent".equals(paramName)) {
               boardDTO.setBoardContent(paramValue);
            }
         }else if(part.isFile() && !isFileUpload) {
            FilePart filePart = (FilePart)part;
            filePart.setRenamePolicy(new DefaultFileRenamePolicy());
            String fileOriginalName = filePart.getFileName();
            
            //기존 파일 삭제
            if(boardNumber != 0) {
               List<FileDTO> existingFiles = fileDAO.select(boardNumber);
               for(FileDTO file : existingFiles) {
                  File oldFile = new File(UPLOAD_PATH, file.getFileSystemName());
                  if(oldFile.exists()) {
                     System.out.println("기존 파일 삭제 : " + oldFile.getAbsolutePath());
                     oldFile.delete();
                  }
               }
               fileDAO.delete(boardNumber);
               System.out.println("기존 파일 db삭제 완료");
            }
            
            //새로운 파일 저장
            if(fileOriginalName != null) {
               String newFileName = System.currentTimeMillis() + "_" + fileOriginalName;
               File newFile = new File(UPLOAD_PATH, newFileName);
               filePart.writeTo(newFile);
               
               if(newFile.exists()) {
                  System.out.println("새로운 파일 저장 완료 : " + newFile.getAbsolutePath());
               }else {
                  System.out.println("새로운 파일 저장 실패 : " + newFile.getAbsolutePath());
               }
               
               //db저장
               FileDTO fileDTO = new FileDTO();
               fileDTO.setFileSystemName(newFileName);
               fileDTO.setFileOriginalName(fileOriginalName);
               fileDTO.setBoardNumber(boardNumber);
               System.out.println("새로운 파일 확인 : " + fileDTO);
               fileDAO.insert(fileDTO);
               System.out.println("새로운 파일 DB 저장 완료 : " + fileDTO);
               
               isFileUpload = true;
            }else {
               System.out.println("업로드된 파일이 없습니다.");
            }
            
         }
      }
      
      //게시글 업데이트 실행
      boardDTO.setMemberNumber((Integer)request.getSession().getAttribute("memberNumber"));
      boardDAO.updateBoard(boardDTO);
      System.out.println("게시글 수정 완료");
      
      //수정 완료 후 페이지 이동
      result.setPath("/board/boardListOk.bo");
      result.setRedirect(true);
      
      return result;
   }
   
}