package Cinema;

import java.util.Scanner;

public class createCinema {
	public static void main(String[] args) {
		Sala sala = new Sala(0);
		
		while(true) {
			String line = input();
			write("$" + line);
			String[] arg = line.split(" ");
			
			switch(arg[0]) {
				case "end":
					return;
				case "init":
					sala = new Sala(number(arg[1]));
					break;
				case "show":
					write(sala + "");
					break;
				case "reservar":
					sala.reservar(arg[1], arg[2], number(arg[3]));
					break;
				case "cancelar":
					sala.cancelar(arg[1]);
					break;
				default:
					write("fail: camando invalido");
			}
		}
	}
	public static Scanner sc = new Scanner(System.in);
	
	public static String input() 			{ return sc.nextLine(); }
	public static void write(String str)	{ System.out.println(str); }
	public static int number(String str)	{ return Integer.parseInt(str); }
}