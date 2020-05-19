package br.upis.sessao;

public class UsuarioSessao {

	private String nome;
	private String senha;

	public UsuarioSessao(String name, String password) {
		this.nome = name;
		this.senha = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
