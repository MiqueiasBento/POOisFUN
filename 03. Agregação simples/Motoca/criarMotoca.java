package Motoca;

import java.util.*;

public class criarMotoca {
    public static void main(String[] args) {
        Motorcycle motoca = new Motorcycle(1);

        while (true) {
            String line = input();
            args = line.split(" ");
            write('$' + line);

            if (args[0].equals("show")) {
                System.out.println(motoca);
            } else if (args[0].equals("init")) {
                motoca = new Motorcycle(number(args[1]));
            } else if (args[0].equals("buy")) {
                motoca.buyTime(number(args[1]));
            } else if (args[0].equals("drive")) {
                motoca.drive(number(args[1]));
            } else if (args[0].equals("enter")) {
                motoca.insertPerson(number(args[2]), args[1]);
            } else if (args[0].equals("honk")) {
                motoca.honk();
            } else if (args[0].equals("leave")) {
                if (motoca.getPerson() != null) {
                    System.out.println(motoca.getPerson());
                }
                motoca.removePerson();
            } else if (args[0].equals("end")) {
                break;
            } else
                System.out.println("fail: comando invalido");
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void write(String value) {
        System.out.println(value);
    }

    public static int number(String str) {
        return Integer.parseInt(str);
    }
}