package dynamicProgramming;

import java.util.Arrays;

public class DynamicProgramming3 {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
							// 34 Wildcard matching.
	
	// 34.1
	public static boolean isMatch1(String s, String p) {
        
        int l1 = s.length();
        int l2 = p.length();
        
        return isMatchHelper1(l1 - 1, l2 - 1, s, p);
        
    }
    
    public static boolean isMatchHelper1(int i, int j, String s, String p) {
        
        if(i < 0 && j < 0) return true;
        if(j < 0) return false;
        if(i < 0) {
            while(j >= 0) {
                if(p.charAt(j) != '*') return false;
                --j;
            }
            
            return true;
        }
        
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return isMatchHelper1(i - 1, j - 1, s, p);
        }
        
        if(p.charAt(j) == '*') {
            boolean match = isMatchHelper1(i - 1, j, s, p);
            boolean notMatch = isMatchHelper1(i, j - 1, s, p);
            
            return match || notMatch;
        }
        
        return false;
    }
	
    // 34.2
	public static boolean isMatch2(String s, String p) {
        
        int l1 = s.length();
        int l2 = p.length();
        
        int dp[][] = new int[l1][l2];
        for(int it[] : dp) {
            Arrays.fill(it, -1);
        }
        
        return isMatchHelper2(l1 - 1, l2 - 1, s, p, dp);
    }
    
    public static boolean isMatchHelper2(int i, int j, String s, String p, int dp[][]) {
        
        if(i < 0 && j < 0) return true;
        if(j < 0) return false;
        if(i < 0) {
            while(j >= 0) {
                if(p.charAt(j) != '*') return false;
                --j;
            }
            
            return true;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }
        
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = isMatchHelper2(i - 1, j - 1, s, p, dp) ? 1 : 0;
            return dp[i][j] == 1 ? true : false;
        }
        
        if(p.charAt(j) == '*') {
            boolean match = isMatchHelper2(i - 1, j, s, p, dp);
            boolean notMatch = isMatchHelper2(i, j - 1, s, p, dp);
            
            dp[i][j] = match || notMatch ? 1 : 0;
            return dp[i][j] == 1 ? true : false;
        }
        
        dp[i][j] = 0;
        return false;
    }
    
    // 33.3
    public static boolean isMatch3(String s, String p) {
        
        int l1 = s.length();
        int l2 = p.length();
        
        int dp[][] = new int[l1 + 1][l2 + 1];
        
        dp[0][0] = 1;
        
        // Useless
        // for(int i = 0; i <= l1; ++i) {
        //     dp[i][0] = 0;
        // }
        
        for(int i = 0; i <= l2; ++i) {
            
            dp[0][i] = 1;
            
            for(int j = i; j >= 1; --j) {
                if(p.charAt(j - 1) != '*') {
                    dp[0][i] = 0;
                    break;
                }
            }    
        }
        
        for(int i = 1; i <= l1; ++i) {
            for(int j = 1; j <= l2; ++j) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1] == 1 ? 1 : 0;
                } else if(p.charAt(j - 1) == '*') {
                    int match = dp[i - 1][j];
                    int notMatch = dp[i][j - 1];
            
                    dp[i][j] = (match == 1 || notMatch == 1) ? 1 : 0;
                } else dp[i][j] = 0;
            }
        }
        
        
        return dp[l1][l2] == 1 ? true : false;
    }
    
    // 34.4
    public static boolean isMatch4(String s, String p) {
        
        int l1 = s.length();
        int l2 = p.length();
        
        int prev[] = new int[l2 + 1];
        
        prev[0] = 1;
        
        // Useless
        // for(int i = 0; i <= l1; ++i) {
        //     dp[i][0] = 0;
        // }
        
        for(int i = 0; i <= l2; ++i) {
            
            prev[i] = 1;
            
            for(int j = i; j >= 1; --j) {
                if(p.charAt(j - 1) != '*') {
                    prev[i] = 0;
                    break;
                }
            }    
        }
        
        for(int i = 1; i <= l1; ++i) {
            
            int curr[] = new int[l2 + 1];
            
            for(int j = 1; j <= l2; ++j) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1] == 1 ? 1 : 0;
                } else if(p.charAt(j - 1) == '*') {
                    int match = prev[j];
                    int notMatch = curr[j - 1];
            
                    curr[j] = (match == 1 || notMatch == 1) ? 1 : 0;
                } else curr[j] = 0;
            }
            
            prev = curr;
        }
        
        return prev[l2] == 1 ? true : false;
    }
	
	/* ------------------------------------------------------------------ */
	
							// 33. Edit Distance
	
	// 33.2
	public static int minDistance2(String word1, String word2) {
        
        int l1 = word1.length();
        int l2 = word2.length();
        
        int dp[][] = new int[l1][l2];
        
        for(int it[] : dp) {
            Arrays.fill(it, -1);
        }
        
        return minDistanceHelper2(l1 - 1, l2 - 1, word1, word2, dp);
    }
    
    public static int minDistanceHelper2(int i, int j, String word1, String word2, int dp[][]) {
        
        if(i < 0) return j + 1;        
        if(j < 0) return i + 1;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 0 + minDistanceHelper2(i - 1, j - 1, word1, word2, dp);
        }
        
        int insert = 1 + minDistanceHelper2(i, j - 1, word1, word2, dp);
        int delete = 1 + minDistanceHelper2(i - 1, j, word1, word2, dp);
        int replace = 1 + minDistanceHelper2(i - 1, j - 1, word1, word2, dp);
        
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    
    // 33.3
    public static int minDistance(String word1, String word2) {
        
        int l1 = word1.length();
        int l2 = word2.length();
        
        int dp[][] = new int[l1 + 1][l2 + 2];
        
        for(int j = 0; j <= l2; ++j) dp[0][j] = j;
        for(int i = 0; i <= l1; ++i) dp[i][0] = i;
        
        for(int i = 1; i <= l1; ++i) {
            for(int j = 1; j <= l2; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 0 + dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
        
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        
        return dp[l1][l2];
    }
    
    // 33.4
    public static int minDistance4(String word1, String word2) {
        
        int l1 = word1.length();
        int l2 = word2.length();
        
        int prev[] = new int[l2 + 1];
        
        for(int j = 0; j <= l2; ++j) prev[j] = j;
        
        for(int i = 1; i <= l1; ++i) {
            
            int curr[] = new int[l2 + 1];
            curr[0] = i;
            for(int j = 1; j <= l2; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = 0 + prev[j - 1];
                } else {
                    int insert = 1 + curr[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];
        
                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            
            prev = curr;
        }
        
        return prev[l2];
    }
	
	/* ------------------------------------------------------------------ */
	
							// 32. Distinct Subsequences
	
	// 32.2
	public int numDistinct2(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        
        int dp[][] = new int[l1][l2];
        
        for(int it[] : dp) {
            Arrays.fill(it, -1);
        }
        
        return numDistinctHelper2(s, t, l1 - 1, l2 - 1, dp);
    }
    
    public int numDistinctHelper2(String s, String t, int i, int j, int dp[][]) {

        if(j < 0) return 1;
        if(i < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)) {
            int pick = numDistinctHelper2(s, t, i - 1, j - 1, dp);
            int notPick = numDistinctHelper2(s, t, i - 1, j, dp);
            return dp[i][j] = pick + notPick;
        } else {
            return dp[i][j] = numDistinctHelper2(s, t, i - 1, j, dp);
        }
    }
	
	// 32.3
	public static int numDistinct3(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        
        int dp[][] = new int[l1 + 1][l2 + 1];
        
        for(int i = 0; i <= l1; ++i) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= l1; ++i) {
            for(int j = 1; j <= l2; ++j) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    int pick = dp[i - 1][j - 1];
                    int notPick = dp[i - 1][j];
                    dp[i][j] = pick + notPick;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[l1][l2];
    }
	
	// 32.4
	public static int numDistinct4(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        
        int prev[] = new int[l2 + 1];
        
        prev[0] = 1;
        
        for(int i = 1; i <= l1; ++i) {
            
            int curr[] = new int[l2 + 1];
            curr[0] = 1;
            for(int j = 1; j <= l2; ++j) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    int pick = prev[j - 1];
                    int notPick = prev[j];
                    curr[j] = pick + notPick;
                } else {
                    curr[j] = prev[j];
                }
            }
            
            prev = curr;
        }
        
        return prev[l2];
    }
	
	/* ------------------------------------------------------------------ */
	
						// 31. Shortest commom supersequence.
	
	public static String shortestCommonSupersequence(String str1, String str2) {
        
        int l1 = str1.length();
        int l2 = str2.length();
        
        int dp[][] = new int[l1 + 1][l2 + 1];
        
        for(int i = 1; i <= l1; ++i) {
            for(int j = 1; j <= l2; ++j) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        String res = "";
        
        int i = l1;
        int j = l2;
        
        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res = str1.charAt(i - 1) + res;
                --i;
                --j;
            } else if(dp[i - 1][j] > dp[i][j - 1]) {
                res = str1.charAt(i - 1) + res;
                --i;
            } else {
                res = str2.charAt(j - 1) + res;
                --j;
            }
        }
        
        if(i > 0) res = str1.substring(0, i) + res;
        if(j > 0) res = str2.substring(0, j) + res;
        
        return res;
    }
	
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
