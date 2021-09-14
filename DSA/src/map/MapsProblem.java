package map;

import java.util.*;

@SuppressWarnings("unused")
public class MapsProblem {

	public static void main(String[] args) {
		
		
		
		
	}
	
	public int numIdenticalPairs(int[] nums) {
	    // https://leetcode.com/problems/number-of-good-pairs. 67.5% faster.
	        int ans = 0;
	        for(int i = 0; i < nums.length; ++i) {
	            for(int j = i+1; j < nums.length; ++j) {
	                if(nums[i] == nums[j]) ++ans;
	            }
	        }
	        return ans;
	    
			/* 100% faster solution
			 * HashMap<Integer,Integer> map=new HashMap<>();
			 * for(int i=0; i<nums.length; i++) {
			 * 		map.put(nums[i],map.getOrDefault(nums[i],0)+1);
			 * }
			 * int tot_count=0;
			 * Set<Integer> seen=map.keySet();
			 * for(int i: map.keySet()) {
			 * 		Integer val=map.get(i);
			 * 		if(val>1) {
			 * 		tot_count += val*(val-1)/2; }
			 * }
			 * return tot_count;
			 * 
			 */
	}
	
	public static int[] smallerNumbersThanCurrent(int[] nums) {
	// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
	// Not my solution.
	        int[] copy = nums;
	        Arrays.sort(copy);
	        Map<Integer, Integer> memo = new HashMap<>();
	        
	        for (int length = copy.length - 1; length >= 0; length--){
	            memo.put(copy[length], length);
	        }
	        int index = 0;
	        for (int num : nums){
	            nums[index] = memo.get(nums[index]);
	            index++;
	        }
	        return nums;
	    }

}
