package br.com.fintech.torre.dao;

import java.util.List;

import br.com.fintech.torre.bean.Gasto;
import br.com.fintech.torre.exception.DBException;

public interface GastoDAO {
	
	void cadastrar (Gasto gasto) throws DBException;
	void atualizar (Gasto gasto) throws DBException;
	void remover (int cdGasto) throws DBException;
	Gasto buscar (int cdGasto);
	List<Gasto> listar();

}
