package stack;

import java.util.Stack;

public class StackDS {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
	/**	Java Collection framework provides a Stack class that models and implements a 
	 * 	Stack data structure. The class is based on the basic principle of last-in-first-out.
	 * 	In addition to the basic push and pop operations, the class provides three more
	 * 	functions of empty, search, and peek. The class can also be said to extend Vector
	 * 	and treats the class as a stack with the five mentioned functions.
	 * 	Top-most element in s Stack is head.
	 */
	 
		
		Stack<Integer> sLL = new Stack<Integer>();
		
		/**	Methods of Stack:
		 * 		push(e)
		 * 		pop()
		 * 		peek()
		 * 		search(e)					Search for particular data and returns boolean.	
		 * 		empty() 
		 * 		size()
		 */
		
		sLL.push(10);
		sLL.push(20);
		
		System.out.println(sLL.get(0));
		
	
	}

}
