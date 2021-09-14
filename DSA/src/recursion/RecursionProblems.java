package recursion;

public class RecursionProblems {

	public static void main(String[] args) {		
		
	//	threeSumSeries(1, 2, 3, 25);
		
		int matrix[][] = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10 ,11, 12},{13, 14, 15, 16},
				{17, 18, 19, 20},{21, 22, 23, 24}};
		int mat2[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		spiralMatrixPrinting(mat2, 0, matrix.length-1, 0, matrix[0].length-1, 1);
		
	}
	
	static void spiralMatrixPrinting(int arr[][], int first1, int last1, int first2, int last2, int base) {
		if(base < 0) return;
		int i;
		for(i = 0; i <= last2; ++i) {
			System.out.print(arr[first1][i] +" ");
		}
		System.out.println();
		for(i = first1+1; i <= last1-1; ++i) {
			System.out.print(arr[i][last2] +" ");
		}
		System.out.println();
		for(i = last2; i >= first2; --i) {
			System.out.print(arr[last1][i] +" ");
		}
		System.out.println();
		for(i = last1-1; i > first1+1; --i) {
			System.out.print(arr[i][first2] +" ");
		}
		System.out.println();
		spiralMatrixPrinting(arr, first1+1, last1-1, first2+1, last2-1, base-1);
	}
	
	static void printNumbers(int n) {
		if(n == 0) return;
		System.out.println(n);
		printNumbers(n-1);
	}
	
	static void printNumbersReverse(int n) {
		if(n == 0) return;
		printNumbersReverse(n-1);
		System.out.println(n);
	}
	
	static int sum(int n) {
		if(n == 1) return 1;
		return n + sum(n-1);
	}

	static int factorial(int n) {
		if(n == 0) return 1;
		return n * factorial(n-1);
	}
	
	static int pow(int base, int power) {
		if(power == 0) return 1;
		return base * pow(base, power-1);
	}
	
	static void gfgRandomProgram(int n) {
	// GFG random program to explain tail recursion.
		if(n == 0) return;
		System.out.println(n);
		gfgRandomProgram(n-1);
		System.out.println(n);		
	}
	
	static boolean palidromeChecker(String str, int s, int e) {
		if(s >= e) return true;
		if(str.charAt(s) != str.charAt(e)) return false;
		return palidromeChecker(str, s+1, e-1);
	}
	
	static void fibonacciSeries(int n, int a, int b) {
	}
	
	static void threeSumSeries(int a, int b, int c, int base) {
	/** There is S series where the next term is the sum of previous three terms. Given the first
	 * 	three terms of the series a, b and c respectively, you have to output the nth term
	 * 	of the series using recursion.
	 * 	4th argument is the number of terms we want to print.
	 */
		if(base < 0) return;
		System.out.println(a+b+c);
		threeSumSeries(b, c, a+b+c, base-1);
	}
	
	
	
	
}
