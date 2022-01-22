package arrays;

import java.util.*;

public class ArraysProblem {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
		
//		int arr[][] = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
//		int arr2[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
//		System.out.println(diagonalSum(arr2));
//		int arr3[][] = {{1,2,3,4}};
//
//		int temp[][] = matrixReshape(arr3, 2, 2);
//		printMatrix(temp);
		
//		int arr4[] = {0, 1};
//		printArray(arr4);
//		System.out.println();
//		int temp[] = sortArrayByParity(arr4);
//		printArray(temp);
		
//		int arr5[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//		int arr6[] = {1, 2, 3, 2};
//		System.out.println(sumOfUnique(arr5));
		
//		int arr[] = {7,6,4,3,1};
//		
//		System.out.println(bestTimeToBuyAndSellStock(arr));
		
//		int arr1[] = {1,2,3,0,0};
//		int arr2[] = {2,5};
//		
//		mergeSortedArrays(arr1, 3, arr2, 2);
//		
//		System.out.println(Arrays.toString(arr1));
		
//		int arr[] = {1,7,3,6,5,6};
//		
//		findPivotIndex(arr);
		
//		System.out.println(pascalTriangle(6));
		
		int arr[][] = {{15, 18}, {1, 3}, {8, 10}, {2, 6}};
//		int arr[][] = {{1, 4}, {8,  10}};
		mergeIntervals(arr);
		
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int[][] mergeIntervals(int arr[][]) {
	// https://leetcode.com/problems/merge-intervals/
		
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		int interval[] = arr[0];
		ArrayList<int[]> result = new ArrayList<>();
		
		for(int i = 1; i < arr.length; ++i){
			if(arr[i][0] <= interval[1]) interval[1] = Math.max(interval[1], arr[i][1]);
			else {
				result.add(interval);
				interval = arr[i];
			}
		}
		
		result.add(interval);
		
		return result.toArray(new int[0][]);
	}
	
	// -----------------------------------------------------------------------
	
	public static int[] twoSum(int arr[], int target) {
	// https://leetcode.com/problems/two-sum		#LS
		
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		int result[] = new int[2];
		
		for(int i = 0; i < arr.length; ++i) {
			if(hs.containsKey(target - arr[i])) {
				result[0] = i;
				result[1] = hs.get(target - arr[i]);
				return result;
			}
			hs.put(arr[i], i);
		}
		
		return result;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int bestTimeToBuyAndSellStock(int prices[]) {
	// https://leetcode.com/problems/two-sum/		#LS
		int profit = 0;
		int min = 0;
		
		for(int i = 0; i < prices.length-1; ++i) {
			min = Math.min(prices[i], min);
			profit = Math.min(prices[i] - min, profit);
		}
		
		return profit;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static void mergeSortedArrays(int nums1[], int m, int nums2[], int n) {
	// https://leetcode.com/problems/merge-sorted-array/		#LS
		int resTail = m+n-1;		// Result tail
		int nums1Tail = m-1;		// nums1 tail
		int nums2Tail = n-1;		// nums2 tail
		
		while(nums1Tail >= 0 && nums2Tail >= 0) {
			if(nums1[nums1Tail] > nums2[nums2Tail]) {
				nums1[resTail--] = nums1[nums1Tail--];
			} else {
				nums1[resTail--] = nums2[nums2Tail--];
			}
		}
		
		while(nums2Tail >= 0) {
			nums1[resTail--] = nums2[nums2Tail--];
		}
	}
	
	/* ------------------------------------------------------------------ */
	
	public static void moveZeroes(int nums[]) {
	// https://leetcode.com/problems/move-zeroes/		#LS
        int zero = 0;
        int number = 0;   
        while(number < nums.length) {      
            if(nums[zero] == 0 && zero < number && nums[number] != 0) {
                nums[zero++] = nums[number];
                nums[number++] = 0;
            } else {
                if(nums[zero] != 0) ++zero;
                if(nums[number] == 0) ++number;
                if(zero >= number) ++number;
            }
        }
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int bestTimeToBuyAndSellStock2(int prices[]) {
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/	#LS
        int profit = 0;
        
        if(prices.length == 1) return profit;
        
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1]) {
                profit = profit + prices[i] - prices[i-1];
            }
        }
        
        return profit;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int[] runningSum(int arr[]) {
	// https://leetcode.com/problems/running-sum-of-1d-array	#LS
        if(arr.length == 1) return arr;
        
        for(int i = 1; i < arr.length; ++i) {
            arr[i] = arr[i] + arr[i-1];
        }
        
        return arr;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int findPivotIndex(int nums[]) {
	// https://leetcode.com/problems/find-pivot-index/		#LS
		int rSum = 0;		// Right sum
		int lSum = 0;		// Left sum
		
		
		// Calculating sum of all element in array.
		for(int i = 0; i < nums.length; ++i) {
			rSum += nums[i];
		}
		
		// Finding the pivot index.
		for(int i = 0; i < nums.length; ++i) {
			
			rSum -= nums[i];
			if(rSum == lSum) return i;
			lSum += nums[i];
		}
		return -1;
	}
	
	/* ------------------------------------------------------------------ */

	public static int findMajorityElement(int nums[]) {
	// https://leetcode.com/problems/majority-element/		#LS
		
        int major = nums[0];
        int count = 0;
        
        for(int i = 0; i < nums.length; ++i) {
            if(count == 0) {
                major = nums[i];		// Updating major
                ++count;				// Increment count
            } else if(nums[i] == major) {
                ++count;				// Increment count
            } else {
                --count;				// Decrement count
            }
        }
        return major;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static List<List<Integer>> pascalTriangle(int n) {
	// https://leetcode.com/problems/pascals-triangle/		#LS
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < n; ++i) {
			List<Integer> row = new ArrayList<Integer>();		// Row
			if(i == 0) {					// Row 1
				row.add(1);					// First element for row 1.
			} else if(i == 1) {				// Row 2
				row.add(1);					// First and second element for row 2.
				row.add(1);
			} else {						// Row 3 and more.
				int size = triangle.get(i-1).size();	// Size of last added list.
				row.add(1);								// Adding first element to the row.
				for(int j = 1; j < size; ++j) {
					// Calculating and adding next element.
					row.add(triangle.get(i-1).get(j) + triangle.get(i-1).get(j-1));
				}
				row.add(1);					// Adding last element to the lost.
			}
			triangle.add(row);				// Adding "row" to "triangle".
		}
		return triangle;
	}
	
	
	public static int removeDuplicate(int nums[]) {
	// https://leetcode.com/problems/remove-duplicates-from-sorted-array/		#LS
        int lengthOfUniqueElements = 0;
        
        for(int j = 1; j < nums.length; ++j) {
            if(nums[lengthOfUniqueElements] != nums[j]) {
                ++lengthOfUniqueElements;
                nums[lengthOfUniqueElements] = nums[j];
            }
        } 
        return 1+lengthOfUniqueElements;
	}
	
	
	// -----------------------------------------------------------------------

	
	public static void swap(int arr[], int key1, int key2) {
	/** Method to swap two(Key1 and Key2) elements of array. 
	 *	This method is just made to make my work easy.
	*/
		
		int temp = arr[key1];
		arr[key1] = arr[key2];
		arr[key2] = temp;
	}
	
	public static void printMatrix(int arr[][]) {
	// Self made method: This method is just made to make my work easy.
	// Prints a matrix.
		
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[0].length; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printArray(int arr[]) {
	// Self made method: This method is just made to make my work easy.
	// Prints an array.
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}
	
	
	public static int largestElementInArr(int arr[]) {
	// #GFG
		
		int res = arr[0];
		for(int start = 0; start < arr.length; start++) {
			if(arr[start] > res) {
				res = arr[start];
			}
		}
		return res;
	}
	
	public static int secondlargestElementInArr(int arr[]) {
	// #GFG
		
		int res = -1;
		int largest = 0;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[largest]) {
				res = largest;
				largest = i;
			} else if(arr[i] != arr[largest]) {
				if(res == -1 || arr[i] > arr[res]) {
					res = i;
				}
			}
		}
		return res;
	}
	
	public static int removeDuplicatesFromSortedArray(int arr[]) {
	// Retruns the size of array without duplicates. #GFG
		
		int size = 1;	
		if(arr.length == 0) return 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] != arr[i+1]) {
				size++;
			}
		}		
		return size;
	}
	
	public static boolean checkIfAnArrayIsSorted(int arr[]) {
	// #GFG
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				return false;
			}			
		}
		return true;
	}
	
	public static void reverseArray(int arr[]) {
	// #GFG
		
		int length = arr.length;
		
		for(int i = 0; i < arr.length/2; i++) {
			swap(arr, i, length - 1);
			length--;
		}		
		printArray(arr);
	}
	
	public static void moveAllZeroesToEnd(int arr[]) {
	// Moving all zeros to end keeping the order of remaining elements. #GFG
		
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				swap(arr, i, count);
				count++;
			}
		}
		printArray(arr);		
	}
	
	public static void leftRotateAnArrayByOne(int arr[]) {
	// #GFG
		
		for(int i = 1; i < arr.length; i++) {
			swap(arr, i, i-1);
		}		
		printArray(arr);
	}
	
	public static void leadersInAnArray(int arr[]) {
	/** An element is called the leader of an array if there is no element
	 *  greater than it on entire the right side. #GFG
	 */
		
		int length = arr.length;
		int leader = arr[length-1];
		System.out.println(arr[length-1]);
		
		for(int i = length-2; i >= 0; i--) {
			if(arr[i] > leader) {
				leader = arr[i];
				System.out.println(leader);
			}
		}
		/** This method prints 'leaders' in reverse order which is not appreciable.
		 *  To print 'leaders' in actual order, 
		 *  we need to use a ArrayList as we dont know how many 'leaders' we can have.
		 *  We add all leaders to ArrayList then reverse the collection and print it.
		 */
	}
	
    public static int maximumWealth(int[][] accounts) {
    // https://leetcode.com/problems/richest-customer-wealth
    	
        int ans = Integer.MIN_VALUE;       
        int sum = 0;
        
        for(int i = 0; i < accounts.length; ++i) {
            for(int j = 0; j < accounts[0].length; ++j) {
                sum = sum + accounts[i][j];
            }
            if(sum > ans) ans = sum;
            sum = 0;
        }        
        return ans;        
    }
    
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    // https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/	
        int lCandies = candies[0];
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i = 1; i < candies.length; ++i) {
            if(lCandies < candies[i]) lCandies = candies[i];
        }
        for(int i = 0; i < candies.length; ++i) {
            if((candies[i] + extraCandies) >= lCandies) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
    
    public static int[] shuffle(int[] nums, int n) {
    // https://leetcode.com/problems/shuffle-the-array
    	
    	 int ans[] = new int[n*2];
         int pointer1 = 0;
         int pointer2 = n;
         int pointerAns = 0;
         
         while(pointer1 < n) {
             ans[pointerAns++] = nums[pointer1++];
             ans[pointerAns++] = nums[pointer2++];
         }
         return ans;
    }
    
    public static int[] sumZero(int n) {
    // https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero
        
    	int arr[] = new int[n];
        int positive = 1;
        int index = 0;
        if(n%2 == 0) {
            while(index < n) {
                arr[index++] = -positive;
                arr[index++] = positive++;                
            }
        } else {
            while(index < n-1) {
                arr[index++] = -positive;
                arr[index++] = positive++;
            }
        }
        return arr;
    }
    
    public static int maxProduct(int[] nums) {
    // https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
    // Not my solution, still in doubt.
        
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] > first) {
                second = first;
                first = nums[i];
            }
            else if(nums[i] > second) {
                second = nums[i];
            }
        }
        return (first-1)*(second-1);
    }
    
    public static int minOperations(int[] nums) {
    // https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
    	
    	int ans = 0;
    	int length = nums.length;
    	
    	if(length <= 1) return 0;
    	for(int i = 0; i < length-1; ++i) {
    		if(nums[i] >= nums[i+1]) {
    			int temp = (nums[i] - nums[i+1]) + 1;
    			ans = ans + temp;
    			nums[i+1] = nums[i+1] + temp;
    		} else {
    			continue;
    		}
    	}
    	return ans;
    }
    
    public static int diagonalSum(int[][] mat) {
    // https://leetcode.com/problems/matrix-diagonal-sum
    	
    	int sum = 0;
    	int dimension = mat[0].length;
    	for(int i = 0; i < dimension; ++i) {
    		sum = sum + mat[i][i] + mat[i][dimension - 1 - i];
    	}
    	
    	if(dimension % 2 == 1) {
    		return sum - mat[dimension/2][dimension/2];
    	}
    	return sum;
    }
    
    public static int[][] matrixReshape(int mat[][], int r, int c) {
    // https://leetcode.com/problems/reshape-the-matrix/
    // Best Solution not mine: https://leetcode.com/problems/reshape-the-matrix/discuss/102491/Java-Concise-O(nm)-time
    	
    	int beforeRows = mat.length;
    	int beforeCols = mat[0].length;
    	if(beforeCols * beforeRows != r * c) {
    		return mat;
    	}
    	
    	int reshapeMatrix[][] = new int[r][c];
    	ArrayList<Integer> temp = new ArrayList<Integer>();

    	for(int i = 0; i < beforeRows; ++i) {
    		for(int j = 0; j < beforeCols; ++j) {
    			temp.add(mat[i][j]);
    		}
    	}
    	int listIndex = 0;
    	for(int i = 0; i < r; ++i) {
    		for(int j = 0; j < c; ++j) {
    			reshapeMatrix[i][j] = temp.get(listIndex++);
    		}
    	}
    	return reshapeMatrix;
    }
    
    
    public static int[] sortArrayByParity(int nums[]) {
    // https://leetcode.com/problems/sort-array-by-parity/
    // Help taken from Algorithms made easy, youtube channel.
    	
    	int first = 0;
    	int last = nums.length-1;
    	
    	while(first < last) {
    		if(nums[first] % 2 == 1 && nums[last] % 2 == 0) {
    			int temp = nums[last];
    			nums[last--] = nums[first];
    			nums[first++] = temp;
    		} else {
    			if(nums[first] % 2 == 0) ++first;
    			if(nums[last] % 2 == 1) --last;
    		}
    	}
    	return nums;
    }
    
    public static int sumOfUnique(int[] nums) {
    // https://leetcode.com/problems/sum-of-unique-elements
    	
    	HashMap<Integer, Integer> uniqueElements = new HashMap<Integer, Integer>();
    	int sum = 0;
    	
    	for(int i = 0; i < nums.length; ++i) {   		
    		if(uniqueElements.containsKey(nums[i])) {
    			if(uniqueElements.get(nums[i]) == 1) sum -= nums[i];
    			uniqueElements.replace(nums[i], 0);
    		} else {	
    			uniqueElements.putIfAbsent(nums[i], 1);
    			sum += nums[i]; 
    		}
    	}
    	
    	return sum;
    }
    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
