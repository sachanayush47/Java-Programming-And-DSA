package Chegg;

public class Chegg4 {

	public static void main(String[] args) {

		// Initializing an 2D array. 
		int arr[][] = {
				{-1, 22, 7, 1, 33, 7, 44, 566},
				{1, 0, 3, 0, 1999, -2, 5, 0},
				{0, 0, 1, 3, 0, 22, 4, 0},
				{6, 4, 1918, 44, 5, 0, 0, 1}
		};
		
		printArray(arr);
		System.out.println("Average value: " + averageValue(arr));
		System.out.println("Average value of row 0: " + averageInRow0(arr));
		System.out.println("Minimum element in column 0: " + minimumInColumn0(arr));
		System.out.println("Maximum element in row 1: " + maximumInRow1(arr));
		System.out.println("Average value in column 6: " + averageInColumn6(arr));
		
	}
	
	public static void printArray(int matrix[][]) {
	// To print a 2D array, traverse each row one by one.
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	public static double averageValue(int matrix[][]) {
	// Returns average of all values in 2D array.
		
		double sum = 0;
		
		// Total elements present in an 2D array is : Row X Column
		int totalElements = matrix.length * matrix[0].length;
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				
				// Calculating sum of all elements.
				sum += matrix[i][j];		
			}
		}
		
		return sum/totalElements;
	}
	
	public static double averageInRow0(int matrix[][]) {
	// Returns average of all values present at row 0 in 2D array.
		
		double sum = 0;
		
		// Total elements present in an row of 2D array.
		int totalElements = matrix[0].length;
		for(int i = 0; i < totalElements; ++i) {
			
			// Calculating sum of all elements present at row 0.
			sum += matrix[0][i];
		}
		
		return sum/totalElements;
	}
	
	public static int minimumInColumn0(int matrix[][]) {
	// Returns minimum possible element at column 0 in 2D array.
		
		// Storing the maximum possible in a INT type variable.
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < matrix.length; ++i) {
			// Calculating the minimum element.
			// Math.min method returns minimum of 2 numbers.
			min = Math.min(min, matrix[0][i]);
		}
		
		return min;
	}
	
	public static int maximumInRow1(int matrix[][]) {
	// Returns maximum possible element at row 1 in 2D array.	
		
		// Storing the minimum possible in a INT type variable.
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < matrix[0].length; ++i) {
			// Calculating the maximum element.
			// Math.max method returns maximum of 2 numbers.
			max = Math.max(max, matrix[1][i]);
		}
		
		return max;
	}
	
	public static double averageInColumn6(int matrix[][]) {
	// Returns average of all values present at column 6 in 2D array.
		
		double sum = 0;
		
		// Total elements present in an column of 2D array.
		int totalElements = matrix.length;
		
		for(int i = 0; i < matrix.length; ++i) {
			// Calculating sum of all elements present at column 6.
			sum += matrix[i][6];
		}
		
		return sum/totalElements;
	}

}
