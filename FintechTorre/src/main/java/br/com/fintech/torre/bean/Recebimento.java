package br.com.fintech.torre.bean;

import java.sql.Date;
import java.time.LocalDate;

public class Recebimento {
	
	private int cdRecebimento;
	private double valorRecebimento;
	private LocalDate dataRecebimento;
	private String nomeRecebimento;
	private CategoriaRecebimento categoriaRecebimento;
	private Conta conta;
	
	public Recebimento() {
		super();
		}

	public Recebimento(int cdRecebimento, double valorRecebimento, LocalDate dataRecebimento, String nomeRecebimento) {
		super();
		this.cdRecebimento = cdRecebimento;
		this.valorRecebimento = valorRecebimento;
		this.dataRecebimento = dataRecebimento;
		this.nomeRecebimento = nomeRecebimento;
	}

	public Recebimento(int codigo, Double valor, Date data, String nome) {
		// TODO Auto-generated constructor stub
	}

	public int getCdRecebimento() {
		return cdRecebimento;
	}

	public void setCdRecebimento(int cdRecebimento) {
		this.cdRecebimento = cdRecebimento;
	}

	public double getValorRecebimento() {
		return valorRecebimento;
	}

	public void setValorRecebimento(double valorRecebimento) {
		this.valorRecebimento = valorRecebimento;
	}

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public CategoriaRecebimento getCategoriaRecebimento() {
		return categoriaRecebimento;
	}

	public void setCategoriaRecebimento(CategoriaRecebimento categoriaRecebimento) {
		this.categoriaRecebimento = categoriaRecebimento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getNomeRecebimento() {
		return nomeRecebimento;
	}

	public void setNomeRecebimento(String nomeRecebimento) {
		this.nomeRecebimento = nomeRecebimento;
	}

	
	

}
