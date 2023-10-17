package Shapes;

import java.util.*;

public class Main {
	public static void main(String[] arg) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();

		while (true) {
			String line = input();
			println("$" + line);
			String[] args = line.split(" ");

			if (args[0].equals("end")) {
				break;
			} else if (args[0].equals("circle")) {
				shapes.add( new Circle(new Point2D(number(args[1]), number(args[2])), number(args[3])) );
			} else if (args[0].equals("rect")) {
				shapes.add( new Rectangle( new Point2D( number(args[1]), number(args[2]) ), new Point2D( number(args[3]), number(args[4]) ) ) );
			} else if (args[0].equals("show")) {
				showAll(shapes);
			} else if (args[0].equals("info")) {
				infoAll(shapes);
			} else {
				println("fail: comando invalido");
			}
		}
	}

	private static Scanner scanner = new Scanner(System.in);

	private static String input() {
		return scanner.nextLine();
	}

	private static double number(String value) {
		return Double.parseDouble(value);
	}

	public static void println(Object value) {
		System.out.println(value);
	}

	public static void print(Object value) {
		System.out.print(value);
	}

	public static void showAll(ArrayList<Shape> shapes) {
		for (Shape s : shapes)
			println(s.toString());
	}

	public static void infoAll(ArrayList<Shape> shapes) {
		for (Shape s : shapes)
			println(s.getInfo());
	}
}