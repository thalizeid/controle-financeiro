package br.com.fintech.torre.bean;

public class CategoriaGasto {
	
	private int cdCategoriaGasto;
	private String nomeCategoriaGasto;
	private String dsCategoriaGasto;
	
	
	public CategoriaGasto() {
		super();
	}


	public CategoriaGasto(int cdCategoriaGasto, String nomeCategoriaGasto, String dsCategoriaGasto) {
		super();
		this.cdCategoriaGasto = cdCategoriaGasto;
		this.nomeCategoriaGasto = nomeCategoriaGasto;
		this.dsCategoriaGasto = dsCategoriaGasto;
	}


	public CategoriaGasto(int codigoCategoria) {
		// TODO Auto-generated constructor stub
		this.cdCategoriaGasto=codigoCategoria;
	}


	public int getCdCategoriaGasto() {
		return cdCategoriaGasto;
	}


	public void setCdCategoriaGasto(int cdCategoriaGasto) {
		this.cdCategoriaGasto = cdCategoriaGasto;
	}


	public String getNomeCategoriaGasto() {
		return nomeCategoriaGasto;
	}


	public void setNomeCategoriaGasto(String nomeCategoriaGasto) {
		this.nomeCategoriaGasto = nomeCategoriaGasto;
	}


	public String getDsCategoriaGasto() {
		return dsCategoriaGasto;
	}


	public void setDsCategoriaGasto(String dsCategoriaGasto) {
		this.dsCategoriaGasto = dsCategoriaGasto;
	}
	
	
	
	
	
	

}
