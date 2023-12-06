package Carga;

import java.util.*;

public class VagaoCarga implements Vagao {
    private float cargaMax;
    private float cargaAtual = 0f;
    private List<Pass> elementos = new ArrayList<>();

    public VagaoCarga(float cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public List<Pass> getElementos() {
        return elementos;
    }

    public Pass getPass(String idPass) {
        for(Pass p : elementos) {
            if(p.getId().equals(idPass))
                return p;
        }
        return null;
    }

    @Override
    public void embarcar(Pass pass) throws Exception {
        if(cargaAtual + ((Carga) pass).getPeso() < cargaMax) {
            elementos.add(pass);
            cargaAtual += ((Carga) pass).getPeso();
        }
        else
            throw new Exception("fail: trem lotado");
    }

    @Override
    public void desembarcar(String idPass) {
        for(Pass p : elementos) {
            if(p.getId().equals(idPass))
                cargaAtual -= ((Carga) p).getPeso();
        }
        elementos.removeIf(p -> p != null && p.getId().equals(idPass));
    }

    @Override
    public boolean exists(Pass pass) {
        return elementos.contains(pass);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");

        if(elementos.isEmpty()) {
            sb.append(String.format("_%.1f )", cargaMax));
            return sb.toString();
        }

        for(Pass p: elementos)
            sb.append(p).append(" ");

        sb.append(String.format("_%.1f )", cargaMax - cargaAtual));
        return sb.toString();
    }
}