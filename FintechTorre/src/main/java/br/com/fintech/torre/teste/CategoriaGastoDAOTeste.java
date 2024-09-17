package br.com.fintech.torre.teste;

import java.util.List;

import br.com.fintech.torre.bean.CategoriaGasto;
import br.com.fintech.torre.dao.CategoriaGastoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.factory.DAOFactory;

public class CategoriaGastoDAOTeste {

	public static void main(String[] args) {
		CategoriaGastoDAO dao = DAOFactory.getCategoriaGastoDAO();
		
		
		// CADASTRAR UMA CATEGORIA
		CategoriaGasto categoriaGasto = new CategoriaGasto(0, "CATEGORIA5", "DESCRICAO5");
		
		try {
			dao.cadastrar(categoriaGasto);
			System.out.println("Categoria Cadastrada.");
		} catch (DBException e) {
			e.printStackTrace();
		}

/*		// BUSCAR UMA CATEGORIA PELO CODIGO E ATUALIZAR
		categoriaGasto = dao.buscar(1);
		categoriaGasto.setNomeCategoriaGasto("CAT ATUALIZADA");
		categoriaGasto.setDsCategoriaGasto("DESC ATUALIZADA");
		try {
			dao.atualizar(categoriaGasto);
			System.out.println("Categoria Atualizada.");
		} catch (DBException e) {
			e.printStackTrace();
		}

    	// LISTAR AS CATEGORIAS
		List<CategoriaGasto> lista = dao.listar();
		for (CategoriaGasto item : lista) {
			System.out.println(item.getNomeCategoriaGasto() + " " + item.getDsCategoriaGasto());
		}

		// REMOVER UMA CATEGORIA
		try {
			dao.remover(1);
			System.out.println("Categoria removida.");
		} catch (DBException e) {
			e.printStackTrace();
		}*/
	
	}
	
}

