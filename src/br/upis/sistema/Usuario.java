package br.upis.sistema;

import br.upis.sistema.state.Data;

public class Usuario {

	private String nome;
	private String email;
	private String senha;
	private Data dataNascimento;
	
	public Usuario(String nome, String email, String senha, Data dataNascimento){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		str.append(this.nome);
		str.append(":");
		str.append(this.email);
		str.append(":");
		str.append(this.senha);
		str.append(":");
		str.append(this.dataNascimento);
		str.append("]");
		return str.toString();
	}
}
