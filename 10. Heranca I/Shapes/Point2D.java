package Shapes;

public class Point2D {
	public double x;
	public double y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point2D p) {
		return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
	}
	
	@ Override
	public String toString() {
		return "";
	}
}