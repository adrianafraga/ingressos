<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro - Evento</title>

<spring:url value="/evento/salva" var="salva"></spring:url>
<spring:url value="/evento/altera" var="altera"></spring:url>
<spring:url value="/evento/deleta" var="deleta"></spring:url>

</head>
<body>
	<form:form action="${salva}" modelAttribute="evento">
		<form:hidden path="id"/>
		
		<label>Nome:</label><br/>
		<form:input path="nome"/>
		</br>
		
		<label>Endereço:</label><br/>
		<form:input path="endereco"/>
		</br>
		
		<label>Numero:</label><br/>
		<form:input path="numero"/>
		</br>
		
		<label>CEP:</label><br/><br/>
		<form:input path="cep"/>
		</br>
		
		<label>Cidade:</label><br/>
		<form:input path="cidade"/>
		</br>
		
		<label>Estado:</label><br/>
		<form:input path="estado"/>
		</br>
		
		<label>Descrição:</label><br/>
		<form:input path="descricao"/>
		</br>
		
		<label>Data do Evento:</label><br/>
		<form:input path="data_evento"/>
		</br>
		
		<label>Faixa Etária:</label><br/>
		<form:input path="faixa_etaria"/>
		</br>
		
		<label>Folder:</label><br/>
		<form:input path="folder"/>
		
		<br />
		<br />
		
		<form:button>Cadastrar</form:button>
		
	
	</form:form>
	<table>
			<tr>
				<th>Código</th>
				<th>Nome do evento</th>
				<th>Endereço</th>
				<th>Número</th>
				<th>CEP</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>Descrição</th>
				<th>Data do evento</th>
				<th>Faixa Etária</th>
				<th>Folder</th>
				<td colspan="2">Ações</td>
			</tr>
			<c:forEach var="evento" items="${eventos}">
				<tr>
					<td>${evento.id}</td>
					<td>${evento.nome}</td>
					<td>${evento.endereco}</td>
					<td>${evento.numero}</td>
					<td>${evento.cep}</td>
					<td>${evento.cidade}</td>
					<td>${evento.estado}</td>
					<td>${evento.descricao}</td>
					<td>${evento.data_evento}</td>
					<td>${evento.faixa_etaria}</td>
					<td>${evento.folder}</td>
					<td><a href="${altera}/${evento.id}">Alterar</a></td>
					<td><a href="${deleta}/${evento.id}">Deletar</a></td>
				</tr>
			</c:forEach>
		</table>
	
	
	
	
</body>
</html>