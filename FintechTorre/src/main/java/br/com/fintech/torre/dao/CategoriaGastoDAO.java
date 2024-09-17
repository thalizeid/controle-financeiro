package br.com.fintech.torre.dao;

import java.util.List;

import br.com.fintech.torre.bean.CategoriaGasto;
import br.com.fintech.torre.exception.DBException;

public interface CategoriaGastoDAO {
	
	void cadastrar (CategoriaGasto categoriaGasto) throws DBException;
	void atualizar (CategoriaGasto categoriaGasto) throws DBException;
	void remover (int cdCategoriaGasto) throws DBException;
	CategoriaGasto buscar (int cdCategoriaGasto);
	List<CategoriaGasto> listar();

}
