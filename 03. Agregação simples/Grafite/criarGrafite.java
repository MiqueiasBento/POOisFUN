package Grafite;

import java.util.*;

public class criarGrafite {
    public static void main(String[] args) {
        Pencil lap = new Pencil(0.5f);

        while (true) {
            String line = input();
            String[] argsL = line.split(" ");
            write('$' + line);

            if ("end".equals(argsL[0])) {
                break;
            } else if ("init".equals(argsL[0])) {
                lap = new Pencil(number(argsL[1]));
            } else if ("insert".equals(argsL[0])) {
                lap.insert(new Lead(number(argsL[1]), argsL[2], (int) number(argsL[3])));
            } else if ("remove".equals(argsL[0])) {
                lap.remove();
            } else if ("write".equals(argsL[0])) {
                lap.writePage();
            } else if ("show".equals(argsL[0])) {
                write(lap.toString());
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void write(String value) {
        System.out.println(value);
    }

    public static float number(String str) {
        return Float.parseFloat(str);
    }
}