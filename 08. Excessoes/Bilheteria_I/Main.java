package Bilheteria_I;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Bilheteria b = new Bilheteria();
		
		while(true) {
			String line = input();
			write("$" + line);
			args = line.split(" ");
			
			try {
				switch(args[0]) {
					case "end":
						return;
					case "show":
						write(b);
						break;
					case "addPessoa":
						b.addPessoa(args[1], isMeia(args[2]));
						break;
					case "addEvento":
						b.addEvento(args[1], number(args[2]));
						break;
					case "pessoas":
						write(b.getPessoas());
						break;
					case "eventos":
						write(b.getEventos());
						break;
					case "pessoa":
						write(b.getPessoa(args[1]));
						break;
					case "evento":
						write(b.getEvento(args[1]));
						break;
					case "vender":
						b.vender(args[1], args[2]);;
						break;
					case "vendas":
						write(b.getVendas();
						break;
					default:
						write("fail: comando invalido");
				}
			} catch (Exception e){
				write(e.getMessage());
			}
		}
	}
	public static Scanner sc = new Scanner(System.in);
	public static String input()				{ return sc.nextLine(); }
	public static void write(Object obj) 		{ System.out.println(obj); }
	public static double number(String str) 	{ return Double.parseDouble(str); }
	public static boolean isMeia(String str) 		{ return (str.equals("meia") ? true : false); }
}