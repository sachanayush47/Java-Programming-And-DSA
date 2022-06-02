package dynamicProgramming;

import java.util.*;

public class DynamicProgramming5 {

	// Longest Increasing Subsequence.
	
	public static void main(String[] args) {

		System.out.println(printingLIS(new int[] {5, 4, 11, 1, 16, 8}));
	
	}
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
									// Lecture 44
	
	public static int longestDivisibleSubset(int arr[]) {
	// Similar to "printingLIS"
		
		int n = arr.length;
		
		Arrays.sort(arr);
		
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		
		int hash[] = new int[n];
		for(int i = 0; i < n; ++i) {
			hash[i] = i;
		}
		
		int max = 1;
		int maxInd = 0;
		
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j < i; ++j) {
				if(arr[i] % arr[j] == 0 && dp[i] < 1 + dp[j]) {
					dp[i] = 1 + dp[j];
					hash[i] = j;
				}
			}

			if(dp[i] > max) {
				max = Math.max(max, dp[i]);
				maxInd = i;
			}
		}
		
		int i = maxInd;
		ArrayList<Integer> lis = new ArrayList<>();		// LIS stored her in reverse order.
		while(hash[i] != i) {
			lis.add(arr[i]);
			i = hash[i];
		}
		
		lis.add(arr[i]);
		Collections.reverse(lis);						//	Now, in correct order.
		System.out.println(lis);
		
		return max;										// Length of LIS
	}
	
	/* ------------------------------------------------------------------ */
	
									// Lecture 43
	
	// Samajh nhi aaya
	
	/* ------------------------------------------------------------------ */
	
									// Lecture 42
	
	// Tabulation
	public static int lis3(int arr[]) {

		int n = arr.length;
		int dp[][] = new int[n][n + 1];

		for(int j = 0; j <= n; ++j) {
			if(j == n) dp[0][j] = 1;
			else dp[0][j] = arr[0] < arr[j] ? 1 : 0;
		}

		for(int i = 1; i < n; ++i) {
			for(int j = 0; j <= n; ++j) {
				int notPick = dp[i - 1][j];
				int pick = 0;
				if(j == arr.length || arr[i] < arr[j]) pick = 1 + dp[i - 1][i];

				dp[i][j] = Math.max(notPick, pick);
			}
		}

		return dp[n -1][n];
	}

	// Space optimization	TC	O(n^2)		SC	O(n) * 2
	public static int lis4(int arr[]) {

		int n = arr.length;
		int prev[] = new int[n + 1];

		for(int j = 0; j <= n; ++j) {
			if(j == n) prev[j] = 1;
			else prev[j] = arr[0] < arr[j] ? 1 : 0;
		}

		for(int i = 1; i < n; ++i) {
			int curr[] = new int[n + 1];

			for(int j = 0; j <= n; ++j) {
				int notPick = prev[j];
				int pick = 0;
				if(j == arr.length || arr[i] < arr[j]) pick = 1 + prev[i];

				curr[j] = Math.max(notPick, pick);
			}

			prev = curr;
		}

		return prev[n];
	}
	
	// TC	O(n^2)		SC	O(n),	more space optimised. Algorithmic approach.
	// This solution is more likely required when we need to trace back the LIS.
	public static int lis5(int arr[]) {
		int n = arr.length;
		
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		
		int max = 1;
		
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j < i; ++j) {
				if(arr[j] < arr[i]) 
					dp[i] = Math.max(dp[i], dp[i] + dp[j]);
			}

			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
	// Printing LIS.
	
	public static int printingLIS(int arr[]) {
	// We just made few changes in "lis5"
		
		int n = arr.length;
		
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		
		int hash[] = new int[n];
		for(int i = 0; i < n; ++i) {
			hash[i] = i;
		}
		
		int max = 1;
		int maxInd = 0;
		
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j < i; ++j) {
				if(arr[j] < arr[i] && dp[i] < 1 + dp[j]) {
					dp[i] = 1 + dp[j];
					hash[i] = j;
				}
			}

			if(dp[i] > max) {
				max = Math.max(max, dp[i]);
				maxInd = i;
			}
		}
		
		int i = maxInd;
		ArrayList<Integer> lis = new ArrayList<>();		// LIS stored her in reverse order.
		while(hash[i] != i) {
			lis.add(arr[i]);
			i = hash[i];
		}
		
		lis.add(arr[i]);
		Collections.reverse(lis);						//	Now, in correct order.
		System.out.println(lis);
		
		return max;										// Length of LIS
	}
	
	/* ------------------------------------------------------------------ */
	
								// Lecture 41
	
	// Recursion
	public static int lis1(int arr[]) {
		return lis1Helper(arr.length - 1, arr.length, arr);
	}

	public static int lis1Helper(int i, int prevInd, int arr[]) {
		if(i == 0) {
			if(prevInd == arr.length) return 1;
			return arr[0] < arr[prevInd] ? 1 : 0;
		}
		
		int notPick = lis1Helper(i - 1, prevInd, arr);
		int pick = 0;
		if(prevInd == arr.length || arr[i] < arr[prevInd]) pick = 1 + lis1Helper(i - 1, i, arr);
		
		return Math.max(notPick, pick);
	}
	
	// Memoization
	public static int lis2(int arr[]) {
		int n = arr.length;

		int dp[][] = new int[n][n + 1];
		
		for(int i = 0; i < arr.length; ++i)
			Arrays.fill(dp[i], -1);
		
		return lis2Helper(arr.length - 1, n, arr, dp);
	}

	public static int lis2Helper(int i, int prevInd, int arr[], int dp[][]) {
		
		if(i == 0) {
			if(prevInd == arr.length) return 1;
			return arr[0] < arr[prevInd] ? 1 : 0;
		}
		
		if(dp[i][prevInd] != -1) return dp[i][prevInd];
		
		int notPick = lis2Helper(i - 1, prevInd, arr, dp);
		int pick = 0;
		if(prevInd == arr.length || arr[i] < arr[prevInd]) pick = 1 + lis2Helper(i - 1, i, arr, dp);
		
		return dp[i][prevInd] = Math.max(notPick, pick);
	}
}
