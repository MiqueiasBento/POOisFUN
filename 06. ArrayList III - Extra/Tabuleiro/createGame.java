package Tabuleiro;

import java.util.Scanner;

public class createGame {
	public static void main(String[] arg) {
		Board tab = new Board(0, 0);
		
		while(true) {
			String line = input();
			println("$" + line);
			String[] args = line.split(" ");
			
			switch(args[0]) {
				case "end":
					return;
				case "init":
					tab = new Board(number(args[1]), number(args[2]));
					break;
				case "show":
					println("" + tab);
					break;
				case "roll":
					int i = tab.rollDice(number(args[1]));
					if(i != -1){
					    println("player" + (i+1) + " ganhou");
					};
					
					break;
				case "addTrap":
				    tab.addTrap(number(args[1]));
				    break;
				default:
					println("comanod invalido");
			}
		}
			
	}
	public static Scanner sc = new Scanner(System.in);
	
	public static String input() 			{ return sc.nextLine(); 	}
	public static void println(String str)	{ System.out.println(str); 	}
	public static int number(String str)	{ return Integer.parseInt(str); 	}
	
}