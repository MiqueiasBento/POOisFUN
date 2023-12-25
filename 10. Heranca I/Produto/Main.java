package Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ProductManager p = new ProductManager();
		
		while(true) {
			String line = input();
			write("$" + line);
			args = line.split(" ");
			
			try {
				switch(args[0]) {
					case "end":
						return;
					case "show":
						write(p);
						break;
					case "add":
						p.addProduct(args[1], number(args[2]));
						break;
					case "addPacote":
						List<Integer> list = new ArrayList<>();
						
						for(int i = 1; i < args.length; i++)
							list.add(number(args[i]));
						
						p.addPackage(list);
						break;
					case "addDesconto":
						p.addDiscount(number(args[1]), number(args[2]));
						break;
					default:
						write("fail: comando invalido");
				}
			} catch (Exception e) {
				write(e.getMessage());
			}
		}
	}
	public static Scanner sc = new Scanner(System.in);
	public static String input() 			{ return sc.nextLine(); }
	public static void write(Object obj) 	{ System.out.println(obj); }
	public static int number(String str) 	{ return Integer.parseInt(str); }
}