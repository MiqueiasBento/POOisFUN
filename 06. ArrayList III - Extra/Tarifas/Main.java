package Tarifas;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Account account = new Account(0);
		
		while(true) {
			String line = input();
			write("$" + line);
			args = line.split(" ");
			
			try {
				switch(args[0]) {
				case "end":
					return;
				case "init":
					account = new Account(number(args[1]));
					break;
				case "show":
					write(account);
					break;
				case "deposit":
					account.deposit(number(args[1]));
					break;
				case "withdraw":
					account.withdraw(number(args[1]));
					break;
				case "fee":
					account.fee(number(args[1]));
					break;
				case "extract":
					write(account.getExtract(number(args[1])));
					break;
				case "reverse":
					for(int i = 1; i < args.length; i++) {
    					try {
    						account.reverse(number(args[i]));
    					} catch(Exception e) {
    						write(e.getMessage());
    						continue;
    					}
    				}
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
	public static void write(Object str)	{ System.out.println(str); }
	public static int number(String str) 	{ return Integer.parseInt(str); }
}