import java.util.*;

class Car {
    int pass;
    int passMax;
    int gas;
    int gasMax;
    int km;

    // Construtor
    public Car() {
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;
    }

    // Metodos
    public void enter() {
        if ((this.pass + 1) <= this.passMax) {
            this.pass++;
        } else {
            println("fail: limite de pessoas atingido");
        }
    }

    public void leave() {
        if ((this.pass - 1) >= 0) {
            this.pass--;
        } else {
            println("fail: nao ha ninguem no carro");
        }
    }

    public void fuel(int maisGas) {
        if ((this.gas + maisGas) <= this.gasMax) {
            this.gas += maisGas;
        } else {
            this.gas = this.gasMax;
        }
    }

    public void drive(int dist) {
        if ((this.pass > 0) && (this.gas > 0)) {
            if (dist > this.gas) {
                println("fail: tanque vazio apos andar " + this.gas + " km");
                this.km += gas;
                this.gas = 0;
            } else {
                this.km = dist;
                this.gas -= dist;
            }
        } else if (this.pass == 0) {
            println("fail: nao ha ninguem no carro");
        } else if (this.gas == 0) {
            println("fail: tanque vazio");
        }
    }

    public String toString() {
        return "pass: " + this.pass + ", gas: " + this.gas + ", km: " + this.km;
    }

    public void println(String str) {
        System.out.println(str);
    }
}

public class Carro {

    public static void main(String[] args) {
        Car carro = new Car();

        while (true) {
            var line = input(); // Ler a linha
            print("$" + line); // Printa o que foi lido anteriormente
            var vals = line.split(" "); // Retira os espaçoes em branco da linha lida

            if (vals[0].equals("end")) {
                break;
            } else if (vals[0].equals("show")) {
                System.out.println(carro);
            } else if (vals[0].equals("enter")) {
                carro.enter();
            } else if (vals[0].equals("leave")) {
                carro.leave();
            } else if (vals[0].equals("drive")) {
                carro.drive((int) number(vals[1]));
            } else if (vals[0].equals("fuel")) {
                carro.fuel((int) number(vals[1]));
            } else {
                print("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    static String input() {
        return scanner.nextLine();
    }

    static double number(String value) {
        return Double.parseDouble(value);
    }

    static void print(String value) {
        System.out.println(value);
    }
}
