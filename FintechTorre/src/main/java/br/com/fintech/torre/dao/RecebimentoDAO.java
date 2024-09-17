package br.com.fintech.torre.dao;

import java.util.List;

import br.com.fintech.torre.bean.Recebimento;
import br.com.fintech.torre.exception.DBException;

public interface RecebimentoDAO {
	
	void cadastrar (Recebimento recebimento) throws DBException;
	void atualizar (Recebimento recebimento) throws DBException;
	void remover (int cdRecebimento) throws DBException;
	Recebimento buscar (int cdRecebimento);
	List<Recebimento> listar();
	
}
