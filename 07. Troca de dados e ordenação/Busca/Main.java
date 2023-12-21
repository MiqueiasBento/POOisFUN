package Busca;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		while(true) {
			String line = input();
			write("$" + line);
			line = line.replaceAll(":", " ");
			args = line.split(" ");
			
			switch(args[0]) {
				case "end":
					return;
				case "show":
					write(agenda);
					break;
				case "add":
					List<Fone> fones = new ArrayList<>();
					for(int i = 2; i < args.length; i += 2) {
						fones.add(new Fone(args[i], args[i + 1]));
					}
					agenda.addContact(args[1], fones);
					break;
				case "rm":
					agenda.rmContact(args[1]);
					break;
				case "rmFone":
					agenda.rmFone(args[1], number(args[2]));
					break;
				case "search":
					agenda.search(args[1]);
					break;
				case "tfav":
					agenda.addFav(args[1]);
					break;
				case "favs":
				    write(agenda.favoritos());
				    break;
				default:
					write("comando invalido");
			}
		}
		
	}
	public static Scanner sc = new Scanner(System.in);
	public static  String input() {
		return sc.nextLine();
	}
	public static void write(Object obj) {
		System.out.println(obj);
	}
	public static int number(String value) {
		return Integer.parseInt(value);
	}
}