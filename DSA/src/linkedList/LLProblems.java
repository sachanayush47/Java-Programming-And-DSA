package linkedList;

public class LLProblems {

	public static void main(String[] args) {
		
		
	}
	// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
	public static int getDecimalValue(ListNode head) {
        ListNode temp = head;
		int size = 0;
        int power = 1;
        int ans = 0;
		while(temp != null) {
			++size;
			temp = temp.next;
		}
        for(int i = 0; i < size-1; ++i) {
            power = power*2;
        }
        temp = head;
        while(temp != null) {
            ans = ans + temp.val*power;
            temp = temp.next;
            power = power/2;
        }
        return ans;
    }
	
	// https://leetcode.com/problems/middle-of-the-linked-list
	public static ListNode middleNode(ListNode head) {
		ListNode temp = head;
	    int size = 0;
	    while(temp != null) {
	    	++size;
	        temp = temp.next;
	    }
	    temp = head;
	    for(int i = 0; i < size/2; ++i) {
	    	temp = temp.next;
	    }
	    return temp;
	        
	}
	
	public static boolean isPalindrome(ListNode head) {
	//https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3693/
		ListNode temp = head;
		int size = 0;
		while(temp != null) {
			++size;
			temp = temp.next;
		}
		int dupArray[] = new int[size]; 
		temp = head;
		for(int i = 0; i < size; ++i) {
			dupArray[i] = temp.val;
			temp = temp.next;
		}
		for(int i = size; i >= 0; --i) {
			if(head.val != dupArray[i]) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
}

class ListNode {
	int val;
	ListNode next;
}


