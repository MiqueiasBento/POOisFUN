package Salario;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		UFC ufc = new UFC();
		
		while (true) {
            try {
                String line = scanner.nextLine();
                System.out.println("$" + line);
                args = line.split(" ");
                
                if (args[0].equals("end")) {
                    break;
                } else if (args[0].equals("addProf")) {
                    ufc.addFuncionario(new Professor(args[1], args[2]));
                } else if (args[0].equals("addSta")) {
                    ufc.addFuncionario(new STA(args[1], number(args[2])));
                } else if (args[0].equals("addTer")) {
                    ufc.addFuncionario(new Terceirizado(args[1], number(args[2]), args[3]));
                } else if (args[0].equals("rm")) {
                    ufc.rmFuncionario(args[1]);
                } else if (args[0].equals("showAll")) {
                    System.out.println(ufc);
                } else if (args[0].equals("show")) {
                    System.out.println(ufc.getFuncionario(args[1]));
                } else if (args[0].equals("addDiaria")) {
                    ufc.getFuncionario(args[1]).addDiaria();
                } else if (args[0].equals("setBonus")) {
                    ufc.setBonus(number(args[1]));
                } else {
                    System.out.print("fail: comando invalido");
                }
            } catch(Exception e) {
                write(e.getMessage());
            }
        }
		
	}
	public static Scanner scanner = new Scanner(System.in);
	public static String input()			{ return scanner.nextLine(); }
	public static void write(String str)	{ System.out.println(str); }
	public static int number(String str)	{ return Integer.parseInt(str); }
}