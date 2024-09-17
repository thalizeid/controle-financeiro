package br.com.fintech.torre.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.torre.bean.CategoriaInvestimento;
import br.com.fintech.torre.dao.CategoriaInvestimentoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.singleton.ConnectionManager;

public class OracleCategoriaInvestimentoDAO implements CategoriaInvestimentoDAO {

	private Connection conexao;

	@Override
	public void cadastrar(CategoriaInvestimento categoriaInvestimento) throws DBException {

		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FIN_CAT_INVESTIMENTO (CD_CAT_INVESTIMENTO, NM_CAT_INVESTIMENTO, DS_CAT_INVESTIMENTO) VALUES (SEQ_CAT_INVESTIMENTO.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoriaInvestimento.getNomeCategoriaInvestimento());
			stmt.setString(2, categoriaInvestimento.getDsCategoriaInvestimento());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao Cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void atualizar(CategoriaInvestimento categoriaInvestimento) throws DBException {

		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FIN_CAT_INVESTIMENTO SET NM_CAT_INVESTIMENTO = ?, DS_CAT_INVESTIMENTO = ? WHERE CD_CAT_INVESTIMENTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoriaInvestimento.getNomeCategoriaInvestimento());
			stmt.setString(2, categoriaInvestimento.getDsCategoriaInvestimento());
			stmt.setInt(3, categoriaInvestimento.getCdCategoriaInvestimento());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(int cdCategoriaInvestimento) throws DBException {
		
		

	}

	@Override
	public CategoriaInvestimento buscar(int cdCategoriaInvestimento) {
		CategoriaInvestimento categoriaInvestimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CAT_INVESTIMENTO WHERE CD_CAT_INVESTIMENTO = ? ");
			stmt.setInt(1, cdCategoriaInvestimento);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("CD_CAT_INVESTIMENTO");
				String nome = rs.getString("NM_CAT_INVESTIMENTO");
				String descricao = rs.getString("DS_CAT_INVESTIMENTO");

				categoriaInvestimento = new CategoriaInvestimento(codigo, nome, descricao);
			}
		} catch (SQLException e) {
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

		return categoriaInvestimento;

		
	}

	@Override
	public List<CategoriaInvestimento> listar() {
		
		List<CategoriaInvestimento> lista = new ArrayList<CategoriaInvestimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CAT_INVESTIMENTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("CD_CAT_INVESTIMENTO");
				String nome = rs.getString("NM_CAT_INVESTIMENTO");
				String descricao = rs.getString("DS_CAT_INVESTIMENTO");

				CategoriaInvestimento categoriaInvestimento = new CategoriaInvestimento(codigo, nome, descricao);
				lista.add(categoriaInvestimento);
			}

		} catch (SQLException e) {
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
		return lista;
		
		
	}

}
