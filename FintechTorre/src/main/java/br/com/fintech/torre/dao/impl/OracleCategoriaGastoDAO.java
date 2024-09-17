package br.com.fintech.torre.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.torre.bean.CategoriaGasto;
import br.com.fintech.torre.dao.CategoriaGastoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.singleton.ConnectionManager;

public class OracleCategoriaGastoDAO implements CategoriaGastoDAO {

	private Connection conexao;

	@Override
	public void cadastrar(CategoriaGasto categoriaGasto) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FIN_CAT_GASTO (CD_CAT_GASTO, NM_CAT_GASTO, DS_CAT_GASTO) VALUES (SEQ_CAT_GASTO.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoriaGasto.getNomeCategoriaGasto());
			stmt.setString(2, categoriaGasto.getDsCategoriaGasto());

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
	public void atualizar(CategoriaGasto categoriaGasto) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FIN_CAT_GASTO SET NM_CAT_GASTO = ?, DS_CAT_GASTO = ? WHERE CD_CAT_GASTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoriaGasto.getNomeCategoriaGasto());
			stmt.setString(2, categoriaGasto.getDsCategoriaGasto());
			stmt.setInt(3, categoriaGasto.getCdCategoriaGasto());

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
	public void remover(int cdCategoriaGasto) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FIN_CAT_GASTO WHERE CD_CAT_GASTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdCategoriaGasto);
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
	public CategoriaGasto buscar(int cdCategoriaGasto) {
		CategoriaGasto categoriaGasto = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CAT_GASTO WHERE CD_CAT_GASTO = ? ");
			stmt.setInt(1, cdCategoriaGasto);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("CD_CAT_GASTO");
				String nome = rs.getString("NM_CAT_GASTO");
				String descricao = rs.getString("DS_CAT_GASTO");

				categoriaGasto = new CategoriaGasto(codigo, nome, descricao);
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

		return categoriaGasto;

	}

	@Override
	public List<CategoriaGasto> listar() {

		List<CategoriaGasto> lista = new ArrayList<CategoriaGasto>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			System.out.println("xxxxxxxxxxxxxxx Inside do lista categoria gasto");
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CAT_GASTO order by NM_CAT_GASTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("CD_CAT_GASTO");
				String nome = rs.getString("NM_CAT_GASTO");
				String descricao = rs.getString("DS_CAT_GASTO");

				CategoriaGasto categoriaGasto = new CategoriaGasto(codigo, nome, descricao);
				lista.add(categoriaGasto);
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
