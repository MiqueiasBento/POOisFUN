import java.util.Scanner;

class Time {
	public int hour = 0;
	public int minute = 0;
	public int second = 0;

	public Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	// Getters e Setters
	public int getHour(){
	    return hour;
	}
	public int getMinute(){
	    return minute;
	}
	public int getSecond(){
	    return second;
	}
	
	public void setHour(int hour){
	    if(hour > 24){
	        System.out.println("fail: hora invalida");
	    } else {
	        this.hour = hour;
	    }
	}
	public void setMinute(int minute){
	    if(minute >= 60){
	        System.out.println("fail: minuto invalido");
	    } else {
	        this.minute = minute;
	    }
	}
	public void setSecond(int second){
	    if(second >= 60){
	        System.out.println("fail: segundo invalido");
	    } else {
	        this.second = second;
	    }
	}

	// Metodos
	public void nextSecond() {
		int tot = getHour() * 3600 + (getMinute() * 60) + getSecond() + 1;
		setHour((tot / 3600) % 24);
		setMinute((tot / 60) % 60);
		setSecond(tot % 60);
		
		if(getHour() == 24) setHour(0);
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}

public class Clock {
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
			} else if (args[0].equals("set")) {
				time.setHour(number(args[1]));
				time.setMinute(number(args[2]));
				time.setSecond(number(args[3]));
			} else if(args[0].equals("init")){
				time = new Time(number(args[1]), number(args[2]), number(args[3]));
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