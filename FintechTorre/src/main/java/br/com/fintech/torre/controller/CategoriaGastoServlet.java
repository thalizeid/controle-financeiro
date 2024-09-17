package br.com.fintech.torre.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.torre.bean.CategoriaGasto;
import br.com.fintech.torre.dao.CategoriaGastoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.factory.DAOFactory;

/**
 * Servlet implementation class CategoriaGastoServlet
 */
@WebServlet("/categoria-gasto")
public class CategoriaGastoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaGastoDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getCategoriaGastoDAO(); 
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriaGastoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * DO POST COM MÉTODOS ISOLADOS
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		
		case "excluir":
			excluir(request, response);
			break;
		}
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int cdCategoriaGasto = Integer.parseInt(request.getParameter("codigo"));
		try {
			dao.remover(cdCategoriaGasto);
			request.setAttribute("msg", "Categoria Removida");	
		}catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover");
		}
		listar(request,response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nomeCategoriaGasto = request.getParameter("nome");
			String dsCategoriaGasto = request.getParameter("descricao");

			CategoriaGasto categoriaGasto = new CategoriaGasto(0, nomeCategoriaGasto, dsCategoriaGasto);
			dao.cadastrar(categoriaGasto);

			request.setAttribute("msg", "Categoria Cadastrada");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao Cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por Favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-categoria-gasto.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int cdCategoriaGasto = Integer.parseInt(request.getParameter("codigo"));
			String nomeCategoriaGasto = request.getParameter("nome");
			String dsCategoriaGasto = request.getParameter("descricao");

			CategoriaGasto categoriaGasto = new CategoriaGasto(cdCategoriaGasto, nomeCategoriaGasto, dsCategoriaGasto);
			dao.atualizar(categoriaGasto);

			request.setAttribute("msg", "Categoria Atualizada");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao Atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por Favor, valide os dados");
		}
		listar(request, response);
	
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		System.out.println("Accao: " + acao + " ... Codigo:" + request.getParameter("codigo"));
		
		switch (acao){
			case "listar":
				listar(request, response);
				break;
				
			case "abrir-form-edicao":
				int cdCategoriaGasto = Integer.parseInt(request.getParameter("codigo"));
				CategoriaGasto categoriaGasto = dao.buscar(cdCategoriaGasto);
				request.setAttribute("categoria", categoriaGasto);
				request.getRequestDispatcher("edicao-categoria-gasto.jsp").forward(request, response);
	
				break;
				
			default:
				System.out.println("Invalid form action");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoriaGasto> lista = dao.listar();
		request.setAttribute("categorias", lista);
		request.getRequestDispatcher("lista-categoria-gasto.jsp").forward(request, response);
	}
	

}
