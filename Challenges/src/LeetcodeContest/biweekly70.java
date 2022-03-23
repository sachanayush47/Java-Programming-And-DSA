package LeetcodeContest;

import java.util.*;

public class biweekly70 {

	public static void main(String[] args) {

		int arr[] = {3,-4,5,1,-2};
		System.out.println(numberOfArrays(arr, -4, 5));
		
	}
	
	// 2145. Count the Hidden Sequences
	public static int numberOfArrays(int[] differences, int lower, int upper) {
		
		int ans = 0;
		
		int UPPER = upper;
		System.out.println(Arrays.toString(differences));
		while(upper >= lower) {
			
			int hidden = upper;
			boolean isCorrect = true;
			ArrayList<Integer> res = new ArrayList<>();
			res.add(hidden);
			for(int i = differences.length-1; i >=0; --i) {
				
				int num = hidden - differences[i];
				res.add(0, num);
				if(num >= lower && num <= UPPER) {
					hidden = num;
				} else {
					isCorrect = false;
					break;
				}
			}
			
			--upper;
			if(isCorrect) ++ans;
		
			System.out.println(res);
		}
		
		return ans;
	}
	
	// 2144. Minimum Cost of Buying Candies With Discount
	public static int minimumCost(int[] cost) {
        
		Arrays.sort(cost);
		int ans = 0;
		int p = 0;
		for(int i = cost.length-1; i >= 0; --i) {
			if(p == 2) {
				p = 0;
				continue;
			}
			System.out.println(cost[i]);
			ans += cost[i];
			++p;
		}
		
		return ans;
    }

}
