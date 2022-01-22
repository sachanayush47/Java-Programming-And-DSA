package LeetcodeContest;

import java.util.Arrays;

public class weekly276 {

	public static void main(String[] args) {
		
	}
	
	/* ------------------------------------------------------------------ */
	
	// 2140. Solving Questions With Brainpower. DP
	public static long mostPoints(int[][] questions) {
		
		long dp[] = new long[questions.length];
		
		long max = mostPointsHelper(0, questions, dp);
		
		System.out.println(Arrays.toString(dp));
		return max;
		
	}

	public static long mostPointsHelper(int index, int[][] questions, long dp[]) {
		
		if(index >= questions.length) return 0;
		
		if(dp[index] != 0) return dp[index];
		
		long notPick = mostPointsHelper(index+1, questions, dp);
		long pick = 
				mostPointsHelper(index + questions[index][1]+1, questions, dp) + questions[index][0];
		
		return dp[index] = Math.max(pick, notPick);
		
	}
	
	/* ------------------------------------------------------------------ */
	
	// 2139. Minimum Moves to Reach Target Score. Math
	public static int minMoves(int target, int maxDoubles) {

		if(target == 1 || maxDoubles == 0) return target-1;
		
		int res = 0;
		
		while(target != 1) {
			
			if(maxDoubles == 0) {
				res += target-1;
				break;
			}
			
			if(maxDoubles > 0 && target % 2 == 0) {
				--maxDoubles;
				target = target/2;
			} else --target;
			
			++res;
			
		}
		
		return res;
	}
	
	/* ------------------------------------------------------------------ */
	
	// 2138. Divide a String Into Groups of Size k. String
	public static String[] divideString(String s, int k, char fill) {
		
		while(s.length() % k != 0) {
			s = s + fill;
		}
		
		String res[] = new String[s.length() / k];
		
		int fIndex = 0;
		int lIndex = k;
		for(int i = 0; i < res.length; ++i) {
			res[i] = s.substring(fIndex, lIndex);
			
			fIndex = lIndex;
			lIndex = lIndex + k;
		}
		
		return res;
		
	}

}
