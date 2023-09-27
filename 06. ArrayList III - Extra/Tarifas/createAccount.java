import java.util.*;

public class createAccount {
	public static void main(String[] args) {
		Account conta;
		
		while(true) {
			String line = input();
			write("$" + line);
			args = line.split(" ");
			
			switch(args[0]) {
				case "end":
					return;
				case "init":
					conta = new Account(number(args[1]));
					break;
				case "deposit":
					conta.deposit(number(args[1]));
					break;
				case "show":
					write("" + show);
					break;
				case "withdraw":
					
					break;
				case "fee":
					
					break;
				case "extract":
					
					break;
				case "reverse":
					
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
