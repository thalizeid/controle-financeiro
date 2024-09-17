<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg roxo px-lg-5 px-3"
	data-bs-theme="light"
	style="background-color: rgba(224, 100, 105, 0.60)">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Torre</a>
		<button class="navbar-toggler " type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home.jsp">Home</a></li>
				<!-- <li class="nav-item"><a class="nav-link" href="listar-receitas.jsp">Receitas</a> 
				</li>-->
				<li class="nav-item"><a class="nav-link" href="gastoss?acao=listar">Despesas</a>
				</li>
				<!-- <li class="nav-item"><a class="nav-link" href="listar-investimento.jsp">Investimentos</a> 
				</li>-->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Cadastrar </a>
					<ul class="dropdown-menu">
						<!-- <li><a class="dropdown-item" href="">Receita</a></li> -->
						<li><a class="dropdown-item" href="gastoss?acao=abrir-form-cadastro">Despesa</a></li>
						<!--  <li><a class="dropdown-item" href="">Investimento</a></li> -->
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false">Categorias </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="cadastro-categoria-recebimento.jsp?acao=cadastrar">Adicionar Categoria de Receita</a></li>
						<li><a class="dropdown-item" href="cadastro-categoria-gasto.jsp?acao=cadastrar">Adicionar Categoria de Despesa</a></li>
						<li><a class="dropdown-item" href="cadastro-categoria-investimento.jsp?acao=cadastrar">Adicionar Categoria de Investimento</a></li>
						<hr class="dropdown-divider">
						<li><a class="dropdown-item" href="categoria-recebimento?acao=listar">Listar Categorias de Receita</a></li>					
						<li><a class="dropdown-item" href="categoria-gasto?acao=listar">Listar Categorias de Despesa</a></li>
						<li><a class="dropdown-item" href="categoria-investimento?acao=listar">Listar Categorias de Investimento</a></li>	
			</ul></li>
			 <c:if test="${empty user }">
	    <span class="navbar-text text-danger" style="margin-right:10px" >
	        ${erro }
	  	</span>	
			
			
			<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false">Login </a>

	  	<ul class="dropdown-menu">
	    <form class="form-inline my-2 my-lg-0" action="login" method="post">
	      <li><input class="dropdown-item form-control mr-sm-2" type="text" name="email" placeholder="Email"></li>
	      <li><input class="dropdown-item form-control mr-sm-2" type="password" name="senha" placeholder="Senha"></li>
	      <li><button class="dropdown-item btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button></li>
	    </form>
	    </ul></li>
			</c:if>
			    <c:if test="${not empty user }">
			    		<span class="navbar-text">
				    		${user }
				    		<a href="login" class="btn btn-outline-primary my-2 my-sm-0">Sair</a>
	  			</span>
			</c:if> 
		</div>
	</div>
</nav>