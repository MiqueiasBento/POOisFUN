package Carga;

import java.util.*;

public class Registro {
    private List<Pass> repPassageiros = new ArrayList<>();
    private List<Movimento> movimentacao = new ArrayList<>();

    public void cadastrar(Pass pass) {
        if(!repPassageiros.contains(pass))
            repPassageiros.add(pass);
    }

    public void movimentar(Movimento mov) {
        movimentacao.add(mov);
    }

    public void sort() {
        repPassageiros.sort(Comparator.comparing(Pass::getId));
    }

    public void showCadastro() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repPassageiros.size(); i++) {
            sb.append(repPassageiros.get(i));
            if(i < repPassageiros.size() - 1) { sb.append("\n"); }
        }
        System.out.println(sb.toString());
    }

    public void showMovimentacao() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < movimentacao.size(); i++) {
            sb.append(movimentacao.get(i));
            if(i < movimentacao.size() - 1) { sb.append("\n"); }
        }
        System.out.println(sb.toString());
    }
}