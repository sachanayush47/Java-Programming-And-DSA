package binaryTree;

import java.util.*;

public class BinaryTreeProblems {
	
	static int ans = 0;			// rangeSumBST method
	
	public static void main(String[] args) {
		
		// Node root = createTree();
		
		/**
		 * 					1
		 * 				 /	   \
		 * 				2	    3
		 * 			   / \	   / \	
		 * 			  4   5  100 200
		 * 			     / \
		 * 			    6   7
		 * 				   / \
		 * 				  69  70
		 */
		
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.left.left = new Node(4);
		
		root1.right = new Node(3);
		root1.right.left = new Node(100);
		root1.right.right = new Node(200);
		
		root1.left.right = new Node(5);
		
		root1.left.right.left = new Node(6);
		root1.left.right.right = new Node(7);
		root1.left.right.right.left= new Node(69);
		root1.left.right.right.right= new Node(70);
		
		/**
		 * 					10
		 * 				  /    \
		 * 				 5	   20
		 * 				/ \    / \
		 * 			   3   8  18  25 
		 * 				  /
		 * 				 7	
		 * 
		 */
		
		Node root2 = new Node(10);
		
		root2.left = new Node(5);
		root2.left.right = new Node(8);
		root2.left.right.left = new Node(7);
		root2.left.left = new Node(3);
		
		root2.right = new Node(20);
		root2.right.left = new Node(18);
		root2.right.right = new Node(25);
		
		System.out.println(deepestLeavesSum(root1));
		

	}
	
	public static void mergeTrees(Node root1, Node root2) {
		
		if(root1 == null || root2 == null) return;
		
		root1.data += root1.data;
		mergeTrees(root1.left, root2.left);
		mergeTrees(root1.right, root2.right);
		
		
	}
	
	public static int deepestLeavesSum(Node root) {
		int sum = 0;
		if(root == null) return sum;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			sum = 0;
			for(int i = 0; i < size; ++i) {
				if(q.peek().left != null) q.offer(q.peek().left);
				if(q.peek().right != null) q.offer(q.peek().right);
				
				sum += q.poll().data;
			}
		}
		
		return sum;
	}

    public static int rangeSumBST(Node root, int low, int high) {
        if(root != null) {
            rangeSumBST(root.left, low, high);
            if(low <= root.data && root.data <= high ) ans = ans + root.data;
            rangeSumBST(root.right, low, high);
        }
        return ans;
	} 
}

