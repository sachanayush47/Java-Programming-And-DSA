package binaryTree;

import java.util.Scanner;

public class BinaryTree<E> {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {		
	/** @author Ayush
	 *	A Tree with each node having atmost 2 children is binary Tree.
	 *	Maximum number of nodes at level at level i is 2^i.
	 *	Maximum number of nodes in a tree with height h is 2^h-1.	
	 */

		Node root = createTree();
		System.out.println("Inorder");
		inOrder(root);
		System.out.println("Preorder");
		preOrder(root);
		System.out.println("Postorder");
		postOrder(root);
		System.out.println("Height");
		System.out.println(height(root));
	}
	
	static Node createTree() {		
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
		
	static void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	
	static void preOrder(Node root) {
		if(root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	static void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}
	
	// Height/Depth of a Binary Tree.
	static int height(Node root) {
		if(root == null) return 0;
	
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return 1 + Math.max(leftHeight, rightHeight);
		
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













