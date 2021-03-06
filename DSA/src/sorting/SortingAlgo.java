package sorting;

import java.util.Arrays;

import arrays.ArraysProblem;

public class SortingAlgo {

	public static void main(String[] args) {
		
		// int arr[] = {50, 90, 33, 10, 9, 6};
		
		//quickSort(arr, 0, arr.length - 1);
		
//		selectionSort(arr);
//		
//		System.out.println(Arrays.toString(arr));
		
		int arr[] = {30, 79, 55, 12, 80, 23, 20}; 
		
		insertionSort(arr);
	}

	// Insertion sort.
	public static void insertionSort(int arr[]) {
		
		for(int i = 1; i < arr.length; ++i) {
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				--j;
			}
			arr[j+1] = key;
		}
		ArraysProblem.printArray(arr);		
	}
	
	// Merge sort
	public static int[] mergeSort(int arr[]) {
		if(arr.length == 1) return arr;
		
		int mid = arr.length/2;
		
		// 
		int left[] = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		
		return mergeTwoSortedArrays(left, right);
		
	}
	// This method is a part of function "mergeSort".
	public static int[] mergeTwoSortedArrays(int arr1[], int arr2[]) {
	// Merge two sorted arrays. [Source: Kunal Khushwaha]
		int result[] = new int[arr1.length + arr2.length];

		int p1 = 0;		// Pointer 1 for arr1.
		int p2 = 0;		// Pointer 2 for arr2
		int pr = 0;		// Pointer for result array.
		
		while(p1 < arr1.length && p2 < arr2.length) {
			if(arr1[p1] < arr2[p2]) {
				result[pr++] = arr1[p1++];
			} else {
				result[pr++] = arr2[p2++];
			}
		}
		
		// Copy the remaining elements from arr2.
		while(p2 < arr2.length) {
			result[pr++] = arr2[p2++];
		}
		// Copy the remaining elements from arr1.
		while(p1 < arr1.length) {
			result[pr++] = arr1[p1++];
		}
		
		return result;
	}
	
	
	// Merge sort in-place. [Preferred method]
	public static void mergeSortInPlace(int arr[], int start, int end) {
	// start = starting index, end = ending index.
	// https://www.interviewbit.com/tutorial/merge-sort-algorithm/
	// In in-place method, we dont create new arrays. We create imaginary arrays.
		if(start < end) {			
			int mid = (end + start)/2;	
			mergeSortInPlace(arr, start, mid);
			mergeSortInPlace(arr, mid+1, end);		
			mergeTwoSortedArraysInPlace(arr, start, mid, end);	
		}
	}
	// This method is a part of function "mergeSortInPlace".
	public static void mergeTwoSortedArraysInPlace(int arr[], int start, int mid, int end) {
		int result[] = new int[end - start + 1];
		
		int i = start;		// For first half of array.
		int j = mid+1;		// For second half of array.
		int k = 0;			// For result array.
		
		while(i <= mid && j <= end) {
			if(arr[i] < arr[j]) {
				result[k++] = arr[i++];
			} else {
				result[k++] = arr[j++];
			}
		}
		
		// Copy the remaining elements from first half.
		while(i <= mid) {
			result[k++] = arr[i++];
		}
		// Copy the remaining elements from the second half.
		while(j <= end) {
			result[k++] = arr[j++];
		}
		
		// Coping "result" array to "arr" array.
		for(int m = start; m <= end; ++m) {
			arr[m] = result[m - start]; 
		}	
	}
	
	// Quick sort.
	public static void quickSort(int arr[], int start, int end) {
	// via InterviewBit	
		if(start < end) {
			
			int pi = partition(arr, start, end);
			quickSort(arr, start, pi-1);
			quickSort(arr, pi+1, end);
			
		}
	
	}
	// This method is a part of function "quickSort".
	public static int partition(int arr[], int start, int end) {
		
		int pivot = arr[end];			// Pivot
		
		int pi = start - 1;				// Next pivot index
		
		for(int i = start; i < end; ++i) {
			if(arr[i] < pivot) {
				++pi;
				int temp = arr[i];		// Swapping arr[i] and arr[pi]
				arr[i] = arr[pi];
				arr[pi] = temp;
			}
		}
		
		int temp = arr[end];			// Swapping arr[end] and arr[pi+1]
		arr[end] = arr[pi + 1];
		arr[pi + 1] = temp;
		
		return pi+1;	
	}
	
	// Bubble sort.
	public static void bubbleSort(int arr[]) {

		for(int i = 0; i < arr.length-1; ++i) {
			
			boolean isSorted = true;
			
			System.out.println("Pass " + i);
			
			for(int j = 0; j < arr.length-i-1; ++j) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				
					System.out.println(Arrays.toString(arr));
					isSorted = false;
				}
			}
			
			if(isSorted) break;
		}
		System.out.println("Final result");
		System.out.println(Arrays.toString(arr));
	}
	
	// Selection sort.
	public static void selectionSort(int arr[]) {
	// Apni Kaksha.
		for(int i = 0; i < arr.length-1; ++i) {
			int smallest = i;
			for(int j = i+1; j < arr.length; ++j) {
				// Finding index of smallest element.
				if(arr[j] < arr[smallest]) {
					smallest = j;
				}	
			}
			
			int temp = arr[smallest];		// Swapping
			arr[smallest] = arr[i];
			arr[i] = temp;
		}
	}
	

}
 