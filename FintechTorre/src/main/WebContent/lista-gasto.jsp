<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Desepesas</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<br>
	<div class="container">
<h2>Despesas</h2>
      
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Data </th>
      <th scope="col">Nome</th>
      <th scope="col">Valor</th>
      <th scope="col">Categoria</th>
      <th></th>
    </tr>
  </thead>
  
  <c:forEach items="${ gastos }" var="g">
   <tr>
      <td>
                
      
     	 ${g.dataGasto}
      
      </td>
      <td>${g.nomeGasto}</td>
      <td>${g.valorGasto}</td>
      <td>${g.categoriaGasto.nomeCategoriaGasto}</td>
      <td> 
      	<c:url value="gastoss" var="link">
      		<c:param name="acao" value="abrir-form-edicao"/>
      		<c:param name="codigo" value="${g.cdGasto}"/>
      	</c:url>	
      	<a href="${link}">Editar</a>
      	<button type="button" 
      	class="btn btn-danger btn-xs" 
      	data-toggle="modal" 
      	data-target="#excluirModal" 
      	onclick="codigoExcluir.value = ${g.cdGasto}">
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
        		Deseja realmente excluir a despesa?
      </div>
      <div class="modal-footer">
      	<form action="gastoss" method="post">
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