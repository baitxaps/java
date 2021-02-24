<%@page import="cn.huse.weblistener.BeanActivationListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	BeanActivationListener activation = new BeanActivationListener();
	activation.setName("activation");
	session.setAttribute("activation", activation);
	%>
</body>
</html>