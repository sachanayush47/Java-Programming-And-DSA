package cp;

import java.util.Scanner;

public class CF_LightsOut275A {

	public static void main(String[] args) {

		solution();
	}
	
	public static void solution() {
		
		int matrix[][] = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				int pressed = sc.nextInt();
				if(pressed % 2 == 1) {
					
					matrix[i][j] = matrix[i][j]^1;
					
					try {
						matrix[i][j+1] = matrix[i][j+1]^1;
					} catch(ArrayIndexOutOfBoundsException e) {	}
					
					try {
						matrix[i][j-1] = matrix[i][j-1]^1;
					} catch(ArrayIndexOutOfBoundsException e) {	}
					
					try {
						matrix[i+1][j] = matrix[i+1][j]^1;
					} catch(ArrayIndexOutOfBoundsException e) {	}
					
					try {
						matrix[i-1][j] = matrix[i-1][j]^1;
					} catch(ArrayIndexOutOfBoundsException e) {	}
				}
			}
		}
		sc.close();
		
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
