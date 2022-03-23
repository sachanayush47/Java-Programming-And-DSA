package bits;

public class BitManipulation {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 6};
		findMisingNumber(arr);
	}
	
	public static void findMisingNumber(int nums[]) {
	
		int xorAll = 0;
		int xorNums = nums[0];
		for(int i = 1; i <= nums.length+1; ++i) xorAll = xorAll ^ i;
		for(int i = 1; i < nums.length; ++i) xorNums = xorNums ^ nums[i];
		
		System.out.println(xorAll ^ xorNums);
		
	}
	
	public static void findOddOccuringNumber(int nums[]) {
		int res = 0;
		for(int i = 0; i < nums.length; ++i) res = res ^ nums[i];
		System.out.println(res);
	}
	
	public static void powerOfTwo(int num) {
	// num >= 0
		
		// Logic: If a binary number contains only 1 set bit then it is a POWER OF TWO.
		
		boolean ans = false;
		if(num == 0) ans = false;
		if((num & (num -1)) == 0) ans = true;
		System.out.println(ans);
	}
	
	public static void countSetBits(int num) {
	// num >= 0.
		
		int count = 0;
		for(int i = 0; i < 31; ++i) {
			if((num & 1) == 1) ++count; 
			num = num >> 1;
		}
		
		System.out.println(count);
	}
	
	public static void checkifKthBitIsSet(int num, int k) {
		
		if((num >> (k-1) & 1) == 0) System.out.println("YES");
		else System.out.println("NO");
		
	}
	
	// Odd/Even finder using Bit manipulation.
	public static void oddEvenUsingBits(int num) {
		
		if((num&1) == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
	}
	
	// Swaping variables using Bit manipulation.
	public static void swapVariablesUsingBits(int var1, int var2) {
		
		var1 = var1 ^ var2;
		var2 = var1 ^ var2;
		var1 = var1 ^ var2;
		System.out.println("Var1 = " +var1 + " and Var2 = " +var2);
	}

}
