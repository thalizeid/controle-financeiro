package br.com.fintech.torre.dao;

import br.com.fintech.torre.bean.Conta;
import br.com.fintech.torre.exception.DBException;

public interface ContaDAO {
	
	void cadastrar (Conta conta) throws DBException;
	void atualizar (Conta conta) throws DBException;
	void remover (int cdConta) throws DBException;

}
