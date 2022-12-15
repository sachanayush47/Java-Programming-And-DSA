package dynamicProgramming;

import java.util.*;

public class PracticeDP1 {

	public static void main(String[] args) {


		System.out.println(numDecodings3("226"));
		
	}
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	// Memoization
	public static int numDecodings2(String s) {
		int dp[] = new int[s.length()];
		Arrays.fill(dp, -1);
		return numDecodingsHelper2(0, s, dp);
	}
	
	public static int numDecodingsHelper2(int i, String s, int dp[]) {
		int len = s.length();
		
		if(i == len) return 1;
		
		if(dp[i] != -1) return dp[i];
		
		int totalWays = 0;
		
		if(s.charAt(i) != '0') {
			totalWays += numDecodingsHelper2(i + 1, s, dp);
		}
		
		if(i + 1 < len && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
			totalWays += numDecodingsHelper2(i + 2, s, dp);
		}
		
		return dp[i] = totalWays;
	}
	
	// Tabulation
	public static int numDecodings3(String s) {
		int len = s.length();
		
		int dp[] = new int[len + 1];
		dp[len] = 1;
		
		for(int i = len - 1; i >= 0; --i) {
			int totalWays = 0;
			
			if(s.charAt(i) != '0')
				totalWays += dp[i + 1];
			
			if(i + 1 < len && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
				totalWays += dp[i + 2];
			
			dp[i] = totalWays;
		}
		
		return dp[0];
	}
	
	// Space optimization
	public static int numDecodings4(String s) {
		int len = s.length();
		
		int dp[] = new int[len + 1];
		dp[len] = 1;
		
		int next1 = 1;
		int next2 = 0;
		
		for(int i = len - 1; i >= 0; --i) {
			int totalWays = 0;
			
			if(s.charAt(i) != '0')
				totalWays += next1;
			
			if(i + 1 < len && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
				totalWays += next2;
			
			next2 = next1;
			next1 = totalWays;
		}
		
		return next1;
	}
	
	

}
