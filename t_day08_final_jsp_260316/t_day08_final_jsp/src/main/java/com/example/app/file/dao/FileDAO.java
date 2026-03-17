package com.example.app.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.app.file.dto.FileDTO;
import com.example.config.MyBatisConfig;

public class FileDAO {
   public SqlSession sqlSession;

   public FileDAO() {
      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
   }
   
   //파일 추가 메소드
   public void insert(FileDTO fileDTO) {
      System.out.println("파일 DAO - 파일 저장 : " + fileDTO);
      
      try {
         int result = sqlSession.insert("file.insert", fileDTO);
         System.out.println("파일 저장 완료 - DB에 저장된 행의 개수 : " + result);
         //db에 파일이 제대로 저장되었는지 확인
         List<FileDTO> uploadFile = select(fileDTO.getBoardNumber());
         System.out.println("db에서 가져온 파일 : " + uploadFile);
      } catch (Exception e) {
         System.out.println("파일 저장이 실패했습니다 : " + e.getMessage());
         e.printStackTrace();
      }   
   }
   
   //파일 조회 메소드
   public List<FileDTO> select(int boardNumber){
      System.out.println("파일 DAO - 파일 조회메소드");
      return sqlSession.selectList("file.select", boardNumber);
   }
   
   //파일 삭제 메소드
   public void delete(int boardNumber) {
      sqlSession.delete("file.delete", boardNumber);
   }
   
}