package com.example.app.file.dto;

public class FileDTO {
//   CREATE TABLE tbl_file(
//            file_system_name varchar2(300),
//            file_original_name varchar2(300),
//            board_number NUMBER,
//            CONSTRAINT pk_file PRIMARY key(file_system_name),
//            CONSTRAINT fk_file_board FOREIGN key(board_number) REFERENCES tbl_board(board_number) ON DELETE cascade
//         );
   private String fileSystemName; //서버 저장되는 파일명(PK)
   private String fileOriginalName; //원본 파일명
   private int boardNumber; //게시글번호(FK)
   
   public String getFileSystemName() {
      return fileSystemName;
   }
   public void setFileSystemName(String fileSystemName) {
      this.fileSystemName = fileSystemName;
   }
   public String getFileOriginalName() {
      return fileOriginalName;
   }
   public void setFileOriginalName(String fileOriginalName) {
      this.fileOriginalName = fileOriginalName;
   }
   public int getBoardNumber() {
      return boardNumber;
   }
   public void setBoardNumber(int boardNumber) {
      this.boardNumber = boardNumber;
   }
   @Override
   public String toString() {
      return "FileDTO [fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName + ", boardNumber="
            + boardNumber + "]";
   }
   
   
}
