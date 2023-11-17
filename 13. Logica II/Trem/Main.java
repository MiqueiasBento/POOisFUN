package Trem;

import java.util.Scanner;

public class Main {
	static Registro registros = new Registro();
	public static void main(String[] args) {
		Trem trem = new Trem(0);
		
		while(true) {
			String line = input();
			write("$" + line);
			args = line.split(" ");
			
			try {
				switch(args[0]) {
				case "end":
					return;
				case "init":
					trem = new Trem(number(args[1]));
					break;
				case "la":
				case "show":
					write(trem);
					break;
				case "nwvag":
					trem.addVagao(number(args[1]));
					break;
				case "entrar":
					trem.embarcar(new Passageiro(args[1]));
					break;
				case "sair":
					trem.desembarcar(new Passageiro(args[1]));
					break;
				case "cadastro":
					write(registros.getCadastro());
					break;
				case "movimentacao":
					write(registros.getMovimento());
					break;
				default:
					write("fail: comando invalido");
				}	
			} catch(Exception e) {
				write(e.getMessage());
			}
		}
	}
	public static Scanner sc = new Scanner(System.in);
	public static String input() 			{ return sc.nextLine(); }
	public static void write(Object str) 	{ System.out.println(str); }
	public static int number(String str) 	{ return Integer.parseInt(str); }
}