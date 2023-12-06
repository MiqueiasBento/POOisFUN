package Carga;

import java.util.Arrays;
import java.util.List;

public class VagaoPessoa implements Vagao {
    private int capacidade;
    private Pass[] elementos;

    public VagaoPessoa(int capacidade) {
        this.capacidade = capacidade;
        elementos = new Pessoa[capacidade];
    }

    public boolean hasVacancy() {
        for(Pass p : elementos) {
            if(p == null)
                return true;
        }
        return false;
    }

    @Override
    public List<Pass> getElementos() {
        return Arrays.asList(elementos);
    }

    @Override
    public void embarcar(Pass pass) {
        for(int i = 0; i < elementos.length; i++) {
            if(elementos[i] == null) {
                elementos[i] = pass;
                return;
            }
        }
    }

    @Override
    public void desembarcar(String idPass) {
        for(int i = 0; i < elementos.length; i++) {
            if(elementos[i] != null && elementos[i].getId().equals(idPass))
                elementos[i] = null;
        }
    }

    @Override
    public boolean exists(Pass pass) {
        for (Pass e : elementos) {
            if (e != null && e.equals(pass))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        for (Pass p : elementos) {
            if (p == null)
                sb.append("- ");
            else
                sb.append(p).append(" ");
        }

        sb.append("]");
        return sb.toString();
    }
}