package arrayDeque;

import java.util.*;

public class ArrayDequeProblems {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int arr[] = new int[length];
		for(int i = 0; i < length; ++i) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		ArrayList<Integer> output = maxOfSubarrays(arr, length, 4);
		System.out.println(output);
	}	
	
	static ArrayList <Integer> maxOfSubarrays(int arr[], int n, int k) {
        
		ArrayList<Integer> ans= new ArrayList<Integer>();
		ArrayDeque<Integer> window = new ArrayDeque<Integer>();
		int max = Integer.MIN_VALUE;
		int i = 0;
		while(i < n) {
			if(window.size() < k) {									
				window.addLast(arr[i]);					
				++i;				
			} else {
				max = Collections.max(window);
				ans.add(max);
				window.removeFirst();
				window.addLast(arr[i]);
				++i;
			}
		}
		max = Collections.max(window);
		ans.add(max);
		
		return ans;
    }

}
