package arrayDeque;

import java.util.ArrayDeque;

public class ArrayDequeDS {

	public static void main(String[] args) {
		
	/**	ArrayDeque:
	 * 	An ArrayDeque(Array Doubly Ended Queue, pronounced as 'ArrayDeck') is a special
	 *	kind of a growable array that allows us to add or remove an from both sides of array. 		
	 * 	An ArrayDeque implementation can be used as a Stack or a Queue.
	 * 	ArrayDeque is faster than Stack
	 * 
	 * 	Methods:
	 *		..Operation..			..Method(Returns null/false)..		..Method(Thows exception)..
	 * 	Insertion from headDeque			offerFirst(e)					addFirst(e)
	 * 	Removal from heaDeque			pollFirst()							removeFirst()
	 * 	Retrieval from heaDeque			peekFirst()							getFirst()
	 * 	Insertion from tail				offerLast(e)						addLast(e)	
	 * 	Removal from tail				pollLast()							removeLast()
	 * 	Retrieval from tail				peekLast()							getLast()
	*/
		
		ArrayDeque<Integer> aDeque = new ArrayDeque<>();
		
		aDeque.addFirst(23);
		aDeque.addFirst(4);
		
		aDeque.pop();
		System.out.println(aDeque.peek());
		
		
		aDeque.push(10);
		aDeque.push(20);
		aDeque.push(30);
		
		System.out.println(aDeque.pop());
		System.out.println(aDeque.pop());

	}

}
