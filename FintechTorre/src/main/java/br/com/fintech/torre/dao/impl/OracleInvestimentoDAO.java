package br.com.fintech.torre.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.torre.bean.CategoriaInvestimento;
import br.com.fintech.torre.bean.CategoriaRecebimento;
import br.com.fintech.torre.bean.Investimento;
import br.com.fintech.torre.bean.Recebimento;
import br.com.fintech.torre.dao.InvestimentoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.singleton.ConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Investimento investimento) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FIN_INVESTIMENTO (CD_INVESTIMENTO, VL_INVESTIMENTO, DT_INVESTIMENTO, DS_INVESTIMENTO, CD_CAT_INVESTIMENTO, NR_CONTA ) VALUES (SEQ_RECEBIMENTO.NEXTVAL,?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, investimento.getValorInvestimento());
			Date data = Date.valueOf(investimento.getDataInvestimento());
			stmt.setDate(2,data);
			stmt.setString(3, investimento.getDsInvestimento());
			stmt.setInt(4, investimento.getCategoriaInvestimento().getCdCategoriaInvestimento());	
			stmt.setInt(5, investimento.getConta().getNumConta());
			
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
	public void atualizar(Investimento investimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FIN_INVESTIMENTO SET VL_INVESTIMENTO = ?, DT_INVESTIMENTO = ?, DS_INVESTIMENTO = ?, CD_CAT_INVESTIMENTO = ? WHERE CD_INVESTIMENTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, investimento.getValorInvestimento());
			Date data = Date.valueOf(investimento.getDataInvestimento());
			stmt.setDate(2,data);
			stmt.setString(3, investimento.getDsInvestimento());
			stmt.setInt(4, investimento.getCategoriaInvestimento().getCdCategoriaInvestimento());
			stmt.setInt(5, investimento.getCdInvestimento());
			

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
	public void remover(int cdInvestimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FIN_INVESTIMENTO WHERE CD_INVESTIMENTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdInvestimento);
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
	public Investimento buscar(int cdInvestimento) {
		Investimento investimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_INVESTIMENTO INNER JOIN T_FIN_CAT_INVESTIMENTO ON T_INVESTIMENTO.CD_CAT_RECEBIMENTO = T_CAT_INVESTIMENTO.CD_CAT_INVESTIMENTO");
			stmt.setInt(1, cdInvestimento);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("CD_INVESTIMENTO");
				String nome = rs.getString("DS_INVESTIMENTO");
				Double valor = rs.getDouble("VL_INVESTIMENTO");
				Date data = Date.valueOf(investimento.getDataInvestimento());
				data = rs.getDate("DT_INVESTIMENTO");
				int codigoCategoria = rs.getInt("CD_CAT_INVESTIMENTO");
				String nomeCategoria = rs.getString("NM_CAT_INVESTIMENTO");
				String descCategoria = rs.getString("DS_CAT_INVESTIMENTO");
				
				

				investimento = new Investimento (codigo, valor, data, nome);
				CategoriaInvestimento categoria = new CategoriaInvestimento (codigoCategoria, nomeCategoria, descCategoria);
				investimento.setCategoriaInvestimento(categoria);
				
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

		return investimento;
		
	
	}

	@Override
	public List<Investimento> listar() {
		List<Investimento> lista = new ArrayList<Investimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_INVESTIMENTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("CD_INVESTIMENTO");
				String nome = rs.getString("DS_INVESTIMENTO");
				Double valor = rs.getDouble("VL_INVESTIMENTO");
				java.sql.Date data = rs.getDate("DT_INVESTIMENTO");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				int codigoCategoria = rs.getInt("CD_CAT_INVESTIMENTO");
				String nomeCategoria = rs.getString("NM_CAT_INVESTIMENTO");
				String descCategoria = rs.getString("DS_CAT_INVESTIMENTO");
				
				
				
				Investimento investimento = new Investimento(codigo, valor, data, nome);
				CategoriaInvestimento categoria = new CategoriaInvestimento(codigoCategoria, nomeCategoria, descCategoria);
				investimento.setCategoriaInvestimento(categoria);
				lista.add(investimento);
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


