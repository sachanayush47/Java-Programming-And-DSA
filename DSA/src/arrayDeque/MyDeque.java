package arrayDeque;

public class MyDeque<E> {
	
	DoublyNode head, tail;
	
	public void addFirst(int data) {
		DoublyNode toAdd = new DoublyNode(data);
		if(isEmpty()) {
			head = tail = toAdd;
			return;
		}
		toAdd.next = head;
		head.prev = toAdd;
		head = toAdd;
	}
	
	public void addLast(int data) {
		DoublyNode toAdd = new DoublyNode(data);
		if(isEmpty()) {
			head = tail = toAdd;
			return;
		}
		tail.next = toAdd;
		toAdd.prev = tail;
		tail = toAdd;
		
	}
	
	public int removeLast() throws Exception{
		if(isEmpty()) {
			throw new Exception("List is empty");
		}
		int removedData = tail.data;
		tail = tail.prev;
		tail.next = null;
		
		if(tail == null) {
			head = null;
		}		
		return removedData;
		
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}

//Node class for Dequeue
class DoublyNode {
	DoublyNode prev, next;
	int data;
	
	public DoublyNode(int data) {
		this.data = data;
	}
}
