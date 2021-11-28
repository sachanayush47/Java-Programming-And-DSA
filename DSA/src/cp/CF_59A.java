package cp;

import java.util.Scanner;

public class CF_59A {

	public static void main(String[] args) {
		solution();
	}
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		
		int low = 0;
		int up = 0;
		
		for(int i = 0; i < s.length(); ++i) {
			if(s.charAt(i) <= 90) {
				++up;
			} else ++low;
		}
		
		if(up > low) {
			System.out.println(s.toUpperCase());
		} else {
			System.out.println(s.toLowerCase());
		}
	}
}
