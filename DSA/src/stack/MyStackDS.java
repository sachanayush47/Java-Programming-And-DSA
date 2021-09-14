package stack;

public class MyStackDS<E> {
	
	Node<E> head;
	
	public void push(E data) {
		Node<E> toAdd = new Node<E>(data);
		if(empty()) {
			head = toAdd;
			return;
		}
		Node<E> temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = toAdd;	
	}
		
	public E pop() throws Exception {		
		if(empty()) {
			throw new Exception("List is empty, not possible");
		}
		Node<E> temp = head;
		
		while(temp.next.next != null) {
			temp = temp.next;
		}
		E popped = (temp.next).data;
		temp.next = null;
		return popped;
	}
	
	public E peek() throws Exception{
		if(empty()) {
			throw new Exception("List is empty, not possible");
		}
		Node<E> temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	public boolean empty() {
		return head == null;
	}
	
	public void print() throws Exception {
		if(empty()) {
			throw new Exception("List is empty, not possible");
		}
		Node<E> temp = head;
		while(temp != null) {			
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public boolean contains(E value) {
		boolean result = false;
		if(empty()) return result;

		Node<E> temp = head;
		while(temp != null) {
			if(temp.data == value) {
				result = true;
				break;
			}
			temp = temp.next;
		}
		return result;
	}
	
}

class Node<E> {

	public E data;
	public Node<E> next;
		
	public Node(E data) {
		this.data = data;
		next = null;
	}
}
