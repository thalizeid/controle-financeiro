package br.com.fintech.torre.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.torre.bean.CategoriaRecebimento;
import br.com.fintech.torre.dao.CategoriaRecebimentoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.factory.DAOFactory;

/**
 * Servlet implementation class CategoriaRecebimentoServlet
 */
@WebServlet("/categoria-recebimento")
public class CategoriaRecebimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaRecebimentoDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getCategoriaRecebimentoDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriaRecebimentoServlet() {
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
		int cdCategoriaRecebimento = Integer.parseInt(request.getParameter("codigo"));
		try {
			dao.remover(cdCategoriaRecebimento);
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
			String nomeCategoriaRecebimento = request.getParameter("nome");
			String descricaoRecebimento = request.getParameter("descricao");

			CategoriaRecebimento categoriaRecebimento = new CategoriaRecebimento(0, nomeCategoriaRecebimento, descricaoRecebimento);
			dao.cadastrar(categoriaRecebimento);

			request.setAttribute("msg", "Categoria Cadastrada");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao Cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por Favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-categoria-recebimento.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int cdCategoriaRecebimento = Integer.parseInt(request.getParameter("codigo"));
			String nomeCategoriaRecebimento = request.getParameter("nome");
			String descricaoRecebimento = request.getParameter("descricao");

			CategoriaRecebimento categoriaRecebimento = new CategoriaRecebimento(cdCategoriaRecebimento, nomeCategoriaRecebimento, descricaoRecebimento);
			dao.atualizar(categoriaRecebimento);

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
				int cdCategoriaRecebimento = Integer.parseInt(request.getParameter("codigo"));
				CategoriaRecebimento categoriaRecebimento = dao.buscar(cdCategoriaRecebimento);
				request.setAttribute("categoria", categoriaRecebimento);
				request.getRequestDispatcher("edicao-categoria-recebimento.jsp").forward(request, response);
	
				break;
				
			default:
				System.out.println("Invalid form action");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoriaRecebimento> lista = dao.listar();
		request.setAttribute("categorias", lista);
		request.getRequestDispatcher("lista-categoria-recebimento.jsp").forward(request, response);
	}
	

}
