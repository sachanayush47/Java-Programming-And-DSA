package Random;

import java.util.Arrays;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class CodeKaze {

	public static void main(String[] args) {
		
		int ar[] = {1, 2, 8, 1};
		int br[] = {2, 3, 3, 1};
		
//		int ar[] = {1, 2, 3};
//		int br[] = {3, 1, 2};
		
		System.out.println(minSwaps(ar, br, ar.length, 4));
		
	}
	

	
	public static int minSwaps(int ar[], int br[], int n, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int sumA = 0;
		int sumB = 0;
		
		for(int i = 0; i < ar.length; ++i)  {
			pq.add(ar[i] - br[i]);
			
			sumA = sumA + ar[i];
			sumB = sumB + br[i];
		}
		
		int res = 0;
		
		while(!pq.isEmpty() && sumA - sumB < k) {
			
			int p = pq.remove();
			if(p >= 0) break;
			
			sumA = sumA + Math.abs(p);
			sumB = sumB - Math.abs(p);
			++res;
		}
		
		return res == 0 ? -1 : res;
	}
	
	public static int[][] neighboursInfluence(int matrix[][]) {
		
		int res[][] = new int[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				try {
					res[i][j] += matrix[i+1][j];
				} catch(Exception e) {	}
				
				try {
					res[i][j] += matrix[i][j+1];
				} catch(Exception e) {	}
				
				try {
					res[i][j] += matrix[i][j-1];
				} catch(Exception e) {	}
				
				try {
					res[i][j] += matrix[i-1][j];
				} catch(Exception e) {	}
			}
		}
		
		return res;
	}

}
