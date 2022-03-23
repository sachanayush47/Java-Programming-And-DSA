package LeetcodeContest;

import java.util.*;

public class weekly279 {

	public static void main(String[] args) {
		
		System.out.println(minimumTime("010110"));
		
		
	}
	
	public static int minimumTime(String s) {
		
		int i = 0;
		int j = s.length()-1;
		int res = 0;
		
		while(i <= j) {
			if(s.charAt(i) == '0' && s.charAt(j) == '0') break;
			if(i == j) {
				if(s.charAt(i) == '1') {
					++res;
					++i;
				}
				
				break;
			}
			
			if(s.charAt(i) == '1') {
				++res;
				++i;
			}
			
			if(s.charAt(j) == '1') {
				++res;
				--j;
			}
		}
		
		while(i <= j) {
			if(s.charAt(i) == '1') res += 2;
			++i;
		}
		
		return res;
		
	}
	
	// 2166
	static class Bitset {
		
		int size;
		Set<Integer> one = new HashSet<>();
		Set<Integer> zero = new HashSet<>();
		
	    public Bitset(int size) {
	        this.size = size;
	        for(int i = 0; i < size; ++i) zero.add(i);
	    }
	    
	    public void fix(int idx) {
	    	one.add(idx);
	    	zero.remove(idx);
	    }
	    
	    public void unfix(int idx) {
	    	one.remove(idx);
	    	zero.add(idx);
	    }
	    
	    public void flip() {
	    	Set<Integer> temp = one;
	    	one = zero;
	    	zero = temp;
	    }
	    
	    public boolean all() {
			return one.size() == size;
	    }
	    
	    public boolean one() {
			return one.size() > 0;
	    }
	    
	    public int count() {
			return one.size();
	    }
	    
	    public String toString() {
	    	String res = "";
	    	for(int i = 0; i < size; ++i) {
	    		if(one.contains(i)) res += "1";
	    		else res += "0";
	    	}
	    	
	    	return res;
	    }
	}
	
	
	// 2165
	public static long smallestNumber(long num) {
		if(num == 0) return 0;
        
        String s = String.valueOf(Math.abs(num));
        List<Character> temp = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i) temp.add(s.charAt(i));
        
        if(num > 0) {
            Collections.sort(temp);
            int nonZeroInd = 0;
            while(nonZeroInd < temp.size() && temp.get(nonZeroInd) == '0') ++nonZeroInd;
            
            Collections.swap(temp, 0, nonZeroInd);
        } 
        else Collections.sort(temp, Comparator.reverseOrder());
        
        String tempAns = "";
        for(int i = 0; i < temp.size(); ++i) tempAns += temp.get(i);
        
        long ans = Long.valueOf(tempAns);
        if(num < 0) ans *= -1;
        
        return ans;
        
    }
	
	// 2164
	public static int[] sortEvenOdd(int arr[]) {
		
		ArrayList<Integer> evenArr = new ArrayList<Integer>();
		ArrayList<Integer> oddArr = new ArrayList<Integer>();
 
        for(int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) evenArr.add(arr[i]);
            else oddArr.add(arr[i]);
        }

        Collections.sort(evenArr);
        Collections.sort(oddArr, Collections.reverseOrder());
        
        int i = 0;
        int odd = 0;
        int even = 0;
        
        while(i < arr.length) {
            if(i % 2 == 0) arr[i++] = evenArr.get(even++);
            else arr[i++] = oddArr.get(odd++);
        }
 
        return arr;
	}

}
