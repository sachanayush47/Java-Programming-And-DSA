package Chegg;

import java.util.Scanner;

public class Chegg8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int totalPositives = 0;		// Keeps track of all positve numbers.
		int totalZeroes = 0;		// Keeps track of all negative numbers.
		int totalNegatives = 0;		// Keeps track of all zeroes.
		
		
		// Running loop 5 times to take input from user 5 times.
		for(int i = 0; i < 5; ++i) {
			int num = sc.nextInt();				// Taking user input.
			if(num > 0) ++totalPositives;		// Checking if number is positve.
			else if(num < 0) ++totalNegatives;	// Checking if number is negative/
			else ++totalZeroes;					// else the number is 0.
		}
		
		sc.close();
		
		// Printing.
		
		System.out.println("Total Positive numbers: " + totalPositives);
		System.out.println("Total Negative numbers: " + totalNegatives);
		System.out.println("Total Zeores: " + totalZeroes);
		
	}

}
