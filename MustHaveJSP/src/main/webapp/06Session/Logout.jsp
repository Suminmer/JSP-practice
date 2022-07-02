<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//방법1
session.removeAttribute("UserId");
session.removeAttribute("UserName");

//방법2
session.invalidate();

response.sendRedirect("LoginForm.jsp");
%>