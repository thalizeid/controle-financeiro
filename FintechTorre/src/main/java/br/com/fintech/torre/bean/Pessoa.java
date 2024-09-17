package br.com.fintech.torre.bean;

import br.com.fintech.torre.util.CriptografiaUtils;

public class Pessoa {
	
	private int cdPessoa;
	private String nome;
	private String email;
	private int telefone;
	private String login;
	private String senha;
	private String docIdentificacao;
	
	
	public Pessoa() {
		super();
	}
	

	public Pessoa(int cdPessoa, String nome, String email, int telefone, String login, String senha, String docIdentificacao) {
		super();
		this.cdPessoa = cdPessoa;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		setSenha(senha);
		this.docIdentificacao = docIdentificacao;
		
	}


	public Pessoa(String email, String senha) {
		this.email= email;
		this.senha = senha;
	}


	public int getCdPessoa() {
		return cdPessoa;
	}


	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTelefone() {
		return telefone;
	}


	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getDocIdentificacao() {
		return docIdentificacao;
	}


	public void setDocIdentificacao(String docIdentificacao) {
		this.docIdentificacao = docIdentificacao;
	}
	
	
	

}
