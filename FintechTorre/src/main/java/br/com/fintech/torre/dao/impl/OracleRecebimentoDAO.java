package br.com.fintech.torre.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.torre.bean.CategoriaGasto;
import br.com.fintech.torre.bean.CategoriaRecebimento;
import br.com.fintech.torre.bean.Gasto;
import br.com.fintech.torre.bean.Recebimento;
import br.com.fintech.torre.dao.RecebimentoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.singleton.ConnectionManager;

public class OracleRecebimentoDAO implements RecebimentoDAO {
	
	private Connection conexao;
	
	@Override
	public void cadastrar(Recebimento recebimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FIN_RECEBIMENTO (CD_RECEBIMENTO, VL_RECEBIMENTO, DT_RECEBIMENTO, NM_RECEBIMENTO, CD_CAT_RECEBIMENTO, NR_CONTA ) VALUES (SEQ_RECEBIMENTO.NEXTVAL,?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, recebimento.getValorRecebimento());
			Date data = Date.valueOf(recebimento.getDataRecebimento());
			stmt.setDate(2,data);
			stmt.setString(3, recebimento.getNomeRecebimento());
			stmt.setInt(4, recebimento.getCategoriaRecebimento().getCdCategoriaRecebimento());	
			stmt.setInt(5, recebimento.getConta().getNumConta());
			
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
	public void atualizar(Recebimento recebimento) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FIN_RECEBIMENTO SET VL_RECEBIMENTO = ?, DT_RECEBIMENTO = ?, NM_RECEBIMENTO = ?, CD_CAT_RECEBIMENTO = ? WHERE CD_RECEBIMENTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, recebimento.getValorRecebimento());
			Date data = Date.valueOf(recebimento.getDataRecebimento());
			stmt.setDate(2,data);
			stmt.setString(3, recebimento.getNomeRecebimento());
			stmt.setInt(4, recebimento.getCategoriaRecebimento().getCdCategoriaRecebimento());
			stmt.setInt(5, recebimento.getCdRecebimento());
			

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
	public void remover(int cdRecebimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FIN_RECEBIMENTO WHERE CD_RECEBIMENTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdRecebimento);
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
	public Recebimento buscar(int cdRecebimento) {
		
		Recebimento recebimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_RECEBIMENTO INNER JOIN T_FIN_CAT_RECEBIMENTO ON T_RECEBIMENTO.CD_CAT_RECEBIMENTO = T_CAT_RECEBIMENTO.CD_CAT_RECEBIMENTO");
			stmt.setInt(1, cdRecebimento);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("CD_RECEBIMENTO");
				String nome = rs.getString("NM_RECEBIMENTO");
				Double valor = rs.getDouble("VL_RECEBIMENTO");
				Date data = Date.valueOf(recebimento.getDataRecebimento());
				data = rs.getDate("DT_RECEBIMENTO");
				int codigoCategoria = rs.getInt("CD_CAT_RECEBIMENTO");
				String nomeCategoria = rs.getString("NM_CAT_RECEBIMENTO");
				String descCategoria = rs.getString("DS_CAT_RECEBIMENTO");
				
				

				recebimento = new Recebimento(codigo, valor, data, nome);
				CategoriaRecebimento categoria = new CategoriaRecebimento(codigoCategoria, nomeCategoria, descCategoria);
				recebimento.setCategoriaRecebimento(categoria);
				
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

		return recebimento;
		
	}

	@Override
	public List<Recebimento> listar() {
		List<Recebimento> lista = new ArrayList<Recebimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_RECEBIMENTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("CD_RECEBIMENTO");
				String nome = rs.getString("NM_RECEBIMENTO");
				Double valor = rs.getDouble("VL_RECEBIMENTO");
				java.sql.Date data = rs.getDate("DT_RECEBIMENTO");
				Calendar dataRecebimento = Calendar.getInstance();
				dataRecebimento.setTimeInMillis(data.getTime());
				int codigoCategoria = rs.getInt("CD_CAT_RECEBIMENTO");
				String nomeCategoria = rs.getString("NM_CAT_RECEBIMENTO");
				String descCategoria = rs.getString("DS_CAT_RECEBIMENTO");
				
				
				
				Recebimento recebimento = new Recebimento(codigo, valor, data, nome);
				CategoriaRecebimento categoria = new CategoriaRecebimento(codigoCategoria, nomeCategoria, descCategoria);
				recebimento.setCategoriaRecebimento(categoria);
				lista.add(recebimento );
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
