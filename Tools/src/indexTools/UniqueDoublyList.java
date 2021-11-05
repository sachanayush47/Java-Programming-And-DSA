package indexTools;


public class UniqueDoublyList {
	
	Node head;
	
	// Add Data at the end of list.
	public void add(int data) {	
		
		Node toAdd = new Node(data);		
		if(head == null) {
			head = toAdd;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}	
		temp.next = toAdd;
 	}
	
	public void append(Node listOne, Node listTwo) {
		Node temp = listOne;
		
		// Iterating to the last node.
		while(temp.next != null) {
			temp = temp.next;
		}
		
		// Appending the list1 to list2.
		temp.next = listTwo;
	}

	public static void main(String[] args) {
		
		
		UniqueDoublyList listOne = new UniqueDoublyList();
		
		listOne.add(10);
		listOne.add(50);
		listOne.add(20);
		listOne.add(30);
		listOne.add(40);
		
		UniqueDoublyList listTwo = new UniqueDoublyList();
		
		listTwo.add(60);
		listTwo.add(70);
		listTwo.add(80);
		listTwo.add(90);
		listTwo.add(100);
		
	}
	
	class Node {

		public int data;
		public Node next;
			
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	

}
