package dynamicProgramming;

import java.util.*;

public class DynamicProgramming1 {

	static int mod = (int)(1e9 + 7);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int arr[][] = {{1, 2, 10, 4}, {100, 3, 2, 1}, {1, 1, 20, 2}, {1, 2, 2, 1}};
		int arr1[][] = {{-10000000}};
		int arr2[][] = {{-9999, -9888, -9777, -9666, -9555},
						{1, 10, 2, 4, 5},
						{-9999, -9888, -9777, -9666, -9555},
						{0, 0, 0, 0, 0},
						{-99, -98, -97, -96, -95}};
		
		int arr3[][] = {
				{2, 3, 1, 2},
				{3, 4, 2, 2},
				{5, 6, 3, 5}
		};
		
		
		System.out.println(maximumChocolates2(arr3.length, arr3[0].length, arr3));
		
	}
	
	/* ------------------------------------------------------------------ */

	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	// 						DP on grids: Cherry Pickup | 3D DP
	
	// 13.1
	public static int maximumChocolates1(int r, int c, int[][] grid) {
		
		return maximumChocolates1Helper(0, 0, c-1, grid);
	}
	
	public static int maximumChocolates1Helper(int i, int j1, int j2, int[][] grid) {
		
		if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) return -(int)1e8;
		if(i == grid.length-1) {
			if(j1 == j2) return grid[i][j1];
			else return grid[i][j1] + grid[i][j2];
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int dj1 = -1; dj1 <= 1; ++dj1) {
			for(int dj2 = -1; dj2 <= 1; ++dj2) {
				
				int value = 0;
				if(j1 == j2) value = grid[i][j1];
				else value = grid[i][j1] + grid[i][j2];
				
				value += maximumChocolates1Helper(i+1, j1+dj1, j2+dj2, grid);
				max = Math.max(max, value);
			}
		}
		
		return max;
	}
	
	// 13.2
	public static int maximumChocolates2(int r, int c, int[][] grid) {
		
		Integer dp[][][] = new Integer[r][c][c];
		return maximumChocolates2Helper(0, 0, c-1, grid, dp);
	}
	
	public static int maximumChocolates2Helper(int i, int j1, int j2, int[][] grid, 
			Integer dp[][][]) {
		
		if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) return -(int)1e8;
		if(i == grid.length-1) {
			if(j1 == j2) return grid[i][j1];
			else return grid[i][j1] + grid[i][j2];
		}
		
		if(dp[i][j1][j2] != null) return dp[i][j1][j2];
		
		int max = Integer.MIN_VALUE;
		
		for(int dj1 = -1; dj1 <= 1; ++dj1) {
			for(int dj2 = -1; dj2 <= 1; ++dj2) {
				
				int value = 0;
				if(j1 == j2) value = grid[i][j1];
				else value = grid[i][j1] + grid[i][j2];
				
				value += maximumChocolates2Helper(i+1, j1+dj1, j2+dj2, grid, dp);
				max = Math.max(max, value);
			}
		}
		
		return dp[i][j1][j2] = max;
	}
	
	// 13.3 Tough time to understand it.
//	public static int maximumChocolates3(int r, int c, int[][] grid) {
//		
//		int dp[][][] = new int[r][c][c];
//		
//		for(int i = r-2; i >= 0; --i) {
//			
//		}
//	}
	
	// 13.4 Tough time to understand it.
	
	/* ------------------------------------------------------------------ */
			// DP on Grids: Minimum Falling Path Sum | Variable Starting and Ending Points
	
	// 12.1
	public static int getMaxPathSum1(int[][] matrix) {
		
		int col = matrix[0].length;
		int max = Integer.MIN_VALUE;
		
		for(int j = 0; j < col; ++j) {
			int curr = getMaxPathSum1Helper(0, j, matrix);
			max = Math.max(max, curr);
		}
		
		return max;
	}
	
	public static int getMaxPathSum1Helper(int i, int j, int[][] matrix) {
		
		if(j < 0 || j > matrix[0].length-1) return -(int)(1e9);
		if(matrix.length-1 == i) return matrix[i][j];
		
		int left = matrix[i][j] + getMaxPathSum1Helper(i+1, j-1, matrix);
		int below = matrix[i][j] + getMaxPathSum1Helper(i+1, j, matrix);
		int right = matrix[i][j] + getMaxPathSum1Helper(i+1, j+1, matrix);
		
		return Math.max(left, Math.max(below, right));
	}
	
	// 12.2
	public static int getMaxPathSum2(int[][] matrix) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		Integer dp[][] = new Integer[row][col];
		
		int max = Integer.MIN_VALUE;
		
		for(int j = 0; j < col; ++j) {
			int curr = getMaxPathSum2Helper(0, j, matrix, dp);
			
			max = Math.max(max, curr);
		}
		
		return max;
	}
	
	public static int getMaxPathSum2Helper(int i, int j, int[][] matrix, Integer[][] dp) {
		
		if(j < 0 || j > matrix[0].length-1) return -(int)(1e9);
		if(matrix.length-1 == i) return matrix[i][j];
		
		if(dp[i][j] != null) return dp[i][j];
		
		int left = matrix[i][j] + getMaxPathSum2Helper(i+1, j-1, matrix, dp);
		int below = matrix[i][j] + getMaxPathSum2Helper(i+1, j, matrix, dp);
		int right = matrix[i][j] + getMaxPathSum2Helper(i+1, j+1, matrix, dp);
		
		return dp[i][j] = Math.max(left, Math.max(below, right));
	}
	
	// 12.3
	public static int getMaxPathSum3(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		int dp[][] = new int[row][col];
		int max = Integer.MIN_VALUE;
		
		for(int j = 0; j < col; ++j) {
			dp[row-1][j] = matrix[row-1][j];
		}
		
		for(int i = row-2; i >= 0; --i) {
			for(int j = 0; j < col; ++j) {
				int left = Integer.MIN_VALUE, below = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
				
				if(j > 0) left = matrix[i][j] + dp[i+1][j-1];
				below = matrix[i][j] + dp[i+1][j];
				if(j < col-1) right = matrix[i][j] + dp[i+1][j+1];
				
				dp[i][j] = Math.max(left, Math.max(below, right));
			}
		}
		
		for(int j = 0; j < col; ++j) max = Math.max(max, dp[0][j]);
		
		return max;
	}
	
	// 12.4
	public static int getMaxPathSum4(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		int prev[] = new int[col];
		int max = Integer.MIN_VALUE;
		
		for(int j = 0; j < col; ++j) {
			prev[j] = matrix[row-1][j];
		}
		
		for(int i = row-2; i >= 0; --i) {
			int curr[] = new int[col];
			
			for(int j = 0; j < col; ++j) {
				int left = Integer.MIN_VALUE, below = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
				
				if(j > 0) left = matrix[i][j] + prev[j-1];
				below = matrix[i][j] + prev[j];
				if(j < col-1) right = matrix[i][j] + prev[j+1];
				
				curr[j] = Math.max(left, Math.max(below, right));
			}
			
			prev = curr;
		}
		
		for(int j = 0; j < col; ++j) max = Math.max(max, prev[j]);
		
		return max;
	}
	
	
	/* ------------------------------------------------------------------ */
							// DP on GRIDS : Triangle
	
	// 11.1
	public static int minimumPathSum1(int[][] triangle, int n) {
		return minimumPathSum1Helper(0, 0, triangle, n-1);
	}
	
	public static int minimumPathSum1Helper(int i, int j, int[][] triangle, int n) {
		
		if(i == n) return triangle[i][j];
		
		int down = triangle[i][j] + minimumPathSum1Helper(i+1, j, triangle, n);
		int diagonal = triangle[i][j] + minimumPathSum1Helper(i+1, j+1, triangle, n);
		
		return Math.min(down, diagonal);
	}
	
	// 11.2
	public static int minimumPathSum2(int[][] triangle, int n) {
		Integer dp[][] = new Integer[n][n];
		return minimumPathSum2Helper(0, 0, triangle, n-1, dp);
	}
	
	public static int minimumPathSum2Helper(int i, int j, int[][] triangle, int n, Integer dp[][]) {
		
		if(i == n) return triangle[i][j];
		
		if(dp[i][j] != null) return dp[i][j];
		
		int down = triangle[i][j] + minimumPathSum2Helper(i+1, j, triangle, n, dp);
		int diagonal = triangle[i][j] + minimumPathSum2Helper(i+1, j+1, triangle, n, dp);
		
		return dp[i][j] = Math.min(down, diagonal);
	}
	
	// 11.3
	public static int minimumPathSum3(int[][] triangle, int n) {
		
		int dp[][] = new int[n][n];
		
		for(int i = 0; i < n; ++i) dp[n-1][i] = triangle[n-1][i];
		
		for(int i = n-2; i >= 0; --i) {
			for(int j = i; j >= 0; --j) {
				dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		
		return dp[0][0];
	}
	
	// 11.4
	public static int minimumPathSum4(int[][] triangle, int n) {
		
		int prev[] = new int[n];
		
		for(int i = 0; i < n; ++i) prev[i] = triangle[n-1][i];
		
		for(int i = n-2; i >= 0; --i) {
			int curr[] = new int[n];
			
			for(int j = i; j >= 0; --j) curr[j] = triangle[i][j] + Math.min(prev[j], prev[j+1]);
			
			prev = curr;
		}
		
		return prev[0];
	}
	
	/* ------------------------------------------------------------------ */
							// DP on GRIDS : Minimum Path Sum
	
	// 10.1
	public static int minSumPath1(int[][] grid) {
		return minSumPath1Helper(grid.length-1, grid[0].length-1, grid);
	}
	
	public static int minSumPath1Helper(int m, int n, int[][] grid) {
		
		if(m == 0 && n == 0) return grid[0][0];
		if(m < 0 || n < 0) return (int)(1e9);
		
		int up = minSumPath1Helper(m-1, n, grid) + grid[m][n];
		int left = minSumPath1Helper(m, n-1, grid) + grid[m][n];
		
		return Math.min(up, left);
	}
	
	// 10.2
	public static int minSumPath2(int[][] grid) {
		int dp[][] = new int[grid.length][grid[0].length];
		return minSumPath2Helper(grid.length-1, grid[0].length-1, grid, dp);
	}
	
	public static int minSumPath2Helper(int m, int n, int[][] grid, int dp[][]) {
		
		if(m == 0 && n == 0) return grid[0][0];
		if(m < 0 || n < 0) return (int)(1e9);
		
		if(dp[m][n] > 0) return dp[m][n];
		
		int up = minSumPath2Helper(m-1, n, grid, dp) + grid[m][n];
		int left = minSumPath2Helper(m, n-1, grid, dp) + grid[m][n];
		
		return dp[m][n] = Math.min(up, left);
	}
	
	// 10.3
	public static int minSumPath3(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		int dp[][] = new int[m][n];
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				
				if(i == 0 && j == 0) dp[i][j] = grid[i][j];
				else {
					int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
					
					if(i > 0) up = dp[i-1][j] + grid[i][j];
					if(j > 0) left = dp[i][j-1] + grid[i][j];
				
					dp[i][j] = Math.min(up, left);
				}
			}
		}
		
		return dp[m-1][n-1];
	}
	
	// 10.4
	public static int minSumPath4(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		int prev[] = new int[n];
		
		for(int i = 0; i < m; ++i) {
			
			int temp[] = new int[n];
			for(int j = 0; j < n; ++j) {
				
				if(i == 0 && j == 0) temp[j] = grid[i][j];
				else {
					int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
					
					if(i > 0) up = prev[j] + grid[i][j];
					if(j > 0) left = temp[j-1] + grid[i][j];
				
					temp[j] = Math.min(up, left);
				}
			}
			prev = temp;
		}
		
		return prev[n-1];
	}
	
	
	/* ------------------------------------------------------------------ */
							// DP on GRIDS : Unique Paths 2
	
	// 9.1
	public static int mazeObstacles1(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		return mazeObstacles1Helper(n-1, m-1, mat);
	}
	
	public static int mazeObstacles1Helper(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		if(n >= 0 && m >= 0 && mat.get(n).get(m) == -1) return 0;
		if(n == 0 && m == 0) return 1;
		if(n < 0 || m < 0) return 0;
		
		int up = mazeObstacles1Helper(n-1, m, mat);
		int left = mazeObstacles1Helper(n, m-1, mat);
		
		return (up + left) % mod;
	}
	
	// 9.2
	public static int mazeObstacles2(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		int dp[][] = new int[n][m];
		return mazeObstacles2Helper(n-1, m-1, mat, dp);
	}
	
	public static int mazeObstacles2Helper(int n, int m, ArrayList<ArrayList<Integer>> mat, int dp[][]) {
		if(n >= 0 && m >= 0 && mat.get(n).get(m) == -1) return 0;
		if(n == 0 && m == 0) return 1;
		if(n < 0 || m < 0) return 0;
		
        if(dp[n][m] > 0) return dp[n][m];
        
		int up = mazeObstacles2Helper(n-1, m, mat, dp);
		int left = mazeObstacles2Helper(n, m-1, mat, dp);
		
		return dp[n][m] = (up + left) % mod;
	}
	
	// 9.3
	public static int mazeObstacles3(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		
		int dp[][] = new int[n][m];

		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				
				if(mat.get(i).get(j) == -1) dp[i][j] = 0;
				else if(i == 0 && j == 0) dp[i][j] = 1;
				else {
					int up = 0, left = 0;
					if(i > 0) up = dp[i-1][j];
					if(j > 0) left = dp[i][j-1];
					dp[i][j] = (up + left) % mod;
				}
				
			}
		}
		
		return dp[n-1][m-1];
	}
	
	// 9.4
	public static int mazeObstacles4(int n, int m, ArrayList<ArrayList<Integer>> mat) {
		
		int prev[] = new int[m];

		for(int i = 0; i < n; ++i) {
			
			int temp[] = new int[m];
			for(int j = 0; j < m; ++j) {
				
				if(mat.get(i).get(j) == -1) temp[j] = 0;
				else if(i == 0 && j == 0) temp[j] = 1;
				else {
					int up = 0, left = 0;
					if(i > 0) up = prev[j];
					if(j > 0) left = temp[j-1];
					temp[j] = (up + left) % mod;
				}
			}
			prev = temp;
		}
		
		return prev[m-1];
	}
	
	/* ------------------------------------------------------------------ */
	
							// DP on GRIDS : Unique Paths
	// 8.1
	public static int uniquePaths1(int m, int n) {
		return uniquePaths1Helper(m-1, n-1);
	}
	
	public static int uniquePaths1Helper(int m, int n) {
		if(m == 0 && n == 0) return 1;
		if(m < 0 || n < 0) return 0;
		
		int up = uniquePaths1Helper(m-1, n);
		int left = uniquePaths1Helper(m, n-1);
		
		return up+left;
	}
	
	// 8.2
	public static int uniquePaths2(int m, int n) {
		int dp[][] = new int[m][n];
		return uniquePaths2Helper(m-1, n-1, dp);
	}
	
	public static int uniquePaths2Helper(int m, int n, int dp[][]) {
		if(m == 0 && n == 0) return 1;
		if(m < 0 || n < 0) return 0;
		
		if(dp[m][n] > 0) return dp[m][n];
		
		int up = uniquePaths2Helper(m-1, n, dp);
		int left = uniquePaths2Helper(m, n-1, dp);
		
		return dp[m][n] = up+left;
	}
	
	// 8.3
	public static int uniquePaths3(int m, int n) {
		
		int dp[][] = new int[m][n];
		
		Arrays.fill(dp[0], 1);
		
		for(int i = 1; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if(j == 0) dp[i][j] = dp[i-1][j];
				else dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
	}
	
	// 8.4
	public static int uniquePaths4(int m, int n) {
		
		int prev[] = new int[n];
		
		Arrays.fill(prev, 1);
		
		for(int i = 1; i < m; ++i) {
			int temp[] = new int[n];
			
			for(int j = 0; j < n; ++j) {
				if(j == 0) temp[j] = prev[j]; 
				else temp[j] = temp[j-1] + prev[j];
			}
			
			prev = temp;
		}
		
		return prev[n-1];
	}
	
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
		
		int first = 0, second = 0, third = 0;
		
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
	
	// 7.4
	public static int ninjaTraining4(int n, int points[][]) {
		
		int prev[] = new int[4];
		
		prev[0] = Math.max(points[0][1], points[0][2]);
		prev[1] = Math.max(points[0][0], points[0][2]);
		prev[2] = Math.max(points[0][0], points[0][1]);
		prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
		
		for(int day = 1; day < n; ++day) {
			
			int temp[] = new int[4];
			
			for(int lastPicked = 0; lastPicked <= 3; ++lastPicked) {
				
				int first = 0;
				int second = 0;
				int third = 0;
				
				if(lastPicked != 0) first = prev[0] + points[day][0];
				if(lastPicked != 1) second = prev[1] + points[day][1];
				if(lastPicked != 2) third = prev[2] + points[day][2];
				
				temp[lastPicked] = Math.max(first, Math.max(second, third));
			}
			
			prev = temp;
		}
		
		return prev[3];
		
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
	public static int maximumNonAdjacentSum3(int[] nums) {
		
		int n = nums.length;
		int dp[] = new int[n];
		dp[0] = nums[0];
		
		for(int i = 1; i < n; ++i) {
            int pick = nums[i];
            if(i > 1) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
		}
		
		return dp[n - 1];
		
	}
	
	// 5.4
	public static int maximumNonAdjacentSum4(int[] nums) {
		
		int n = nums.length;
		int prev1 = nums[0];
		int prev2 = 0;
		
		for(int i = 1; i < n; ++i) {
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            
            prev2 = prev1;
            prev1 = curr;
		}
		
		return prev1;
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
	
	// 1.4 Tabulation + Space optimization.
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
