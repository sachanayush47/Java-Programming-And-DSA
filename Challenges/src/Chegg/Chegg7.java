package Chegg;

public class Chegg7 {

	public static void main(String[] args) {
		
	// Every quadratic equation has 2 roots.
		
		// Test 1:
		System.out.println("-----Test 1-----");
		getRoot1(2, 10, 12);
		getRoot2(2, 10, 12);
		
		// Test 2:
		System.out.println("-----Test 2-----");
		getRoot1(3, 24, 48);
		getRoot2(3, 24, 48);
		
		// Test 3:
		System.out.println("-----Test 3-----");
		getRoot1(4, 24, 100);	// Here, the roots are imaginary so the it will print NaN
		getRoot2(4, 24, 100);	// Here, the roots are imaginary so the it will print NaN
	}
	
	// Printing the root 1
	public static void getRoot1(int a, int b, int c) {
		double res = (-b + Math.sqrt(b*b - 4*a*c))/2*a;
		System.out.println("Root 1: " + res);
	}
	
	// Printing the root 2.
	public static void getRoot2(int a, int b, int c) {
		double res = (-b - Math.sqrt(b*b - 4*a*c))/2*a;
		System.out.println("Root 2: " + res);
	}
}
