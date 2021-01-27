<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- test:http://localhost:8080/webcookie/jstl/jstl.jsp -->
<%
	pageContext.setAttribute("name","aaa");
%>

<c:set value="bbb" var="name" scope="page"> </c:set>
${ name }

<h1>how to use the if label </h1>
<c:set var ="i" value = "5" scope="page"></c:set>
<c:if test="${ i>=10 }">
	<font color="red">i greater than 10</font>
</c:if>

<c:if var="flag" test="${ i<10 }" scope="page">
	<font color="blue">i less than 10</font>
</c:if>
<c:if test= "${flag }">
	flag is true
</c:if>

</body>
</html>














