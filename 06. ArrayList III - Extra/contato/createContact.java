package contato;

import java.util.Scanner;

public class createContact {
	public static void main(String[] arg) {
		Contact contato = new Contact("");
		
		while(true) {
			String line = input();
			write("$" + line);
			String[] args = line.split(" ");
			
			switch(args[0]) {
				case "end":
					return;
				case "init":
					contato = new Contact(args[1]);
					break;
				case "add":
					contato.addFone(new Fone(args[1], args[2]));
					break;
				case "rm":
					contato.removeFone(number(args[1]));
					break;
				case "tfav":
					contato.toogleFavorited();
					break;
				case "show":
					write("" + contato);
					break;
				default:
					write("fail: comando invalido");
			}
		}
	}
	public static Scanner sc = new Scanner(System.in);
	
	public static String input() {
		return sc.nextLine();
	}
	public static void write(String str) {
		System.out.println(str);
	}
	public static int number(String str) {
		return Integer.parseInt(str);
	}
}
