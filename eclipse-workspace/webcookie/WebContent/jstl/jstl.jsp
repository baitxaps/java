<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

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


<h1>foreach label to use</h1>
<%
	String[] arrs = {"a","b","c"};
	pageContext.setAttribute("arrs",arrs);
%>
<c:forEach var="s" items="${ arrs }">
	${ s }
</c:forEach>
</br>


<%
	List<String> list = new ArrayList<String>();
	list.add("1");
	list.add("2");
	pageContext.setAttribute("list",list);
%>
<c:forEach var="s" items="${ list }">
	${ s } 
</c:forEach>
</br>


<%
	Map<String,Integer> map = new HashMap<String,Integer>();
	map.put("a",1);
	map.put("b",2);
	pageContext.setAttribute("map",map);
%>
<c:forEach var="entry" items="${ map }">
	${ entry.key }:${ entry.value }
</c:forEach>
</br>

<c:forEach var = "i" begin="1" end="10" step="1">
	${ i }
</c:forEach>
</br>

<c:forEach var="i" begin="100" end="200" step="2" varStatus="status">
	<c:if test="${ status.count %3 ==0 }">
		<font color = "blue">${ i }</font>
	</c:if>
	<c:if test="${ status.count %3 !=0 }">
		${ i }
	</c:if>
</c:forEach>
</br>


</body>
</html>














