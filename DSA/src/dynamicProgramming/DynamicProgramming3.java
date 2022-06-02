package dynamicProgramming;

public class DynamicProgramming3 {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
		// 30. Minimum Insertions/Deletions to Convert String A to String B
	
	// 30.3
	public static int canYouMake3(String str, String ptr) {
		
		int dp[][] = new int[str.length() + 1][ptr.length() + 1];
		
		for(int i = 1; i <= str.length(); ++i) {
			for(int j = 1; j <= ptr.length(); ++j) {
				if(str.charAt(i - 1) == ptr.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		int lcs = dp[str.length()][ptr.length()];
		return str.length() - lcs + ptr.length() - lcs;
	}
	
	// 30.4
	public static int canYouMake4(String str, String ptr) {
		
		int prev[] = new int[ptr.length() + 1];
		
		for(int i = 1; i <= str.length(); ++i) {
			int curr[] = new int[ptr.length() + 1];
 			
			for(int j = 1; j <= ptr.length(); ++j) {
				if(str.charAt(i - 1) == ptr.charAt(j - 1)) curr[j] = 1 + prev[j - 1];
				else curr[j] = Math.max(prev[j], curr[j - 1]);
			}
			
			prev = curr;
		}
		
		int lcs = prev[ptr.length()];
		return str.length() - lcs + ptr.length() - lcs;
	}
	
	/* ------------------------------------------------------------------ */
	
				// 29. Minimum insertions to make a string palindrome
	
	// NOTE : The ans for minimum no. of deletions to make a string palindrome will also be 
	// same because if we just remove the characters which are not a part of the
	// longest palindromic subsequence we'll get the ans...
	// which is same as n-len(longest palindromic subsequence)
	
	// 29.4
	public static int minInsertion4(String s) {
		return s.length() - minInsertion4Helper(s, new StringBuilder(s).reverse().toString());
	}
	
	public static int minInsertion4Helper(String s, String t) {
		
		int sLen = s.length();
		int tLen = t.length();
		
		int prev[] = new int[tLen + 1];
		
		for(int i = 1; i <= sLen; ++i) {
			int curr[] = new int[tLen + 1];
			
			for(int j = 1; j <= tLen; ++j) {
				if(s.charAt(i - 1) == t.charAt(j - 1)) curr[j] = 1 + prev[j - 1];
				else curr[j] = Math.max(curr[j - 1], prev[j]);
			}
			
			prev = curr;
		}
		
		return prev[tLen];
	}
	
	/* ------------------------------------------------------------------ */
	
					// 28. Longest Palindromic Subsequence
	
	// 28.3
	public static int longestPalindromeSubsequence3(String s) {
		return longestPalindromeSubsequence3Helper(s, new StringBuilder(s).reverse().toString());
	}
	
	public static int longestPalindromeSubsequence3Helper(String s, String t) {
		
		int sLen = s.length();
		int tLen = t.length();
		
		int dp[][] = new int[sLen + 1][tLen + 1];
		
		for(int i = 1; i <= sLen; ++i) {
			for(int j = 1; j <= tLen; ++j) {
				if(s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
				else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		
		return dp[sLen][tLen];
	}
	
	// 28.4
	public static int longestPalindromeSubsequence4(String s) {
		return longestPalindromeSubsequence4Helper(s, new StringBuilder(s).reverse().toString());
	}
	
	public static int longestPalindromeSubsequence4Helper(String s, String t) {
		
		int sLen = s.length();
		int tLen = t.length();
		
		int prev[] = new int[tLen + 1];
		
		for(int i = 1; i <= sLen; ++i) {
			int curr[] = new int[tLen + 1];
			
			for(int j = 1; j <= tLen; ++j) {
				if(s.charAt(i - 1) == t.charAt(j - 1)) curr[j] = 1 + prev[j - 1];
				else curr[j] = Math.max(curr[j - 1], prev[j]);
			}
			
			prev = curr;
		}
		
		return prev[tLen];
	}
	
	/* ------------------------------------------------------------------ */
	
						// 27. Longest Common Substring
	
	// Feel nhi aayi
	
	// 27.3
	public static int lcSubstring3(String str1, String str2) {
		
		int s1Len = str1.length();
		int s2Len = str2.length();
		int dp[][] = new int[s1Len + 1][s2Len + 1];
		
		int ans = 0;
		
		for(int i = 1; i <= s1Len; ++i) {
			for(int j = 1; j <= s2Len; ++j) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					ans = Math.max(ans, dp[i][j]);
				} else dp[i][j] = 0;
			}
		}
		
		return ans;
	}
	
	// 27.4
	public static int lcSubstring4(String str1, String str2) {
		int s1Len = str1.length();
		int s2Len = str2.length();
		int prev[] = new int[s2Len + 1];
		
		int ans = 0;
		
		for(int i = 1; i <= s1Len; ++i) {
			int curr[] = new int[s2Len + 1];
			
			for(int j = 1; j <= s2Len; ++j) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					curr[j] = 1 + prev[j - 1];
					ans = Math.max(ans, curr[j]);
				} else curr[j] = 0;
			}
			
			prev = curr;
		}
		
		return ans;
	}
	
	/* ------------------------------------------------------------------ */
	
					// 26. Print Longest Common Subsequence
	
	// 26.3
	public static String printLCS(String s, String t) {
		
		int sLen = s.length();
		int tLen = t.length();
		
		int dp[][] = new int[sLen + 1][tLen + 1];
		
		for(int indS = 1; indS <= sLen; ++indS) {
			for(int indT = 1; indT <= tLen; ++indT) {
				if(s.charAt(indS - 1) == t.charAt(indT - 1)) 
					dp[indS][indT] = 1 + dp[indS - 1][indT - 1];
				else dp[indS][indT] = Math.max(dp[indS - 1][indT], dp[indS][indT - 1]);
			}
		}
		
		String ans = "";
		int i = sLen;
		int j = tLen;
		while(i > 0 && j > 0) {
			if(s.charAt(i - 1) == t.charAt(j - 1)) {
				ans = s.charAt(i - 1) + ans;
				--i;
				--j;
			} else if(dp[i][j - 1] > dp[i - 1][j]) --j;
			else if(dp[i][j - 1] < dp[i - 1][j]) --i;
		}
		
		return ans;
	}
	
	/* ------------------------------------------------------------------ */
	
						// 25. Longest Common Subsequence
	
	// 25.1
	public static int lcs1(String s, String t) {
		return lcs1Helper(s.length(), t.length(), s, t);
	}
	
	public static int lcs1Helper(int indS, int indT, String s, String t) {
		
		if(indS == 0 || indT == 0) return 0;
		
		if(s.charAt(indS - 1) == t.charAt(indT - 1)) return 1 + lcs1Helper(indS - 1, indT - 1, s, t);
		
		return Math.max(lcs1Helper(indS - 1, indT, s, t), lcs1Helper(indS, indT - 1, s, t));
	}
	
	// 25.2
	public static int lcs2(String s, String t) {
		Integer dp[][] = new Integer[s.length() + 1][t.length() + 1];
		return lcs2Helper(s.length(), t.length(), s, t, dp);
	}
	
	public static int lcs2Helper(int indS, int indT, String s, String t, Integer dp[][]) {
		if(indS == 0 || indT == 0) return 0;
		
		if(dp[indS][indT] != null) return dp[indS][indT];
		
		if(s.charAt(indS - 1) == t.charAt(indT - 1)) 
			return dp[indS][indT] = 1 + lcs2Helper(indS - 1, indT - 1, s, t, dp);
		
		return dp[indS][indT] = Math.max(
				lcs2Helper(indS - 1, indT, s, t, dp), lcs2Helper(indS, indT - 1, s, t, dp));
	}

	// 25.3
	public static int lcs3(String s, String t) {
		
		int sLen = s.length();
		int tLen = t.length();
		
		int dp[][] = new int[sLen + 1][tLen + 1];
		
		// Base cases, makes no use of this code.
//		for(int i = 0; i <= sLen; ++i) dp[sLen][0] = 0;
//		for(int j = 0; j <= tLen; ++j) dp[0][tLen] = 0;
		
		for(int indS = 1; indS <= sLen; ++indS) {
			for(int indT = 1; indT <= tLen; ++indT) {
				if(s.charAt(indS - 1) == t.charAt(indT - 1)) 
					dp[indS][indT] = 1 + dp[indS - 1][indT - 1];
				else dp[indS][indT] = Math.max(dp[indS - 1][indT], dp[indS][indT - 1]);
			}
		}
		
		return dp[sLen][tLen];
	}
	
	// 25.4
	public static int lcs4(String s, String t) {
		
		int sLen = s.length();
		int tLen = t.length();
		
		int prev[] = new int[tLen + 1];
		
		for(int indS = 1; indS <= sLen; ++indS) {
			int curr[] = new int[tLen + 1];
			
			for(int indT = 1; indT <= tLen; ++indT) {
				if(s.charAt(indS - 1) == t.charAt(indT - 1)) 
					curr[indT] = 1 + prev[indT - 1];
				else curr[indT] = Math.max(prev[indT], curr[indT - 1]);
			}
			
			prev = curr;
		}
		
		return prev[tLen];
	}

}
