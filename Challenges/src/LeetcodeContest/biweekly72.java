package LeetcodeContest;
import java.util.*;
public class biweekly72 {

	public static void main(String[] args) {
		
		System.out.println(maximumEvenSplit(34));
		
	}
	
	public static List<Long> maximumEvenSplit(long finalSum) {
		
		List<Long> res = new ArrayList<>();
		if(finalSum % 2 != 0) return res;
		
		int i = 2;
		while(finalSum > 0) {
			finalSum -= i;
			res.add((long)i);
			i += 2;
		}
		
		if(finalSum == 0) return res;
		
		finalSum = Math.abs(finalSum);
		for(i = 0; i < res.size(); ++i) {
			if(finalSum == res.get(i)) {
				res.remove(i);
				break;
			}
		}
		
		return res;
	}

	
	public static long[] sumOfThree(long num) {
		if((num % 3) != 0) return new long[0];

		long temp = num/3;
		long res[] = new long[3];
		
		res[0] = temp-1;
		res[1] = temp;
		res[2] = temp+1;
		
		return res;
		
	}
	
	public static int countPairs(int[] nums, int k) {
		
		int res = 0;
		
		for(int i = 0; i < nums.length; ++i) {
			for(int j = i+1; j < nums.length; ++j) {
				if(nums[i] == nums[j]) {
					if((i * j) % k == 0) ++res;
				}
			}
		}
		
		return res;
	}

}
