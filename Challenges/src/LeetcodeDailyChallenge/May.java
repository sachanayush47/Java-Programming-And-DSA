package LeetcodeDailyChallenge;

import java.util.*;

public class May {

	public static void main(String[] args) {
		
		System.out.println(findMaxForm(new String[] {"10","0001","111001","1","0"}, 5, 3));
	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
		int res = 0;
		
		for(int i = 0; i < strs.length; ++i) {
			
			int tempM = 0;
			int tempN = 0;
			for(int j = 0; j < strs[i].length(); ++j) {
				if(strs[i].charAt(j) == '0') ++tempM;
				else ++tempN;
			}
			
			if(tempM <= m && tempN <= n) ++res;
		}
		
		return res;
    }
	
	
	
    public static List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        
        String keys[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsHelper(0, digits, "", keys, res);
        return res;
    }

    public static void letterCombinationsHelper
    	(int i, String digits, String prefix, String keys[], List<String> res) {
    	if(i >= digits.length()) {
    		res.add(prefix);
    		return;
    	}
    	
    	String d = keys[digits.charAt(i) - '0'];
    	for(int ind = 0; ind < d.length(); ++ind) {
    		letterCombinationsHelper(i + 1, digits, prefix + d.charAt(ind), keys, res);
    	}
    	
    }
}
