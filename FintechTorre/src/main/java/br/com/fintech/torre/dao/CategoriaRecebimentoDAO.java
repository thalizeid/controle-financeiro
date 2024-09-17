package br.com.fintech.torre.dao;

import java.util.List;

import br.com.fintech.torre.bean.CategoriaRecebimento;
import br.com.fintech.torre.exception.DBException;

public interface CategoriaRecebimentoDAO {
	
	void cadastrar (CategoriaRecebimento categoriaRecebimento) throws DBException;
	void atualizar (CategoriaRecebimento categoriaRecebimento) throws DBException;
	void remover (int cdCategoriaRecebimento) throws DBException;
	CategoriaRecebimento buscar (int cdCategoriaRecebimento);
	List<CategoriaRecebimento> listar();

}
