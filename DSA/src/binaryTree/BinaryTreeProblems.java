package binaryTree;

import java.util.*;

public class BinaryTreeProblems {
	
	
	
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
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	public static Node invertTree(Node root) {
		invertTreeHelper(root);
		return root;
	}
	
	public static void invertTreeHelper(Node root) {
		
		if(root == null) return;
		
		invertTreeHelper(root.left);
		invertTreeHelper(root.right);
		
		Node tempLeft = root.left;
		root.left = root.right;
		root.right = tempLeft;
	}
	
	/* ------------------------------------------------------------------ */
	public static Node mergeTrees(Node root1, Node root2) {
		
		
		mergeTrees(root1.left, root2.left);
		mergeTrees(root1.right, root2.right);
		return null;
	}
	
	/* ------------------------------------------------------------------ */
	// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
	public static int goodNodes(Node root) {
		
		int arr[] = new int[1];
		
		countGoodNodes(root, Integer.MIN_VALUE, arr);
		return arr[0];
	}
	
	public static void countGoodNodes(Node root, int largest, int arr[]) {
		if(root == null) return;
		
		if(root.data > largest) {
			largest = root.data;
			++arr[0];
		}
		
		countGoodNodes(root.left, largest, arr);
		countGoodNodes(root.right, largest, arr);
	}
	
	/* ------------------------------------------------------------------ */
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

	/* ------------------------------------------------------------------ */
	static int ans = 0;			// rangeSumBST method
    public static int rangeSumBST(Node root, int low, int high) {
        if(root != null) {
            rangeSumBST(root.left, low, high);
            if(low <= root.data && root.data <= high ) ans = ans + root.data;
            rangeSumBST(root.right, low, high);
        }
        return ans;
	} 
}

