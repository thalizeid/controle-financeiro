package br.com.fintech.torre.bean;

public class CategoriaRecebimento {
	
	private int cdCategoriaRecebimento;
	private String nomeCategoriaRecebimento;
	private String descricaoRecebimento;
	
	
	public CategoriaRecebimento() {
		super();
	}
	
	
	public CategoriaRecebimento(int cdCategoriaRecebimento, String nomeCategoriaRecebimento, String descricaoRecebimento) {
		super();
		this.cdCategoriaRecebimento = cdCategoriaRecebimento;
		this.nomeCategoriaRecebimento = nomeCategoriaRecebimento;
		this.descricaoRecebimento = descricaoRecebimento;
	}


	public int getCdCategoriaRecebimento() {
		return cdCategoriaRecebimento;
	}


	public void setCdCategoriaRecebimento(int cdCategoriaRecebimento) {
		this.cdCategoriaRecebimento = cdCategoriaRecebimento;
	}


	public String getNomeCategoriaRecebimento() {
		return nomeCategoriaRecebimento;
	}


	public void setNomeCategoriaRecebimento(String nomeCategoriaRecebimento) {
		this.nomeCategoriaRecebimento = nomeCategoriaRecebimento;
	}


	public String getDescricaoRecebimento() {
		return descricaoRecebimento;
	}


	public void setDescricaoRecebimento(String descricaoRecebimento) {
		this.descricaoRecebimento = descricaoRecebimento;
	}
	
	

}
