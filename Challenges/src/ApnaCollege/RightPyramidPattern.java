package ApnaCollege;

import java.util.Scanner;

public class RightPyramidPattern {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter height of pyramid:");
		int height = sc.nextInt();
		sc.close();
		
		for(int i = 0; i < height; i++) {	
			for(int j = 0; j < height; j++) {
				if(j < height-i-1) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			} 
			System.out.println();
		}
	}

}
