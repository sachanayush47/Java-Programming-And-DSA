package binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		
		int arrays[] = {5, 10, 13, 17, 22, 30, 45, 47, 47, 51, 60, 81};
		System.out.println(bSearch(arrays, 30));
		
	}
	
	public static int bSearch(int arr[], int key) {
	// Follows Divide and Conquer strategy.
	// Condition: Array must be sorted.
	// Time Complexity: log(n)
		
		int low = 0;
		int high = arr.length-1;
		
		while(low <= high) {
			
			int mid = (low + high)/2;
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] > key) {
				high =  mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
