package LeetcodeContest;

import java.util.*;

public class weekly277 {

	public static void main(String[] args) {

		
	}
	
	// 2150. Find All Lonely Numbers in the Array
	public static List<Integer> findLonely(int[] nums) {
		
		List<Integer> res = new ArrayList<>();
		
		HashMap<Integer, Integer> freq = new HashMap<>();
		
		for(int i = 0; i < nums.length; ++i) {
			int num = nums[i];
			
			if(freq.containsKey(num)) freq.put(num, freq.get(num)+1);
			else freq.put(num, 1);
		}
		
		for(int i = 0; i < nums.length; ++i) {
			
			int num = nums[i];
			
			if(freq.get(num) >= 2 || freq.containsKey(num-1) || freq.containsKey(num+1)) {	}
			else res.add(num);
		}
		
		return res;
	}
	
	// 2149. Rearrange Array Elements by Sign
	public static int[] rearrangeArray(int[] nums) {
		
		int res[] = new int[nums.length];
		
		int p = 0;
		int n = 1;
		
		for(int i = 0; i < nums.length; ++i) {
			
			if(nums[i] >= 0) {
				res[p] = nums[i];
				p += 2;
			} else if(nums[i] < 0) {
				res[n] = nums[i];
				n += 2;
			}
		}
		
		return res;
	}
	
	// 2148. Count Elements With Strictly Smaller and Greater Elements
	public static int countElements(int[] nums) {
		
		int res = 0;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < nums.length; ++i) {
			
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
			
		}
		
		for(int i = 0; i < nums.length; ++i) {
			
			if(nums[i] == min || nums[i] == max) continue;
			else ++res;
		}

		return res;
	}
	
	
	

}
