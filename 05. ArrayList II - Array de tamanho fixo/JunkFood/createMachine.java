package JunkFood;

import java.util.Locale;
import java.util.Scanner;

public class createMachine {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		vendingMachine mach = new vendingMachine(0);
		
		while(true) {
			String line = input();
			write("$" + line);
			String[] arg = line.split(" ");
			
			switch(arg[0]) {
				case "end":
					return;
				case "init":
					mach= new vendingMachine((int) number(arg[1]));
					break;
				case "show":
					write(mach + "");
					break;
				case "limpar":
					mach.clearSlot((int) number(arg[1]));
					break;
				case "set":
					mach.setSlot((int) number(arg[1]), (new Slot(arg[2], (int) number(arg[3]), number(arg[4]))));
					break;
				case "dinheiro":
					mach.insertCash(number(arg[1]));
					break;
				case "troco":
					write("voce recebeu " + String.format("%.2f", mach.withdrawCash()) + " RS");
					break;
				case "comprar":
					mach.buyItem((int) number(arg[1]));
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
	public static float number(String str) {
		return Float.parseFloat(str);
	}
}