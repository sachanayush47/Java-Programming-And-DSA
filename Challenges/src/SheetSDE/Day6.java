package SheetSDE;

import java.util.*;

public class Day6 {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
							// Flattening a Linked List
	
	public static Node flatten(Node root) {
		if(root == null) return null;
		if(root.next == null) return root;
		Node head = flatten(root.next);
		return mergeTwoLists1(root, head);
	}
	
	public static Node mergeTwoLists1(Node list1, Node list2) {
		
		// Base cases
        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;
        
        Node head = null;
        Node p1 = list1;
        Node p2 = list2;
		
		if(list1.data < list2.data) {
			head = list1;
			p1 = p1.bottom;
		} else {
			head = list2;
			p2 = p2.bottom;
		}
		
		Node curr = head;
		
		while(p1 != null && p2 != null) {
			if(p1.data < p2.data) {
				curr.bottom = p1;
				curr = curr.bottom;
				p1 = p1.bottom;
			} else {
				curr.bottom = p2;
				curr = curr.bottom;
				p2 = p2.bottom;
			}
		}
		
		if(p1 == null) curr.bottom = p2;
		else curr.bottom = p1;
		
		return head;
	}
	
	static class Node {
		int data;
		Node next;
		Node bottom;
		Node(int d) {
			data = d;
			next = null;
			bottom = null;
		}
	}
	
	/* ------------------------------------------------------------------ */
	
							// Linked List Cycle II
	
	public static ListNode detectCycle2(ListNode head) {
		
		if(head == null) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode entry = head;
		
		while(fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				while(entry != slow) {
					entry = entry.next;
					slow = slow.next;
				}
				
				return entry;
			}
		}
		
		return null;
	}
	
	public static ListNode detectCycle1(ListNode head) {
		
		if(head == null) return null;
		
		Set<ListNode> s = new HashSet<>();
		ListNode temp = head;
		
		while(temp != null) {
			boolean node = s.add(temp);
			if(node == false) return temp;
			temp = temp.next;
		}
		
		return null;
	}

	
	/* ------------------------------------------------------------------ */
	
					// Check if a LinkedList is palindrome or not.
	
	public static boolean isPalindrome(ListNode head) {
		
		ListNode temp = head;

		ListNode mid = findMiddle(head);
		mid.next = reverseLL(mid.next);
	
		mid = mid.next;
		
		while(mid != null) {
			if(mid.val != temp.val) return false;
			temp = temp.next;
			mid = mid.next;
		}
		
		return true;
	}
	
	public static ListNode findMiddle(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static ListNode reverseLL(ListNode head) {
		
		if(head == null || head.next == null) return head;
		
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return curr;
	}
	
	/* ------------------------------------------------------------------ */
	
					//	Reverse a LinkedList in groups of size k.
	
	/* ------------------------------------------------------------------ */
	
	public static boolean hasCycle2(ListNode head) {
        
		if(head == null || head.next == null) return false;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) return true;
		}
		
		return false;
    }
	
	public static boolean hasCycle1(ListNode head) {
        
		Set<ListNode> s = new HashSet<>();
		ListNode temp = head;
		
		while(temp != null) {
			boolean isCycle = s.add(temp);
			if(isCycle == false) return true;
			temp = temp.next;
		}
		
		return false;
    }
	
	/* ------------------------------------------------------------------ */
	
	// Optimal		TC O(n + m)		SC O(1)
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		
		if(headA == null || headB == null) return null;
		
		ListNode temp1 = headA;
		ListNode temp2 = headB;
		
		while(temp1 != temp2) {
			temp1 = temp1 == null ? headB : temp1.next;
			temp2 = temp2 == null ? headA : temp2.next;
		}
		
		return temp1;
	}
	
	// Better		TC O(n + m)		SC O(n + m)
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        
		Set<ListNode> s = new HashSet<>();
		ListNode temp1 = headA, temp2 = headB;
		while(temp1 != null) {
			s.add(temp1);
			temp1 = temp1.next;
		}
		
		while(temp2 != null) {
			boolean isAdd = s.add(temp2);
			if(isAdd == false) return temp2;
			temp2 = temp2.next;
		}
		
		return null;
    }

}
