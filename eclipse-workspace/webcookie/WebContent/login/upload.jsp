<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- default enctype:enctype=application/x-www-form-urlencoded -->
	<h1>file upload</h1>
	<h1>${ msg }</h1>
	<form action="${ pageContext.request.contextPath }/UploadServlet" method="post"
		enctype="multipart/form-data">
		文件描述:<input type="text" name="info"><br />
		文件上传:<input type="file" name="upload"><br /> <input type="submit" value="上传" />
	</form>
</body>
</html>



<!-- 文件上传的技术 -->
<!-- 	JSPSmartUpload	：应用在JSP上的文件上传和下载的组件。 -->
<!-- 	FileUpload		：应用在Java环境上的文件上传的功能。 -->
<!-- 	Servlet3.0			：提供文件上传的功能 -->
<!-- 	Struts2			：提供文件上传的功能 -->
<!-- 文件上传的要素 -->
<!-- 	文件上传的三个要素 -->
<!-- 	表单的提交的方式需要是POST -->
<!-- 	表单中需要有<input type=”file”>元素，需要有name属性和值。 -->
<!-- 	表单enctype=”multipart/form-data” -->











