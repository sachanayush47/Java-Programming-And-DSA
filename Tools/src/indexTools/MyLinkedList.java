package indexTools;

public class MyLinkedList {

	public static void main(String[] args) {
		
		
		// Creating node class object.
		Node obj1 = new Node(10);
		Node obj2 = new Node(45);
		Node obj3 = new Node(65);
		Node obj4 = new Node(85);
		
		// Linking the node class object.
		obj1.next = obj2;
		obj2.next = obj3;
		obj3.next = obj4;
		
		// Prints the result.
		System.out.println(sum(obj1));
		
	}

		
//		Node obj1 = new Node(22);
//		Node obj2 = new Node(33);
//		Node obj3 = new Node(44);
//		Node obj4 = new Node(55);
//		
//		obj1.next = obj2;
//		obj2.next = obj3;
//		obj3.next = obj4;
//		
//		Node obj5 = new Node(66);
//		Node obj6 = new Node(77);
//		Node obj7 = new Node(88);
//		Node obj8 = new Node(99);
//		
//		obj5.next = obj6;
//		obj6.next = obj7;
//		obj7.next = obj8;
		
		
		
	//	 {22, 33, 44, 55} and list2 is {66, 77, 88, 99} 
		
		
		
		
//		append(obj1, obj5);
		
//		System.out.println(sum(obj1));
//		
//		print(obj1);
		
		

	
	
	
	static int sum(Node list) {
		int sum = 0;
		Node tempList = list;
		
		while(tempList != null) {
			sum = sum + tempList.data;
			tempList = tempList.next;
		}
		return sum;		
	}
	
	void append(Node list1, Node list2) {
		Node temp = list1;
		
		// Iterating to the last node.
		while(temp.next != null) {
			temp = temp.next;
		}
		
		// Appending the list1 to list2.
		temp.next = list2;
	}
	
	
	
	static void print(Node list) {
		Node temp = list;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}

	class Node {
	
		int data;
		Node next;
	
		Node(int data) {
			this.data = data;
			next = null; 
		}
	}
