package priorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueDS {

	public static void main(String[] args) {
		
	/**	Priority Queue:
	 * 	A priority queue is a special type of queue in which each element is associated
	 * 	with a priority and is served according to its priority.
	 * 	If elements with the same priority occur, they are served according to their order
	 * 	in the queue.	
	 * 	In a queue, the first-in-first-out rule is implemented whereas.
	 * 	In a priority queue, the values are removed	on the basis of priority.
	 * 	The element with the highest priority is removed first.
	 */
		
		PriorityQueue<String> pQueue = new PriorityQueue<String>();
	
	/**	Methods:
 	 *	add()
	 * 	remove()
	 * 	element() 
	 */
		
		pQueue.add("Kiwi");
		pQueue.add("Apple");
		pQueue.add("Mango");
		pQueue.add("Banana");
		
		System.out.println(pQueue);
		System.out.println(pQueue.remove());
		System.out.println(pQueue.remove());
		System.out.println(pQueue.remove());
		System.out.println(pQueue.remove());

	}

}
