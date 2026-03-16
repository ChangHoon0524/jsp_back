<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>자유게시판</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/board/boardList.css" />
  </head>
  <body>
  <jsp:include page="/header.jsp" />
    <div class="container">
      <div class="write-btn-wrap">
        <!-- 글쓰기 페이지 이동 처리 -->
        <a href="${pageContext.request.contextPath}/board/boardWrite.bo" class="write-btn">글쓰기</a>
      </div>

      <!-- 게시글 목록 -->
      <div class="board-list">
        <div class="board-header">
          <span class="no">번호</span>
          <span class="title">제목</span>
          <span class="author">작성자</span>
          <span class="date">날짜</span>
          <span class="hit">조회수</span>
        </div>

<!--         <div class="board-row">
          <span class="no">1</span>
          <span class="title">첫 번째 게시글입니다.</span>
          <span class="author">홍길동</span>
          <span class="date">2025-08-16</span>
          <span class="hit">10</span>
        </div> -->
        <!-- 게시글 목록 -->
                 <div class="board-body">
            <c:choose>
               <c:when test="${not empty boardList}">
                  <c:forEach var="board" items="${boardList}">
                      <div class="board-row">
                         <div class="board-item no">
                            <c:out value="${board.getBoardNumber()}" />
                         </div>
                         <div class="board-item title">
                            <a href="${pageContext.request.contextPath}/board/boardReadOk.bo?boardNumber=${board.boardNumber}">
                               <c:out value="${board.getBoardTitle()}" />
                            </a>
                         </div>
                         <div class="board-item author">
                            <c:out value="${board.getMemberId() }" />
                         </div>
                         <div class="board-item date">
                            <c:out value="${board.getBoardDate() }" />
                         </div>
                         <div class="board-item hit">
                            <c:out value="${board.getBoardReadCount() }" />
                         </div>
                      </div>
                   </c:forEach>
               </c:when>
               <c:otherwise>
                  <div>
                     <div colspan="5" align="center">등록된 게시물이 없습니다.</div>
                  </div>
               </c:otherwise>
            </c:choose>
         </div>   
      </div>
      
      </div>
      <div class="pagination">
        <ul>
          <!-- 페이징 처리 -->
         <!--  <li><a href="#" class="prev">&lt;</a></li>
          <li><a href="#" class="active">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li><a href="#" class="next">&gt;</a></li> -->
          <c:if test="${prev }">
          	<li><a href="${PageContext.request.contextPath}/board/boardListOk.bo?page=${startPage-1}"></a>
          	</li>
          </c:if>
          <c:set var="realStartPage" value ="${startPage < 0 ? 0 : startPage }"/>
          <c:forEach var="i" begin="${realStartPage}" end="${endPage }">
     		<c:choose>
     			<c:when test="${!(i==page) }">
     				<li><a href="${pageContext.request.contextPath}/board/boardListOk.bo?page=${i}">
     					<c:out value="${i}"/>
     				</a></li>     				
     			</c:when>
     			<c:otherwise>
     				<li><a href="#" class="active"></a></li>
     			</c:otherwise>
     		</c:choose>     
          </c:forEach>
          <c:if test="${next }">
          	<li><a href="${pageContext.request.contextPath }/board/boardListOk.bo?page=${endPage+1}"></a></li>
          </c:if>
        </ul>
       </div>      
   </div>
   <script>
   		let memberNumber = "${sessionScope.memberNumber}";
   </script>
  </body>
</html>