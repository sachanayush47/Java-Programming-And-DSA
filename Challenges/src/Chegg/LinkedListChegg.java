package Chegg;

public class LinkedListChegg {

	static Node head = null;
	static int size = 0;
	
	public static void main(String[] args) {
		
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(6);
//		head.next.next.next.next = new Node(7);
//		head.next.next.next.next.next = new Node(8);
		size = 4;
		printLL();
		
		swap1_2();
		
		printLL();
		
		addLast(new Node(4));
		
		printLL();
		
		insertMiddle(new Node(5));
		
		printLL();
	}
	
	static void printLL() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	static void swap1_2() {
		if(head != null && head.next != null) {
			Node temp = head;
			head = temp.next;
			
			// You missed that line. You have to link 1st node to the 3rd node.
			temp.setNext(head.next);
			
			head.setNext(temp);
		}
	}
	
	static void addLast(Node n) {
		
		// In the addLast() method, you were using a for-loop
		// in which, you increment the variable "size" by 1 in each iteration.
		// Increament "size" by 1 leads to infinite loop.
		
		if(head == null) head = n;
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			
			temp.setNext(n);;
			++size;
		}
	}
	
	static void insertMiddle(Node n) {
		Node temp = head;
		for(int i = 0; i < size/2 - 1; ++i) {
			temp = temp.next;
		}
		
		n.setNext(temp.next);
		temp.setNext(n);
	}

}

class Node {
	
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
}
