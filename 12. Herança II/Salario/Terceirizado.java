package Salario;

public class Terceirizado extends Funcionario {
    protected int horas;
    protected boolean isSalubre;

    public Terceirizado(String nome, int horas, String isSalubre) {
        super(nome);
        this.horas = horas;
        this.isSalubre = (isSalubre.equals("sim") ? true : false);
        this.maxDiarias = 0;
    }

    public int getHoras() {
        return this.horas;
    }

    public String getIsSalubre() {
        return this.isSalubre ? "sim" : "nao";
    }

    @Override
    public int getSalario() {
        return 4 * this.horas + ((this.isSalubre) ? 0 : 500) + super.getSalario();
    }

    @Override
    public String toString(){
        return "ter:" + this.getNome() + ":" + this.getHoras() + ":" + this.getIsSalubre() + ":" + getSalario();
    }
}