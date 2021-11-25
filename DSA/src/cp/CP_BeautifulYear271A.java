package cp;

import java.util.*;

public class CP_BeautifulYear271A {

	public static void main(String[] args) {
		
		solution();
		
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		sc.close();
		
		while(true) {
			++year;
			boolean res = isUniqueDigits(year);
			if(res) {
				System.out.println(year);
				return;
			}
		}
	}
	
	public static boolean isUniqueDigits(int year) {
		
		Set<Integer> digit = new HashSet<Integer>();
		
		for(int i = 0; i < 4; ++i) {
			digit.add(year%10);
			year = year/10;
		}
		
		return (digit.size() == 4);
		
	}

}
