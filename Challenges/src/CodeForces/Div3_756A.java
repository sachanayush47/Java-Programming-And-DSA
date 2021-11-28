package CodeForces;

import java.util.Scanner;

public class Div3_756A {
	
	public static void main(String[] args) {
		
		solution();
		
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int num = sc.nextInt();
			
			if(num % 2 == 0) {
				sb.append("0\n");
				continue;
			}
			
			boolean isPossible = true;
			
			String numStr = String.valueOf(num);
			
			for(int i = 0; i < numStr.length(); ++i) {
				
				int digit = Integer.parseInt(String.valueOf(numStr.charAt(i)));
				
				if(i == 0 && digit % 2 == 0) {
					sb.append("1\n");
					isPossible = true;
					break;
				} else if(digit % 2 == 0) {
					sb.append("2\n");
					isPossible = true;
					break;
				} else {
					isPossible = false;
				}
				
			}
			if(!isPossible) {
				sb.append("-1\n");
			}
		}
		sc.close();
		System.out.println(sb.toString());
	}
}
