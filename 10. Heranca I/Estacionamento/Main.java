package Estacionamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Estacionamento estac = new Estacionamento();
        // Questão com ajustes da AP2
        
        while (true) {
            String line = input();
            println("$" + line);
            String[] args = line.split(" ");
            
            try{
            	switch(args[0]) {
            		case "end":
            			return;
            		case "show":
            			println(estac);
            			break;
            		case "bike":
            			estac.estacionar(new Bike(args[1]));
            			break;
            		case "carro":
            			estac.estacionar(new Carro(args[1]));
            			break;
            		case "moto":
            			estac.estacionar(new Moto(args[1]));
            			break;
            		case "tempo":
            			estac.passarTempo((int) number(args[1]));
            			break;
            		case "pagar":
            			println(estac.pagar(args[1]));
            			break;
            		case "pagarTodos":
            			println(estac.pagar(args[1]));
            			break;
            		case "sair":
            			estac.sair(args[1]);
            			break;
            		case "sairTodos":
            			estac.sairTodos();
            			break;
            		default:
            			println("fail: comando invalido");
            	}
            } catch(Exception e){
                println(e.getMessage());
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static double  number(String value)   { return Double.parseDouble(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }
}