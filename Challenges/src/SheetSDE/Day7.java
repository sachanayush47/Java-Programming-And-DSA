package SheetSDE;

import java.util.*;

@SuppressWarnings("unused")
public class Day7 {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
							// Trapping rainwater
	
	public static int trap(int[] height) {
		
		int l = height.length;
		
		int prefix[] = new int[l];
		int suffix[] = new int[l];
		
		int max = 0;
		for(int i = 0; i < l; ++i) {
			max = Math.max(max, height[i]);
			prefix[i] = max;
		}
		
		max = 0;
		for(int i = l - 1; i >= 0; --i) {
			max = Math.max(max, height[i]);
			suffix[i] = max;
		}
		
		int ans = 0;
		
		for(int i = 0; i < l; ++i) {
			ans += Math.min(prefix[i], suffix[i]) - height[i];
		}
		
		return ans;
	}
	
	/* ------------------------------------------------------------------ */
	
					// Remove Duplicates from Sorted Array
	
	// Optimal		TC O(n)		SC O(1)
	public static int removeDuplicates(int[] nums) {
		
        int prev = nums[0];
		int insert = 1;
		for(int i = 1; i < nums.length; ++i) {
			if(prev != nums[i]) {
                prev = nums[i];
				swap(i, insert, nums);
				++insert;
			}
		}
		
		return insert;
	}
	
	public static void swap(int i, int j, int arr[]) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		System.out.println("hello");
	}
	
	/* ------------------------------------------------------------------ */
	
							// Max Consecutive Ones
	
	// Optimal		TC O(n)		SC O(1)
	public static int findMaxConsecutiveOnes(int[] nums) {
        
		int ans = 0;
		int curr = 0;
		for(int i = 0; i < nums.length; ++i) {
			if(nums[i] == 1) ++curr;
			else curr = 0;
			
			ans = Math.max(ans, curr);
		}
		
		return ans;
    }
	
	/* ------------------------------------------------------------------ */
	
								// Rotate List
	
	// Optimal		TC O(n)		SC O(1)
	public static ListNode rotateRight(ListNode head, int k) {
        
		ListNode dummy = new ListNode(-1, head);
		
		ListNode slow = dummy;
		ListNode fast = dummy;
		
		int length = llLength(head);
		int totalRotation = k - k/length;
		
		while(k-- > 0)
			fast = fast.next;
		
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		ListNode newHead = slow.next;
		ListNode tailOfNewHead = newHead;
		while(tailOfNewHead.next != null)
			tailOfNewHead = tailOfNewHead.next;
		
		tailOfNewHead.next = head;
		
		slow.next = null;
		
		return newHead;
    }
	
	public static int llLength(ListNode head) {
		int len = 0;
		ListNode temp = head;
		while(temp != null) {
			++len;
			temp = temp.next;
		}
		
		return len;
	}
	
}
