package cp;

import java.util.*;

public class CF_YoungPhysicist69A {
	
	public static void main(String[] args) {
		
		solution();
	
	}
	
	public static void solution() {
		
		Scanner sc = new Scanner(System.in);
		
		int x = 0, y = 0, z = 0;
		
		int vector = sc.nextInt();
		
		for(int i = 0; i < vector; ++i) {
			x += sc.nextInt();
			y += sc.nextInt();
			z += sc.nextInt();
		}
		sc.close();
		
		if(x != 0 || y != 0 || z != 0) {
			System.out.println("NO");
			return;
		}
		
		System.out.println("YES");
		
	}

}
