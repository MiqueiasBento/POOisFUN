import java.util.*;

public class Budega {
	public static void main(String[] arg) {
		Mercantil bank = new Mercantil(0);

		while (true) {
			String line = input();
			String[] args = line.split(" ");
//			write('$' + line);

			switch (args[0]) {
			case "end":
				return;
			case "init":
				bank = new Mercantil(number(args[1]));
				break;
			case "call":
				bank.chamar(number(args[1]));
				break;
			case "finish":
				bank.finalizar(number(args[1]));
				break;
			case "arrive":
				bank.chegar(new Pessoa(args[1]));
				break;
			case "show":
				write(bank + "");
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
