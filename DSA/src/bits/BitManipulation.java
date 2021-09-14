package bits;

public class BitManipulation {

	public static void main(String[] args) {
		
		oddEvenUsingBits(201);
		swapVariablesUsingBits(15566, 1561532);

	}
	
	// Odd/Even finder using Bit manipulation.
	static void oddEvenUsingBits(int num) {
		
		if((num&1) == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}
	
	// Swaping variables using Bit manipulation.
	static void swapVariablesUsingBits(int var1, int var2) {
		
		var1 = var1 ^ var2;
		var2 = var1 ^ var2;
		var1 = var1 ^ var2;
		System.out.println("Var1 = " +var1 + " and Var2 = " +var2);
	}

}
