<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Categoria</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<div class="container">
		<h2>Adicionar Categoria de Receita</h2>
		<c:if test="${not empty msg }">
			<div class="alert alert-sucess">${msg}</div>
			</c:if>
		<c:if test="${not empty erro }">
			<div class = "alert alert-danger">${erro}</div>
		</c:if>
		<form action="categoria-recebimento" method="post">
		<input type="hidden" value= "cadastrar" name="acao">
			<div class="form-group">
				<label for="nome-categoria-recebimento">Nome da Categoria</label> <input
					type="text" name="nome" id="nome"
					class="form-control">
			</div>
			<br>
			<div class="form-group">
				<label for="ds-categoria">Descrição</label> <input
					type="text" name="descricao" id="descricao"
					class="form-control">
			</div>
			<br>
			<input type="submit" value= "Adiconar" class= "btn btn-outline-dark" >
		</form>
	</div>
<%@ include file = "footer.jsp" %>
</body>
</html>