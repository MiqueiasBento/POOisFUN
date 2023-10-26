package Salario;

public class STA extends Funcionario {
    protected int nivel;

    public STA(String nome, int nivel) {
        super(nome);
        this.nivel = nivel;
        this.maxDiarias = 1;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public int getSalario() {
        return 3000 + 300 * nivel + super.getSalario();
    }

    @Override
    public String toString(){
        return "sta:" + getNome() + ":" + getNivel() + ":" + getSalario();
    }
}