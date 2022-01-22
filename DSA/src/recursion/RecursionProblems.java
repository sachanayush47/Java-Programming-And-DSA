package recursion;

import java.util.*;

@SuppressWarnings("unused")
public class RecursionProblems {

	public static void main(String[] args) {		
		
		// System.out.println(numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
		
		int arr[] = {1, 2, 3};
		ArrayList<Integer> output = new ArrayList<>();
		printAllSubsequencesOfArray(0, arr, output);
		
	}
	
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	// Will do it later beacuse it is based on DP. Although this approach is correct
	// but on large testcases it fails. It is need to be optimised using DP technique. 
	public static int numDistinct(String s, String t) {
		
		return numDistinctHelper(s, t, "");
	}
	
    public static int numDistinctHelper(String s, String t, String output) {
        
        if(s.length() == 0) {
            if(output.equals(t) == true) {
            	return 1;
            }
            return 0;
        }
        
        String output1 = output;
        String output2 = output + s.charAt(0);
    
        s = s.substring(1);
        
        int left = numDistinctHelper(s, t, output1);
        int right = numDistinctHelper(s, t, output2);
        
        return left+right;
    }

    /* ------------------------------------------------------------------ */
    
    public static void printAllSubsequencesOfArray(int index, int input[], ArrayList<Integer> output) {
    	
    	if(index == input.length) {
    		System.out.println(output);
    		return;
    	}
    	
    	output.add(input[index]);		// Take
    	printAllSubsequencesOfArray(index+1, input, output);
    	
    	output.remove(output.size()-1);	// Not take
    	printAllSubsequencesOfArray(index+1, input, output);
    	
    }
	
	/* ------------------------------------------------------------------ */
	
	static void printNumbers(int n) {
		if(n == 0) return;
		System.out.println(n);
		printNumbers(n-1);
	}
	
	/* ------------------------------------------------------------------ */
	
	static void printNumbersReverse(int n) {
		if(n == 0) return;
		printNumbersReverse(n-1);
		System.out.println(n);
	}
	
	/* ------------------------------------------------------------------ */
	
	static int sum(int n) {
		if(n == 1) return 1;
		return n + sum(n-1);
	}

	/* ------------------------------------------------------------------ */
	
	static int factorial(int n) {
		if(n == 0) return 1;
		return n * factorial(n-1);
	}
	
	/* ------------------------------------------------------------------ */
	
	static int pow(int base, int power) {
		if(power == 0) return 1;
		return base * pow(base, power-1);
	}
	
	/* ------------------------------------------------------------------ */
	
	static void gfgRandomProgram(int n) {
	// GFG random program to explain tail recursion.
		if(n == 0) return;
		System.out.println(n);
		gfgRandomProgram(n-1);
		System.out.println(n);		
	}
	
	/* ------------------------------------------------------------------ */
	
	static boolean palidromeChecker(String str, int s, int e) {
		if(s >= e) return true;
		if(str.charAt(s) != str.charAt(e)) return false;
		return palidromeChecker(str, s+1, e-1);
	}
	
	/* ------------------------------------------------------------------ */
	
	static void fibonacciSeries(int n, int a, int b) {
		
	}
	
	/* ------------------------------------------------------------------ */
	
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
