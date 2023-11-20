package Autenticaveis;

public interface Autenticavel {
	public void logar(String senha);

	public void deslogar();

	public String getNome();

	public void setSenha(String senha);

	public String getSenha();

	public void setLogado(boolean logado);

	public String getLogado();
}
