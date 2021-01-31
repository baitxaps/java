<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<h3><font color="red">${ msg }</font></h3>
	<form action="${ pageContext.request.contextPath }/UserServlet" method="post">
		<table border="1" width="400">
			<tr>
				<td>username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>