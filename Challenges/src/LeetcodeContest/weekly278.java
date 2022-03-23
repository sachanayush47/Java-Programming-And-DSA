package LeetcodeContest;

import java.util.*;

public class weekly278 {

	public static void main(String[] args) {
		
		
		int arr[] = {8,19,4,2,15,3};
		
		System.out.println(findFinalValue(arr, 2));
	}
	
	public static int findFinalValue(int[] nums, int original) {
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length; ++i) {
			if(nums[i] == original) original = original * 2;
		}
		
		return original;
		
	}
	
	public static List<Integer> maxScoreIndices(int[] nums) {
		
		int zero = 0;
		int one = 0;
		
		for(int i = 0; i < nums.length; ++i) {
			if(nums[i] == 0) ++zero;
			else ++one;
		}

		int max = Math.max(zero, one);
		List<Integer> ans = new ArrayList<>();
		
		int l = 0;
		int r = one;
		int i = 0;
		
		while(i <= nums.length) {
			
			if(i == nums.length) {
				if(zero == max) ans.add(i);
				break;
			}
			
			if(nums[i] == 1) {
				if(l+r == max) ans.add(i);
				else if(l+r > max) {
					ans.clear();
					max = l+r;
					ans.add(i);
				}
				--r;
			} else {
				if(l+r == max) ans.add(i);
				else if(l+r > max) {
					ans.clear();
					max = l+r;
					ans.add(i);
				}
				++l;
			}
			++i;
		}
		
		return ans;
	}

}
