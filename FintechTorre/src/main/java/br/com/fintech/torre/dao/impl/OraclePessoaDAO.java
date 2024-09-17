package br.com.fintech.torre.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fintech.torre.bean.Pessoa;
import br.com.fintech.torre.dao.PessoaDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.singleton.ConnectionManager;

public class OraclePessoaDAO implements PessoaDAO {

	private Connection conexao;

	@Override
	public boolean validarPessoa(Pessoa pessoa) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			
//			System.out.println("IN DAO Login: " + pessoa.getEmail() + " / senha: " + pessoa.getSenha());
//			System.out.println("SELECT * FROM T_FIN_PESSOA WHERE DS_EMAIL = '"+ pessoa.getEmail() + "' AND DS_SENHA_LOGIN = '" +  pessoa.getSenha() + "'");
			
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_PESSOA WHERE DS_EMAIL = ? AND DS_SENHA_LOGIN = ?");
			stmt.setString(1, pessoa.getEmail());
			stmt.setString(2, pessoa.getSenha());
			rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("login OK");
				return true;
			}
			else
				System.out.println("invalid login");
			
		

			
			
			
			

		} catch (SQLException e) {
			System.out.println("Error: " + e.toString());
			e.printStackTrace();

		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

//	@Override
//	public void cadastrar(Pessoa pessoa) throws DBException {
//		
//		
//		
//	}
//
//	@Override
//	public void atualizar(Pessoa pessoa) throws DBException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void remover(int cdPessoa) throws DBException {
//		// TODO Auto-generated method stub
//		
//	}

}
