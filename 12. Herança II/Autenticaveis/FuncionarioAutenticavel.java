package Autenticaveis;

public class FuncionarioAutenticavel extends Funcionario implements Autenticavel {
	private String senha;
	private boolean logado;

	public FuncionarioAutenticavel(String nome) {
		super(nome);
		this.senha = "";
		this.logado = false;
	}

	@Override
	public void logar( String senha ) {
        if ( !this.senha.equals(senha) ) {
            throw new MsgException("fail: senha invalida");
        }
        
        this.setLogado( true );
    }

	@Override
	public void deslogar() {
		this.setLogado(false);
	}

	@Override
	public String getNome() {
		return super.getNome();
	}

	@Override
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String getSenha() {
		return this.senha;
	}

	@Override
	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	@Override
	public String getLogado() {
		if (logado)
			return "online";
		else
			return "offline";
	}
}
