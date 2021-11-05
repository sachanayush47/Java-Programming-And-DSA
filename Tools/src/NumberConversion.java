import java.util.Scanner;

public class NumberConversion {

	public static void main(String[] args) {
				
		Scanner sc = new  Scanner(System.in);
		ProgramDescription();
		
		while(true) {
			System.out.println("\nEnter a number between 0 to 255. To exit the program enter 1.");
			try {
				int num = sc.nextInt();	
				if(num < 0) {
					System.out.println("Error: Number is less than 0. Please try again.");
				} else if(num > 255) {
					System.out.println("Error: Number is greater than 255. Please try again.");
				} else if(num == 1) {
					System.out.println("Exit");
					break;
				} else {
					DisplayConversion(num);
				}
			} catch(Exception e) {
				System.out.println("Wrong input try again");
				continue;
			}				
		}
		
		DeveloperInformation();
		sc.close();
	}
	
	public static void DisplayConversion(int num) {
		
		System.out.println("\nASCII");
		// Using type-casting to convert Integer to ASCII symbol.
		System.out.println((char)num);
		
		System.out.println("Binary");
		// Integer.toBinaryString(num) is a built in-function which converts Integer to Binary
		System.out.println(Integer.toBinaryString(num));
		
		System.out.println("Hexadecimal");		
		// Integer.toHexString(num) is a built in-function which converts Integer to Hexadecimal
		String hex =Integer.toHexString(num);
		System.out.println(hex.toUpperCase());
		
	}
	
	public static void ProgramDescription() {
		// Print message
		System.out.println("This program converts whole INTEGER to ASCII, Binary and Hexadecimal.");
	}
	
	public static void DeveloperInformation() {
		// Print message
		System.out.println("\nThis program is made by XYZ, student at ABC school.");
	}

}
