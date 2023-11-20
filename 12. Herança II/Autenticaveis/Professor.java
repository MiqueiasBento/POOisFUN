package Autenticaveis;

public class Professor extends FuncionarioAutenticavel {
	protected String classe;

	// inicializa classe e muda maxDiarias para 2
	public Professor(String nome, String classe) {
		super(nome);
		this.classe = classe;
		this.maxDiarias = 2;
	}

	public String getClasse() {
		return this.classe;
	}

	public int getValorClasse() {
		switch (this.getClasse()) {
		case "A":
			return 3000;
		case "B":
			return 5000;
		case "C":
			return 7000;
		case "D":
			return 9000;
		case "E":
			return 11000;
		default:
			return 0;
		}
	}

	// lógica do salário do professor
	// usa o super.getSalario() para pegar bonus e diarias
	@Override
	public int getSalario() {
		return super.getSalario() + getValorClasse();
	}

	@Override
	public String toString() {
		return "prof:" + this.getNome() + ":" + this.getClasse() + ":" + this.getSalario();
	}
}