package LeetcodeContest;

import java.util.*;

public class weekly280 {

	public static void main(String[] args) {
		
		int arr[] = {4,1,6,5};
		System.out.println(minimumRemoval(arr));
	}
	
	// 2171
	public static long minimumRemoval(int[] beans) {
		
		long N = beans.length;
        long ans = Long.MAX_VALUE;
        long sum = 0;
        for(int i = 0; i < N; ++i) sum += beans[i];
        Arrays.sort(beans);
        
        for(int i = 0; i < N; ++i) {
        	ans = Math.min(ans, sum - beans[i] * (N - i));
        }
        
        return ans;
    }
	
	// 2170
	public static int minimumOperations(int[] nums) {
		
		Map<Integer, Integer> evenFreq = new HashMap<>();
		Map<Integer, Integer> oddFreq = new HashMap<>();
		
		for(int i = 0; i < nums.length; ++i) {
			if(i % 2 == 0) {
				if(evenFreq.containsKey(nums[i])) {
					evenFreq.put(nums[i], evenFreq.get(nums[i]) + 1);
				}
				else evenFreq.put(nums[i], 1);
			} else {
				if(oddFreq.containsKey(nums[i])) oddFreq.put(nums[i], oddFreq.get(nums[i]) + 1);
				else oddFreq.put(nums[i], 1);
			}
		}
		
		int firstNumEven = 0, firstNumEvenFreq = 0;
		int firstNumOdd = 0, firstNumOddFreq = 0;
		int secNumEvenFreq = 0, secNumOddFreq = 0;
		
		for(Integer i : evenFreq.keySet()) {
			if(evenFreq.get(i) > firstNumEvenFreq) {
				firstNumEven = i;
				firstNumEvenFreq = evenFreq.get(i);
			}
		}
		
		for(Integer i : oddFreq.keySet()) {
			if(oddFreq.get(i) > firstNumOddFreq) {
				firstNumOdd = i;
				firstNumOddFreq = oddFreq.get(i);
			}
		}
		
		int ans;
		if(firstNumEven != firstNumOdd) {
			ans = nums.length - firstNumEvenFreq - firstNumOddFreq;
		} else {
			for(Integer i : evenFreq.keySet()) {
				if(evenFreq.get(i) > secNumEvenFreq && firstNumEven != i)
					secNumEvenFreq = evenFreq.get(i);
			}
			
			for(Integer i : oddFreq.keySet()) {
				if(oddFreq.get(i) > secNumOddFreq && firstNumOdd != i)
					secNumOddFreq = oddFreq.get(i);
			}
			
			int l = nums.length;
			ans = Math.min(l-firstNumEvenFreq-secNumOddFreq, l-secNumEvenFreq-firstNumOddFreq);
		}
		
		return ans;
	}
	
	// 2169
	public static int countOperations(int num1, int num2) {
		
		int res = 0;
		while(num1 != 0 && num2 != 0) {
			
			if(num1 >= num2) num1 = num1 - num2;
			else num2 = num2 - num1;
			++res;
		}
		
		
		return res;
	}

}
