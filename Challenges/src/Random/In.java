package Random;

import java.util.*;

public class In {

	public static void main(String[] args) throws java.lang.Exception {

		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String arr[] = sc.nextLine().split(",");
		
		sc.close();
		System.out.println(solve(s, arr));
	}
	
	public static String solve(String s, String arr[]) {
		
		Map<Character, ArrayList<Integer>> ind = new LinkedHashMap<>();
		Map<String, Integer> f = new HashMap<>();
		
		for(int i = 0; i < s.length(); ++i) {
			
			if(f.containsKey(arr[i])) {
				f.put(arr[i], f.get(arr[i]) + 1);
			} else f.put(arr[i], 1);
			
			if(ind.containsKey(s.charAt(i))) {
				ind.get(s.charAt(i)).add(i);
			} else {
				ind.put(s.charAt(i), new ArrayList<>());
				ind.get(s.charAt(i)).add(i);
			}
		}
		
		String res = "";
		for(char key : ind.keySet()) {
			
			ArrayList<Integer> l = ind.get(key);
			String m = arr[l.get(0)];
			boolean exist = true;
			
			int fm = 1;
			
			for(int i = 1; i < l.size(); ++i) {
				if(!m.equals(arr[l.get(i)])) {
					exist = false;
					break;
				} else ++fm;
			}
			
			if(exist && fm == f.get(m)) res += key;
		}
		
		return res.length() == 0 ? "NA" : res;
	}
}
	
//	Scanner sc = new Scanner(System.in);
//	
//	String s = sc.nextLine();
//	int innum = sc.nextInt();
//	sc.close();
//	System.out.println(solve(s, innum));
	
//	public static int solve(String s, int k) {
//		
//		int n = s.length();
//		int freq[] = new int[n+1];
//		int countOne = 0;
//
//		int res = 0;
//
//		freq[0] = 1;
//
//		for(int i = 0; i < n; ++i) {
//			countOne += (s.charAt(i) - '0');
//			if(countOne >= k) res += freq[countOne - k];
//			++freq[countOne];
//		}
//
//		return res > 0 ? res : -1;
//	}