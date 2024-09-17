package br.com.fintech.torre.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.torre.bean.CategoriaGasto;
import br.com.fintech.torre.bean.Gasto;
import br.com.fintech.torre.dao.CategoriaGastoDAO;
import br.com.fintech.torre.dao.GastoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.factory.DAOFactory;

/**
 * Servlet implementation class GastoServlet
 */

@WebServlet("/gastoss")
public class GastoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GastoDAO dao;
	private CategoriaGastoDAO categoriaGastoDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getGastoDAO();
		categoriaGastoDAO= DAOFactory.getCategoriaGastoDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GastoServlet() {
		super();
	}

	/**
	 * 
	 *  DO GET COM METODOS ISOLADOS
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		System.out.println("on gastos Accao: " + acao + " ... Codigo:" + request.getParameter("codigo"));
		
		switch (acao){
			case "listar":
				listar(request, response);
				break;
				
			case "abrir-form-edicao":
				abrirFormEdicao(request, response);
				break;
			
			case "abrir-form-cadastro":	
				abrirFormCadastro(request, response);
				break;
		}
	}

	/**
	 * DO POST COM MÉTODOS ISOLADOS
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	//	doGet(request, response);
		
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
	
	

//	
//  MÉTODOS DO POST ------------------------------------------------------
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int cdGasto = Integer.parseInt(request.getParameter("codigo"));
		try {
			dao.remover(cdGasto);
			request.setAttribute("msg", "Transação Removida");	
		}catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover");
		}
		listar(request,response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nomeGasto = request.getParameter("nome");
			double valorGasto = Double.parseDouble(request.getParameter("valor"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataGasto = Calendar.getInstance();
			dataGasto.setTime(format.parse(request.getParameter("data")));
			
			int cdCategoriaGasto = Integer.parseInt(request.getParameter("categoria"));			
			
			CategoriaGasto categoriaGasto = new CategoriaGasto();
			categoriaGasto.setCdCategoriaGasto(cdCategoriaGasto);
			
			LocalDate dataGastoLD = LocalDateTime.ofInstant(dataGasto.toInstant(), dataGasto.getTimeZone().toZoneId()).toLocalDate();
			
			Gasto gasto = new Gasto(0, nomeGasto, valorGasto, dataGastoLD);
			gasto.setCategoriaGasto(categoriaGasto);
			
			System.out.println("inside do doPost 1");
			
			dao.cadastrar(gasto);
			
			System.out.println("inside do doPost 2");

			request.setAttribute("msg", "Transação Cadastrada");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao Cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por Favor, valide os dados");
		}
		abrirFormCadastro(request, response);
//		request.getRequestDispatcher("cadastro-gasto.jsp").forward(request, response);
		}
	
//	
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int cdGasto = Integer.parseInt(request.getParameter("codigo"));
			String nomeGasto = request.getParameter("nome");
			double valorGasto  = Double.parseDouble(request.getParameter("valor"));
			
			int cdCategoriaGasto = Integer.parseInt(request.getParameter("categoria"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataGasto = Calendar.getInstance();
			dataGasto.setTime(format.parse(request.getParameter("data")));
			LocalDate dataGastoLD = LocalDateTime.ofInstant(dataGasto.toInstant(), dataGasto.getTimeZone().toZoneId()).toLocalDate();

			Gasto gasto = new Gasto(cdGasto,  nomeGasto,  valorGasto,  dataGastoLD);
			
			CategoriaGasto categoriaGasto = new CategoriaGasto(cdCategoriaGasto, "", "");			
			gasto.setCategoriaGasto(categoriaGasto);
			
			dao.atualizar(gasto);

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

////  METODOS DOGET-----------------------------------------------------

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cdGasto = Integer.parseInt(request.getParameter("codigo"));
		
		System.out.println("getting gasto " + cdGasto);
		
		Gasto gasto = dao.buscar(cdGasto);
		request.setAttribute("gasto", gasto);
		carregarOpcoesCategoria(request);
		request.getRequestDispatcher("edicao-gasto.jsp").forward(request, response);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		
		carregarOpcoesCategoria(request);

//		System.out.println(" Inside do abrirFormCadastro");
//		List<CategoriaGasto> lista = categoriaGastoDAO.listar();
//		request.setAttribute("categoriasgastos", lista);

		request.getRequestDispatcher("cadastro-gasto.jsp").forward(request, response);
	}

	private void carregarOpcoesCategoria(HttpServletRequest request) {
		List<CategoriaGasto> lista = categoriaGastoDAO.listar();
		request.setAttribute("categorias", lista);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Gasto> lista = dao.listar();
		request.setAttribute("gastos", lista);
		request.getRequestDispatcher("lista-gasto.jsp").forward(request, response);
	}
	

}
