<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
 </head>
 <body>
<table>
  <tr>
   <td>
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
     <tr style=" text-align:center;">
      <td width="5"height="30"></td>
      <td>글쓰기</td>
      <td width="5"height="30"></td>
     </tr>
    </table>
    <form action="${pagecontext.request.contextpath}/board/write" method="post">
    	<input type="hidden" name="page" value=${page}>
   <table>
     <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td><input type="text" name="title" size="50" maxlength="100"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">작성자</td>
      <td><input type="text" name="writer" size="50" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
      <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea name="content" rows="20" cols="50"></textarea></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
     <tr align="center">
      <td>&nbsp;</td>
      <td colspan="2"><input type=submit value="등록">
       <a href="${pagecontext.request.contextpath}/board/list?page=${page}">
       	<input type=button value="취소">
       	</a>
      <td>&nbsp;</td>
     </tr>
    </table>
   </form>
   </td>
   </tr>
   </table>
   
</body> 
</html>
<!-- 참고: http://seinarin.tistory.com/5?category=452459 [행복을 찾아서]-->