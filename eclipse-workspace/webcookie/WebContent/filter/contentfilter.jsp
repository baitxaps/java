<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>contentFilter.jsp</h1>
</body>
</html>


	<!--filter to configure -->
	<filter>
		<filter-name>contentFilter</filter-name>
		<filter-class>cn.huse.filter.ContentFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>contentFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	<!-- filter to configure -->

	
	

	


