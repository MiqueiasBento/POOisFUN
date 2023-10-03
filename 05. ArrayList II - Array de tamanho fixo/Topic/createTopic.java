package Topic;

import java.util.Scanner;

public class createTopic {
	public static void main(String args[]) {
		Topic topic = new Topic(0, 0);
		
		while(true) {
			String line = input();
			write("$" + line);
			String[] arg = line.split(" ");
			
			switch(arg[0]) {
				case "end":
					return;
				case "init":
					topic = new Topic(number(arg[2]), (number(arg[1]) - number(arg[2])));
					break;
				case "show":
					write(topic + "");
					break;
				case "in":
					topic.insert(new Pass(number(arg[2]), arg[1]));
					break;
				case "out":
					topic.remove(arg[1]);
					break;
				default:
					write("comando invalido");
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