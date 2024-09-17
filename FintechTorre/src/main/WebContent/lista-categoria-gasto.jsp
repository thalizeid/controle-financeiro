<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Categorias</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<div class="container">
<h2>Categorias Cadastradas - Despesas</h2>
      
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Nome </th>
      <th scope="col">Descrição</th>
      <th></th>
    </tr>
  </thead>
  
  <c:forEach items="${ categorias }" var="ct">
   <tr>
      <td>${ct.nomeCategoriaGasto}</td>
      <td>${ct.dsCategoriaGasto}</td>
      <td> 
      	<c:url value="categoria-gasto" var="link">
      		<c:param name="acao" value="abrir-form-edicao"/>
      		<c:param name="codigo" value="${ct.cdCategoriaGasto}"/>
      	</c:url>	
      	<a href="${link}">Editar</a>
      	<button type="button" 
      	class="btn btn-danger btn-xs" 
      	data-toggle="modal" 
      	data-target="#excluirModal" 
      	onclick="codigoExcluir.value = ${ct.cdCategoriaGasto}">
      	Excluir
      	</button>
      	
      	
      	
      	</td>
    </tr>
   </c:forEach>
  
</table>

</div>
<%@ include file="footer.jsp" %>

<!-- Modal -->
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir a categoria?
      </div>
      <div class="modal-footer">
      	<form action="categoria-gasto" method="post">
      		<input type="hidden" name="acao" value="excluir" />
      		<input type="hidden" name="codigo" id="codigoExcluir" />
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>


</body>
</html>