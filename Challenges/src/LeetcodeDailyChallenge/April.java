package LeetcodeDailyChallenge;

import java.util.*;

public class April {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
	public static void gameOfLife2(int[][] board) {
		
		int m = board.length;
		int n = board[0].length;
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				
				int up = 0, down = 0, left = 0, right = 0;
				int upleft = 0, upright = 0, downleft = 0, downright = 0;
				
				if(i > 0) up = board[i - 1][j] & 1;
				if(i < m - 1) down = board[i + 1][j] & 1;
				if(j > 0) left = board[i][j - 1] & 1;
				if(j < n - 1) right = board[i][j + 1] & 1;
				if(i > 0 && j > 0) upleft = board[i - 1][j - 1] & 1;
				if(i > 0 && j < n - 1) upright = board[i - 1][j + 1] & 1;
				if(i < m - 1 && j > 0) downleft = board[i + 1][j - 1] & 1;
				if(i < m - 1 && j < n - 1) downright = board[i + 1][j + 1] & 1;
				
				int lives = up + down + left + right + upleft + upright + downleft + downright; 
				
				if(lives < 2 || lives > 3) continue;
				else if(lives == 3) board[i][j] |= 2;
				else if(lives == 2 && board[i][j] == 1) board[i][j] = 3;
			}
		}
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) board[i][j] >>= 1;
		}
		
	}
	
	
	// TC	O(mn)	SC O(mn)	
	public static void gameOfLife1(int[][] board) {
		
		int m = board.length;
		int n = board[0].length;
		
		int ans[][] = new int[m][n];
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				
				int up = 0, down = 0, left = 0, right = 0;
				int upleft = 0, upright = 0, downleft = 0, downright = 0;
				
				try {
					up = board[i - 1][j];
				} catch(Exception e) {	}
				
				try {
					down = board[i + 1][j];
				} catch(Exception e) {	}
				
				try {
					left = board[i][j - 1];
				} catch(Exception e) {	}
				
				try {
					right = board[i][j + 1];
				} catch(Exception e) {	}
				
				try {
					upleft = board[i - 1][j - 1];
				} catch(Exception e) {	}
				
				try {
					upright = board[i - 1][j + 1];
				} catch(Exception e) {	}
				
				try {
					downleft = board[i + 1][j - 1];
				} catch(Exception e) {	}
				
				try {
					downright = board[i + 1][j + 1];
				} catch(Exception e) {	}
				
				int lives = up + down + left + right + upleft + upright + downleft + downright; 
				
				if(lives < 2) ans[i][j] = 0;
				else if(lives == 3) ans[i][j] = 1;
				else if(lives == 2) ans[i][j] = board[i][j];
				else if(lives > 3) ans[i][j] = 0;
				
			}
		}
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				board[i][j] = ans[i][j];
			}
		}
		
	}
        
	
	/* ------------------------------------------------------------------ */
	
	public static int lastStoneWeight(int[] stones) {
        
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < stones.length; ++i) pq.offer(stones[i]);
		
		while(!pq.isEmpty()) {
			
			int heavy1 = pq.poll();
			int heavy2 = 0;
			if(pq.isEmpty()) return heavy1;
			else heavy2 = pq.poll();
			
			if(heavy1 - heavy2 != 0) pq.offer(heavy1 - heavy2);
			
		}
		
		return 0;
    }
	
	/* ------------------------------------------------------------------ */
	
							// Container With Most Water
	
	public static int maxArea(int[] height) {
			
		int ans = 0;
		int i = 0;
		int j = height.length - 1;
		
		while(i < j) {
			int vol = (j - i) * Math.min(height[i], height[j]);
			ans = Math.min(ans, vol);
			if(height[i] < height[j]) ++i;
			else --j;
		}
		
		return ans;
	}
	
	/* ------------------------------------------------------------------ */
	
						// Swapping Nodes in a Linked List
	
	public static ListNode swapNodes(ListNode head, int k) {
        
		ListNode start = new ListNode(-1, head);
		ListNode fast = start;
		ListNode slow = start;
		
		while(k > 0) {
			fast = fast.next;
			--k;
		}
		
		ListNode backNode = fast;
		
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		int temp = backNode.val;
		backNode.val = slow.next.val;
		slow.next.val = temp;
		
		return head;
    }
	
	/* ------------------------------------------------------------------ */
	
	// Day 3 			Next permutation, already solved.
	
	/* ------------------------------------------------------------------ */
	
	// Day 2
	public static boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) {
				return isPalindrome(i + 1, j, s) || isPalindrome(i, j - 1, s);
			}
			++i;
			--j;
		}
		
		return true;
	}
	
	public static boolean isPalindrome(int i, int j, String s) {
		
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) return false;
			++i;
			--j;
		}
		
		return true;
	}
	
	/* ------------------------------------------------------------------ */
	
	// Day 1
	public static void reverseString(char[] s) {
		
		int l = 0;
		int r = s.length - 1;
		while(l < r) {
			char temp = s[l];
			s[l++] = s[r];
			s[r--] = temp;
		}
	}

}

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
