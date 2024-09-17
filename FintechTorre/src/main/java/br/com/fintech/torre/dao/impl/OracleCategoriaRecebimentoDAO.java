package br.com.fintech.torre.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.torre.bean.CategoriaRecebimento;
import br.com.fintech.torre.dao.CategoriaRecebimentoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.singleton.ConnectionManager;

public class OracleCategoriaRecebimentoDAO implements CategoriaRecebimentoDAO {

	private Connection conexao;

	@Override
	public void cadastrar(CategoriaRecebimento categoriaRecebimento) throws DBException {

		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FIN_CAT_RECEBIMENTO (CD_CAT_RECEBIMENTO, NM_CAT_RECEBIMENTO, DS_CAT_RECEBIMENTO) VALUES (SEQ_CAT_RECEB.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoriaRecebimento.getNomeCategoriaRecebimento());
			stmt.setString(2, categoriaRecebimento.getDescricaoRecebimento());

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
	public void atualizar(CategoriaRecebimento categoriaRecebimento) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FIN_CAT_RECEBIMENTO SET NM_CAT_RECEBIMENTO = ?, DS_CAT_RECEBIMENTO = ? WHERE CD_CAT_RECEBIMENTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoriaRecebimento.getNomeCategoriaRecebimento());
			stmt.setString(2, categoriaRecebimento.getDescricaoRecebimento());
			stmt.setInt(3,categoriaRecebimento.getCdCategoriaRecebimento());

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
	public void remover(int cdCategoriaRecebimento) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FIN_CAT_RECEBIMENTO WHERE CD_CAT_RECEBIMENTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdCategoriaRecebimento);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
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
	public CategoriaRecebimento buscar(int cdCategoriaRecebimento) {
		
		CategoriaRecebimento categoriaRecebimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CAT_RECEBIMENTO WHERE CD_CAT_RECEBIMENTO = ? ");
			stmt.setInt(1, cdCategoriaRecebimento);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("CD_CAT_RECEBIMENTO");
				String nome = rs.getString("NM_CAT_RECEBIMENTO");
				String descricao = rs.getString("DS_CAT_RECEBIMENTO");

				categoriaRecebimento = new CategoriaRecebimento(codigo, nome, descricao);
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

		return categoriaRecebimento;

	}

	@Override
	public List<CategoriaRecebimento> listar() {

		List<CategoriaRecebimento> lista = new ArrayList<CategoriaRecebimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CAT_RECEBIMENTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("CD_CAT_RECEBIMENTO");
				String nome = rs.getString("NM_CAT_RECEBIMENTO");
				String descricao = rs.getString("DS_CAT_RECEBIMENTO");

				CategoriaRecebimento categoriaRecebimento = new CategoriaRecebimento(codigo, nome, descricao);
				lista.add(categoriaRecebimento);
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
