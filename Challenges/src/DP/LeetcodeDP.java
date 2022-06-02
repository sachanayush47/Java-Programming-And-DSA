package DP;

import java.util.*;

@SuppressWarnings("unused")
public class LeetcodeDP {

	public static void main(String[] args) {

	}
	
	
	/* ------------------------------------------------------------------ */
	
	
	
	/* ------------------------------------------------------------------ */
	
									// Triangle
	
	public static int minimumTotal1(List<List<Integer>> triangle) {
		int m = triangle.size();
		int n = triangle.get(m - 1).size();
		int dp[][] = new int[m][n];
		for(int i = 0; i < m; ++i)
			Arrays.fill(dp[i], -1);
		return minimumTotal1Helper(0, 0, triangle, dp);
    }
	
	public static int minimumTotal1Helper(int i, int j, List<List<Integer>> triangle, int dp[][]) {
        
		if(i >= triangle.size() || j >= triangle.get(i).size()) return (int)1e5;
        if(i == triangle.size() - 1) return triangle.get(i).get(j);
		
		if(dp[i][j] != -1) return dp[i][j];
		
		int down = triangle.get(i).get(j) + minimumTotal1Helper(i + 1, j, triangle, dp);
		int diagonal = triangle.get(i).get(j) + minimumTotal1Helper(i + 1, j + 1, triangle, dp);
		
		return dp[i][j] = Math.min(down, diagonal);
    }
	
	/* ------------------------------------------------------------------ */
	
								// Minimum Path Sum
	
	public static int minPathSum1(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		int dp[][] = new int[m][n];
		for(int i = 0; i < m; ++i)
			Arrays.fill(dp[i], -1);
		
		return minPathSum1Helper(m - 1, n - 1, grid, dp);
	}
	
	public static int minPathSum1Helper(int i, int j, int[][] grid, int dp[][]) {
		
		if(i < 0 || j < 0) return Integer.MAX_VALUE;
		if(i == 0 && j == 0) return grid[0][0];
		
		if(dp[i][j] != -1) return dp[i][j];
		
		int up = grid[i][j] + minPathSum1Helper(i - 1, j, grid, dp);
		int down = grid[i][j] + minPathSum1Helper(i, j - 1, grid, dp);
		
		return dp[i][j] = Math.min(up, down);
	}
	
	public static int minPathSum2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		int prev[] = new int[n];
		
		for(int i = 0; i < m; ++i) {
			int curr[] = new int[n];
			
			for(int j = 0; j < n; ++j) {
				if(i == 0 && j == 0) curr[j] = grid[i][j];
				else {
					int up = (int)1e9, down = (int)1e9;
					if(i > 0) up = grid[i][j] + prev[j];
					if(j > 0) down = grid[i][j] + curr[j - 1];
					
					curr[j] = Math.min(up, down);
				}
			}
			prev = curr;
		}
		
		return prev[n - 1];
	}
	
	
	
	/* ------------------------------------------------------------------ */
	
								// Grid Unique Path II
	
	public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		return uniquePathsWithObstacles1Helper(m - 1, n - 1, obstacleGrid);
	}
	
	public static int uniquePathsWithObstacles1Helper(int i, int j, int[][] grid) {
		
		if(i < 0 || j < 0) return 0;
		if(grid[i][j] == 1) return 0;
		if(i == 0 && j == 0) return 1;
		
		int up = uniquePathsWithObstacles1Helper(i - 1, j, grid);
		int left = uniquePathsWithObstacles1Helper(i, j - 1, grid);
		
		return up + left;
	}
	
	/* ------------------------------------------------------------------ */
	
								// Climbing Stairs
	
	// Memoization
	public static int climbStairs1(int n) {
		Integer dp[] = new Integer[n + 1];
		return climbStairs1Helper(n, dp);
	}
	
	public static int climbStairs1Helper(int n, Integer dp[]) {
		if(n < 0) return 0;
		if(n == 0) return 1;
		
		if(dp[n] != null) return dp[n];
		
		int oneStep = climbStairs1Helper(n - 1, dp);
		int twoStep = climbStairs1Helper(n - 2, dp);
		
		return dp[n] = oneStep + twoStep;
	}
	
	// Tabulation
	public static int climbStairs2(int n) {
		
		int dp[] = new int[n + 1];
		dp[0] = 1;
		
		for(int i = 1; i <= n; ++i) {
			int oneStep = dp[i - 1];
			int twoStep = 0;
			if(i > 1) twoStep = dp[i - 2];
			
			dp[i] = oneStep + twoStep;
		}
		
		return dp[n];
	}
	
	
	
}
