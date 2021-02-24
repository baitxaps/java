<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:8080/webcookie/jsp/success_new.jsp -->
<h1>login success! welcome :${ existUser.username }</h1>

<!-- project path:pageContext.request.contextPath -->
<a href="${ pageContext.request.contextPath }/jsp/sub.jsp">提交数据</a>
</body>
</html>