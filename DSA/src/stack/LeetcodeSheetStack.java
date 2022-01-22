package stack;

public class LeetcodeSheetStack {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	class Minstack {
		
		NodeMin head;
		
		class NodeMin {
			
			int data;
			int min;
			NodeMin next;
			
			public NodeMin(int data, int min) {
				this.data = data;
				
				this.min = head == null ? data : Math.min(data, head.min);
			}
			
		}
		
		public void push(int data) {
			
			if(head == null) head = new NodeMin(data, data);
			else {
				NodeMin curr = new NodeMin(data, Math.min(head.min, data));
				curr.next = head;
				head = curr;
			}
			
		}
		
		public void pop() {
			head = head.next;
		}
		
		public int top() {
			return head.data;
		}
		
		public int getMin() {
			return head.min;
		}
	}
	
	/* ------------------------------------------------------------------ */

}


