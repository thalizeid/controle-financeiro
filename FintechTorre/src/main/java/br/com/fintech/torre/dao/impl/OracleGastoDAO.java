package br.com.fintech.torre.dao.impl;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fintech.torre.bean.CategoriaGasto;
import br.com.fintech.torre.bean.Gasto;
import br.com.fintech.torre.dao.GastoDAO;
import br.com.fintech.torre.exception.DBException;
import br.com.fintech.torre.singleton.ConnectionManager;

public class OracleGastoDAO implements GastoDAO{
	
	private Connection conexao;

	@Override
	public void cadastrar(Gasto gasto) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FIN_GASTO (CD_GASTO, VL_GASTO, DT_GASTO, NM_GASTO, CD_CAT_GASTO ) VALUES (SQ_GASTO.NEXTVAL,?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, gasto.getValorGasto());
			Date data = Date.valueOf(gasto.getDataGasto());
			stmt.setDate(2,data);
			stmt.setString(3, gasto.getNomeGasto());
			stmt.setInt(4,gasto.getCategoriaGasto().getCdCategoriaGasto());	
//			stmt.setInt(5, gasto.getConta().getNumConta());
			
			

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
	public void atualizar(Gasto gasto) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FIN_GASTO SET VL_GASTO = ?, DT_GASTO = ?, NM_GASTO = ?, CD_CAT_GASTO = ? WHERE CD_GASTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, gasto.getValorGasto());
			Date data = Date.valueOf(gasto.getDataGasto());
			stmt.setDate(2,data);
			stmt.setString(3, gasto.getNomeGasto());
			stmt.setInt(4, gasto.getCategoriaGasto().getCdCategoriaGasto());
			stmt.setInt(5, gasto.getCdGasto());
			

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
	public void remover(int cdGasto) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FIN_GASTO WHERE CD_GASTO = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdGasto);
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
	public Gasto buscar(int cdGasto) {
		
		Gasto gasto = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT CD_GASTO, DT_GASTO, NM_GASTO, VL_GASTO, g.CD_CAT_GASTO,DS_CAT_GASTO,NM_CAT_GASTO  from t_fin_gasto g inner join t_fin_cat_gasto cg on cg.cd_cat_gasto = g.CD_CAT_GASTO where g.CD_GASTO = ?");
			stmt.setInt(1, cdGasto);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("CD_GASTO");
				String nome = rs.getString("NM_GASTO");
				Double valor = rs.getDouble("VL_GASTO");
//				Date data = Date.valueOf(gasto.getDataGasto());
//				data = rs.getDate("DT_GASTO");				
				java.sql.Date data = rs.getDate("DT_GASTO");
				Calendar dataGasto = Calendar.getInstance();
				dataGasto.setTimeInMillis(data.getTime());
				LocalDate localDate = LocalDateTime.ofInstant(dataGasto.toInstant(), dataGasto.getTimeZone().toZoneId()).toLocalDate();

				
				int codigoCategoria = rs.getInt("CD_CAT_GASTO");
				String nomeCategoria = rs.getString("NM_CAT_GASTO");
				String descCategoria = rs.getString("DS_CAT_GASTO");
				
				
				gasto = new Gasto(codigo, nome, valor, localDate);
				//gasto = new Gasto(codigo, nome, valor, data);
				CategoriaGasto categoria = new CategoriaGasto(codigoCategoria, nomeCategoria, descCategoria);
				gasto.setCategoriaGasto(categoria);
				
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

		return gasto;
		
	}

	@Override
	public List<Gasto> listar() {
		List<Gasto> lista = new ArrayList<Gasto>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT CD_GASTO, DT_GASTO, NM_GASTO, VL_GASTO, g.CD_CAT_GASTO,DS_CAT_GASTO,NM_CAT_GASTO  from t_fin_gasto g inner join t_fin_cat_gasto cg on cg.cd_cat_gasto = g.CD_CAT_GASTO");
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("CD_GASTO");
				String nome = rs.getString("NM_GASTO");
				Double valor = rs.getDouble("VL_GASTO");
				java.sql.Date data = rs.getDate("DT_GASTO");
				Calendar dataGasto = Calendar.getInstance();
				dataGasto.setTimeInMillis(data.getTime());
				LocalDate localDate = LocalDateTime.ofInstant(dataGasto.toInstant(), dataGasto.getTimeZone().toZoneId()).toLocalDate();
				int codigoCategoria = rs.getInt("CD_CAT_GASTO");
				
				String nomeCat = rs.getString("NM_CAT_GASTO") ;
				String descCategoria = rs.getString("DS_CAT_GASTO");
	
				
				Gasto gasto = new Gasto(codigo, nome, valor, localDate);
				CategoriaGasto categoria = new CategoriaGasto(codigoCategoria, nomeCat, descCategoria);
				gasto.setCategoriaGasto(categoria);
				
				lista.add(gasto);
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
