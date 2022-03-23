package LeetcodeContest;

public class weekly282 {

	public static void main(String[] args) {
		
		int arr[] = {3,3,8};
		System.out.println(minimumTime(arr, 6));
		
	}
	
	public static long minimumTime(int[] time, int totalTrips) {
		
		long ti = 1;
		long tt = 0;
		while(tt != totalTrips) {
			for(int i = 0; i < time.length; ++i) {
				if(tt == totalTrips) break;
				if(ti % time[i] == 0) ++tt;
			}
			
			++ti;
		}
		
		return ti;
	}
	
	public static int minSteps(String s, String t) {
		
		int res = 0;
		
		int char1[] = new int[26];
		int char2[] = new int[26];
		
		for(int i = 0; i < s.length(); ++i) {
			++char1[s.charAt(i) - 'a'];
		}
		
		for(int i = 0; i < t.length(); ++i) {
			++char2[t.charAt(i) - 'a'];
		}
		
		for(int i = 0; i < 26; ++i) {
			if(char1[i] != char2[i]) {
				res += Math.abs(char1[i] - char2[i]);
			}
		}
		
		return res;
		
	}
	
	public int prefixCount(String[] words, String pref) {
		
		int res = 0;
		
		for(int i = 0; i < words.length; ++i) {
			boolean f = words[i].startsWith(pref);
			if(f) ++res;
		}
		
		return res;
	}

}
