import java.util.*;

public class Test {

	public static void main(String[] args) {
		
//		String as = "1ii23";
//		System.out.println(as.matches("-?\\d+"));
//		
//		int arr1[] = new int[10];
//		arr1[9] = 4;
//		
//		int arr2[] = new int[5];
//		
//		arr2 = arr1;
//		
//		System.out.println(arr2[5]);
		
		int arr[] = {3, 9, 7, 5, 2, 8, 7};
		partition(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}
	
	public static void partition(int arr[], int start, int end) {
		
		int pivot = arr[end];
		
		int pi = start - 1;
		
		for(int i = start; i < end; ++i) {
			if(arr[i] <= pivot) {
				++pi;
				int temp = arr[i];
				arr[i] = arr[pi];
				arr[pi] = temp;
			}
		}
		
		int temp = arr[end];
		arr[end] = arr[pi + 1];
		arr[pi + 1] = temp;
	}
	
	public static List<Integer> aa() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		return al;
	}
}