package br.com.fintech.torre.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gasto {
	
	private int cdGasto;
	private String nomeGasto;
	private double valorGasto;
	private LocalDate dataGasto;
	private String dataGastoFmt;
	private CategoriaGasto categoriaGasto;
	private Conta conta;
	private double saldoGasto;
	
	
	
	public Gasto() {
		super();
	}


	public Gasto(int cdGasto, String nomeGasto, double valorGasto, LocalDate dataGasto) {
		super();
		this.cdGasto = cdGasto;
		this.nomeGasto = nomeGasto;
		this.valorGasto = valorGasto;
		this.dataGasto = dataGasto;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		
		this.dataGastoFmt = dataGasto.format(formatter); 
		
	}




	public int getCdGasto() {
		return cdGasto;
	}


	public void setCdGasto(int cdGasto) {
		this.cdGasto = cdGasto;
	}


	public String getNomeGasto() {
		return nomeGasto;
	}


	public void setNomeGasto(String nomeGasto) {
		this.nomeGasto = nomeGasto;
	}


	public double getValorGasto() {
		return valorGasto;
	}


	public void setValorGasto(double valorGasto) {
		this.valorGasto = valorGasto;
	}


	public String getDataGastoFmt() {
		return dataGastoFmt;
	}
	public void setDataGastoFmt(String dataGastoFmt) {
		this.dataGastoFmt = dataGastoFmt;
	}

	public LocalDate getDataGasto() {
		return dataGasto;
	}


	public void setDataGasto(LocalDate dataGasto) {
		this.dataGasto = dataGasto;
	}


	public CategoriaGasto getCategoriaGasto() {
		return categoriaGasto;
	}


	public void setCategoriaGasto(CategoriaGasto categoriaGasto) {
		this.categoriaGasto = categoriaGasto;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}
	

}
