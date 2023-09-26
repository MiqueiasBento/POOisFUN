import java.util.*;

class Calculator {
    int battery;
    int batteryMax;
    float display;

    // Construtor
    public Calculator(int batteryMax) {
        this.battery = 0;
        this.batteryMax = batteryMax;
        this.display = 0;
    }

    // Metodos
    public void chargeBattery(int value) {
        if (value + this.battery > this.batteryMax) {
            this.battery = batteryMax;
        } else {
            this.battery += value;
        }
    }

    public void sum(int number1, int number2) {
        if (this.battery > 0) {
            this.display = number1 + number2;
            useBattery();
        } else {
            Calculadora.println("fail: bateria insuficiente");
        }
    }

    public void division(float number1, float number2) {
        if (this.battery > 0) {
            if (number2 == 0) {
                Calculadora.println("fail: divisao por zero");
            } else {
                this.display = (float) number1 / number2;
            }
            useBattery(); // Usa bateria mesmo que a divisao nao ocorra, ou seja quando o number2 e igual
                          // a 0
        } else {
            Calculadora.println("fail: bateria insuficiente");
        }
    }

    public void useBattery() {
        this.battery--;
    }

    public String toString() {
        return "display = "
                + String.format("%.2f", this.display)
                + ", battery = "
                + this.battery;
    }
}

public class Calculadora {
    public static void main(String[] args) {
        Calculator calc = new Calculator(0);

        while (true) {
            String line = input();
            String[] argsL = line.split(" ");
            println('$' + line);

            if ("show".equals(argsL[0])) {
                println(calc.toString());
            } else if ("init".equals(argsL[0])) {
                calc = new Calculator(number(argsL[1]));
            } else if ("charge".equals(argsL[0])) {
                calc.chargeBattery(number(argsL[1]));
            } else if ("sum".equals(argsL[0])) {
                calc.sum(number(argsL[1]), number(argsL[2]));
            } else if ("div".equals(argsL[0])) {
                calc.division(number(argsL[1]), number(argsL[2]));
            } else if ("end".equals(argsL[0])) {
                break;
            } else {
                println("fail: comando invalido");
            }
        }

    }

    static Scanner scanner = new Scanner(System.in);

    static String input() {
        return scanner.nextLine();
    }

    static void println(String str) {
        System.out.println(str);
    }

    static int number(String str) {
        return Integer.parseInt(str);
    }
}