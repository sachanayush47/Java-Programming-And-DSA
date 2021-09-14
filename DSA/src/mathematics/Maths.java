package mathematics;

import java.util.Arrays;

public class Maths {

	public static void main(String[] args) {
		
		boolean res[] = seiveOFEratosthenes(50);
		for(int i = 0; i <= 50; i++) {
			System.out.println(i +" "+res[i]);
		}
		
		int res2 = gcdEuclid(18, 25);
		System.out.println(res2);
				
	}
		
	public static boolean[] seiveOFEratosthenes(int n) {
		
		boolean isPrime[] = new boolean[n+1];
		
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int start = 2; start*start <= n; start++) {
			
			for(int end = 2*start; end <= n; end += start) {
				isPrime[end] = false;
			}
		}		
		return isPrime;		
	}
	
	public static int gcdEuclid(int a, int b) {
		
		if(b == 0) return a;
		return gcdEuclid(b, a%b);
	}

}
