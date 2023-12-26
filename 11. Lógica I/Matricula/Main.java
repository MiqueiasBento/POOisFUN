package Matricula;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		while(true) {
			String line = input();
			write("$" + line);
			args = line.split(" ");
			
			try {
				switch(args[0]) {
					case "end":
						return;
					case "nwalu":
						for(int i = 1; i < args.length; i++) {
							sistema.addAluno(new Aluno(args[i]));
						}
						break;
					case "nwdis":
						for(int i = 1; i < args.length; i++) {
							sistema.addDiscp(new Discp(args[i]));
						}
						break;
					case "tie":
						for(int i = 2; i < args.length; i++) {
							sistema.matricular(args[1], args[i]);;
						}
						break;
					case "untie":
						for(int i = 2; i < args.length; i++) {
							sistema.desmatricular(args[1], args[i]);;
						}
						break;
					case "rmalu":
						sistema.rmAluno(args[1]);
						break;
					case "show":
						write(sistema);
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
	public static String input() { return sc.nextLine(); }
	public static void write(Object value) { System.out.println(value); }
	public static int number(String value) { return Integer.parseInt(value); }
}