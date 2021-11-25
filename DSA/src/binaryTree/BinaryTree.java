package binaryTree;

import java.util.*;

public class BinaryTree<E> {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {		
	/** @author Ayush
	 *	A Tree with each node having atmost 2 children is binary Tree.
	 *	Maximum number of nodes at level at level i is 2^i.
	 *	Maximum number of nodes in a tree with height h is 2^h-1.	
	 */

		// Node root = createTree();
		
		/**
		 * 					1
		 * 				  /	  \
		 * 				 2	   3
		 * 				/ \		
		 * 			   4   5
		 * 				  / \
		 * 				 6   7
		 */
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		
		root.right = new Node(3);
		
		root.left.right = new Node(5);
		
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.left.right.right.left= new Node(69);
		
		
		System.out.println(balancedBinaryTree(root));
	}
	
	// ------------------------------------------------------------------
	
	// Using recursion.
	public static boolean balancedBinaryTree(Node root) {
		
		if(root == null) return true;
		
		int height = height(root);
		
		if(height == -1) return false;
		return true;
	
	}
	// This function is a part of method "balancedBinaryTree".
	public static int height(Node root) {
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		if(lh == -1 || rh == -1) return -1;
		
		if(Math.abs(rh-lh) > 1) return -1;
		
		return 1+Math.max(lh, rh);
		
	}
	
	// ------------------------------------------------------------------
	
	// Using recursion.
	public static int heightOfABinaryTree1(Node root) {
		
		if(root == null) return 0;
		
		int left = heightOfABinaryTree1(root.left);
		int right = heightOfABinaryTree1(root.right);
		
		return 1 + Math.max(left, right);
		
	}
	
	// Using level order traversal.
	public static int heightOfABinaryTree2(Node root) {
		
		int height = 0;
		if(root == null) return height;
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(root);
		while(!q.isEmpty()) {
			
			int level = q.size();
			for(int i = 0; i < level; ++i) {
				
				if(q.peek().left != null) q.offer(q.peek().left);
				if(q.peek().right != null) q.offer(q.peek().right);
				
				q.poll();
			}
			++height;
		}
		return height;
	}
	
	// ------------------------------------------------------------------
	
	public static List<Integer> iterativePostorderTraversal(Node root) {
		
		List<Integer> result = new ArrayList<Integer>();
		Stack<Node> s = new Stack<Node>();
		Stack<Node> r = new Stack<Node>();
		
		if(root == null) return result;
		
		s.push(root);
		
		while(!s.isEmpty()) {
			
			root = s.pop();
			
			r.push(root);
			
			if(root.left != null) s.push(root.left);
			if(root.right != null) s.push(root.right);
			
		}
		
		while(!r.isEmpty()) {
			result.add(r.pop().data);
		}
		
		return result;
	}
	
	public static List<Integer> iterativePreorderTraversal(Node root) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(root == null) return result;
		
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		
		while(!s.isEmpty()) {
			
			root = s.pop();
			
			if(root.right != null) s.push(root.right);
			if(root.left != null) s.push(root.left);
			
			result.add(root.data);
		}
		return result;
	}
	
	public static List<Integer> iterativeInorderTraversal(Node root) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(root == null) return result;
		
		Stack<Node> s = new Stack<Node>();
		
		Node temp = root;
		while(true) {
			
			if(temp != null) {
				s.push(temp);
				temp = temp.left;
			} else {
				if(s.empty()) break;
				
				temp = s.pop();
				result.add(temp.data);
				temp = temp.right;
			}
		}
		return result;
	}
	
	
	public static List<List<Integer>> levelOrderTraversal(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		List<List<Integer>> wrapList = new ArrayList<List<Integer>>();
		
		if(root == null) return wrapList;
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> subList = new ArrayList<Integer>();
			int levelNum = queue.size();
			for(int i = 0; i < levelNum; ++i) {
				if(queue.peek().left != null) queue.offer(queue.peek().left);
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				subList.add(queue.poll().data);
			}
			
			wrapList.add(subList);
		}
		return wrapList;
	}
		
	public static void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	
	public static void preOrder(Node root) {
		if(root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}
	
	// ------------------------------------------------------------------
	
	public static Node createTree() {		
		Node root = null;
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		
		if(data == -1) return null;		
		root = new Node(data);
		
		System.out.println("Enter left for: " +data);
		root.left = createTree();
		
		System.out.println("Enter right for: " +data);
		root.right = createTree();
		
		return root;
	}
	
}


// Node class for Binary Tree
class Node {
	Node left, right;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}













