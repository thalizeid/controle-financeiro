package br.com.fintech.torre.dao;

import java.util.List;

import br.com.fintech.torre.bean.Investimento;
import br.com.fintech.torre.exception.DBException;

public interface InvestimentoDAO {
	
	void cadastrar (Investimento investimento) throws DBException;
	void atualizar (Investimento investimento) throws DBException;
	void remover (int cdInvestimento) throws DBException;
	Investimento buscar (int cdInvestimento);
	List<Investimento> listar();

}
