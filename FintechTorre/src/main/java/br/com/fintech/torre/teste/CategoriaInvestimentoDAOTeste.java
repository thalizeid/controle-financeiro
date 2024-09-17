package br.com.fintech.torre.teste;

import java.util.List;


import br.com.fintech.torre.bean.CategoriaInvestimento;
import br.com.fintech.torre.dao.CategoriaInvestimentoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.factory.DAOFactory;

public class CategoriaInvestimentoDAOTeste {
	public static void main(String[] args) {
		CategoriaInvestimentoDAO dao = DAOFactory.getCategoriaInvestimentoDAO();
		
		// CADASTRAR UMA CATEGORIA
		CategoriaInvestimento categoriaInvestimento = new CategoriaInvestimento(0, "CATEGORIA2", "DESCRICAO2");
		
		try {
			dao.cadastrar(categoriaInvestimento);
			System.out.println("Categoria Cadastrada.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// BUSCAR UMA CATEGORIA PELO CODIGO E ATUALIZAR
		categoriaInvestimento = dao.buscar(1);
		categoriaInvestimento.setNomeCategoriaInvestimento("CAT ATUALIZADA");
		categoriaInvestimento.setDsCategoriaInvestimento("DESC ATUALIZADA");
		try {
			dao.atualizar(categoriaInvestimento);
			System.out.println("Categoria Atualizada.");
		} catch (DBException e) {
			e.printStackTrace();
		}

    	// LISTAR AS CATEGORIAS
		List<CategoriaInvestimento> lista = dao.listar();
		for (CategoriaInvestimento item : lista) {
			System.out.println(item.getNomeCategoriaInvestimento() + " " + item.getDsCategoriaInvestimento());
		}

		// REMOVER UMA CATEGORIA
		try {
			dao.remover(2);
			System.out.println("Categoria removida.");
		} catch (DBException e) {
			e.printStackTrace();
		}

	
	}

}
