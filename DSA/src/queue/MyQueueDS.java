package queue;


public class MyQueueDS<E> {
	
	Node<E> head;
	Node<E> rear;
	
	public void add(E data) {
		Node<E> toAdd = new Node<E>(data);
		if(isEmpty()) {
			head = toAdd;
			rear = toAdd;
			return;
		}
		rear.next = toAdd;
		rear = rear.next;
	}
	
	public E pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty");
		}
		E popped = head.data;
		head = head.next;
		
		if(isEmpty()) rear = null;
		
		return popped;
	}
	
	public E element() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return head.data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

}

//Node class for Queue
class Node<E> {

	public E data;
	public Node<E> next;
		
	public Node(E data) {
		this.data = data;
		next = null;
	}
}
