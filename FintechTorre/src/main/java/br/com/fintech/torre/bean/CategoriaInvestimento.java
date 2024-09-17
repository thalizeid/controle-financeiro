package br.com.fintech.torre.bean;

public class CategoriaInvestimento {
	
	private int cdCategoriaInvestimento;
	private String nomeCategoriaInvestimento;
	private String dsCategoriaInvestimento;
	
	
	public CategoriaInvestimento() {
		super();
	}


	public CategoriaInvestimento(int cdCategoriaInvestimento, String nomeCategoriaInvestimento,
			String dsCategoriaInvestimento) {
		super();
		this.cdCategoriaInvestimento = cdCategoriaInvestimento;
		this.nomeCategoriaInvestimento = nomeCategoriaInvestimento;
		this.dsCategoriaInvestimento = dsCategoriaInvestimento;
	}


	public int getCdCategoriaInvestimento() {
		return cdCategoriaInvestimento;
	}


	public void setCdCategoriaInvestimento(int cdCategoriaInvestimento) {
		this.cdCategoriaInvestimento = cdCategoriaInvestimento;
	}


	public String getNomeCategoriaInvestimento() {
		return nomeCategoriaInvestimento;
	}


	public void setNomeCategoriaInvestimento(String nomeCategoriaInvestimento) {
		this.nomeCategoriaInvestimento = nomeCategoriaInvestimento;
	}


	public String getDsCategoriaInvestimento() {
		return dsCategoriaInvestimento;
	}


	public void setDsCategoriaInvestimento(String dsCategoriaInvestimento) {
		this.dsCategoriaInvestimento = dsCategoriaInvestimento;
	}
	
	
	
	
	
	
	

}
