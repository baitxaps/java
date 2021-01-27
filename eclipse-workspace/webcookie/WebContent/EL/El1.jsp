<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL get data</h1>
<%
	pageContext.setAttribute("name","apgeContext-jack");
	request.setAttribute("name","request-jack");
	session.setAttribute("name","session-jack");
	application.setAttribute("name","application-jack");
%>
<%=pageContext.getAttribute("name") %> - ${pageScope.name} <br/>
<%=request.getAttribute("name") %> - ${requestScope.name} <br/>
<%=session.getAttribute("name") %> - ${sessionScope.name} <br/>
<%=application.getAttribute("name") %> - ${applicationScope.name} <br/>

<h3>EL简写,从最小范围查找</h3>
${name}

<h1>el get web obj</h1>
<!-- http://localhost:8080/webcookie/EL/El1.jsp?name="a"&hobby="bb" -->
${ param.name } <br/> <!-- request.getParamter("name") -->
${ paramValues.hobby[0]} <br/> <!-- request.getParamterValues("hobby") -->
${ header["User-Agent"] } <br/>
${ initParam.username } <br/>

<!-- ${ pageContext.request.contextPath } <br/> -->  <!-- get project name -->
<!-- ${ pageContext.request.remoteAddr } <br/> -->  <!-- get IP address -->

</body>
</html>













