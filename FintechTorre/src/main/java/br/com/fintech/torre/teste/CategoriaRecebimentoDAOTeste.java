package br.com.fintech.torre.teste;

import java.util.List;

import br.com.fintech.torre.bean.CategoriaRecebimento;
import br.com.fintech.torre.dao.CategoriaRecebimentoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.factory.DAOFactory;

public class CategoriaRecebimentoDAOTeste {
	
	public static void main(String[] args) {
		CategoriaRecebimentoDAO dao = DAOFactory.getCategoriaRecebimentoDAO();
		
		// CADASTRAR UMA CATEGORIA
		CategoriaRecebimento categoriaRecebimento = new CategoriaRecebimento(0, "CATEGORIA2", "DESCRICAO2");
		
		try {
			dao.cadastrar(categoriaRecebimento);
			System.out.println("Categoria Cadastrada.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// BUSCAR UMA CATEGORIA PELO CODIGO E ATUALIZAR
		categoriaRecebimento = dao.buscar(1);
		categoriaRecebimento.setNomeCategoriaRecebimento("CAT ATUALIZADA");
		categoriaRecebimento.setDescricaoRecebimento("DESC ATUALIZADA");
		try {
			dao.atualizar(categoriaRecebimento);
			System.out.println("Categoria Atualizada.");
		} catch (DBException e) {
			e.printStackTrace();
		}

    	// LISTAR AS CATEGORIAS
		List<CategoriaRecebimento> lista = dao.listar();
		for (CategoriaRecebimento item : lista) {
			System.out.println(item.getNomeCategoriaRecebimento() + " " + item.getDescricaoRecebimento());
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
