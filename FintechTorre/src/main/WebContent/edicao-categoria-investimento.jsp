<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Categoria</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	
	<div class="container">
	
		<h2>Editar Categoria de Despesa</h2>
		
		<c:if test="${not empty msg }">
			<div class="alert alert-sucess">${msg}</div>
			</c:if>
		<c:if test="${not empty erro }">
			<div class = "alert alert-danger">${erro}</div>
		</c:if>
		
		<form action="categoria-investimento" method="post">
			<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${categoria.cdCategoriaInvestimento }" name="codigo">
			
			<div class="form-group">
				<label for="nome-categoria-investimento">Nome da Categoria</label> <input
					type="text" name="nome" id="nome"
					class="form-control" value="${categoria.nomeCategoriaInvestimento }">
			</div>
			<br>
			<div class="form-group">
				<label for="ds-categoria">Descrição</label> <input
					type="text" name="descricao" id="descricao"
					class="form-control" value="${categoria.dsCategoriaInvestimento }">
			</div>
			<br>
			<input type="submit" value= "Salvar" class= "btn btn-outline-dark" >
			<a href="categoria-investimento?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>
<%@ include file = "footer.jsp" %>

</body>
</html>