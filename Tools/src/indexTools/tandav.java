package indexTools;

import java.util.*;


@SuppressWarnings("unused")
public class tandav {

//	public static void main(String[] args) {
		     
/**
 		int score;
		int NUM_TESTS;
		int sum = 0;

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter total number of test you have");
		NUM_TESTS = keyboard.nextInt();
		
		for(int i = 1; i <= NUM_TESTS; ++i) {
		
			System.out.print("Enter the score on the test " + i + ": "); //prompt
			score = keyboard.nextInt(); // read in the next integer
			sum += score;
		
		}
		keyboard.close();
		
		double AVERAGE;
		AVERAGE = (sum) / (double) NUM_TESTS; // results
		System.out.println("Your average is " + AVERAGE);

		int odd = 0;
		if(odd+1 > -1) System.out.println(odd);
*/
		
/**
  	We will solve this question with wrost case in O(n) time complexity and O(1) time complexity by	using count sort.
  	Using count sort we can solve this in O(n) time complexity and O(1) time complexity.
   	
   	What is count sort? 
   	It is linear algorithm, it does not make any comparisson to sort. 
   	It assumes that the number to be sorted is in range 1 to n.
   	
   	Let assume a unsorted array of 0s, 1s and 2s
   	where 0 = “Ice cream is too cold”, 1 = “Ice cream is just right”, 
   	2 = “Ice cream is melted".
   	
   	Create three variable named as "cold", "perfect" and "melted".
   	and traverse through the array and increment "cold" if array[i] == 0,
   	increment "perfect" if array[i] == 1 and increment "melted" if array[i] == 2.
   	
   	Now in the given array of size N and refill it with the 0s, 1s and 2s using a for loop.
   	
   	Below code demonstrate the above explaination.  	
   	

		int arr[] = {0, 2, 1, 2, 0};
		int arr2[] = {0, 1, 0};
		
		System.out.println("Input Array");
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("Output array");
		countSort(arr);		
		
	}
	
	public static int fn_sumInteger(int n) {
		if(n==0) return n;
		return n + fn_sumInteger(n-1);
	}
	
	public static void countSort(int arr[]) {
		
		int cold = 0, perfect = 0, melted = 0;
		
		// Counting 0s, 1s and 2s.
		for(int i = 0; i < arr.length; ++i) {	
			if(arr[i] == 0) {
				++cold;
			} else if(arr[i] == 1) {
				++perfect;
			} else {
				++melted;
			}
		}
		
		// Filling same array with 0s, 1s, and 2s.
		for(int i = 0; i < arr.length; ++i) {
			if(cold > 0) {
				arr[i] = 0;
				--cold;
			} else if(perfect > 0) {
				arr[i] = 1;
				--perfect;
			} else {
				arr[i] = 2;
				--melted;
			}
		}
		
		// Printing the sorted array.
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
 */
		
		
/**	
 	Lets first understand few basic things and our algorithmic approch.
  	We know, Stack follows "Last in first out" and Queue "First in fisrt out".
  	
  	Explaination of Algorithm:
  		
  	I have created a method with name "reverseStackUsingQueue". The method takes Stack as a parameter.
  	The method has one queue and two while loops. Queue is used to store stack element in the reversed order. In the first while loop, we call pop() method of stack to remove all the elements from back of the stack one by one and add the popped element to the queue simultaneously using queue's add() method. Now our stack is empty and all elements of stack are stored in queue in reverse order and we have to add all those element to the stack. To do this we have second loop. In second loop, we call remove() method of queue to remove all the elements from front of the queue one by one and add the removed element to the stack simultaneously using stack's push() method.
  	First while loop runs till the stack becomes empty and second while loop runs till the queue becomes empty.
  
 */
	public static void main(String[] args) {
		
/**		// Driver Code
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		
		System.out.println("Original Stack:");
		System.out.println(stack);
		
		stack = reverseStackUsingQueue(stack);
		
		System.out.println("Reversed stack using queue:");
		System.out.println(stack);
*/
		
/**		
 
Here is the recursive approach to solve this,

Base condition when m and n becomes equal to each other, we return n else if m is greater than n then call the function recursively func(m - n, n) 

 
	
*/

//		String text = "UTAS";
//		char ch = text.charAt(4);
//		System.out.println(ch);
//		int[] arr = new int[5];
		
//		for (int i = 3; i > 0; i--) {
//			System.out.print((i * 3) + " ");
//		}
		
//		char X = '4';
//		
//	//	Character.isdigit(X) ;
//
//		System.out.println(Character.isDigit(X));
	

			System.out.println( doTask (3) );



			
		

//		X.isDigit();
//
//		X.isdigit();
		
	}
	
	public static int doTask (int x, int y) {
		
		return x * y;
	
	}

	public static double doTask (double x) {
		
		return x * x;
	}
	
	public static void printChar(char ch) {
		for(int i = 1; i<=3; i++) {
			System.out.println(ch);
		}
	}
	
	public static Stack<Integer> reverseStackUsingQueue(Stack<Integer> nums) {
		
		// Queue to store stack's element in reversed order.
		Queue<Integer> revStack = new LinkedList<Integer>();
		
		// Adding stack elements to queue in reversed order.
		while(!nums.empty()) {
			revStack.add(nums.pop());
		}
		
		// Now our stack is empty and filling it from queue.
		while(!revStack.isEmpty()) {
			nums.push(revStack.remove());	
		}
		
		return nums;
		
	}
	
	public static void random(int m, int n) {
		
		while(m != n) {
			if(m > n) {
				m = m - n;
			} else {
				n = n - m;
			}
		}
		System.out.println("Iterative");
		System.out.println("m " + m + " n " + n);

	}
	
	public static int recursiveSolution(int m, int n) {
				
		if(m == n) {
			return n;
		}		
		if(m > n) {
			return recursiveSolution(m - n, n);
		}
		return recursiveSolution(m, n - m);

	}
	    
}

//public class SLL {
//
//private static class Node{
//
//	private int data;
//	private Node next;
//	private Node(int dataItem) {
//
//		data = dataItem;
//		next = null;
//	}
//
//	private Node(int dataItem, Node nodeRef) {
//
//		data = dataItem;
//		next = nodeRef;
//	}
//}
//
//private Node head = null; private int size = 0;
//
//}
//
//
//public class SLL<E> {
//	
//	private Node<E> head = null;
//	private int size = 0;
//	
//	private static class Node<E> {
//		E data;
//		Node<E> next;		
//		private Node(E dataItem) {
//			data = dataItem;
//			next = null;
//		}
//		private Node(E dataItem, Node<E> nodeRef) {
//			data = dataItem;
//			next = nodeRef;
//		}
//	}
//}


/**


package indexTools;

public class SLL<E> {
	
	private Node<E> head = null;
	private int size = 0;
	
	private static class Node<E> {
		E data;
		Node<E> next;		
		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}
	
	// Add Data at the end of list. This method is optional.
	private void add(E data) {			
		Node<E> toAdd = new Node<E>(data);		
		if(head == null) {
			head = toAdd;
			++size;
			return;
		}		
		Node<E> temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		++size;
		temp.next = toAdd;
 	}
	
	// Sums all the even number present in the linkedlist.
	private int evenNumberSum() {		
		int sum = 0;		
		if(head == null) {
			return sum;
		}		
		Node<E> temp = head;
		while(temp != null) {
			
			if((int)temp.data % 2 == 0) {
				sum = sum + (int)temp.data;				
			}
			temp = temp.next;
		}		
		return sum;		
	}
	

	
	public static void main(String[] args) {
		
		SLL<Integer> myLL = new SLL<Integer>();		
		
		myLL.add(10);
		myLL.add(15);
		myLL.add(20);
		myLL.add(25);
		myLL.add(30);
		myLL.add(35);
		myLL.add(40);		
			
		int res = myLL.evenNumberSum();
		System.out.println("Result: " +res);

	}

}

		
		
		
		
		
*/
