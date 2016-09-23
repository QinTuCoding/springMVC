<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>注册表单详细信息确认 - yiibai.com</title>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="success">
		确认信息 : ${success}
		<br>
		我们也给你发了确认邮件到您的电子邮件地址 : ${student.email}.
	</div>
</body>
</html>