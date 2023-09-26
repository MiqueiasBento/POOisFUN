import java.util.Scanner;

class Time {
	public int hour;
	public int minute;
	public int second;

	public Time(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// Getters e Setters
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	// Metodos
	public void nextSecond() {
		int tot = getHour() * 3600 + (getMinute() * 60) + getSecond() + 1;
		setHour((tot / 3600) % 24);
		setMinute((tot / 60) % 60);
		setSecond(tot % 60);
		
//		if(getHour() == 24) setHour(0);
	}
	
	public void set(int hour, int minute, int second) {
		if(hour <= 24) setHour(hour);
		else System.out.println("fail: hora invalida");
		
		if(minute <= 59) setMinute(minute);
		else System.out.println("fail: minuto invalido");
		
		if(second <= 59) setSecond(second);
		else System.out.println("fail: segundo invalido");
	}
	
	// Função para não ter que fazer a instacia novamente
	public void init(int hour, int minute, int second) {
		if(hour <= 24) setHour(hour);
		else{
			setHour(0);
			System.out.println("fail: hora invalida");
		}
		
		if(minute <= 59) setMinute(minute);
		else{
			setMinute(0);
			System.out.println("fail: minuto invalido");
		}
		
		if(second <= 59) setSecond(second);
		else{
			setSecond(0);
			System.out.println("fail: segundo invalido");
		}
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

}

public class criarTime {
	public static void main(String[] arg) {
		Time time = new Time(0, 0, 0);

		while (true) {
			var line = input();
			write("$" + line);
			var args = line.split(" ");

			if (args[0].equals("end")) {
				break;
			} else if (args[0].equals("show")) {
				System.out.println(time);
			} else if (args[0].equals("next")) {
				time.nextSecond();
//				System.out.println(time);
			} else if (args[0].equals("set")) {
				time.set(number(args[1]), number(args[2]), number(args[3]));
			} else if(args[0].equals("init")){
				time.init(number(args[1]), number(args[2]), number(args[3]));
			} else {
				write("fail: comando invalido");
			}
		}
	}
	
	private static Scanner scanner = new Scanner(System.in);
	private static String input() {return scanner.nextLine();}
	private static int number(String value) {return Integer.parseInt(value);}
	private static void write(String value) {System.out.println(value);}
}