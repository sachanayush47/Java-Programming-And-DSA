package greedy;

import java.util.Arrays;

public class Problems {

	public static void main(String[] args) {
		
		int arr[][] = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
		findMinArrowShots(arr);
	}
	
	public static int findMinArrowShots(int[][] points) {
	// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
		
		int res = 1;
		int arr[][] = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
		
		sort2DArray(arr);
		
		int prev[] = arr[0];
		
		for(int i = 1; i < arr.length; ++i) {
			if(arr[i][0] > prev[1]) {
				++res;
				prev = arr[i];
			}
		}

		return res;
	}
	
	public static void sort2DArray(int arr[][]) {
		
		for(int i = 1; i < arr.length; ++i) {
			int j = i-1;
			int key[] = arr[i];
			
			while(j >= 0 && key[1] < arr[j][1]) {
				arr[j+1] = arr[j];
				--j;
			}
			arr[j+1] = key;
		}
	}
	
}
