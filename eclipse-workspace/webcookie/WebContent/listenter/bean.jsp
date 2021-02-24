<%@page import="cn.huse.weblistener.BeanBindingListener"%>
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
// http://localhost:8080/webcookie/listenter/bean.jsp
	BeanBindingListener bean = new BeanBindingListener();
	bean.setName("william");
// 	bean to bind
// 属性添加：任何类型往里添加都可以，绑定：必须是java 对象
	session.setAttribute("bean",bean);
// 解除绑定
	session.removeAttribute("bean");
%>

</body>
</html>








