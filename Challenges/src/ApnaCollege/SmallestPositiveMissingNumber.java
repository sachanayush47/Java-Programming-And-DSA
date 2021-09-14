package ApnaCollege;

import java.util.ArrayList;
import java.util.Scanner;

public class SmallestPositiveMissingNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		ArrayList<Integer> givenNUmbers = new ArrayList<Integer>();
			
		int length = sc.nextInt();
		for(int i = 0; i < length; i++) {
			int input = sc.nextInt();
			if(input > 0) {
				givenNUmbers.add(input);
			}
		}
		sc.close();
		
		boolean missingFounded = false;
		int temp = 1;
		while(missingFounded == false) {
			if(givenNUmbers.contains(temp) == false) {
				missingFounded = true;
			}
		}
		if(missingFounded) {
			System.out.println(temp);
		} else {
			 System.out.println("No missing number found");
		}		
	}
}
