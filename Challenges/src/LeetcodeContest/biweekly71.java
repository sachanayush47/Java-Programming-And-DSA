package LeetcodeContest;
import java.util.*;
public class biweekly71 {

	public static void main(String[] args) {
		
	}
	
	public static int minimumSum(int num) {
		
		String s = String.valueOf(num);
		String arr[] = new String[4];
		
		for(int i = 0; i < 4; ++i) {
			arr[i] = String.valueOf(s.charAt(i));
		}
		
		Arrays.sort(arr);
		String num1 = arr[0] + arr[2];
		String num2 = arr[1] + arr[3];
		
		Integer n1 = Integer.valueOf(num1);
		Integer n2 = Integer.valueOf(num2);
		
		return n1+n2;
		
	}
	
	public static int[] pivotArray(int[] arr, int pivot) {
		
		int res[] = new int[arr.length];
		ArrayList<Integer> e = new ArrayList<>();
		ArrayList<Integer> l = new ArrayList<>();
		
		int curr = 0;
		
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] < pivot) res[curr++] = arr[i];
			else if(arr[i] == pivot) e.add(arr[i]);
			else l.add(arr[i]);
		}
		
		for(int i = 0; i < e.size(); ++i) {
			res[curr++] = e.get(i);
		}
		
		for(int i = 0; i < l.size(); ++i) {
			res[curr++] = l.get(i);
		}
		
		return res;
		
	}

}
