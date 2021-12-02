package cp;

import java.util.Arrays;
import java.util.Scanner;

public class CF_80A {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		boolean isPrime = false;
		
		boolean arr[] = seiveOFEratosthenes(n, m);
		for(int i = n+1; i < arr.length; ++i) {
			if(arr[i]) {
				if(i == m) System.out.println("YES");
				else System.out.println("NO");
				isPrime = true;
				break;
			}
		}
		if(!isPrime) System.out.println("NO");
	}
	
	public static boolean[] seiveOFEratosthenes(int n, int m) {
		
		boolean isPrime[] = new boolean[m+1];
		
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int start = 2; start*start <= m; start++) {
			
			for(int end = 2*start; end <= m; end += start) {
				isPrime[end] = false;
				
			}
		}		
		return isPrime;		
	}

}
