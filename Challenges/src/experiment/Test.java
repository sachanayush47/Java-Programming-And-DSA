package experiment;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {
		
//		int arr[] = {1,2,3,8,9,6,0,4};
//		System.out.println(getIndex(arr, 8, arr.length-1));
		
		S.helloJi();
		
		boolean arr[] = new boolean[1];
		System.out.println("sdsds" + arr[0]);
		T(arr, 5);
		
	}
	
	public static int getIndex(int arr[], int num, int index) {
		
		if(num == arr[index]) return index;
		if(index == 0) return -1;
		
		return getIndex(arr, num, --index);
		
	}
	
	public static void T(boolean arr[], int num) {
		
		if(num == 0) {
			arr[0] = true;
			return;
		}
		
		T(arr, --num);
		System.out.println(arr[0]);
	}
	


}

class S {
	static boolean isCorrect = false;
	static void helloJi() {
		System.out.println("Namaste");
	}
}


