package SheetSDE;

import java.util.*;

public class Day9 {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(2);
		arr.add(1);
		
		System.out.println(subsetSums(arr, 3));
		
	}
	
	/* ------------------------------------------------------------------ */
	
								// Partition Palidrome
	
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionHelper(0, s, new ArrayList<>(), res);
        return res;
    }
    
    public static void partitionHelper(int i, String s, List<String> set, List<List<String>> res) {
        if(i >= s.length()) {
            res.add(new ArrayList<>(set));
            return;
        }
        
        for(int ind = i; ind < s.length(); ++ind) {
            if(isPalidrome(i, ind, s)) {
                set.add(s.substring(i, ind + 1));
                int size = set.size();
                partitionHelper(ind + 1, s, set, res);
                set.remove(size - 1);
            }      
        }        
    }
    
    public static boolean isPalidrome(int i, int j, String s) {
        
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            ++i;
            --j;
        }
        
        return true;
    }
	
	/* ------------------------------------------------------------------ */
	
								// Combination Sum 2
	
    public static List<List<Integer>> combinationSum2(int[] c, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(c);
        combinationSum2Helper(0, c, target, new ArrayList<>(), res);
        return res;
        
    }
    
    public static void combinationSum2Helper
        (int ind, int[] c, int target, List<Integer> set, List<List<Integer>> res) {
        
        if(target == 0) {
            res.add(new ArrayList<>(set));
            return;
        }
        
        for(int i = ind; i < c.length; ++i) {
            if(c[i] > target) break;
            if(i > ind && c[i] == c[i - 1]) continue;
            
            set.add(c[i]);
            int size = set.size() - 1;
            combinationSum2Helper(i + 1, c, target - c[i], set, res);
            set.remove(size);
        }
    }
	
	/* ------------------------------------------------------------------ */
	
								// Combination Sum 1
	
    public static List<List<Integer>> combinationSum(int[] c, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        combinationSumHelper(c.length - 1, c, target, set, res);
        return res;
    }
    
    public static void combinationSumHelper(int i, int[] c, int target,
    		List<Integer> set, List<List<Integer>> res) {
        
        if(target == 0) {
            res.add(new ArrayList<>(set));
            return;
        }
        
        if(i < 0) {
            if(target == 0) res.add(new ArrayList<>(set));
            return;
        }
        
        if(target >= c[i]) {
            set.add(c[i]);
            int size = set.size();
            combinationSumHelper(i, c, target - c[i], set, res);
            set.remove(size - 1);
        }
        
        combinationSumHelper(i - 1, c, target, set, res);
        
        
    }
	
	
	/* ------------------------------------------------------------------ */
	
	public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
		ArrayList<Integer> res = new ArrayList<>();
		subsetSumsHelper(N - 1, 0, res, arr);
		return res;
    }

	public static void subsetSumsHelper(
			int i, int sum, ArrayList<Integer> res, ArrayList<Integer> arr) {
		
		if(i < 0) {
			res.add(sum);
			return;
		}
		
		subsetSumsHelper(i - 1, sum + arr.get(i), res, arr);		// Pick
		subsetSumsHelper(i - 1, sum, res, arr);						// Not pick
	}
	
}
