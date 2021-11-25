package cp;

import java.util.*;

public class CF_DimaAndFriends272A {

	public static void main(String[] args) {
		
		solution();
	}
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		int allFriends = sc.nextInt();
		int fingerCount = 0;
		
		for(int i = 0; i < allFriends; ++i) {
			fingerCount += sc.nextInt();
		}
		sc.close();
		
		int result = 0;
		int friendPointer = 1;
		
		for(int dimaFinger = 1; dimaFinger <= 5; ++dimaFinger) {
			int totalFingers = dimaFinger + fingerCount;
			
			while(totalFingers > 0) {
				
				--totalFingers;
				++friendPointer;
				
				if(friendPointer == allFriends + 2) friendPointer = 1;
				
			}
			if(friendPointer != 1) ++result;
		}
		System.out.println(result);	
	}
}
	
//	public static void solution() {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int totalFriends = sc.nextInt();
//		
//		CircularLinkedList fingers = new CircularLinkedList();
//		
//		fingers.addLast(0);
//		
//		int fingerOfFriends = 0;
//		
//		for(int i = 0; i < totalFriends; ++i) {
//			fingerOfFriends += fingers.addLast(sc.nextInt());
//		}
//		sc.close();
//		
//		int result = 0;
//		
//		for(int dimaFinger = 1; dimaFinger <= 5; ++dimaFinger) {
//			Node head = fingers.getHead();
//			for(int i = 0; i < dimaFinger + fingerOfFriends-1; ++i) {
//				
//				head = head.next;
//			}
//			if(head.index != 0) {
//				++result;
//				System.out.println(dimaFinger);
//			}
//		}
//		System.out.println(result);		
//	}


class Node {
	
	int data;
	Node next;
	int index;
	
	public Node(int data) {
		this.data = data;
	}
}

class CircularLinkedList {
	
	Node head;
	int size;
	int index;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int addLast(int data) {
		if(head == null) {
			head = new Node(data);
			head.next = head;
			size = 1;
			index = 0;
			head.index = index;
			return data;
		}
		
		Node temp = head;
		
		for(int i = 0; i < size-1; ++i) {
			temp = temp.next;
		}
		
		temp.next = new Node(data);
		temp.next.next = head;
		++size;
		temp.index = ++index;
		return data;
	}
	
	public void print() {
		
		Node temp = head;
		
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
