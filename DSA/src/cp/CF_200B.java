package cp;

import java.util.*;

public class CF_200B {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < l; ++i) {
			sum += sc.nextInt();
		}
		sc.close();
		System.out.println((double)sum/l);
	}

}
