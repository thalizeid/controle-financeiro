package br.com.fintech.torre.factory;

import br.com.fintech.torre.dao.CategoriaGastoDAO;
import br.com.fintech.torre.dao.CategoriaInvestimentoDAO;
import br.com.fintech.torre.dao.CategoriaRecebimentoDAO;
import br.com.fintech.torre.dao.GastoDAO;
import br.com.fintech.torre.dao.InvestimentoDAO;
import br.com.fintech.torre.dao.PessoaDAO;
import br.com.fintech.torre.dao.RecebimentoDAO;
import br.com.fintech.torre.dao.impl.OracleCategoriaGastoDAO;
import br.com.fintech.torre.dao.impl.OracleCategoriaInvestimentoDAO;
import br.com.fintech.torre.dao.impl.OracleCategoriaRecebimentoDAO;
import br.com.fintech.torre.dao.impl.OracleGastoDAO;
import br.com.fintech.torre.dao.impl.OracleInvestimentoDAO;
import br.com.fintech.torre.dao.impl.OraclePessoaDAO;
import br.com.fintech.torre.dao.impl.OracleRecebimentoDAO;


public class DAOFactory {
	
	public static CategoriaGastoDAO getCategoriaGastoDAO() {
		return new OracleCategoriaGastoDAO();
	}
	
	public static CategoriaRecebimentoDAO getCategoriaRecebimentoDAO() {
		return new OracleCategoriaRecebimentoDAO();
	}
	
	public static CategoriaInvestimentoDAO getCategoriaInvestimentoDAO() {
		return new OracleCategoriaInvestimentoDAO();
	}
	
	public static GastoDAO getGastoDAO() {
		return new OracleGastoDAO();
	}
	
	public static InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}
	
	public static RecebimentoDAO getRecebimentoDAO() {
		return new OracleRecebimentoDAO();
	}
	
	public static PessoaDAO getPessoaDAO() {
		return new OraclePessoaDAO();
		

		
	}
	
	

}
