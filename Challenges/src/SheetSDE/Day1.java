package SheetSDE;

import java.util.*;

public class Day1 {

	public static void main(String[] args) {
		System.out.println(generate(2));
	}
	
	/* ------------------------------------------------------------------ */
	
						//	Sort an array of 0’s 1’s 2’s
	
	public static void sortColors(int[] nums) {
		
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;
		
		while(mid <= high) {
			if(nums[mid] == 0) {
				swapArr(nums, low, mid);
				++low;
				++mid;
			} else if(nums[mid] == 2) {
				swapArr(nums, mid, high);
				--high;
			} else ++mid;
		}
		
	}
	
	/* ------------------------------------------------------------------ */
	
							//	Stock buy and Sell

	public static int maxProfit(int[] prices) {
		
		int maxProfit = 0;
		int buyDay = prices[0];
		
		for(int i = 1; i < prices.length; ++i) {
			maxProfit = Math.max(maxProfit, prices[i] - buyDay);
			buyDay = Math.min(buyDay, prices[i]);
		}
		
		return maxProfit;
	}
	
	/* ------------------------------------------------------------------ */
	
							//	Pascal’s Triangle
	// My
	public static List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> res = new ArrayList<>();
		for(int i = 0; i < numRows; ++i) res.add(new ArrayList<>());
		res.get(0).add(1);
		
		for(int i = 0; i < numRows - 1; ++i) {
			
			List<Integer> next = res.get(i + 1);
			List<Integer> curr = res.get(i);
			
			if(i == 0) {
				next.add(1);
				next.add(1);
			} else {
				next.add(1);
				for(int j = 0; j < curr.size() - 1; ++j)
					res.get(i + 1).add(curr.get(j) + curr.get(j + 1));
				next.add(1);
			}
		}
		
		return res;
	}
	
	/* ------------------------------------------------------------------ */
	
							//	Kadane’s Algorithm

	// Optimal : Kadane's Algorithm					O(n)
	public static int maxSubArray1(int[] nums) {
		
		int currSum = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < nums.length; ++i) {
			currSum += nums[i];
			max = Math.max(max, currSum);
			if(currSum < 0) currSum = 0;
		}
		
		return max;
	}
	
	// Better : My									O(n^2)										
	public static int maxSubArray(int[] nums) {
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < nums.length; ++i) {
			int sum = 0;
			for(int j = i; j < nums.length; ++j) {
				sum += nums[j];
				System.out.println(sum);
				max = Math.max(max, sum);
			}
		}
		
		return max;
	}
	
	/* ------------------------------------------------------------------ */
	
							//	Next Permutation
	
	// Optimal
	public static void nextPermutation(int[] nums) {
		
		int n = nums.length;
		if(n == 1) return;
		
		int k = -1;
		for(int i = n - 2; i >= 0; --i) {
			if(nums[i] < nums[i + 1]) {
				k = i;
				break;
			}
		}
		
		if(k == -1) {
			reverseSubarray(nums, 0, n - 1);
			return;
		}
		
		for(int i = n - 1; i >= 0; --i) {
			if(nums[i] > nums[k]) {
				swapArr(nums, i, k);
				break;
			}
		}
		
		
		int j = n - 1;
		reverseSubarray(nums, k + 1, j);
 		
	}
	
	public static void reverseSubarray(int arr[], int i, int j) {
		while(i < j) {
			swapArr(arr, i, j);
			++i;
			--j;
		}
	}
	
	public static void swapArr(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/* ------------------------------------------------------------------ */
	
							//	Set Matrix Zeroes
	
	// Brute : works only if matrix[i][j] >= 0. 
	public static void setZeroes1(int[][] matrix) {
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				if(matrix[i][j] == 0) {
					for(int p = 0; p < matrix.length; ++p) 
						if(matrix[p][j] != 0) matrix[p][j] = -1;
					for(int p = 0; p < matrix[0].length; ++p) 
						if(matrix[i][p] != 0) matrix[i][p] = -1;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				if(matrix[i][j] == -1) matrix[i][j] = 0;
			}
		}
	}
	
	// Better
	public static void setZeroes2(int[][] matrix) {
		
		int row[] = new int[matrix[0].length];
		int col[] = new int[matrix.length];
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				if(matrix[i][j] == 0) row[j] = col[i] = -1;
			}
		}
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				if(row[j] == -1 || col[i] == -1) matrix[i][j] = 0;
			}
		}
	}
	
	// Optimal
	public static void setZeroes3(int[][] matrix) {
		
		int col0 = 1;
		
		for(int i = 0; i < matrix.length; ++i) {
			if(matrix[i][0] == 0) col0 = 0;
			for(int j = 1; j < matrix[0].length; ++j) {
				if(matrix[i][j] == 0) matrix[0][j] = matrix[i][0] = 0;
			}
		}
		
		for(int i = matrix.length - 1; i >= 0; --i) {
			for(int j = matrix[0].length - 1; j >= 1; --j)
				if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
			
			if(col0 == 0) matrix[i][0] = 0;
		}
		
	}
	
	
	// My
	public static void setZeroes(int[][] matrix) {
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < matrix.length; ++i) {
			map.putIfAbsent(i, new ArrayList<>());
			for(int j = 0; j < matrix[0].length; ++j) if(matrix[i][j] == 0) map.get(i).add(j);
		}
		
		for(int i = 0; i < matrix.length; ++i) {
			ArrayList<Integer> curr = map.get(i);
			for(int j = 0; j < curr.size(); ++j) setZeroesHelper(i, curr.get(j), matrix);
		}
		
	}
	
	public static void setZeroesHelper(int i, int j, int[][] matrix) {
		for(int p = 0; p < matrix.length; ++p) matrix[p][j] = 0;
		for(int p = 0; p < matrix[0].length; ++p) matrix[i][p] = 0;
	}

}
