package experiment;

import java.util.*;

public class Adda247 {

	public static void main(String[] args) {
		
		String s2 = "qwerty";
		System.out.println(s2.hashCode());
	}
	
    static int ZeroPairSum(int n, ArrayList<Integer> arr) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
		}
		
		System.out.println(map);
		
		int res = 0;
		for(int i = 0; i < n; ++i) {
			if(map.containsKey(arr.get(i) * -1)) {
				map.put(arr.get(i), map.get(arr.get(i)) - 1);
				res += map.get(arr.get(i) * -1);
			}
		}
		
		return res;
    }

}
