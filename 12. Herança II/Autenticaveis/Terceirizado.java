package Autenticaveis;

public class Terceirizado extends Funcionario {
	protected int horas;
	protected boolean isSalubre;

	public Terceirizado(String nome, int horas, String isSalubre) {
		super(nome);
		this.horas = horas;
		this.isSalubre = isSalubre.equals("sim") ? true : false;
	}

	public int getHoras() {
		return this.horas;
	}

	public String getIsSalubre() {
		return this.isSalubre ? "sim" : "nao";
	}

	// lance uma MsgException com um texto diferente
	@Override
	public void addDiaria(){
		throw new MsgException("fail: terc nao pode receber diaria");
	}

	// lógica do salário do terceirizado
	// usa o super.getSalario() para pegar bonus e diarias
	@Override
	public int getSalario() {
		return super.getSalario() + 4 * this.getHoras() + (this.isSalubre ? 500 : 0);
	}

	@Override
	public String toString() {
		return "ter:" + this.getNome() + ":" + this.getHoras() + ":" + this.getIsSalubre() + ":" + this.getSalario();
	}
}
