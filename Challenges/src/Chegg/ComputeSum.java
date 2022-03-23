package Chegg;

public class ComputeSum {

	public static void main(String[] args) {
		
		getSum();	// OUTPUT : 640395
		
	}
	
	public static void getSum() {
		
		// Storing sum of all integer that satisfies the given condition i.e
		// the integer contains value 9 in both their TENS and ONES places.
		int totalSum = 0;
		
		// Looping from 874 to 11353.
		for(int i = 874; i <= 11353; ++i) {
			
			/**
			 * i % 100 returns the last 2 digit of a integer.
			 * For example, 	i. 		876 % 100 = 76
			 * 					ii.		1099 % 100 = 99
			 * 
			 * So, if i % 100 == 99 then add it to the variable "totalSum".
			 */			
			
			if(i % 100 == 99) {
				totalSum = totalSum + i;
			}
		}
		
		// Printing out the result.
		System.out.println(totalSum);
	}

}




