package cp;

import java.util.*;

public class CF_BeautifulMatrix263A {

	public static void main(String[] args) {
		
		solution();
		
	}
	
	@SuppressWarnings("resource")
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		for(int row = 0; row < 5; ++row) {
			for(int col = 0; col < 5; ++col) {
				int num = sc.nextInt();
				
				if(num == 1) {
					System.out.println(Math.abs(row - 2) + Math.abs(col - 2));
					return;
				}
			}
		}
	}

}
