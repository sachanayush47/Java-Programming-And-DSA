package SheetSDE;

import java.util.*;

public class Day4 {

	public static void main(String[] args) {

	}
	
	
	/* ------------------------------------------------------------------ */
	
				// Longest Substring Without Repeating Characters
	
	// Optimal : TC O(2n)		SC O(n)
	public static int lengthOfLongestSubstring2(String s) {
		
		if(s.length() == 0) return 0;
		
		Map<Character, Integer> c = new HashMap<>();
		int l = 0;
		int r = 0;
		int res = 0;
		while(r < s.length()) {
			if(c.containsKey(s.charAt(r)))
				l = Math.max(c.get(s.charAt(r)) + 1, l);
			
			c.put(s.charAt(r), r);
			res = Math.max(r - l + 1, res);
			++r;
		}
		
		return res;
	}
	
	// Better : TC O(2n)		SC O(n)
	public static int lengthOfLongestSubstring1(String s) {
		
		if(s.length() == 0) return 0;
		
		HashSet<Character> c = new HashSet<>();
		int l = 0;
		int r = 0;
		int res = 0;
		while(r < s.length()) {
			if(c.contains(s.charAt(r))) {
				c.remove(s.charAt(l));
				++l;
			} else {
				c.add(s.charAt(r));
				++r;
			}
			
			res = Math.max(c.size(), res);
		}
		
		return res;
	}
	
	
	/* ------------------------------------------------------------------ */
	
						// Longest Consecutive Sequence
	
	// Optimal : Almost O(n)
	public static int longestConsecutive2(int[] nums) {
		if (nums.length == 0) return 0;
		Set<Integer> s = new HashSet<>();

		for (int i = 0; i < nums.length; ++i) s.add(nums[i]);
		int res = 0;

		for (int i = 0; i < nums.length; ++i) {
			if (!s.contains(nums[i] - 1)) {
				int currLength = 1;
				int temp = nums[i];
				while (s.contains(temp + 1)) {
					++temp;
					++currLength;
				}

				res = Math.max(currLength, res);
			}
		}

		return res;
	}

	// Brute : O(nlogn)
	public static int longestConsecutive1(int[] nums) {
		if (nums.length == 0) return 0;

		int currLength = 1;
		int max = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == nums[i + 1])
				continue;
			else if (nums[i] == nums[i + 1] - 1)
				++currLength;
			else {
				max = Math.max(max, currLength);
				currLength = 1;
			}
		}
		max = Math.max(max, currLength);
		return max;
	}

	/* ------------------------------------------------------------------ */
	
								// Four sum

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> res = new ArrayList<>();

		if (nums.length < 4)
			return res;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; ++i) {

			for (int j = i + 1; j < nums.length - 2; ++j) {
				int left = j + 1;
				int right = nums.length - 1;

				int twoSum = nums[i] + nums[j];
				while (left < right) {

					int fourSum = nums[left] + nums[right] + twoSum;

					if (fourSum < target) {
						int tempLeft = nums[left];
						while (left < right && tempLeft == nums[left])
							++left;
					} else if (fourSum > target) {
						int tempRight = nums[right];
						while (left < right && tempRight == nums[right])
							--right;
					} else {
						List<Integer> subResult = new ArrayList<>();
						subResult.add(nums[i]);
						subResult.add(nums[j]);
						subResult.add(nums[left]);
						subResult.add(nums[right]);
						res.add(subResult);

						while (left < right && subResult.get(2) == nums[left])
							++left;
						while (left < right && subResult.get(3) == nums[right])
							--right;
					}
				}
				while (j + 1 < nums.length && nums[j] == nums[j + 1])
					++j;
			}
			while (i + 1 < nums.length && nums[i] == nums[i + 1])
				++i;
		}

		return res;
	}

	/* ------------------------------------------------------------------ */
			
								// Two sum

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int ans[] = new int[2];

		for (int i = 0; i < nums.length; ++i) {
			int num = nums[i];
			if (map.containsKey(target - num)) {
				ans[1] = i;
				ans[0] = map.get(target - num);
				System.out.println("hello");
				break;
			}
			map.put(num, i);
		}

		return ans;
	}

}
