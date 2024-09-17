package br.com.fintech.torre.bean;

import java.sql.Date;
import java.time.LocalDate;

public class Investimento {
	
	private int cdInvestimento;
	private double valorInvestimento;
	private LocalDate dataInvestimento;
	private String dsInvestimento;
	private CategoriaInvestimento categoriaInvestimento;
	private Conta conta;
	
	
	public Investimento() {
		super();
	}


	public Investimento(int cdInvestimento, double valorInvestimento, LocalDate dataInvestimento,
			String dsInvestimento) {
		super();
		this.cdInvestimento = cdInvestimento;
		this.valorInvestimento = valorInvestimento;
		this.dataInvestimento = dataInvestimento;
		this.dsInvestimento = dsInvestimento;
	}


	public Investimento(int codigo, Double valor, Date data, String nome) {
		// TODO Auto-generated constructor stub
	}


	public int getCdInvestimento() {
		return cdInvestimento;
	}


	public void setCdInvestimento(int cdInvestimento) {
		this.cdInvestimento = cdInvestimento;
	}


	public double getValorInvestimento() {
		return valorInvestimento;
	}


	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}


	public LocalDate getDataInvestimento() {
		return dataInvestimento;
	}


	public void setDataInvestimento(LocalDate dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}


	public String getDsInvestimento() {
		return dsInvestimento;
	}


	public void setDsInvestimento(String dsInvestimento) {
		this.dsInvestimento = dsInvestimento;
	}


	public CategoriaInvestimento getCategoriaInvestimento() {
		return categoriaInvestimento;
	}


	public void setCategoriaInvestimento(CategoriaInvestimento categoriaInvestimento) {
		this.categoriaInvestimento = categoriaInvestimento;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
	

}
