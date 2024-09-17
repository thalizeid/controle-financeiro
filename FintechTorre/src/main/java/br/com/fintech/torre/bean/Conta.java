package br.com.fintech.torre.bean;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private int numConta;
	private double saldo;
	private Pessoa Pessoa;
	private List<Gasto> gastos;
	private List<Recebimento> recebimentos;
	
	
	public Conta() {
		super();
	}


	public Conta(int numConta, double saldo) {
		super();
		this.numConta = numConta;
		this.saldo = saldo;
	}
	
	
	public Conta(double saldo, List<Gasto> gastos, List<Recebimento> recebimentos) {
		super();
		this.saldo = saldo;
		this.gastos = gastos;
		this.recebimentos = recebimentos;
	}
	
	public void adicionarRecebimento (Recebimento recebimento) {
		recebimentos.add(recebimento);
		saldo += recebimento.getValorRecebimento();
	}
	
	public void adicionarGasto (Gasto gasto) {
		gastos.add(gasto);
		saldo -= gasto.getValorGasto();
	}


	public int getNumConta() {
		return numConta;
	}


	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Pessoa getPessoa() {
		return Pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		Pessoa = pessoa;
	}
	
	public List<Recebimento> getRecebimentos(){
		return recebimentos;
	}
	
	public List<Gasto> getGastos(){
		return gastos;
	}

}
