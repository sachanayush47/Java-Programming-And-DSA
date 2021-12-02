package cp;

import java.util.Scanner;

public class CN_2 {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		
		int evenSum = 0;
		int oddSum = 0;
		
		for(int i = 0; i < l; ++i) {
			int num = sc.nextInt();
			
			if(num % 2 == 0 && i % 2 == 0) evenSum += num;
			if(num % 2 == 1 && i % 2 == 1) oddSum += num;
		}
		sc.close();
		
		System.out.println("EVEN " + evenSum + ", ODD " + oddSum);
		
	}

}
