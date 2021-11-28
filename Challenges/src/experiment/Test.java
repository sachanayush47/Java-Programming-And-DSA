package experiment;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
        
		String s = sc.nextLine();
		
        StringBuilder sb = new StringBuilder(s);
        
        sb.setCharAt(0, Character.toUpperCase(s.charAt(0)));
        
        sc.close();
        
        System.out.println(sb.toString());
		
	}

}
