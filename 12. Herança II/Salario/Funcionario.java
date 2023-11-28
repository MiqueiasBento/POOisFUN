package Salario;

abstract class Funcionario {
    protected String nome;
    protected int bonus;
    protected int diarias;
    protected int maxDiarias;

    public Funcionario(String nome) {
        this.nome = nome;
        this.bonus = 0;
        this.diarias = 0;
        this.maxDiarias = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void addDiaria() throws Exception {
        if(this.maxDiarias == 0){
            throw new Exception("fail: terc nao pode receber diaria");
        }
        
        if (this.diarias < this.maxDiarias) {
            this.diarias++;
        } else {
            throw new Exception("fail: limite de diarias atingido");
        }
    }

    public int getSalario() {
        return this.bonus + this.diarias * 100;
    }
}