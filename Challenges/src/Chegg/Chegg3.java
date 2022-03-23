package Chegg;

public class Chegg3 {

	public static void main(String[] args) {
		
		int arr[] = {1, 101, 100, 90, 4, 5};
		int ans = findMaximum(arr, arr.length-1);
		System.out.println(ans);	// Output : 102
	}
	
	// This method takes 2 parameters, 
	//		i. 	Array in which we have to find the maximum element.
	//		ii.	Index "i" to traverse array recursively and access elements of array,
	//			"i" is initialised with arr.length-1
	public static int findMaximum(int arr[], int i) {
		// When i = 0, that means we have traversed the whole array.
		// So we return element at i = 0.
		if(i == 0) return arr[0];
		
		// "num" maximum element of from "i-1" index to 0;
		int num = findMaximum(arr, i-1);
		
		// Return the maximum of "num" and element at index "i"; 
		return Math.max(num, arr[i]);
	}

}
