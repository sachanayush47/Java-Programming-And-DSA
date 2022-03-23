package recursion;

import java.util.*;

public class AdityaVermaRecursion {

	public static void main(String[] args) {
		
		printAllSubsequencesOfString("AYUSH", "");
		
	}
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	
	
	/* ------------------------------------------------------------------ */
	
	// printAllSubsequencesOfString OR Print Permutations OR Print Powerset.
	public static void printAllSubsequencesOfString(String input, String output) {
		
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		String output1 = output;					// Not Take
		String output2 = output + input.charAt(0);	// Take
		
		input = input.substring(1);
		
		printAllSubsequencesOfString(input, output1);
		printAllSubsequencesOfString(input, output2);
	}
	
	/* ------------------------------------------------------------------ */
	
    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
    // Didnt get it.
    	
        if (n == 1) {
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }
    
    /* ------------------------------------------------------------------ */
	
	// Sort an array using recursion.
	public static ArrayList<Integer> sort(ArrayList<Integer> in) {
	// [9, 8, 4, 1]	
		if(in.size() == 1) return in;
		
		// Removing the last element and storing the removed element in a variable.
		int lastElement = in.remove(in.size() - 1);
		sort(in);
		return insert(in, lastElement);
	}
	
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
	
	/* ------------------------------------------------------------------ */
	
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
	
	/* ------------------------------------------------------------------ */
	
	// Delete middle element from a stack.
	public static Stack<Integer> middleElement(Stack<Integer> in) {
	// I did this on my own.
		
		if(in.empty()) return in;
		
		int middleIndex = in.size()/2;	
		return deleteMiddle(in, middleIndex);
	}

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
	
	/* ------------------------------------------------------------------ */
	
	// Reverse stack.
	public static Stack<Integer> reverseStack(Stack<Integer> in) {
	// I did this on my own.
		if(in.empty()) return in;
		
		int popped = in.pop();
		return addElementAtBottom(in, popped);
	}

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
	
	/* ------------------------------------------------------------------ */
	
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
