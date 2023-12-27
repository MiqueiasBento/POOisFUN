package Hospital;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();

		while (true) {
			String line = input();
			write("$" + line);
			args = line.replace('-', ' ').split(" ");
			
			try {
				switch(args[0]) {
					case "end":
						return;
					case "show":
						write(hospital);
						break;
					case "addPacs":
						for(int i = 1; i < args.length; i += 2)
							hospital.addPaciente(new Paciente(args[i], args[i+1]));
						break;
					case "addMeds":
						for(int i = 1; i < args.length; i += 2)
							hospital.addMedico(new Medico(args[i], args[i+1]));
						break;
					case "tie":
						for(int i = 2; i < args.length; i++)
							hospital.vincular(args[1], args[i]);
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
	public static void write(Object obj) 	{ System.out.println(obj); }
}