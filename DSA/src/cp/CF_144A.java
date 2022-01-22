package cp;

import java.util.Scanner;

public class CF_144A {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int arr[] = new int[l];
		
		int lo = 0;
		int hi = 0;
		
		for(int i = 0; i < l; ++i) {
			arr[i] = sc.nextInt();
			
			if(arr[i] > arr[hi]) hi = i;
			if(arr[i] <= arr[lo]) lo = i;
			
		}
		sc.close();
		
		if(lo < hi) {
			System.out.println(hi + l-lo - 2);
		} else {
			System.out.println(hi + l-lo - 1);
		}
	}
}
