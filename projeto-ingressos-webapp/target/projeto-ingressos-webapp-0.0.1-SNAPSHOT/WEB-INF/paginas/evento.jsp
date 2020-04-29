<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro - Evento</title>
</head>
<body>
	<form:form action="salva" modelAttribute="evento">
		<form:hidden path="id"/>
		
		<label>Nome:</label><br/>
		<form:input path="nome"/>
		
		<label>Endereço:</label><br/>
		<form:input path="endereco"/>
		
		<label>Numero:</label><br/>
		<form:input path="numero"/>
		
		<label>CEP:</label><br/>
		<form:input path="cep"/>
		
		<label>Cidade:</label><br/>
		<form:input path="cidade"/>
		
		<label>Estado:</label><br/>
		<form:input path="estado"/>
		
		<label>Descrição:</label><br/>
		<form:input path="descricao"/>
		
		<label>Data Evento:</label><br/>
		<form:input path="data_evento"/>
		
		<label>Faixa Etária:</label><br/>
		<form:input path="faixa_etaria"/>
		
		<label>Folder:</label><br/>
		<form:input path="folder"/>
		
		<br />
		<br />
		
		<form:button>Cadastrar</form:button>
	
	</form:form>
	
</body>
</html>