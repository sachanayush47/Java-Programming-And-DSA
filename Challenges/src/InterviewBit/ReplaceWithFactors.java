package InterviewBit;

public class ReplaceWithFactors {

	public static void main(String[] args) {
						

	}
}
	
class myLL {
	
	ListNode head;
	
	public static ListNode solve(ListNode A, int B) {
        
        ListNode ans = A;
		while(A != null) {
		    int x = A.val;
			x = B*(x/B);
			A.val = x;
			A = A.next;
		}
		return ans;
	}
}
		

class ListNode {
	
	public int val;
	public ListNode next;
	
	public ListNode(int x) {
		val = x;
		next = null;
	}
}

