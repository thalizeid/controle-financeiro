<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Despesa</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	
	<div class="container">
	
		<h2>Editar Despesa</h2>
		
		<c:if test="${not empty msg }">
			<div class="alert alert-sucess">${msg}</div>
			</c:if>
		<c:if test="${not empty erro }">
			<div class = "alert alert-danger">${erro}</div>
		</c:if>
		
		<form action="gastoss" method="post">
			<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${gasto.cdGasto }" name="codigo">
			<div class="form-group">
				<label for="data-gasto">Data</label> <input
					type="text" name="data" id="data" value="${gasto.dataGastoFmt}"
					class="form-control">
			</div>
			<br> 
			<div class="form-group">
				<label for="nome-gasto">Nome da Despesa</label> <input
					type="text" name="nome" id="nome" value="${gasto.nomeGasto}"
					class="form-control">
			</div>
			<br>
			<div class="form-group">
				<label for="vl-gasto">Valor</label> <input
					type="text" name="valor" id="valor" value="${gasto.valorGasto}"
					class="form-control">
			</div>
			<br>
			
			<div class="form-group">
				<label for="id-categoria">Categoria</label> 
				<select name="categoria" id="categoria"
					class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${categorias}" var="cg">
						
						
						<c:if test="${gasto.categoriaGasto.cdCategoriaGasto == cg.cdCategoriaGasto}">
							<option value="${cg.cdCategoriaGasto}" selected> ${cg.nomeCategoriaGasto}</option>
						</c:if>
						<c:if test="${gasto.categoriaGasto.cdCategoriaGasto != cg.cdCategoriaGasto}">
							<option value="${cg.cdCategoriaGasto}"> ${cg.nomeCategoriaGasto}</option>
						</c:if>
						
					</c:forEach>
				</select>
							
			</div>
			
			
			<br>
			<input type="submit" value= "Salvar" class= "btn btn-outline-dark" >
			<a href="gastoss?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>
<%@ include file = "footer.jsp" %>

</body>
</html>