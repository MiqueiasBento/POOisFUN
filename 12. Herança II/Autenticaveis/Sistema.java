package Autenticaveis;

import java.util.*;

public class Sistema {
	private UFC ufc;
	private Map<String, Autenticavel> usuarios;

	public Sistema() {
	    this.ufc = new UFC();
	    this.usuarios = new TreeMap<String, Autenticavel>();
	}

	public UFC getUFC() {
		return ufc;
	}

	public Autenticavel getUsuario(String nome) {
		return usuarios.get(nome);
	}

	public void addUsuario(String nome, String senha){
		Funcionario func = this.getUFC().getFuncionario(nome);
		if (func != null && func instanceof Terceirizado) {
			throw new MsgException("fail: terc nao pode ser cadastrado no sistema");
		}

		Autenticavel user = (FuncionarioAutenticavel) this.getUFC().getFuncionario(nome);
		if (user == null) {
			user = this.getUFC().getAluno(nome);
		}

		if (user == null) {
			throw new MsgException("fail: " + nome + " nao encontrado");
		}
        user.setSenha(senha);
		this.usuarios.put(nome, user);
	}

	public void rmUsuario(String nome) {
		if (usuarios.get(nome) == null) {
			throw new MsgException("fail: usuario " + nome + " nao encontrado");
		}
		
		this.usuarios.remove(nome);
	}

	public void logar(String nome, String senha){
		Autenticavel user = this.getUsuario(nome);
		if (user == null) {
			throw new MsgException("fail: usuario " + nome + " nao encontrado");
		}

		user.logar(senha);
	}

	public void deslogar(String nome) {
		Autenticavel user = this.getUsuario(nome);
		if (user == null) {
			throw new MsgException("fail: usuario " + nome + " nao encontrado");
		}

		user.deslogar();
	}

	public void deslogarTodos() {
		for (Autenticavel u : this.usuarios.values()) {
			u.deslogar();
		}
	}
	
	public String showUser(String nome) {
	    if(usuarios.get(nome) == null) {
	        throw new MsgException("fail: usuario " + nome + " nao encontrado");
	    }
	    
		return usuarios.get(nome) + ":" + usuarios.get(nome).getSenha() + ":" +usuarios.get(nome).getLogado();
	}

	@Override
	public String toString() {
		String s = "";
		for (Autenticavel u : this.usuarios.values()) {
			s += u + ":" + u.getSenha() + ":" + u.getLogado() + "\n";
		}
		return s;
	}
}
