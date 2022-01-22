package cp;

import java.util.*;

public class CF_339A {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		
		String arr[] = sc.nextLine().split("\\+");
		
		int low = 0;
		int mid = 0;
		int high = arr.length-1;
		while(mid <= high) {
			if(arr[mid].equals("1")) {
				String temp = arr[mid];
				arr[mid++] = arr[low];
				arr[low++] = temp;
			} else if(arr[mid].equals("2")) {
				++mid;
			} else if(arr[mid].equals("3")) {
				String temp = arr[mid];
				arr[mid] = arr[high];
				arr[high--] = temp;
			}
		}
		sc.close();
		
		for(int i = 0; i < arr.length; ++i) {
			if(i == arr.length-1) System.out.print(arr[i]);
			else System.out.print(arr[i]+"+");
		}
	}
}
