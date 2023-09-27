package Porquinho;

import java.util.*;

public class Cofre {
	public static void main(String[] args) {
		Pig pig = new Pig();

		while (true) {
			String line = input();
			write("$" + line);
			String[] arg = line.split(" ");

			switch (arg[0]) {
			case "end":
				return;
			case "addCoin":
				if (arg[1].equals("10"))
					pig.addCoin(Coin.C10);
				else if (arg[1].equals("25"))
					pig.addCoin(Coin.C25);
				else if (arg[1].equals("50"))
					pig.addCoin(Coin.C50);
				else if (arg[1].equals("100"))
					pig.addCoin(Coin.C100);
				break;
			case "init":
				pig = new Pig(number(arg[1]));
				break;
			case "addItem":
				pig.addItem(new Item(arg[1], number(arg[2])));
				break;
			case "break":
				pig.breakPig();
				break;
			case "extractCoins":
				pig.extractCoins();
				break;
			case "extractItems":
				pig.extractItens();
				break;
			case "show":
				write(pig + "");
				break;
			default:
				write("fail: invalid command");
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