package cp;
import java.util.*;
public class CF_116A {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int res = 0;
		int currPass = 0;
		for(int i = 0; i < n; ++i) {
			int exit = sc.nextInt();
			int enter = sc.nextInt();
			
			if(i == 0) {
				res = enter;
				currPass = enter;
			}
			else {
				currPass = currPass - exit + enter;
				if(currPass >= res) res = currPass;
			}
		}
		sc.close();
		System.out.println(res);
	}

}
