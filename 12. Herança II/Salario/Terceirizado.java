package Salario;

public class Terceirizado extends Funcionario {
    protected int horas;
    protected boolean isSalubre;

    public Terceirizado(String nome, int horas, String isSalubre) {
        super(nome);
        this.horas = horas;
        this.isSalubre = Boolean.parseBoolean(isSalubre);
        this.maxDiarias = 0;
    }

    public int getHoras() {
        return horas;
    }

    public String getIsSalubre() {
        return isSalubre ? "nao" : "sim";
    }

    @Override
    public int getSalario() {
        return 4 * horas + ((isSalubre) ? 0 : 500) + super.getSalario();
    }

    @Override
    public String toString(){
        return "ter:" + getNome() + ":" + getHoras() + ":" + getIsSalubre() + ":" + getSalario();
    }
}