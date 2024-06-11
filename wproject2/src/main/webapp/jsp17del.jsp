<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<% String code = request.getParameter("code"); %>
<jsp:useBean id="connP" class="pack.ConnPooling" scope="page" />

<%
if(connP.deleteData(code)) 
	response.sendRedirect("jsp17dbcp.jsp");  // 삭제 후 목록보기
else
	response.sendRedirect("jsp17fail.html");
%>