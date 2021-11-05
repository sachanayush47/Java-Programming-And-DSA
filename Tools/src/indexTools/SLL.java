package indexTools;


public class SLL {

	private Node head = null;
	int size = 0;
	private static class Node{

	private int data;
	private Node next;
	private Node(int dataItem) {

		data = dataItem;
		next = null;
	}

	private Node(int dataItem, Node nodeRef) {

		data = dataItem;
		next = nodeRef;
	}
}

	
	// Add Data at the end of list. This method is optional.
	private void add(int data) {			
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
	
	// Sums all the even number present in the linkedlist.
	private int evenNumberSum() {		
		int sum = 0;		
		if(head == null) {
			return sum;
		}		
		Node temp = head;
		while(temp != null) {
			
			if(temp.data % 2 == 0) {
				sum = sum + temp.data;				
			}
			temp = temp.next;
		}		
		return sum;		
	}
	
	
	
	
	
	

	
	public static void main(String[] args) {
		
		SLL myLL = new SLL();		
		
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
