import java.util.*;

class Animal {
	public String especie;
	public String barulho;
	public int idade;
	public boolean alive;
	
	public Animal() {
	}
	
	public Animal(String especie, String barulho) {
		super();
		this.especie = especie;
		this.barulho = barulho;
		this.idade = 0;
		this.alive = true;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getBarulho() {
		return barulho;
	}

	public void setBarulho(String barulho) {
		this.barulho = barulho;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public boolean getAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	// Metodos
	public String fazerBarulho() {
		if(getAlive() && getIdade() < 1) {
			return "---";
		} else if(getAlive() && getIdade() >= 1) {
			return this.barulho;
		} else {
			return "RIP";
		}
	}

	public void envelhecer(int number) {
		if(getIdade() < 4) {
			setIdade(getIdade() + number);
		}
		if(getIdade() >= 4) {
			Animais.write("warning: " + getEspecie() + " morreu");
			setIdade(4);
			setAlive(false);
		}
	}

	@Override
	public String toString() {
		return especie + ":" + idade + ":" + barulho;
	}
}

public class Animais {
	public static void main(String[] arg) {
		Animal animal = new Animal();

		while (true) {
			var line = input();
			var args = line.split(" ");
			write("$" + line);

			if (args[0].equals("init")) {
				animal = new Animal(args[1], args[2]);
			} else if (args[0].equals("grow")) {
				animal.envelhecer((int) number(args[1]));
			} else if (args[0].equals("noise")) {
				write(animal.fazerBarulho());
			} else if (args[0].equals("show")) {
				write(animal.toString());
			} else if (args[0].equals("end")) {
				break;
			} else {
				write("fail: comando invalido");
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