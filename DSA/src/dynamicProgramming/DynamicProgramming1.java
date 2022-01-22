package dynamicProgramming;

import java.util.*;

public class DynamicProgramming1 {

	public static void main(String[] args) {
		
	//	int points[][] = {{1,2,5}, {3 ,1 ,1} ,{3,3,3}};
		
		
		int points[][] = {{10, 40, 70},
				{20, 50, 80},
				{30, 60, 90}};
		System.out.println(ninjaTraining3(points.length, points));
		
		
	}
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
					
						// Ninja's training.
	
	// 7.1
	public static int ninjaTraining1(int n, int points[][]) {
		return ninjaTraining1Helper(n-1, 3, points);
	}
	
	public static int ninjaTraining1Helper(int n, int lastPicked, int points[][]) {
		
		if(n == -1) return 0;
		
		int first = 0;
		int second = 0;
		int third = 0;
				
		if(lastPicked != 0) first = ninjaTraining1Helper(n-1, 0, points) + points[n][0];
		if(lastPicked != 1) second = ninjaTraining1Helper(n-1, 1, points) + points[n][1];
		if(lastPicked != 2) third = ninjaTraining1Helper(n-1, 2, points) + points[n][2];
		
		return Math.max(first, Math.max(second, third));
		
	}
	
	// 7.2
	public static int ninjaTraining2(int n, int points[][]) {
		
		int dp[][] = new int[n][4];

		return ninjaTraining2Helper(n-1, 3, points, dp);
	}
	
	public static int ninjaTraining2Helper(int n, int lastPicked, int points[][], int dp[][]) {
		
		if(n == -1) return 0;
		
		if(dp[n][lastPicked] != 0) return dp[n][lastPicked];
		
		int first = 0;
		int second = 0;
		int third = 0;
				
		if(lastPicked != 0) first = ninjaTraining2Helper(n-1, 0, points, dp) + points[n][0];
		if(lastPicked != 1) second = ninjaTraining2Helper(n-1, 1, points, dp) + points[n][1];
		if(lastPicked != 2) third = ninjaTraining2Helper(n-1, 2, points, dp) + points[n][2];
		
		return dp[n][lastPicked] = Math.max(first, Math.max(second, third));
		
	}
	
	// 7.3
	public static int ninjaTraining3(int n, int points[][]) {
		
		int dp[][] = new int[n][4];
		
		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
		
		for(int day = 1; day < n; ++day) {
			
			for(int lastPicked = 0; lastPicked <= 3; ++lastPicked) {
					
				int first = 0, second = 0, third = 0;
				
				if(lastPicked != 0) first = dp[day-1][0] + points[day][0];
				if(lastPicked != 1) second = dp[day-1][1] + points[day][1];
				if(lastPicked != 2) third = dp[day-1][2] + points[day][2];
				
				dp[day][lastPicked] = Math.max(first, Math.max(second, third));
				
			}
			
		}
		
		return dp[n-1][3];
		
	}
	
	/* ------------------------------------------------------------------ */
	
	// This question 95% similar to Q5.
	
	// 6.2
	public static long houseRobber2(int[] valueInHouse) {
		
		if(valueInHouse.length == 1) return valueInHouse[0];
		
		ArrayList<Integer> valueInHouseTemp = new ArrayList<Integer>();
		
		for(int i = 0; i < valueInHouse.length; ++i) {
			valueInHouseTemp.add(valueInHouse[i]);
		}
		
		long dp[] = new long[valueInHouseTemp.size()-1];
		
		valueInHouseTemp.remove(0);		// Skip first
		System.out.println(valueInHouseTemp);
		long ans1 = houseRobber2Helper(valueInHouseTemp.size()-1, valueInHouseTemp, dp);
		
		Arrays.fill(dp, 0);
		valueInHouseTemp.add(0, valueInHouse[0]);	// Adding first
		
		
		valueInHouseTemp.remove(valueInHouseTemp.size()-1);	// Removing last
		System.out.println(valueInHouseTemp);
		long ans2 = houseRobber2Helper(valueInHouseTemp.size()-1, valueInHouseTemp, dp);
		
		return Math.max(ans1, ans2);
		
	}
	
	public static long houseRobber2Helper(int index, ArrayList<Integer> nums, long dp[]) {
		
		if(index == 0) return nums.get(0);
		if(index < 0) return 0;
		
		if(dp[index] != 0) return dp[index];
		
		long notPick = houseRobber2Helper(index-1, nums, dp);
		long pick = houseRobber2Helper(index-2, nums, dp) + nums.get(index);
		
		return dp[index] = Math.max(notPick, pick);
		
	}
	
	// 6.4
	public static long houseRobber4(int[] valueInHouse) {
		
		if(valueInHouse.length == 1) return valueInHouse[0];
		
		long prev = valueInHouse[0];
		long prev2 = 0;
		
		for(int i = 1; i < valueInHouse.length-1; ++i) {		// Skipping last
			
			long curr = Math.max(prev2 + valueInHouse[i], prev);
			prev2 = prev;
			prev = curr;
			
		}
		
		long ans1 = prev;
		
		prev = valueInHouse[1];
		prev2 = 0;
		for(int i = 2; i < valueInHouse.length; ++i) {			// Skipping first
			
			long curr = Math.max(prev2 + valueInHouse[i], prev);
			prev2 = prev;
			prev = curr;
			
		}
		
		return Math.max(ans1, prev);
		
	}
	
	/* ------------------------------------------------------------------ */
	
	// 5.1
	public static int maximumNonAdjacentSum1(ArrayList<Integer> nums) {
		return maximumNonAdjacentSum1Helper(nums.size()-1, nums);
	}
	
	public static int maximumNonAdjacentSum1Helper(int index, ArrayList<Integer> nums) {
		
		if(index == 0) return nums.get(0);
		if(index < 0) return 0;
		
		int notPick = maximumNonAdjacentSum1Helper(index-1, nums);
		int pick = maximumNonAdjacentSum1Helper(index-2, nums) + nums.get(index);
		
		return Math.max(notPick, pick);
		
	}
	
	// 5.2
	public static int maximumNonAdjacent2Sum(ArrayList<Integer> nums) {
		
		int dp[] = new int[nums.size()];
		return maximumNonAdjacentSum2Helper(nums.size()-1, nums, dp);
		
	}
	
	public static int maximumNonAdjacentSum2Helper(int index, ArrayList<Integer> nums, int dp[]) {
		
		if(index == 0) return nums.get(0);
		if(index < 0) return 0;
		
		if(dp[index] != 0) return dp[index];
		
		int notPick = maximumNonAdjacentSum1Helper(index-1, nums);
		int pick = maximumNonAdjacentSum1Helper(index-2, nums) + nums.get(index);
		
		return dp[index] = Math.max(notPick, pick);
		
	}
	
	// 5.3
	public static int maximumNonAdjacentSum3(ArrayList<Integer> nums) {
		
		int dp[] = new int[nums.size()];
		dp[0] = nums.get(0);
		
		for(int i = 1; i < nums.size(); ++i) {
		
			if(i >= 2) dp[i] = Math.max(dp[i-2] + nums.get(i), dp[i-1]);
			else if(i == 1) dp[i] = Math.max(0 + nums.get(i), dp[i-1]);
		}
		
		return dp[nums.size()-1];
		
	}
	
	// 5.4
	public static int maximumNonAdjacentSum4(ArrayList<Integer> nums) {
		
		int prev = nums.get(0);
		int prev2 = 0;
		
		for(int i = 1; i < nums.size(); ++i) {
			
			int curr = Math.max(prev2 + nums.get(i), prev);
			prev2 = prev;
			prev = curr;
			
		}
		
		return prev;
		
	}
	
	/* ------------------------------------------------------------------ */

						// LEC : A follow-up problem.
	
	/* ------------------------------------------------------------------ */
	
				// Frop Jump: Minimum energy required to reach the Nth stair.
	
	// 3.1
	// n = Nth stair(heights[].length) and heights[i] = energy required at each stair.
	public static int frogJump1(int n, int heights[]) {

		return frogJump1Helper(n-1, heights);
		
	}
	
	public static int frogJump1Helper(int n, int heights[]) {
		if(n == 0) return 0;
        
        int l = frogJump1Helper(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        int r = Integer.MAX_VALUE;
        if(n > 1) r = frogJump1Helper(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        
		return Math.min(l, r);
		
	}
	
	// 3.2
	public static int frogJump2(int n, int heights[]) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		return frogJump2Helper(n-1, heights, dp);
		
	}
	
	public static int frogJump2Helper(int n, int heights[], int dp[]) {
		if(n == 0) return 0;
        
		if(dp[n] != -1) return dp[n]; 
		
        int l = frogJump2Helper(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int r = Integer.MAX_VALUE;
        if(n > 1) r = frogJump2Helper(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);
        
		return dp[n] = Math.min(l, r);
		
	}
	
	// 3.3
	public static int frogJump3(int n, int heights[]) {
		
		int dp[] = new int[n];
		dp[0] = 0;
		
		for(int i = 1; i < n; ++i) {
			int first  = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
			int second = Integer.MAX_VALUE;
			if(i >= 2) second = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
			
			dp[i] = Math.min(first, second);
		}
		
		return dp[n-1];
		
	}
	
	// 3.4
	public static int frogJump4(int n, int heights[]) {
		
		int first = 0;
		int second = 0;
		
		for(int i = 1; i < n; ++i) {
			
			int energy1 = first + Math.abs(heights[i] - heights[i-1]); 
			
			int energy2 = Integer.MAX_VALUE;
			if(i >= 2) energy2 = second + Math.abs(heights[i] - heights[i-2]);
			
			second = first;
			first = Math.min(energy1, energy2);
		}
		
		return first;
		
	}
	
	
	/* ------------------------------------------------------------------ */
	
		// Count the total number of ways to climb to the nth stair, 99% same as fibonacci(P1).
	
	// 2.1 Normal recursive, no optimization.
	public static int climbStairs1(int n) {
		
		if(n == 0) return 1;
		if(n == -1) return 1;
		
		int l = climbStairs1(n-1);
		int r = climbStairs1(n-2);
		
		return l + r;
	}
	
	// 2.2 Memoization.
	public static int climbStairs2(int n, int dp[]) {
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		
		if(dp[n] != -1) return dp[n];
		
		int l = climbStairs2(n-1, dp);
		int r = climbStairs2(n-2, dp);
		
		return dp[n] = l + r;
	}
	
	// 2.4 Tabulation + SO
	public static int climbStairs4(int n) {

		int oneStepAway = 1;
		int twoStepAway = 2;
		
		if(n == 0) return 0;
		if(n == 1) return oneStepAway;
		if(n == 2) return twoStepAway;
		
		for(int i = 3; i <= n; ++i) {
			int totalWays = oneStepAway + twoStepAway;
			twoStepAway = oneStepAway;
			oneStepAway = totalWays;
		}
		
		return oneStepAway;
	}
	
		/* ------------------------------------------------------------------ */
	
							// Find the nth fibonacci number.
	
	// 1.1 Normal recursive, no optimization.
	public static int fibonacci1(int n) {
		if(n <= 1) return n;
		
		return fibonacci1(n - 1) + fibonacci1(n - 2);
	}
	
	// 1.2 Memoization.
	// dp[] : Length = n + 1 && by default, values at all indexes should be -1
	public static int fibonacci2(int n, int dp[]) {
		if(n <= 1) return n;
		
		if(dp[n] != -1) return dp[n];
		
		return dp[n] = fibonacci2(n - 1, dp) + fibonacci2(n - 2, dp);
	}
	
	// 1.3 Tabulation.
	public static int fibonacci3(int n) {
		
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; ++i) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	// 1.3 Tabulation + Space optimization.
	public static int fibonacci4(int n) {
		
		int prev1 = 1;
		int prev2 = 0;
		
		for(int i = 2; i <= n; ++i) {
			int curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
		}
		
		return prev1;
		
	}

}
