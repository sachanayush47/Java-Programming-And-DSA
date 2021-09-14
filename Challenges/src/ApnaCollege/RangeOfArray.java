package ApnaCollege;

public class RangeOfArray {

	public static void main(String[] args) {
		
		int arr[] = {2, 4, 6, 1, 10, 99, 2};
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			} else if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(max-min);
		
		/** Solution 2:
		 * 		Using Collections.max and Collections.min on Arraylist.
		 */
	}

}
