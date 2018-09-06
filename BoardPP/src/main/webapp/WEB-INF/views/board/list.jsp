<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a:link  { text-decoration: none; color: #5E5E5E}
a:visited {  text-decoration: none; color: #5E5E5E}
a:active {  text-decoration: none; color: #5E5E5E}     
a:hover { text-decoration: none; color:#F36798} 
</style>
</head>
<body>
<h2 style="text-align:center; color:#5E5E5E;">게시판</h2>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr height="20"></tr>
 <tr style="text-align:center;">
   <td width="5"></td>
   <td width="60">번호</td>
   <td width="379">제목</td>
   <td width="73">작성자</td>
   <td width="164">작성일</td>
   <td width="60">조회수</td>
   <td width="5"></td>
  </tr>
<c:forEach var="board" items="${bList}">

<tr height="25" align="center">
	<td>&nbsp;</td>
	<td>${board.bno}</td>
	<td align="left"><a href="${pagecontext.request.contextpath}/board/read?bno=${board.bno}&page=${page.curPage}">${board.title}</a></td>
	<td align="center">${board.writer}</td>
	<td align="center">${board.regdate}</td>
	<td align="center">${board.viewcnt}</td>
	<td>&nbsp;</td>
</tr>
  <tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
</c:forEach>
  <tr height="1" bgcolor="#82B5DF"><td colspan="6" width="752"></td></tr>
 </table>
 
<table width="100%" cellpadding="0" cellspacing="0" border="0">
  <tr><td height="10"></td></tr>
  <tr align="center">
  	<td width="25%"></td>
  	<td width="50%">
  		<c:if test="${page.prevButton}">
  		<a href="${pagecontext.request.contextpath}/board/list?page=${page.firstPage-1}">◀<b> 이전</b>&nbsp;</a>
  		</c:if>
  		
  		<c:forEach var="pageNum" begin="${page.firstPage}" end="${page.lastPage}" step="1">
  			<a href="${pagecontext.request.contextpath}/board/list?page=${pageNum}&searchType=${search.searchType}&keyword=${search.keyword}">
  			<b>${pageNum}</b></a>&nbsp;
  		</c:forEach>
  		
  		<c:if test="${page.nextButton}">
  		<a href="${pagecontext.request.contextpath}/board/list?page=${page.lastPage+1}"><b>다음</b> ▶</a>
  		</c:if>
  	</td>
    <td width="22.5%" align="right"><a href="${pagecontext.request.contextpath}/board/write?page=${page.curPage}"><input type=button value="글쓰기"></a></td>
  	<td width="2.5%"></td>
  </tr>
  <tr>
  	<td width="25%"></td>
  	<td width="50%" align="center">
  		<form action="${pagecontext.request.contextpath}/board/list" method="get">
   			<select name = "searchType">
   				<option value ="title" <c:out value="${search.searchType == 'title'?'selected':''}"/>>제목</option>
   				<option value="content"<c:out value="${search.searchType == 'content'?'selected':''}" />>내용</option>
   				<option value="titlecontent"<c:out value="${search.searchType == 'titlecontent'?'selected':''}"/>>제목+내용</option>
   				<option value="wirter"<c:out value="${search.searchType == 'wirter'?'selected':''}"/>>작성자</option>
   			</select>
   			<input type="text" name = "keyword" value=${search.keyword}>
   			<input type="submit" value="검색">
   		</form>
   	</td>
   	<td width="25%" colspan=2></td>
  </tr>
</table>
</body> 
</html>


<!-- 참고: http://seinarin.tistory.com/3 [행복을 찾아서] -->