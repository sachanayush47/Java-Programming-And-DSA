package binarySearch;

import arrays.ArraysProblem;

@SuppressWarnings("unused")
public class BinarySearchProblems {

	public static void main(String[] args) {
		
		
		
	}
	
	/* ----------------------------------------------
	 * public class Solution extends VersionControl {
	 * https://leetcode.com/problems/first-bad-version/#
	 * 		public int firstBadVersion(int n) {
	 * 
	 * 
	 * 			int low = 0;
	 * 			int high = n -1;
	 * 			while(low <= high) {
	 * 				int mid = low + (high -low)/2;
	 * 				if(isBadVersion(mid) == false) {
	 * 					low = mid+1;
	 * 				} if(isBadVersion(mid) == true) {
	 * 					high = mid-1;
	 * 				}
	 * 			}
	 * 			return high+1;
	 * 		}
	 * }
	 * 
	 */

	
	
	public int findMin(int[] arr) {
	// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/   
        int low = 0;
        int high = arr.length - 1;    
        
        while(low < high) {
            int mid = low + (high-low)/2;
            
            if(arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }            
        }       
        return arr[low];      
    }
	
	public static int searchInsert(int[] arr, int target) {
	// https://leetcode.com/problems/search-insert-position/      
	        int low = 0;
	        int high = arr.length - 1;
	                
	        while(low <= high) {
	            int mid = low + (high - low)/2;
	            
	            if(arr[mid] == target) {
	                return mid;
	            } else if(arr[mid] > target) {
	                high = mid - 1;              
	            } else {
	                low = mid + 1;                
	            }	                
	        }
	        return low;
	 }
	 
	 public static int countNegatives(int[][] grid) {
	 // https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix	        
	        int ans = 0;
	        for(int i = 0; i < grid.length; ++i) {
	            for(int j = grid[0].length-1; j >= 0; --j) {
	                if(grid[i][j] < 0) ++ans;
	                if(j > 0) {
	                    if(grid[i][j-1] > -1) break;
	                }
	            }
	        }
	        return ans;
	 }
}


class Pair {
	int index;
	int soldier;
	
	Pair(int index, int soldier) {
		this.index = index;
		this.soldier = soldier;
	}
}
