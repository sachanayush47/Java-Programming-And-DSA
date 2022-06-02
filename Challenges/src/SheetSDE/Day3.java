package SheetSDE;

import java.util.*;

public class Day3 {

	public static void main(String[] args) {

	}

	/* ------------------------------------------------------------------ */

							// Reverse Pairs (Leetcode)

	/* ------------------------------------------------------------------ */

								// Grid Unique Paths

	// Memoziation solution
	public static int uniquePaths1(int m, int n) {
		Integer dp[][] = new Integer[m][n];
		return uniquePathsHelper1(m - 1, n - 1, dp);
	}

	public static int uniquePathsHelper1(int m, int n, Integer dp[][]) {

		if (m < 0 || n < 0)
			return 0;
		if (m == 0 && n == 0)
			return 1;

		if (dp[m][n] != null)
			return dp[m][n];

		int up = uniquePathsHelper1(m - 1, n, dp);
		int down = uniquePathsHelper1(m, n - 1, dp);

		return dp[m][n] = up + down;
	}

	// Tabulation solution
	public static int uniquePaths2(int m, int n) {

		int prev[] = new int[n];
		for (int j = 0; j < n; ++j)
			prev[j] = 1;

		for (int i = 1; i < m; ++i) {
			int curr[] = new int[n];

			for (int j = 0; j < n; ++j) {
				int up = prev[j];
				int down = 0;
				if (j > 0)
					down = curr[j - 1];

				curr[j] = up + down;
			}
			prev = curr;
		}

		return prev[n - 1];
	}

	/* ------------------------------------------------------------------ */

						// Majority Element (>N/3 times)

	// Optimal								TC : O(n) + O(n)	SC : O(1)
	public List<Integer> majorityElementII(int[] nums) {
		int num1 = -1, count1 = 0, num2 = -1, count2 = 0;

		for (int i = 0; i < nums.length; ++i) {
			if (num1 == nums[i])
				++count1;
			else if (num2 == nums[i])
				++count2;
			else if (count1 == 0) {
				num1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				num2 = nums[i];
				count2 = 1;
			} else {
				--count1;
				--count2;
			}
		}

		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == num1)
				++count1;
			if (nums[i] == num2)
				++count2;
		}

		List<Integer> ans = new ArrayList<>();

		if ((double) (nums.length / 3) < count1)
			ans.add(num1);
		if ((double) (nums.length / 3) < count2)
			ans.add(num2);

		return ans;
	}

	/* ------------------------------------------------------------------ */

						// Majority Element (>N/2 times)

	// Optimal								TC : O(n)		SC : O(1)
	public static int majorityElement(int[] nums) {

		int ans = nums[0];
		int count = 1;

		for (int i = 1; i < nums.length; ++i) {
			if (ans == nums[i])
				++count;
			else {
				--count;
				if (count == 0) {
					ans = nums[i];
					count = 1;
				}
			}
		}

		return ans;
	}

	/* ------------------------------------------------------------------ */

									// Pow(x, n)

	// Optimal : Leetcode not accepting			TC : O(log(n))		SC : O(1)
	public double myPow(double x, int n) {

		double ans = 1;
		int nn = Math.abs(n);

		while (nn > 0) {
			if (nn % 2 == 1) {
				ans = ans * x;
				--nn;
			} else {
				x = x * x;
				nn = nn / 2;
			}
		}

		if (n < 0)
			ans = (double) 1.0 / (double) ans;
		return ans;
	}

	/* ------------------------------------------------------------------ */

							// Search a 2D Matrix

	// Optimal							TC : O(log(n*m))		SC : O(1)
	public boolean searchMatrix2(int[][] matrix, int target) {

		int r = matrix.length;
		int c = matrix[0].length;

		int low = 0;
		int high = r * c - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			int eleRow = mid / c;
			int eleCol = mid % c;

			if (matrix[eleRow][eleCol] == target)
				return true;
			else if (matrix[eleRow][eleCol] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}

		return false;
	}

	// Better								TC : O(n + logm)	SC : O(1)
	public boolean searchMatrix1(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; ++i) {
			if (matrix[i][0] <= target && target <= matrix[i][matrix[0].length - 1]) {
				int low = 0;
				int high = matrix[0].length;

				while (low <= high) {
					int mid = (low + high) / 2;

					if (matrix[i][mid] == target)
						return true;
					else if (matrix[i][mid] < target)
						low = mid + 1;
					else
						high = mid - 1;
				}

				break;
			}
		}

		return false;
	}

}
