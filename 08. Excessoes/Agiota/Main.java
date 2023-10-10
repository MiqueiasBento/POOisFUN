package Agiota;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		LoanShark agiota = new LoanShark();

		while (true) {
			String line = input();
//			write("$" + line);
			args = line.split(" ");

			switch (args[0]) {
			case "end":
				return;
			case "init":
				agiota = new LoanShark();
				break;
			case "show":
				print(agiota);
				break;
			case "showCli":
				agiota.getClient(args[1]);
				break;
			case "addCli":
			case "add":
				agiota.addClient(args[1], (int) number(args[2]));
				break;
			case "give":
				agiota.give(args[1], (int) number(args[2]));
				break;
			case "take":
				agiota.take(args[1], (int) number(args[2]));
				break;
			case "kill":
				agiota.kill(args[1]);
				break;
			case "plus":
				agiota.plus();
				break;
			default:
				println("fail: comando invalido");
			}

		}
	}

	private static Scanner scanner = new Scanner(System.in);

	public static String input()				{ return scanner.nextLine(); }
	public static void write(String str)		{ System.out.println(str); }
	private static double number(String value)	{ return Double.parseDouble(value); }
	public static void println(Object value)	{ System.out.println(value); }
	public static void print(Object value)		{ System.out.print(value); }
}
