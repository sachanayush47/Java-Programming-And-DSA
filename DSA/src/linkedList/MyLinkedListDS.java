package linkedList;

public class MyLinkedListDS<E> {
	
	Node<E> head;
	
	// Add Data at the end of list.
	public void add(E data) {	
		
		Node<E> toAdd = new Node<E>(data);		
		if(isEmpty()) {
			head = toAdd;
			return;
		}
		Node<E> temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}	
		temp.next = toAdd;
 	}
	
	// Add Data at the given index.
	public void add(int index, E data) throws Exception {
		
		if(index >= size() || index < 0) {
			throw new Exception("Index not in range");
		}		
		Node<E> toAdd = new Node<E>(data);
		Node<E> temp = head;
		Node<E> prev = null;
		for(int i = 0; i < index; i++) {
			if(i == index-1) prev = temp;			
			temp = temp.next;
		}		
		toAdd.next = temp;	
		
		if(index == 0) {
			head = toAdd;
			return;
		}
		prev.next = toAdd;	
	}
	
	// Removes Data at the given index.
	public E remove(int index) throws Exception {
		
		if(index >= size() || index < 0) {
			throw new Exception("Index not in range");
		}
		Node<E> temp = head;
		Node<E> prev = null;
		for(int i = 0; i < index; i++) {
			if(i == index-1) prev = temp; 
			temp = temp.next;
		}
		E removedValue = temp.data;
		
		if(index == 0) {
			head = temp.next;
			return removedValue;
		}
		prev.next = temp.next;
		return removedValue;
	}


	
	// Returns Data present at given index.
	public E get(int index) throws Exception {
		if(index >= size() || index < 0) {
			throw new Exception("Index not in range");
		}
		Node<E> temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
		
	}
	
	// Returns Boolean whether given Data present in list or not.
	public boolean contains(E value) {
		Node<E> temp = head;
		for(int i = 0; i < size(); i++) {
			if(temp.data == value) return true;
			temp = temp.next;
		}
		return false;
	}
	
	// Replaces Data by the given Data in the list.
	public void set(int index, E value) throws Exception {		
		if(isEmpty() || index >= size() || index < 0) {
			throw new Exception("Index not in range");
		}
		Node<E> temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		temp.data = value;
	}
	
	// Is list empty or not. Return Boolean.
	public boolean isEmpty() {
		return head == null;
	}
	
	// Return size of array.
	public int size() {
		
		int size = 0;		
		if(isEmpty()) return size;
		
		Node<E> temp = head;
		while(temp != null) {			
			++size;			
			temp = temp.next;
		}
		return size;	
	}
	
	// Prints the whole list.
	public void printList() {
		Node<E> temp = head;
		while(temp != null) {			
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	// Completely delete the whole list.
	public void clear() {
		head = null;
	}
	
}


// Node class for LinkedList
class Node<E> {

	public E data;
	public Node<E> next;
		
	public Node(E data) {
		this.data = data;
		next = null;
	}
}

