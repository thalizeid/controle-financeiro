<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Despesa</title>
<%@ include file="header.jsp"%>
</head>

<!-- INICIO BODY
 -->
 
<body>
	<%@ include file="menu.jsp"%>
	<br>
	
	<div class="container">	
		<h2>Cadastrar Despesa   </h2>
		
<!-- CONDICIONAIS DA TAGLIB PARA VALIDAR O CADASTRO		
 -->	
 	<c:if test="${not empty msg }">
			<div class="alert alert-sucess">${msg}</div>
			</c:if>
		<c:if test="${not empty erro }">
			<div class = "alert alert-danger">${erro}</div>
		</c:if>
		
<!-- FIM DAS CONDICIONAIS E INICIO FORMULARIO DE CADASTRO
 -->
 
 		<form action="gastoss" method="post">
		<input type="hidden" value= "cadastrar" name="acao">
		
 	<div class="form-group">
				<label for="data-gasto">Data</label> <input
					type="text" name="data" id="data"
					class="form-control">
			</div>
			<br> 
			<div class="form-group">
				<label for="nome-gasto">Nome da Despesa</label> <input
					type="text" name="nome" id="nome-gasto"
					class="form-control">
			</div>
			<br>
			<div class="form-group">
				<label for="vl-gasto">Valor</label> <input
					type="text" name="valor" id="vl-gasto"
					class="form-control">
			</div>
			<br>
			
			<div class="form-group">
				<label for="id-categoria">Categoria</label> 
				<select name="categoria" id="id-categoria"
					class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${categorias}" var="cg">
						<option value="${cg.cdCategoriaGasto}"> ${cg.nomeCategoriaGasto}</option>
					</c:forEach>
				</select>
							
			</div>
			<br> 
			
			<input type="submit" value= "Adicionar" class= "btn btn-outline-dark" >
		</form>
	</div>
<%@ include file = "footer.jsp" %>
</body>
</html>