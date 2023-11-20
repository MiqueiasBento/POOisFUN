package Autenticaveis;

import java.util.*;

class MsgException extends RuntimeException {
    public MsgException(String message) {
        super(message);
        // this.detailMessage = message;
    }
}

public class Main {
	public static void main(String[] arg) {
		Sistema sis = new Sistema();

		while (true) {
			String line = input();
			println("$" + line);
			String[] args = line.split(" ");

			try {
				if (args[0].equals("end")) {
					break;
				} else if (args[0].equals("addProf")) {
					sis.getUFC().addFuncionario(new Professor(args[1], args[2]));
				} else if (args[0].equals("addSta")) {
					sis.getUFC().addFuncionario(new STA(args[1], (int) number(args[2])));
				} else if (args[0].equals("addTer")) {
					sis.getUFC().addFuncionario(new Terceirizado(args[1], (int) number(args[2]), args[3]));
				} else if (args[0].equals("rm")) {
					sis.getUFC().rmFuncionario(args[1]);
				} else if (args[0].equals("rmFunc")) {
					sis.getUFC().rmFuncionario(args[1]);
				} else if (args[0].equals("showAll")) {
					print(sis.getUFC());
				} else if (args[0].equals("show")) {
					println(sis.getUFC().getFuncionario(args[1]));
				} else if (args[0].equals("showFunc")) {
					println(sis.getUFC().getFuncionario(args[1]));
				} else if (args[0].equals("addDiaria")) {
					sis.getUFC().getFuncionario(args[1]).addDiaria();
				} else if (args[0].equals("setBonus")) {
					sis.getUFC().setBonus((int) number(args[1]));
				} else if (args[0].equals("addAlu")) {
					sis.getUFC().addAluno(new Aluno(args[1], args[2], (int) number(args[3])));
				} else if (args[0].equals("rmAlu")) {
					sis.getUFC().rmAluno(args[1]);
				} else if (args[0].equals("showAlu")) {
					println(sis.getUFC().getAluno(args[1]));
				} else if (args[0].equals("addUser")) {
					sis.addUsuario(args[1], args[2]);
				} else if (args[0].equals("rmUser")) {
					sis.rmUsuario(args[1]);
				} else if (args[0].equals("showUser")) {
					println(sis.showUser(args[1]));
				} else if (args[0].equals("showAllUsers")) {
					print(sis);
				} else if (args[0].equals("logar")) {
					sis.logar(args[1], args[2]);
				} else if (args[0].equals("deslogar")) {
					sis.deslogar(args[1]);
				} else if (args[0].equals("deslogarTodos")) {
					sis.deslogarTodos();
				} else {
					println("fail: comando invalido");
				}
			} catch (MsgException me) {
				println(me.getMessage());
				// e.printStackTrace(System.out);
			}
		}
	}

	private static Scanner scanner = new Scanner(System.in);

	private static String input() {
		return scanner.nextLine();
	}

	private static double number(String value) {
		return Double.parseDouble(value);
	}

	public static void println(Object value) {
		System.out.println(value);
	}

	public static void print(Object value) {
		System.out.print(value);
	}
}