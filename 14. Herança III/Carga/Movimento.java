package Carga;

public class Movimento {
    private Pass pass;
    private Direcao dir;

    public Movimento(Pass pass, Direcao dir) {
        this.pass = pass;
        this.dir  = dir;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }

    public Direcao getDir() {
        return dir;
    }

    public void setDir(Direcao dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        if(pass instanceof Pessoa)
            return pass.getId() + " " + dir.toString();
        else
            return pass.getId() + ":" + String.format("%.1f", ((Carga) pass).getPeso()) + " " + dir.toString();
    }
}