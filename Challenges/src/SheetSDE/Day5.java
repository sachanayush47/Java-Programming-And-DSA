package SheetSDE;

import java.util.*;

public class Day5 {

	public static void main(String[] args) {
		
		ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
		reverseList1(head1);
	}
	
	/* ------------------------------------------------------------------ */
	
								// Add Two Numbers
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		int carry = 0;
		ListNode temp1 = l1, temp2 = l2;
		ListNode ans = null, curr = null;
		
		while(temp1 != null || temp2 != null || carry != 0) {
			
			int val1 = 0, val2 = 0;
			
			if(temp1 != null) {
				val1 = temp1.val;
				temp1 = temp1.next;
			}
			
			if(temp2 != null) {
				val2 = temp2.val;
				temp2 = temp2.next;
			}
			
			int sum = val1 + val2 + carry;
			carry = 0;
			
			if(sum > 9) {
				sum = sum % 10;
				carry = 1;
			}
			
			if(ans == null) {
				ans = new ListNode(sum);
				curr = ans;
			} else {
				curr.next = new ListNode(sum);
				curr = curr.next;
			}
		}
		
		return ans;
	}
	
	/* ------------------------------------------------------------------ */
	
						// Remove Nth Node From End of List
	
	// Optimal		TC O(n)		SC O(1)		
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
	
		ListNode start = new ListNode(-1);
		ListNode fast = start;
		ListNode slow = start;
		
		while(n > 0) {
			fast = fast.next;
			--n;
		}
		
		if(fast.next == null) head = head.next;
		
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;
		
		return head;
	}
	
	
	// Better		TC O(n)		SC O(n)
	public static ListNode removeNthFromEnd1(ListNode head, int n) {
		return removeNthFromEndHelper1(head, new int[]{n});
	}
	
	public static ListNode removeNthFromEndHelper1(ListNode head, int arr[]) {
		if(head == null) return null;
		ListNode node = removeNthFromEndHelper1(head.next, arr);
		
		if(arr[0] == 1) return node;
		
		--arr[0];
		head.next = node;
		return head;
	}
	
	/* ------------------------------------------------------------------ */
	
						//	Merge two sorted Linked List
	
	// Optimal		TC O(n)		SC O(1)
	public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
		
		// Base cases
        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;
        
		ListNode head = null;
		ListNode p1 = list1;
		ListNode p2 = list2;
		
		if(list1.val < list2.val) {
			head = list1;
			p1 = p1.next;
		} else {
			head = list2;
			p2 = p2.next;
		}
		
		ListNode curr = head;
		
		while(p1 != null && p2 != null) {
			if(p1.val < p2.val) {
				curr.next = p1;
				curr = curr.next;
				p1 = p1.next;
			} else {
				curr.next = p2;
				curr = curr.next;
				p2 = p2.next;
			}
		}
		
		if(p1 == null) curr.next = p2;
		else curr.next = p1;
		
		return head;
	}
	
	/* ------------------------------------------------------------------ */
	
						//	Find the middle of LinkedList
	
	// Optimal : TC O(n)	SC O(1)
	public static ListNode middleNode(ListNode head) {
		
		if(head == null) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	/* ------------------------------------------------------------------ */
	
								//	Reverse a LinkedList
	
	// Optimal : TC O(n) 	SC O(1)
	public static ListNode reverseList2(ListNode head) {
		if(head == null) return null;
		
		ListNode prev = head;
		ListNode curr = head.next;
        
		prev.next = null;
		if(curr == null) return prev;
		ListNode next = curr.next;
		
		while(curr != null) {
			curr.next = prev;
            if(next == null) return curr;
            prev = curr;
			curr = next;
			next = curr.next;
		}
		
		return curr;
	}
	
	// Brute : TC O(n)		SC O(n)
	public static ListNode reverseList1(ListNode head) {
		if(head == null) return null;
		
		Stack<ListNode> s = new Stack<>();
		while(head != null) {
			s.push(head);
			head = head.next;
		}
		
		ListNode temp = s.pop();
		head = temp;
		while(!s.isEmpty()) {
			temp.next = s.pop();
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}
}

// -----------------------------------------

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
	
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
