package Salario;

public class Professor extends Funcionario {
    protected String classe;

    public Professor(String nome, String classe) {
        super(nome);
        this.classe = classe;
        this.maxDiarias = 2;
    }

    public String getClasse() {
        return classe;
    }

    @Override
    public int getSalario() {
        int salarioBase = 0;
        switch (classe) {
            case "A":
                salarioBase = 3000;
                break;
            case "B":
                salarioBase = 5000;
                break;
            case "C":
                salarioBase = 7000;
                break;
            case "D":
                salarioBase = 9000;
                break;
            case "E":
                salarioBase = 11000;
                break;
        }
        return salarioBase + super.getSalario();
    }

    @ Override
    public String toString(){
        return "prof:" + getNome() + ":" + getClasse() + ":" + getSalario();
    }
}