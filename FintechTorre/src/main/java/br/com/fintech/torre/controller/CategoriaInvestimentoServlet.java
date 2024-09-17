package br.com.fintech.torre.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.torre.bean.CategoriaInvestimento;
import br.com.fintech.torre.dao.CategoriaInvestimentoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.factory.DAOFactory;

/**
 * Servlet implementation class CategoriaGastoServlet
 */
@WebServlet("/categoria-investimento")
public class CategoriaInvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaInvestimentoDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getCategoriaInvestimentoDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriaInvestimentoServlet() {
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
		int cdCategoriaInvestimento = Integer.parseInt(request.getParameter("codigo"));
		try {
			dao.remover(cdCategoriaInvestimento);
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
			String nomeCategoriaInvestimento = request.getParameter("nome");
			String dsCategoriaInvestimento = request.getParameter("descricao");

			CategoriaInvestimento categoriaInvestimento = new CategoriaInvestimento(0, nomeCategoriaInvestimento, dsCategoriaInvestimento);
			dao.cadastrar(categoriaInvestimento);

			request.setAttribute("msg", "Categoria Cadastrada");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao Cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por Favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-categoria-investimento.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int cdCategoriaInvestimento = Integer.parseInt(request.getParameter("codigo"));
			String nomeCategoriaInvestimento = request.getParameter("nome");
			String dsCategoriaInvestimento = request.getParameter("descricao");

			CategoriaInvestimento categoriaInvestimento = new CategoriaInvestimento(cdCategoriaInvestimento, nomeCategoriaInvestimento, dsCategoriaInvestimento);
			dao.atualizar(categoriaInvestimento);

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
		
		
		switch (acao){
			case "listar":
				listar(request, response);
				break;
				
			case "abrir-form-edicao":
				int cdCategoriaInvestimento = Integer.parseInt(request.getParameter("codigo"));
				CategoriaInvestimento categoriaInvestimento = dao.buscar(cdCategoriaInvestimento);
				request.setAttribute("categoria", categoriaInvestimento);
				request.getRequestDispatcher("edicao-categoria-investimento.jsp").forward(request, response);
				
				
	
				break;
				
			default:
				System.out.println("Invalid form action");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoriaInvestimento> lista = dao.listar();
		request.setAttribute("categorias", lista);
		request.getRequestDispatcher("lista-categoria-investimento.jsp").forward(request, response);
	}
	

}
