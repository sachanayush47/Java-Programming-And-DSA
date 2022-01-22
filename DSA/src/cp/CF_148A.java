package cp;

import java.util.*;

public class CF_148A {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int l = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int d = sc.nextInt();
		
		sc.close();
		
		int res = 0;
		if(k == 1 || l == 1 || m == 1 || n == 1) {
			System.out.println(d);
		} else {
			for(int i = 1; i <= d; ++i) {
				if(i%k == 0) ++res;
				else if(i%l == 0) ++res;
				else if(i%m == 0) ++res;
				else if(i%n == 0) ++res;
			}
			System.out.println(res);
		}
	}

}
