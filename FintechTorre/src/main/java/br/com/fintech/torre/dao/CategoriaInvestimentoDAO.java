package br.com.fintech.torre.dao;

import java.util.List;

import br.com.fintech.torre.bean.CategoriaInvestimento;
import br.com.fintech.torre.exception.DBException;

public interface CategoriaInvestimentoDAO {
	
	void cadastrar (CategoriaInvestimento categoriaInvestimento) throws DBException;
	void atualizar (CategoriaInvestimento categoriaInvestimento) throws DBException;
	void remover (int cdCategoriaInvestimento) throws DBException;
	CategoriaInvestimento buscar (int cdCategoriaInvestimento);
	List<CategoriaInvestimento> listar();

}
