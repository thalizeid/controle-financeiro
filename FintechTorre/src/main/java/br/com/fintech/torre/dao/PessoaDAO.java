package br.com.fintech.torre.dao;

import br.com.fintech.torre.bean.Pessoa;
import br.com.fintech.torre.exception.DBException;

public interface PessoaDAO {
	
//	void cadastrar (Pessoa pessoa) throws DBException;
//	void atualizar (Pessoa pessoa) throws DBException;
//	void remover (int cdPessoa) throws DBException;
	
	boolean validarPessoa (Pessoa pessoa);
	
}
