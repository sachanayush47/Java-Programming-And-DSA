package linkedList;

public class LS_LinkedList_Problems {

	public static void main(String[] args) {
		
		Node<Integer> ll1 = new Node<>(1);
		ll1.next = new Node<>(2);
		ll1.next.next = new Node<>(3);
		ll1.next.next.next = new Node<>(4);
		ll1.next.next.next.next = new Node<>(5);
		ll1.next.next.next.next.next = new Node<>(6);
		
		System.out.println(reverse(ll1));
		
		
	//	printList(reverse(ll1));
	}
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	public static Node<Integer> reverse(Node<Integer> head) {
		Node<Integer> result = null;
		revLL(head, result);
		System.out.println(result);
		return result;
	}
	
	public static void revLL(Node<Integer> head, Node<Integer> result) {
		if(head == null) return;
		revLL(head.next, result);
		add(head.data, result);
	}
	
	public static void add(int data, Node<Integer> result) {
		Node<Integer> toAdd = new Node<>(data);
		if(result == null) {
			result = toAdd;
			System.out.println(result.data);
			return;
		}

		Node<Integer> temp = result;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
	//	System.out.println("hi");
		
		temp.next = toAdd;
	}
	
	
	
	/* ------------------------------------------------------------------ */
	public static int getDecimalValue(Node<Integer> head) {
		int size = 0;
		Node<Integer> temp = head;
		while(temp.next != null) {
			temp = temp.next;
			++size;
		}
		
		int res = 0;
		
		temp = head;
		while(temp != null) {
			res += temp.data == 0 ? 0 : Math.pow(2, size);
			--size;
			temp = temp.next;
		}
		
		return res;
	}
	
	/* ------------------------------------------------------------------ */
	public static Node<Integer> middleOfLL(Node<Integer> head) {

		// My solution, uses to iteration.
//		int size = 0;
//		Node<Integer> temp = head;
//		while(temp != null) {
//			temp = temp.next;
//			++size;
//		}
//		
//		int mid = size/2 + 1;
//		
//		temp = head;
//		while(mid > 0) {
//			temp = temp.next;
//			--mid;
//		}
//		return temp;
		
		// Someone's solution from leetcode using 1 iteration. Very clean and short.
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static void printList(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp != null) {			
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	
	

}
