package Twitter;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Tweet twitter = new Tweet();
		
		while(true) {
			String line = input();
			write("$" + line);
			args = line.split(" ");
			
			try {
				switch(args[0]) {
					case "end":
						return;
					case "add":
						
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
