package Carga;

public enum Direcao {
    IN,
    OUT;

    @Override
    public String toString() {
        if(this == IN) return "in";
        else return "out";
    }
}