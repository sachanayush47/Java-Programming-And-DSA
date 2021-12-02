package cp;

import java.util.Scanner;

public class CF_61A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		
		String b1 = sc.nextLine();
		String b2 = sc.nextLine();
		sc.close();
		
		StringBuilder res= new StringBuilder();
		
		for(int i = 0; i < b1.length(); ++i) {
			if(b1.charAt(i) == b2.charAt(i)) res.append("0");
			else res.append("1");
		}
		
		System.out.println(res.toString());
		
	}

}
