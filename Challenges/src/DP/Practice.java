package DP;

public class Practice {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	public static int minPathSum(int[][] grid) {
		Integer dp[][] = new Integer[grid.length][grid[0].length];
		return minPthSumHelper(grid.length - 1, grid[0].length, grid, dp);
	}
	
	public static int minPthSumHelper(int i, int j, int[][] grid, Integer dp[][]) {
		
		if(i == 0 && j == 0) return grid[0][0];
		
		if(dp[i][j] != null) return dp[i][j];
		
		int up = Integer.MAX_VALUE;
		if(i != 0) up = minPthSumHelper(i - 1, j, grid, dp);
		int down = Integer.MAX_VALUE;
		if(j != 0) down = minPthSumHelper(i, j - 1, grid, dp);
		
		return dp[i][j] = Math.min(up + grid[i][j], down + grid[i][j]);
	}
	
	

}
