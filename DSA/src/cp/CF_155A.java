package cp;
import java.util.*;
public class CF_155A {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int largest = 0;
		int smallest = 0;
		int res = 0;
		for(int i = 0; i < n; ++i) {
			int num = sc.nextInt();
			
			if(i == 0) {
				largest = num;
				smallest = num;
			} else {
				if(num > largest) {
					largest = num;
					++res;
				} else if(num < smallest) {
					smallest = num;
					++res;
				}
			}
		}
		sc.close();
		System.out.println(res);
	}

}
