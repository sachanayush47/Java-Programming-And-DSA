package sorting;

import arrays.ArraysProblem;

public class SortingAlgo {

	public static void main(String[] args) {
		
		int arr[] = {50, 90, 33, 10, 9, 6};
		int arr2[] = {10,15,20,40};
        int arr3[] = {5,6,6,10,15};
		
        insertionSort(arr);
		MergeSortAlgorithms.merge(arr2, arr3);
	}

	public static void insertionSort(int arr[]) {
		
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		ArraysProblem.printArray(arr);		
	}
	
	static class MergeSortAlgorithms {
		
		public static void merge(int arr1[], int arr2[]) {
			
			int i = 0, j = 0;
			int arr1Length = arr1.length;
			int arr2Length = arr2.length;
			
			while(i < arr1Length && j < arr2Length) {
				if(arr1[i] < arr2[j]) {
					System.out.println(arr1[i++]);
				} else {
					System.out.println(arr2[j++]);
				}
			}
			
			while(i < arr1Length) {
				System.out.println(arr1[i++]);
			}
			while(j < arr2Length) {
				System.out.println(arr2[j++]);
			}
		}
		
	}

}
