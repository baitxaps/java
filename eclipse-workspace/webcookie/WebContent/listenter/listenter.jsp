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
	session.setAttribute("name", "add");
	session.setAttribute("name", "replace");
	session.removeAttribute("name");
	%>
	
	${ activation.name }
	
</body>
</html>






