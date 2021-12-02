package cp;

import java.util.*;

public class CN_1 {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int sum = 0;
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				int ele = sc.nextInt();
				
				if(i == j) sum += ele;		// Diagonal 1.
				else if(j == n-i-1) sum += ele;  // Diagonal 2.
				else if(i == 0 || i == n-1 || j == 0 || j == n-1) sum += ele;
			}
		}
		sc.close();
		System.out.println(sum);
	}

}
