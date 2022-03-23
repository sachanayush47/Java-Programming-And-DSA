package Chegg;

public class Chegg6 {

	public static void main(String[] args) {
		
		Box b = new Box(10, 20, 30);
		System.out.println("Area " + b.getArea());
		System.out.println("Volume " + b.getVolume());
		
	}

}

class Box {
	
	double l;
	double b;
	double h;
	
	public Box(double l, double b, double h) {
		this.l = l;
		this.b = b;
		this.h = h;
	}
	
	public double getArea() {
		return (l*b + b*h + h*l)*2;
	}
	
	public double getVolume() {
		return l*b*h;
	}
	
}
