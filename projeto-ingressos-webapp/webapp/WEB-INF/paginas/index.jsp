<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title> Ingressos Online</title>
<spring:url value="evento/" var="evento"></spring:url>
</head>
<body>
	<h1> Form Ingressos Online </h1>
	<hr/>
	<a href="${evento}"> Evento</a>
</body>
</html>