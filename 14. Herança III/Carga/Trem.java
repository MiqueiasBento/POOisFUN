package Carga;

import java.util.*;

public class Trem {
    private int maxVagoes;
    private List<Vagao> vagoes = new ArrayList<>();
    private Registro reg = new Registro();

    public Trem(int maxVagoes) {
        this.maxVagoes = maxVagoes;
    }

    public void addVagao(Vagao vagao) throws Exception {
        if(vagoes.size() == maxVagoes)
            throw new Exception("fail: limite de vagões atingido");
        vagoes.add(vagao);
    }

    public Registro getReg() {
        return reg;
    }

    public boolean isFull() {
        long size = vagoes.stream()
                .filter(v -> v instanceof VagaoPessoa).count();
        long aux  = vagoes.stream()
                .filter(v -> v instanceof VagaoPessoa && !((VagaoPessoa) v).hasVacancy()).count();
        return size == aux;
    }

    public boolean passengerExist(Pass pass) {
        long i = vagoes.stream()
                .filter(v -> v instanceof VagaoPessoa && v.exists(pass)).count();
        return i > 0;
    }

    public void embarcar(Pass pass) throws Exception {
        reg.cadastrar(pass);
        reg.sort();

        if(pass instanceof Pessoa) {
            if(isFull())
                throw new Exception("fail: trem lotado");

            for(Vagao v : vagoes) {
                if(v.exists(pass))
                    throw new Exception("fail: " + pass.getId() + " já está no trem");

                if(v instanceof VagaoPessoa && ((VagaoPessoa) v).hasVacancy()) {
                    v.embarcar(pass);
                    reg.movimentar(new Movimento(pass, Direcao.IN));
                    return;
                }
            }
        }
        else {
            for(Vagao v : vagoes) {
                if(v instanceof VagaoCarga) {
                    v.embarcar(pass);
                    reg.movimentar(new Movimento(pass, Direcao.IN));
                }
            }
        }
    }

    public void desembarcar(String idPass) throws Exception {
        int i = 0;
        for(Vagao v : vagoes) {
            if (v instanceof VagaoPessoa) {
                for (Pass p : v.getElementos()) {
                    if (p != null) {
                        if (p.getId().equals(idPass)) {
                            i++;
                            v.desembarcar(idPass);
                            reg.movimentar(new Movimento(new Pessoa(idPass), Direcao.OUT));
                        }
                    }
                }
            }
            else if (v.exists(new Carga(idPass, 0f))){
                Carga aux = (Carga) ((VagaoCarga) v).getPass(idPass);
                v.desembarcar(idPass);
                reg.movimentar(new Movimento(aux, Direcao.OUT));
                i++;
            }
        }
        if(i == 0)
            throw new Exception("fail: " + idPass + " nao esta no trem");

    }

    public boolean exists(Pass pass) {
        int i = 0;
        for(Vagao v : vagoes) {
            if(v instanceof VagaoPessoa && v.exists(pass))
                i++;
        }
        return i > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trem ");

        for(Vagao v : vagoes) { sb.append(v); }

        return sb.toString();
    }
}