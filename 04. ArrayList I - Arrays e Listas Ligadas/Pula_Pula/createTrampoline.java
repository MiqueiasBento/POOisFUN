package Pula_Pula;

import java.util.*;

public class createTrampoline {
	public static void main(String[] args) {
		Trampoline tramp = new Trampoline();
		
        while(true) {
            String line = input();
//            write("$"+ line);
            String[] ui = line.split(" ");
            
            switch(ui[0]) {
            	case "end":
            		return;
            	case "arrive":
            		tramp.arrive(new Kid(number(ui[2]), (ui[1]))) ;
            		break;
            	case "enter":
            		tramp.enter();
            		break;
            	case "leave":
            		tramp.leave();
            		break;
            	case "remove":
            		tramp.remove(ui[1]);
            		break;
            	case "show":
            		write(tramp + "");
            		break;
            	default:
            		write("fail: comando invalido");
            }
        }
	}
	public static Scanner sc = new Scanner(System.in);
	
	public static String input() 			{ return sc.nextLine(); }
	public static void write(String str) 	{ System.out.println(str); }
	public static int number(String str) 	{ return Integer.parseInt(str); }
}