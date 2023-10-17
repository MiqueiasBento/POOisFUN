package Shapes;

import java.text.DecimalFormat;

public class Circle extends Shape{
	public Point2D center;
	public double radius;
	
	public Circle(Point2D center, double radius) {
		super("Circ");
		this.center = center;
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return (Math.PI * Math.pow(radius, 2));
	}

	@Override
	public double getPerimeter() {
		return (Math.PI * radius * 2);
	}
	
	@Override
	public String toString() {
		DecimalFormat d = new DecimalFormat("0.00");
		return super.toString() + ": " 
								+ "C=(" + d.format(center.x) + ", " + d.format(center.y) + "), "
								+ "R=" + d.format(radius);
	}
}