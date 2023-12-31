package Shapes;

import java.text.DecimalFormat;

public class Rectangle extends Shape{
	public Point2D p1;
	public Point2D p2;
	
	public Rectangle(Point2D p1, Point2D p2) {
		super("Rect");
		this.p1 = p1;
		this.p2 = p2;
	}
	

	@Override
	public double getArea() {
		double altura = Math.abs(p1.x - p2.x);
		double largura = Math.abs(p1.y - p2.y);
		
		return (largura * altura);
	}

	@Override
	public double getPerimeter() {
		double altura = Math.abs(p1.x - p2.x);
		double largura = Math.abs(p1.y - p2.y);
		
		return 2 * (altura + largura);
	}
	
	public String toString() {
		DecimalFormat d = new DecimalFormat("0.00");
		// Rect: P1=(1.00, 1.00) P2=(3.00, 3.00)
		return super.toString() + ": "
								+ "P1=(" + d.format(p1.x) + ", " + d.format(p1.y) + ") "
								+ "P2=(" + d.format(p2.x) + ", " + d.format(p2.y) + ")";
	}
}