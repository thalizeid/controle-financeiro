package br.com.fintech.torre.teste;

import java.time.LocalDate;

import br.com.fintech.torre.bean.CategoriaGasto;
import br.com.fintech.torre.bean.Conta;
import br.com.fintech.torre.bean.Gasto;
import br.com.fintech.torre.dao.GastoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.factory.DAOFactory;

public class GastoDAOTeste {
	
	public static void main(String[] args) {
		
		GastoDAO dao = DAOFactory.getGastoDAO();
		
		
		//CADASTRAR UM GASTO
		
		Gasto gasto = new Gasto (0, "Nome Gasto", 1000, LocalDate.of(2000, 4, 4));
		gasto.setConta(new Conta(10031,2000));
		gasto.setCategoriaGasto(new CategoriaGasto(10,"CATEGORIA5", "DESCRICAO5"));
	
		
		try {
			dao.cadastrar(gasto);
			System.out.println("Gasto Cadastrado");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
