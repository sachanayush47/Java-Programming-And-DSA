package strings;

import java.util.*;

public class StringsProblem {

	public static void main(String[] args) {
		
		System.out.println(interpret("G()(al)"));
		
	}
	
    public static String defangIPaddr(String address) {
    // https://leetcode.com/problems/defanging-an-ip-address
        String splitString[] = address.split("\\.");
        String ans = "";
        for(int i = 0; i < splitString.length; ++i) {
            ans = ans + splitString[i];
            if(i != splitString.length-1) ans = ans + "[.]";
        }
        return ans;
    /** Alternative
  	 *	return address.replaceAll("\\.", "[.]");
  	 *	Slower and taking more memory than above one.
  	 */
    }
    
    public static String interpret(String command) {
    // https://leetcode.com/problems/goal-parser-interpretation/
    // This solution is 5% faster and taking %% less memory.
    	String ans = "";        
        while(true) {
        
            int ind1 = command.indexOf("G");
            int ind2 = command.indexOf("()");
            int ind3 = command.indexOf("(al)");
            
            if(ind1 == -1) ind1 = Integer.MAX_VALUE;
            if(ind2 == -1) ind2 = Integer.MAX_VALUE;
            if(ind3 == -1) ind3 = Integer.MAX_VALUE;
            if(ind1 == ind2) {
                if(ind1 == ind3) break;
            }
            
            if(ind1 < ind2 && ind1 < ind3) {
                ans = ans + "G";
                command = command.replaceFirst("G", "");
            } else if(ind2 < ind1 && ind2 < ind3) {
                ans = ans + "o";
                command = command.replaceFirst("\\(+\\)", "");
            } else {
                ans = ans + "al";
                command = command.replaceFirst("\\(+al+\\)", "");
            }  
        }      
        return ans;
        
        /**	100% faster solution but not mine.
         * 	leetcode.com/problems/goal-parser-interpretation/discuss/1056826/Java-faster-than-100.00
         * 
         * 	StringBuilder sb = new StringBuilder();
		 *
		 *	for (int i = 0; i < command.length(); i++) {
		 *		if (command.charAt(i) == 'G')
		 *			sb.append("G");
		 *		else if (i < command.length() - 1) {
		 *			if (command.charAt(i + 1) == 'a') {
		 *			sb.append("al");
		 *			i +=3;
		 *		} else {
		 *			sb.append("o");
		 *			i++;
		 *		}
		 *		}
		 *	}
		 *	return sb.toString();
         * 
         */
    }
    
    public static int balancedStringSplit(String s) {
    // https://leetcode.com/problems/split-a-string-in-balanced-strings
    // Copied solution. I was unable to solve.
        int ans = 0, temp = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == 'R') {
                ++temp;
            } else {
                --temp;
            }
            if(temp == 0) ++ans;
        }
        return ans;
    }
    
    public static String restoreString(String s, int[] indices) {
    // https://leetcode.com/problems/shuffle-string    
        char temp[] = new char[s.length()];
        int op;
        for(int i = 0; i < s.length(); ++i) {
            op = indices[i];
            temp[op] = s.charAt(i);
        }
        
        String ans = new String(temp);
        return ans;
        
    }
    
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    // https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/   
        String s1 = "";
        String s2 = "";
        for(int i = 0; i < word1.length; ++i) {
            s1 = s1 + word1[i];
        }
        for(int i = 0; i < word2.length; ++i) {
            s2 = s2 + word2[i];
        }
        return s1.equals(s2);
        /** s1==s2 wont work because == compares that they're the same object in memory,
         *	which they aren't. They represent the same data, but they aren't the same object.
         */
    }
    
    public static boolean halvesAreAlike(String s) {
    // https://leetcode.com/problems/determine-if-string-halves-are-alike   
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        s = s.toLowerCase();
        char part1[] = s.substring(0, s.length()/2).toCharArray();
        char part2[] = s.substring(s.length()/2).toCharArray();
        int count = 0;
        for(int i = 0; i < part1.length; ++i) {
            if(vowels.contains(part1[i])) ++count;
        }
        for(int i = 0; i < part1.length; ++i) {
            if(vowels.contains(part2[i])) --count;
        }
        return count==0;
    }

    
    

}
