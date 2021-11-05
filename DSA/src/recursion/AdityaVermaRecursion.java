package recursion;

import java.util.*;

public class AdityaVermaRecursion {

	public static void main(String[] args) {
		
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		nums.add(9);
//		nums.add(8);
//		nums.add(4);
//		nums.add(1);
		
		// // Sort an array using recursion.
//		System.out.println(sort(nums));
		
		Stack<Integer> nums = new Stack<Integer>();
		nums.push(5);
		nums.push(1);
		nums.push(0);
		nums.push(2);
		nums.push(25);
		
		// // Sort a stack using recursion.
//		System.out.println(sortStack(nums));
		
		// // Delete middle element from a stack in O(1) space.
//		System.out.println(middleElement(nums));
		
		// // Reverse stack in O(1) space.
		System.out.println(reverseStack(nums));
		
		System.out.println(kthGrammar(4, 5));
		
	}
	
	
	// Sort an array using recursion.
	public static ArrayList<Integer> sort(ArrayList<Integer> in) {
	// [9, 8, 4, 1]	
		if(in.size() == 1) return in;
		
		// Removing the last element and storing the removed element in a variable.
		int lastElement = in.remove(in.size() - 1);
		sort(in);
		return insert(in, lastElement);
	}
	// This function is a part of function "sort".
	public static ArrayList<Integer> insert(ArrayList<Integer> temp, int elementToBeInserted) {
		
		if(temp.size() == 0 || temp.get(temp.size() - 1) <= elementToBeInserted) {
			temp.add(elementToBeInserted);
			return temp;
		}
		// Removing the last element and storing the removed element in a variable.
		int lastElement = temp.remove(temp.size() - 1);
		insert(temp, elementToBeInserted);
		temp.add(lastElement);
		return temp;
		
	}
	
	
	// Sort a stack using recursion.
	public static Stack<Integer> sortStack(Stack<Integer> in) {
	// This problem is almost same as "Sort an array using recursion". I did this on my own!
		
		if(in.empty()) return in;
		
		int popped = in.pop();
		sortStack(in);
		return insertStack(in, popped);
	}
	// This function is a part of function "sortStack".
	public static Stack<Integer> insertStack(Stack<Integer> temp, int elementToBeInserted) {
		if(temp.empty() || temp.peek() <= elementToBeInserted) {
			temp.push(elementToBeInserted);
			return temp;
		}
		
		int popped = temp.pop();
		insertStack(temp, elementToBeInserted);
		temp.push(popped);
		return temp;
	}
	
	
	// Delete middle element from a stack in O(1) space.
	public static Stack<Integer> middleElement(Stack<Integer> in) {
	// I did this on my own.
		
		if(in.empty()) return in;
		
		int middleIndex = in.size()/2;	
		return deleteMiddle(in, middleIndex);
	}
	// This function is a part of function "sortStack".
	public static Stack<Integer> deleteMiddle(Stack<Integer> temp, int middleIndex) {
		if(middleIndex == 0) {
			temp.pop();
			return temp;
		}
		
		int popped = temp.pop();
		deleteMiddle(temp, --middleIndex);
		temp.push(popped);
		return temp;
	}
	
	
	// Reverse stack in O(1) space.
	public static Stack<Integer> reverseStack(Stack<Integer> in) {
	// I did this on my own.
		if(in.empty()) return in;
		
		int popped = in.pop();
		return addElementAtBottom(in, popped);
	}
	// This function is a part of function "sort".
	public static Stack<Integer> addElementAtBottom(Stack<Integer> temp, int elementToAdd) {		
		if(temp.empty()) {
			temp.push(elementToAdd);
			return temp;
		}
		
		int popped = temp.pop();
		addElementAtBottom(temp, elementToAdd);
		temp.push(popped);
		return temp;
	}
	
	// Kth symbol in grammer. LEETCODE
	public static int kthGrammar(int N, int K) {
	// Im unable to understand this, still in doubt. #COPIED	    
		if(N==1 && K==1) return 0;
		int mid = (int) (Math.pow(2, N-1)/2);
		
		if(K<=mid) {
			return kthGrammar(N-1, K);
		} else {
			// Bitwise XOR
			return (kthGrammar(N-1, K-mid)^1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
