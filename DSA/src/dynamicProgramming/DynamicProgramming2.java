package dynamicProgramming;

import java.util.Arrays;

// NOTE : Some questions similar to knapsack can be 1D array sapce optimised.
// Questions similar to knapsack are 19, 23, 24.

@SuppressWarnings("unused")
public class DynamicProgramming2 {

	public static void main(String[] args) {
		
		int arr1[] = {1, 2, 4, 5};
		int arr2[] = {5, 4, 8, 6};
		System.out.println(knapsack2(arr1, arr2, 4, 5));
		
	}

	
	/* ------------------------------------------------------------------ */
	
				// DP on subsequences/subset : Rod Cutting Problem
	
	// 24.1
	public static int cutRod1(int price[], int n) {
		return cutRod1Helper(n - 1, price, n);
	}
	
	public static int cutRod1Helper(int i, int price[], int n) {
		
		if(i == 0) return price[0] * n;
		
		int take = Integer.MIN_VALUE;
		int rodLength = i + 1;
		if(rodLength <= n) take = price[i] + cutRod1Helper(i, price, n - rodLength);
		int notTake = cutRod1Helper(i - 1, price, n);
		
		return Math.max(take, notTake);
	}
	
	// 24.2
	public static int cutRod2(int price[], int n) {
		Integer dp[][] = new Integer[n][n + 1];
		return cutRod2Helper(n - 1, price, n, dp);
	}
	
	public static int cutRod2Helper(int i, int price[], int n, Integer dp[][]) {
		
		if(i == 0) return price[0] * n;
		
		if(dp[i][n] != null) return dp[i][n];
		
		int take = Integer.MIN_VALUE;
		int rodLength = i + 1;
		
		if(rodLength <= n) take = price[i] + cutRod2Helper(i, price, n - rodLength, dp);
		int notTake = cutRod2Helper(i - 1, price, n, dp);
		
		return dp[i][n] = Math.max(take, notTake);
	}
	
	// 24.3
	public static int cutRod3(int price[], int n) {
		
		int dp[][] = new int[n][n + 1];
		
		for(int j = 0; j <= n; ++j) dp[0][j] = price[0] * j;
		
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j <= n; ++j) {
				int take = Integer.MIN_VALUE;
				int rodLength = i + 1;
				
				if(rodLength <= j) take = price[i] + dp[i][j - rodLength];
				int notTake = dp[i - 1][j];
				
				dp[i][j] = Math.max(take, notTake);
			}
		}
		
		return dp[n - 1][n];
	}
	
	// 24.4
	public static int cutRod4(int price[], int n) {
		
		int prev[] = new int[n + 1];
		
		for(int j = 0; j <= n; ++j) prev[j] = price[0] * j;
		
		for(int i = 1; i < n; ++i) {
			int curr[] = new int[n + 1];
			
			for(int j = 0; j <= n; ++j) {
				int take = Integer.MIN_VALUE;
				int rodLength = i + 1;
				
				if(rodLength <= j) take = price[i] + curr[j - rodLength];
				int notTake = prev[j];
				
				curr[j] = Math.max(take, notTake);
			}
			
			prev = curr;
		}
		
		return prev[n];
	}
	
	/* ------------------------------------------------------------------ */
	
				// DP on subsequences/subset : Unbounded Knapsack
	
	// 23.1
	public static int unboundedKnapsack1(int n, int w, int[] profit, int[] weight) {
		return unboundedKnapsack1Helper(n - 1, w, profit, weight);
	}
	
	public static int unboundedKnapsack1Helper(int i, int w, int[] profit, int[] weight) {
		
		if(w == 0) return 0;
		
		if(i == 0) return w/weight[0] * profit[0];
		
		int take = 0;
		if(weight[i] <= w) take = profit[i] + unboundedKnapsack1Helper(i, w  - weight[i], profit, weight); 
		int notTake = unboundedKnapsack1Helper(i - 1, w, profit, weight);
		
		return Math.max(take, notTake);
	}
	
	// 23.2
	public static int unboundedKnapsack2(int n, int w, int[] profit, int[] weight) {
		Integer dp[][] = new Integer[n][w + 1];
		return unboundedKnapsack2Helper(n - 1, w, profit, weight, dp);
	}
	
	public static int unboundedKnapsack2Helper(int i, int w, int[] profit, int[] weight, 
			Integer dp[][]) {
		
		if(w == 0) return 0;
		
		if(i == 0) return w/weight[0] * profit[0];
		
		if(dp[i][w] != null) return dp[i][w];
		
		int take = 0;
		if(weight[i] <= w) take = profit[i] + unboundedKnapsack2Helper(i, w  - weight[i], profit, weight, dp); 
		int notTake = unboundedKnapsack2Helper(i - 1, w, profit, weight, dp);
		
		return dp[i][w] = Math.max(take, notTake);
		
	}
	
	// 23.3
	public static int unboundedKnapsack3(int n, int w, int[] profit, int[] weight) {
		
		int dp[][] = new int[n][w + 1];
		
		for(int j = 0; j <= w; ++j) {
			dp[0][j] = j/weight[0] * profit[0];
		}
		
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j <= w; ++j) {
				int take = 0;
				if(weight[i] <= j) take = profit[i] + dp[i][j  - weight[i]]; 
				int notTake = dp[i - 1][j];
				
				dp[i][j] = Math.max(take, notTake);
			}
		}
		
		return dp[n - 1][w];
	}
	
	// 23.4
	public static int unboundedKnapsack4(int n, int w, int[] profit, int[] weight) {
		int prev[] = new int[w + 1];
		
		for(int j = 0; j <= w; ++j) {
			prev[j] = j/weight[0] * profit[0];
		}
		
		for(int i = 1; i < n; ++i) {
			int curr[] = new int[w + 1];
			
			for(int j = 0; j <= w; ++j) {
				int take = 0;
				if(weight[i] <= j) take = profit[i] + curr[j  - weight[i]]; 
				int notTake = prev[j];
				
				curr[j] = Math.max(take, notTake);
			}
			
			prev = curr;
		}
		
		return prev[w];
	}
	
	// 23.5			:( 		Samajh nhi aaya
	public static int unboundedKnapsack5(int n, int w, int[] profit, int[] weight) {
		int prev[] = new int[w + 1];
		
		for(int j = 0; j <= w; ++j) {
			prev[j] = j/weight[0] * profit[0];
		}
		
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j <= w; ++j) {
				int take = 0;
				if(weight[i] <= j) take = profit[i] + prev[j  - weight[i]]; 
				int notTake = prev[j];
				
				prev[j] = Math.max(take, notTake);
			}
		}
		
		return prev[w];
	}
		
	
	/* ------------------------------------------------------------------ */
	
				// DP on subsequences/subset : Coin Change 2
	
	// 22.1
	public static long countWaysToMakeChange1(int denominations[], int value) {
		return countWaysToMakeChange1Helper(denominations.length - 1, denominations, value);
	}
	
	public static long countWaysToMakeChange1Helper(int i, int denominations[], int value) {
		
		if(value == 0) return 1;
		if(i == 0) return value % denominations[0] == 0 ? 1 : 0;
		
		long take = 0;
		if(value >= denominations[i]) 
			take = countWaysToMakeChange1Helper(i, denominations, value - denominations[i]);
		long notTake = countWaysToMakeChange1Helper(i - 1, denominations, value);
	
		return take + notTake;
	}
	
	// 22.2
	public static long countWaysToMakeChange2(int denominations[], int value) {
		Long dp[][] = new Long[denominations.length][value + 1];
		return countWaysToMakeChange2Helper(denominations.length - 1, denominations, value, dp);
	}
	
	public static long countWaysToMakeChange2Helper(int i, int denominations[], int value, 
			Long dp[][]) {
		
		if(value == 0) return 1;
		if(i == 0) return value % denominations[0] == 0 ? 1 : 0;
		
		if(dp[i][value] != null) return dp[i][value];
		
		long take = 0;
		if(value >= denominations[i]) 
			take = countWaysToMakeChange2Helper(i, denominations, value - denominations[i], dp);
		long notTake = countWaysToMakeChange2Helper(i - 1, denominations, value, dp);
	
		return dp[i][value] = take + notTake;
	}
	
	// 22.3
	public static long countWaysToMakeChange3(int denominations[], int value) {
		
		int n = denominations.length;
		long dp[][] = new long[n][value + 1];
		
		for(int i = 0; i <= value; ++i) dp[0][i] = i % denominations[0] == 0 ? 1 : 0;
		
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j <= value; ++j) {
				long take = 0;
				if(j >= denominations[i]) take = dp[i][j - denominations[i]];
				long notTake = dp[i - 1][j];
				
				dp[i][j] = take + notTake;
			}
		}
		
		return dp[n - 1][value];
	}
	
	// 22.4
	public static long countWaysToMakeChange4(int denominations[], int value) {
		
		int n = denominations.length;
		long prev[] = new long[value + 1];
		
		for(int i = 0; i <= value; ++i) prev[i] = i % denominations[0] == 0 ? 1 : 0;
		
		for(int i = 1; i < n; ++i) {
			
			long curr[] = new long[value + 1];
			
			for(int j = 0; j <= value; ++j) {
				long take = 0;
				if(j >= denominations[i]) take = curr[j - denominations[i]];
				long notTake = prev[j];
				
				curr[j] = take + notTake;
			}
			
			prev = curr;
		}
		
		return prev[value];
	}

	/* ------------------------------------------------------------------ */
	
				// DP on subsequences/subset : Target Sum
	
	// 21.2
	public static int targetSum(int n, int target, int[] arr) {
		// Uses 18.2
		return countPartitions(n, target, arr);
	}
	
	/* ------------------------------------------------------------------ */
	
				// DP on subsequences/subset : Minimum Coins
	
	// 20.1
    public static int minimumElements1(int num[], int x) {
		
		int res = minimumElements1Helper(num.length - 1, num, x);
		if(res == 1e9) return -1;
        else return res;
    }
	
	public static int minimumElements1Helper(int i, int num[], int x) {
		
		if(x == 0) return 0;
		
		if(i == 0) {
            if(x % num[0] == 0) return x/num[0];
            else return (int)1e9;
        }
		
		int notTake = minimumElements1Helper(i-1, num, x);
		int take = Integer.MAX_VALUE;
		if(num[i] <= x) take = 1 + minimumElements1Helper(i, num, x - num[i]);
		
		return Math.min(notTake, take);
	}
	
	// 20.2
    public static int minimumElements2(int num[], int x) {
		Integer dp[][] = new Integer[num.length][x+1];
		int res = minimumElements2Helper(num.length - 1, num, x, dp);
		if(res == 1e9) return -1;
        else return res;
    }
	
	public static int minimumElements2Helper(int i, int num[], int x, Integer dp[][]) {
		if(x == 0) return 0;
		
		if(i == 0) {
            if(x % num[0] == 0) return x/num[0];
            else return (int)1e9;
        }
		
		if(dp[i][x] != null) return dp[i][x];
		
		int notTake = minimumElements2Helper(i-1, num, x, dp);
		int take = Integer.MAX_VALUE;
		if(num[i] <= x) take = 1 + minimumElements2Helper(i, num, x - num[i], dp);
		
		return dp[i][x] = Math.min(notTake, take);
	}
	
	// 20.3
	public static int minimumElements3(int num[], int x) {
		
		if(x == 0) return 0;
		
		int dp[][] = new int[num.length][x+1];
		
		for(int j = 0; j <= x; ++j) {
			if(j % num[0] == 0) dp[0][j] = j/num[0];
			else dp[0][j] = (int)1e9;
			
		}
		
		for(int i = 1; i < num.length; ++i) {
			for(int j = 0; j <= x; ++j) {
				
				int notTake = dp[i-1][j];
				int take = Integer.MAX_VALUE;
				if(num[i] <= j) take = 1 + dp[i][j - num[i]];
				
				dp[i][j] = Math.min(notTake, take);
				
			}
		}
		
		int res = dp[num.length - 1][x];
		if(res == 1e9) return -1;
		return res;
	}
	
	// 20.4
	public static int minimumElements4(int num[], int x) {
		
		if(x == 0) return 0;
		
		int prev[] = new int[x+1];
		
		for(int j = 0; j <= x; ++j) {
			if(j % num[0] == 0) prev[j] = j/num[0];
			else prev[j] = (int)1e9;
			
		}
		
		for(int i = 1; i < num.length; ++i) {
			int curr[] = new int[x+1];
			
			for(int j = 0; j <= x; ++j) {
				
				int notTake = prev[j];
				int take = Integer.MAX_VALUE;
				if(num[i] <= j) take = 1 + curr[j - num[i]];
				
				curr[j] = Math.min(notTake, take);
			}
			
			prev = curr;
		}
		
		int res = prev[x];
		if(res == 1e9) return -1;
		return res;
	}
	
	// 20.5
	// Not working at this moment.
	public static int minimumElements5(int num[], int x) {
		
		int prev[] = new int[x+1];
		
		for(int j = 0; j <= x; ++j) {
			if(j % num[0] == 0) prev[j] = j/num[0];
			else prev[j] = (int)1e9;
			
		}
		
		for(int i = 1; i < num.length; ++i) {
			for(int j = x; j >= 0; --j) {
				
				int notTake = prev[j];
				int take = Integer.MAX_VALUE;
				if(num[i] <= j) take = 1 + prev[j - num[i]];
				
				prev[j] = Math.min(notTake, take);
			}
		}
		
		int res = prev[x];
		if(res == 1e9) return -1;
		return res;
	}
	
	/* ------------------------------------------------------------------ */
	
					// DP on subsequences/subset : 0/1 Knapsack
	
	// 19.1
    public static int knapsack1(int[] weight, int[] value, int n, int maxWeight) {
    	return knapsack1Helper(weight, value, n-1, maxWeight);
    }
    
    public static int knapsack1Helper(int[] weight, int[] value, int i, int maxWeight) {
    	
    	if(maxWeight == 0) return 0;
    	if(i == 0) {
    		if(maxWeight >= weight[0]) return value[0];
    		return 0;
    	}
    	
    	int take = 0;
    	if(maxWeight >= weight[i])
    		take = value[i] + knapsack1Helper(weight, value, i-1, maxWeight-weight[i]);
    	int notTake = knapsack1Helper(weight, value, i-1, maxWeight);
    	
    	return Math.max(take, notTake);
    }
    
    // 19.2
    public static int knapsack2(int[] weight, int[] value, int n, int maxWeight) {
    	Integer dp[][] = new Integer[n][maxWeight+1];
    	return knapsack2Helper(weight, value, n-1, maxWeight, dp);
    }
    
    public static int knapsack2Helper(int[] weight, int[] value, int i, int maxWeight, Integer dp[][]) {
    	
    	if(maxWeight == 0) return 0;
    	if(i == 0) {
    		if(maxWeight >= weight[0]) return value[0];
    		return 0;
    	}
    	
    	if(dp[i][maxWeight] != null) return dp[i][maxWeight];
    	
    	int take = 0;
    	if(maxWeight >= weight[i])
    		take = value[i] + knapsack2Helper(weight, value, i-1, maxWeight-weight[i], dp);
    	int notTake = knapsack2Helper(weight, value, i-1, maxWeight, dp);
    	
    	return dp[i][maxWeight] = Math.max(take, notTake);
    }
    
    // 19.3
    public static int knapsack3(int[] weight, int[] value, int n, int maxWeight) {
    	
    	if(maxWeight == 0) return 0;
    	
    	int dp[][] = new int[n][maxWeight+1];
    	for(int j = 0; j <= maxWeight; ++j) {
    		dp[0][j] = weight[0] <= j ? value[0] : 0;
    	}
    	
    	for(int i = 1; i < n; ++i) {
    		for(int j = 0; j <= maxWeight; ++j) {
    			int take = 0;
    			if(j >= weight[i]) take = value[i] + dp[i-1][j-weight[i]];
    			int notTake = dp[i-1][j];
    			
    			dp[i][j] = Math.max(take, notTake);
    		}
    	}
    	
    	return dp[n-1][maxWeight];
    }
    
    // 19.4
    public static int knapsack4(int[] weight, int[] value, int n, int maxWeight) {
    	
    	int prev[] = new int[maxWeight+1];
    	for(int j = 0; j <= maxWeight; ++j) {
    		prev[j] = weight[0] <= j ? value[0] : 0;
    	}
    	
    	for(int i = 1; i < n; ++i) {
    		int temp[] = new int[maxWeight+1];
    		
    		for(int j = 0; j <= maxWeight; ++j) {
    			int take = 0;
    			if(j >= weight[i]) take = value[i] + prev[j-weight[i]];
    			int notTake = prev[j];
    			
    			temp[j] = Math.max(take, notTake);
    		}
    		
    		prev = temp;
    	}
    	
    	return prev[maxWeight];
    	
    }
    
    // 19.5 : No need of curr[] array. 1D array space optimization.
    public static int knapsack5(int[] weight, int[] value, int n, int maxWeight) {
    	
    	int prev[] = new int[maxWeight+1];
    	for(int j = 0; j <= maxWeight; ++j) {
    		prev[j] = weight[0] <= j ? value[0] : 0;
    	}
    	
    	for(int i = 1; i < n; ++i) {
    		for(int j = maxWeight; j >= 0; --j) {
    			int take = 0;
    			if(j >= weight[i]) take = value[i] + prev[j-weight[i]];
    			int notTake = prev[j];
    			
    			prev[j] = Math.max(take, notTake);
    		}
    	}
    	
    	return prev[maxWeight];
    	
    }

	/* ------------------------------------------------------------------ */
	
			// DP on subsequences/subset : Count Partitions With Given Difference.
	
    // 18.2
	public static int countPartitions(int n, int d, int[] arr) {
		
		int totalSum = 0;
		for(int i = 0; i < n; ++i) totalSum += arr[i];
		
		if(totalSum - d < 0 || (totalSum - d) % 2 == 1) return 0;
		
		int target = (totalSum - d)/2; 
		
		// uses 17.2
		return findWays2(arr, target);
		
	}
	
	/* ------------------------------------------------------------------ */
	
				// DP on subsequences/subset : Counts Subsets with Sum K
	
	// 17.1
	public static int findWays1(int num[], int tar) {
		return findWays1Helper(num.length-1, num, tar);
	}
	
	public static int findWays1Helper(int i, int num[], int tar) {
		
		// Not handles 0 i.e num[i] = 0 preferred when 1 <= num[i] <= 1e5 	-----------
//		if(tar == 0 && i < 0) return 1; 
//		
//		if(i < 0 || tar < 0) return 0;
//		
//		int take = findWays1Helper(i-1, num, tar-num[i]);
//		int notTake = findWays1Helper(i-1, num, tar);
//		
//		return take + notTake;
		
		// Handles 0, i.e num[i] = 0 preferred when 0 <= num[i] <= 1e5 		-----------
		if(tar == 0 && i < 0) return 1;
		
		if(i < 0 || tar < 0) return 0;
		
		int take = findWays1Helper(i-1, num, tar-num[i]);
		int notTake = findWays1Helper(i-1, num, tar);
		
		return take + notTake;
	}
	
	// 17.2
	public static int findWays2(int num[], int tar) {
		Integer dp[][] = new Integer[num.length][tar+1];
		return findWays2Helper(num.length-1, tar, num, dp);
	}
	
	public static int findWays2Helper(int i, int tar, int num[], Integer dp[][]) {
		
		// Not handles 0 i.e num[i] = 0 preferred when 1 <= num[i] <= 1e5 	-----------
//		if(tar == 0) return 1;
//		
//		if(i < 0 || tar < 0) return 0;
//		
//		if(dp[i][tar] != null) return dp[i][tar];
//		
//		int take = findWays2Helper(i-1, tar-num[i], num, dp);
//		int notTake = findWays2Helper(i-1, tar, num, dp);
//		
//		return dp[i][tar] = take + notTake;
		
		// Handles 0, i.e num[i] = 0 preferred when 0 <= num[i] <= 1e5 		-----------
		if(tar == 0 && i < 0) return 1;
		
		if(i < 0 || tar < 0) return 0;
		
		if(dp[i][tar] != null) return dp[i][tar];
		
		int take = findWays2Helper(i-1, tar-num[i], num, dp);
		int notTake = findWays2Helper(i-1, tar, num, dp);
		
		return dp[i][tar] = take + notTake;
	}
	
	// 17.3
	public static int findWays3(int num[], int tar) {
		
		int dp[][] = new int[num.length][tar+1];
		
		for(int i = 0; i < num.length; ++i) dp[i][0] = 1;
		if(num[0] <= tar) dp[0][num[0]] = 1;
		
		for(int i = 1; i < num.length; ++i) {
			for(int j = 0; j <= tar; ++j) {
				
				int take = 0;
				if(num[i] <= j) take = dp[i-1][j-num[i]];
				int notTake = dp[i-1][j];
				
				dp[i][j] = take + notTake;
			}
		}
		
		return dp[num.length-1][tar];
		
		// Unable to understand how to handle 0, i.e num[i] = 0 in tabulation, so skipped.
	}
	
	// 17.4
	public static int findWays4(int num[], int tar) {
		
		int prev[] = new int[tar+1];
		
		prev[0] = 1;
		if(num[0] <= tar) prev[num[0]] = 1;
		
		for(int i = 1; i < num.length; ++i) {
			int curr[] = new int[tar+1];
			curr[0] = 1;
			
			for(int j = 0; j <= tar; ++j) {
				
				int take = 0;
				if(num[i] <= j) take = prev[j-num[i]];
				int notTake = prev[j];
				
				curr[j] = take + notTake;
			}
			
			prev = curr;
		}
		
		return prev[tar];
	}
	
	/* ------------------------------------------------------------------ */
	
	// DP on subsequences/subset : Partition A Set Into Two Subsets With Minimum Difference
	
	// 16.1
	public static int minSubsetSumDifference1(int[] arr, int n) {
		return minSubsetSumDifference1Helper(n-1, 0, 0, arr);
	}
	
	public static int minSubsetSumDifference1Helper(int i, int s1, int s2, int arr[]) {
		
		if(i < 0) return Math.abs(s1 - s2);
		
		int pick = minSubsetSumDifference1Helper(i-1, s1 + arr[i], s2, arr);
		int notPick = minSubsetSumDifference1Helper(i-1, s1, s2 + arr[i], arr);
		
		return Math.min(pick, notPick);
	
	}
	
	// 16.4
	public static int minSubsetSumDifference4(int[] arr, int n) {
		
		int sum = 0;
		for(int i = 0; i < n; ++i) sum += arr[i];
		
		// <------------uses 14.4-------------->
		
		boolean prev[] = new boolean[sum+1];
		prev[0] = true;
		if(arr[0] <= sum) prev[arr[0]] = true;
		
		for(int i = 1; i < n; ++i) {
			boolean curr[] = new boolean[sum+1];
			curr[0] = true;
			
			for(int j = 0; j <= sum; ++j) {
				boolean pick = false;
				if(arr[i] <= j) pick = prev[j-arr[i]];
				boolean notPick = prev[j];
				
				curr[j] = pick || notPick;
			}
			
			prev = curr;
		}
		
		// <----------------------------------->
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= sum; ++i) {
			if(prev[i]) min = Math.min(min, Math.abs(sum - i - i));
		}
		
		return min;
		
	}

	/* ------------------------------------------------------------------ */
	
				// DP on subsequences/subset : Partition Equal Subset Sum
	
	// 15.4
	public static boolean canPartition(int[] arr, int n) {
		
		int totalSum = 0;
		for(int i = 0; i < n; ++i) totalSum += arr[i];
		if(totalSum % 2 == 1) return false;
		
		// Uses 14.4
		return subsetSumToK4(n, totalSum/2, arr);
	}
	
	/* ------------------------------------------------------------------ */
	
				// DP on subsequences/subset : Subset Sum Equals to Target
	
	// 14.1 : This solution is enough.
	public static boolean subsetSumToK1(int n, int k, int arr[]) {
		return subsetSumToK1Helper(n-1, k, arr);
	}
	
	public static boolean subsetSumToK1Helper(int i, int k, int arr[]) {
		
		if(k == 0) return true;
		if(i < 0 || k < 0) return false;
		
		if(subsetSumToK1Helper(i-1, k-arr[i], arr) || subsetSumToK1Helper(i-1, k, arr)) {
			return true;
		}
		
		return false;
	}
	
	// 14.2
	public static boolean subsetSumToK2(int n, int k, int arr[]) {
		Integer dp[][] = new Integer[n][k+1]; 
		return subsetSumToK2Helper(n-1, k, arr, dp);
	}
	
	public static boolean subsetSumToK2Helper(int i, int k, int arr[], Integer dp[][]) {
		// -1 : FALSE & null : UNVISITED
		if(k == 0) return true;
		if(i < 0 || k < 0) return false;
		
		if(dp[i][k] != null && dp[i][k] == -1) return false;
		
		if(subsetSumToK2Helper(i-1, k-arr[i], arr, dp) || subsetSumToK2Helper(i-1, k, arr, dp)) {
			return true;
		}
		
		dp[i][k] = -1;
		return false;
	}
	
	// 14.3
	public static boolean subsetSumToK3(int n, int k, int arr[]) {
		boolean dp[][] = new boolean[n][k+1];
		
		for(int i = 0; i < n; ++i) dp[i][0] = true;
		
		if(arr[0] <= k) dp[0][arr[0]] = true;
		
		for(int i = 1; i < n; ++i) {
			for(int target = 0; target <= k; ++target) {
				boolean take = false;
				if(arr[i] <= target) take = dp[i-1][target-arr[i]];
				boolean notTake = dp[i-1][target];
				
				dp[i][target] = take || notTake;
			}
		}
		
		return dp[n-1][k];
	}
	
	// 14.4
	public static boolean subsetSumToK4(int n, int k, int arr[]) {
		boolean prev[] = new boolean[k+1];
		prev[0] = true;
		if(arr[0] <= k) prev[arr[0]] = true;
		
		for(int i = 1; i < n; ++i) {
			boolean curr[] = new boolean[k+1];
			curr[0] = true;
			
			for(int target = 0; target <= k; ++target) {
				boolean take = false;
				if(arr[i] <= target) take = prev[target-arr[i]];
				boolean notTake = prev[target];
				
				curr[target] = take || notTake;
			}
			prev = curr;
		}
		
		return prev[k];
	}
	
}
