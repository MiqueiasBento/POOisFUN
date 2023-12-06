package Carga;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Trem trem = new Trem(0);

        while(true) {
            var line = sc.nextLine();
            println("$" + line);
            var ui = line.split(" ");

            try {
                switch (ui[0]) {
                    case "end":
                        return;
                    case "init":
                        trem = new Trem((int) converter(ui[1]));
                        break;
                    case "la":
                        println(trem);
                        break;
                    case "nwvp":
                        trem.addVagao(new VagaoPessoa((int) converter(ui[1])));
                        break;
                    case "nwvc":
                        trem.addVagao(new VagaoCarga((float) converter(ui[1])));
                        break;
                    case "addp":
                        trem.embarcar(new Pessoa(ui[1]));
                        break;
                    case "addc":
                        trem.embarcar(new Carga(ui[1], (float) converter(ui[2])));
                        break;
                    case "sair":
                        trem.desembarcar(ui[1]);
                        break;
                    case "cadastro":
                        trem.getReg().showCadastro();
                        break;
                    case "movimentacao":
                        trem.getReg().showMovimentacao();
                        break;
                    default:
                        println("fail: comando invalido");
                        break;
                }
            } catch (Exception e) {
                println(e.getMessage());
            }
        }
    }
    public static Scanner sc = new Scanner(System.in);
    public static void println(Object obj) { System.out.println(obj); }
    public static double converter(String str) { return Double.parseDouble(str); }
}