package sorting;

import java.util.*;

@SuppressWarnings("unused")
public class SortingProblems {

	public static void main(String[] args) {
		
		
	}
	
	public static int[] sortedSquares(int[] A) {
    // https://leetcode.com/problems/squares-of-a-sorted-array/
	// Best solution from leetcode discussion, not mine. O(N)
		
		int n = A.length;
		int[] result = new int[n];
	    int i = 0, j = n - 1;
		for(int p = n - 1; p >= 0; p--) {
			if(Math.abs(A[i]) > Math.abs(A[j])) {
				result[p] = A[i] * A[i];
				i++;
			} else {
				result[p] = A[j] * A[j];
				j--;
			}
		}
		return result;
		
		
	// My solution, O(NlogN)
	//        for(int i = 0; i < nums.length; ++i) {
	//        	nums[i] = nums[i] * nums[i];
	//        }
	//        Arrays.sort(nums);
	//        return nums;
	}
	
}
