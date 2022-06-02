package SheetSDE;

import java.util.*;

public class Day2 {

	public static void main(String[] args) {
		
	}
	
	/* ------------------------------------------------------------------ */
	
								//	Count Inversions
	
	// Optimal
	public static long getInversions2(long arr[], int n) {
		return 0;
	}
	
	// Brute								TC : O(n^2)		SC : O(1);
	public static long getInversions1(long arr[], int n) {
		
		int countInversions = 0;
		for(int i = 0; i < n - 1; ++i)
			for(int j = i + 1; j < n; ++j)
				if(arr[i] > arr[j]) ++countInversions;
		
		return countInversions;
	}
	
	/* ------------------------------------------------------------------ */
	
						//	Missing and repeating numbers
	
	// Optimal : Does not work for very big value of N because of integer overflow.
	// There is one more optimal approach that uses bit manipulation.
	public static Pair<Integer, Integer> missingAndRepeating2(ArrayList<Integer> arr, int n) {
		
		int s = n * (n + 1) / 2;
		int s2 = n * (n + 1) * (2 * n + 1) / 6;
		
		int actualSum = 0;
		int actualSum2 = 0;
		for(int i = 0; i < n; ++i) {
			actualSum += arr.get(i);
			actualSum2 += arr.get(i) * arr.get(i);
		}
		
		int num1 = s - actualSum;
		int num2 = s2 - actualSum2;
		
		int newEquation = num2/num1;
		
		int missing = (newEquation + num1) / 2;
		int repeating = newEquation - missing;
		
		return new Pair<Integer, Integer>(missing, repeating);
	}
	
	// Better									TC : O(n)	SC : O(n)
	public static Pair<Integer, Integer> missingAndRepeating1(ArrayList<Integer> arr, int n) {
		
		Integer missing = null;
		Integer repeating = null;
		
		int freqArr[] = new int[n + 1];
		
		for(int i = 0; i < arr.size(); ++i) ++freqArr[arr.get(i)];
		
		for(int i = 1; i <= n; ++i) {
			if(freqArr[i] == 0) missing = i;
			if(freqArr[i] > 1) repeating = i;
		}
		
		return new Pair<Integer, Integer>(missing, repeating);
	}
	
	static class Pair<E, F> {
		E obj1;
		F obj2;
		
		Pair(E obj1, F obj2) {
			this.obj1 = obj1;
			this.obj2 = obj2;
		}
	}
	
	/* ------------------------------------------------------------------ */
	
						//	Find the Duplicate Number
	
	// Optimal : Samajh nhi aaya				TC : O(n)	SC : O(1)
	public static int findDuplicate3(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while(slow != fast);
		
		fast = nums[0];
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return slow;
	}
	
	// Better
	public static int findDuplicate2(int[] nums) {
		
		int freqArr[] = new int[nums.length + 1];
		
		int i;
		for(i = 0; i < nums.length; ++i) {
			if(freqArr[nums[i]] == 0) ++freqArr[nums[i]];
			else break;
		}
		
		return nums[i];
	}
	
	// Brute									TC : O(nlogn)	SC : O(1)
	public static int findDuplicate1(int[] nums) {
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 1; ++i) {
			if(nums[i] == nums[i + 1]) return nums[i];
		}
		
		return 0;
	}
	
	
	/* ------------------------------------------------------------------ */
	
				//	Merge two sorted Arrays without extra space
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
		int ind1 = m - 1;
		int ind2 = n - 1;
		
		int i = m + n - 1;
		
		while(ind1 > -1 && ind2 > -1) {
			if(nums1[ind1] > nums2[ind2]) nums1[i--] = nums1[ind1--];
			else nums1[i--] = nums2[ind2--];
		}
		
		if(ind2 > -1) while(ind2 > -1) nums1[i--] = nums2[ind2--];
    }
	
	/* ------------------------------------------------------------------ */
	
	public static int[][] merge(int[][] intervals) {
		
						//	Merge Overlapping Subintervals
		
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		List<int[]> res = new ArrayList<>();
		
		for(int i = 1; i < intervals.length; ++i) {
			if(intervals[i][0] <= end) end = Math.max(intervals[i][1], end);
			else {
				res.add(new int[]{start, end});
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		
		res.add(new int[]{start, end});
		
		return res.toArray(new int[res.size()][2]);
	}
	
	/* ------------------------------------------------------------------ */
	
								//	Rotate Matrix
	
	public static void rotate(int[][] matrix) {
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = i; j < matrix[0].length; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for(int i = 0; i < matrix.length; ++i) {
			int f = 0;
			int r = matrix[0].length - 1;
			while(f <= r) {
				int temp = matrix[i][f];
				matrix[i][f] = matrix[i][r];
				matrix[i][r] = temp;
				--r;
				++f;
			}
		}
	}

}
