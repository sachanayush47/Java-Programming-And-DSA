import java.util.*;
public class Chegg2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number:");
		double num = sc.nextDouble();
		System.out.println("Sum: " + addDigits(num));
		sc.close();

	}
	
	public static int addDigits(double n) {
		// Initiazlizing variable sum.
		int sum = 0;		
		// Converting double to int.
		int num = (int)n;
		while(num > 0) {
			// Calculatin the last digit of the given integer and andd it to the variable sum.
			sum = num%10 + sum;
			// Deleting the last the last digit of the given number.
			num = num/10;
		}		
		return sum;
	}
}






