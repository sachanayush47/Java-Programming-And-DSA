package LeetcodeContest;

import java.util.*;

public class weekly281 {

	public static void main(String[] args) {
		int arr[] = {3,2,6,1,8,4,1};
		System.out.println(coutPairs(arr, 3));
	}
	
	public static long coutPairs(int[] nums, int k) {
		
		int countk = 0;
		long res = 0;
		for(int i = 0; i < nums.length; ++i) {
			if(nums[i] % k == 0) {
				res += nums.length - 1 - countk;
				++countk;
			}
		}
		
		return res;
	}
	
	
	public static String repeatLimitedString(String s, int repeatLimit) {
		
		StringBuilder res = new StringBuilder();
		Map<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());
		
		for(int i = 0; i < s.length(); ++i) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		
		//boolean isChange = false;
		while(true) {
			for(Character c : map.keySet()) {
				if(map.get(c) <= repeatLimit) {
					for(int i = 0; i < map.get(c); ++i) res.append(c);
					map.remove(c);
				} else {
					for(int i = 0; i < map.get(c); ++i) res.append(c);
					map.put(c, map.get(c)-repeatLimit);
				}
			}
			
			
		}
		
		
	}
	
	public static ListNode mergeNodes(ListNode head) {
		
		ListNode res = null;
		ListNode tail = res;
		int sum = 0;
		while(head != null) {
			if(head.val == 0 && sum != 0) {
				if(res == null) {
					res = new ListNode(sum);
					tail = res;
				} else {
					tail.next = new ListNode(sum);
					tail = tail.next;
				}
				sum = 0;
			} else sum += head.val;
			
			head = head.next;
		}
		
		return res;
		
	}
	
	public static int countEven(int n) {
		
		int res = 0;
		for(int i = 2; i <= n; ++i) {
			if(getSum(i) % 2 == 0) ++res;
		}
		
		return res;
		
	}
	
	static int getSum(int n) {   
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n/10;
        }
     
        return sum;
    }
	
	static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

}
