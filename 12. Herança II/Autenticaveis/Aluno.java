package Autenticaveis;

public class Aluno implements Autenticavel {
	private String nome;
	private String curso;
	private int bolsa;

	private String senha;
	private boolean logado;

	public Aluno(String nome, String curso, int bolsa) {
		this.nome = nome;
		this.curso = curso;
		this.bolsa = bolsa;
		this.senha = "";
		this.logado = false;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCurso() {
		return this.curso;
	}

	public int getBolsa() {
		return this.bolsa;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public String getLogado() {
		return this.logado ? "online" : "offline";
	}

	public void logar(String senha) {
		if (senha.equals(this.senha)) {
			this.setLogado(true);
		} else {
			this.setLogado(false);
		}
	}

	public void deslogar() {
		this.setLogado(false);
	}

	@Override
	public String toString() {
		// alu:joana:CC:800:%e123@:offline
		return "alu:" + getNome() + ":" + getCurso() + ":" + getBolsa();
	}
}
