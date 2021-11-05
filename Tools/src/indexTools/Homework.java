package indexTools;

public class Homework {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		int a = 5, b = 2, c;
		
		try {
			c = 2*a/(b*5-10);
			System.out.println("Display c value");
		}  catch(ArithmeticException e) {
			System.out.println("Check the equation");
		}
		
		
		
	}

}
