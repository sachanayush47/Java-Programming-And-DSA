package binaryTree;

import java.util.*;


public class BST {

	public static void main(String[] args) {
		
		Node root = new Node(5);
		root.right = new Node(6);
		root.right.right = new Node(7);

		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		
		System.out.println(kthSmallest(root, 6));
		
		Node root2 = new Node(5);
		root2.left = new Node(4);
		root2.right = new Node(6);
		root2.right.left = new Node(3);
		root2.right.right = new Node(7);
		
	//	System.out.println(isValidBST(root2));
	}
	
	/* ------------------------------------------------------------------ */

	/* ------------------------------------------------------------------ */

	/* ------------------------------------------------------------------ */
	public static boolean isValidBST(Node root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
	}
	
	public static boolean validate(Node root, int min, int max) {
		if(root == null) return true;
		
		return root.data > min && root.data < max &&
		validate(root.left, min, root.data) &&
		validate(root.right, root.data, max);
	}
	

	/* ------------------------------------------------------------------ */
	public static int kthSmallest(Node root, int k) {
	// I did this on my own.
		
		// 0th index = result. 1st index = kth smallest element.
		int res[] = new int[2];
		helper(root, k, res);
		return res[0];
	}
	
	public static void helper(Node root, int k, int arr[]) {
		if(root == null) return;
		
		helper(root.left, k, arr);
		++arr[1];
		if(k == arr[1]) {
			arr[0] = root.data;
			return;
		}
		helper(root.right, k, arr);
	}
	
	/* ------------------------------------------------------------------ */
	public static Node delete(Node root, int key) {
	// I did this on my own.
		
		if(root == null) return root;
		List<Integer> subBST = new LinkedList<>();
		Node curr = root;
		Node parent = curr;
		
		while(curr != null) {
			if(curr.data == key) {
				
				if(root.data == key) {
					if(root.left == null && root.right == null) return null;
					else if(root.left != null && root.right == null) return root.left;
					else if(root.left == null && root.right != null) return root.right;
					else {
						preorder(curr.left, subBST);
						
						while(!subBST.isEmpty()) {
							insert(curr.right, subBST.remove(0));
						}
						
						return curr.right;
					}
				}
				
				// If root.data != key
				preorder(curr, subBST);
				subBST.remove(0);
				
				if(parent.left != null && parent.left.data == key) parent.left = null;
				else parent.right = null;
				
				while(!subBST.isEmpty()) {
					insert(root, subBST.remove(0));		// Uses insert method made earlier.
				}
				
				break;
				
			} else if(curr.data > key) {
				parent = curr;
				curr = curr.left;
			} else {
				curr = parent;
				curr = curr.right;
			}
		}
		
		return root;
	}
	
	public static void preorder(Node root, List<Integer> res) {
		if(root == null) return;
		
		res.add(root.data);
		preorder(root.left, res);
		preorder(root.right, res);
	}
	
	/* ------------------------------------------------------------------ */
	public static Node insert(Node root, int key) {
		// I coded on my own.

		Node temp = root;
		Node n = new Node(key);
        
        if(root == null) return n;
        
		while(true) {
			if(temp.data > key) {
				if(temp.left == null) {
					temp.left = n;
					break;
				} else temp = temp.left;
			} else if(temp.data < key) {
				if(temp.right == null) {
					temp.right = n;
                    break;
				} else temp = temp.right;
			}
		}

		return root;
	}
	
	/* ------------------------------------------------------------------ */
	public static int floor(Node root, int key) {
		
		int parent = -1;
		while(root != null) {
			if(root.data == key) return key;
			else if(root.data > key) {
				root = root.left;
			} else if(root.data < key) {
				parent = root.data;
				root = root.right;
			}
		}
		
		return parent;
	}
	
	/* ------------------------------------------------------------------ */
	public static int ceil(Node root, int key) {
	// I did this on my own.
		
		int parent = -1;
		while(root != null) {
			if(root.data == key) return key;
			else if(root.data > key) {
				parent = root.data;
				root = root.left;
			} else if(root.data < key) {
				root = root.right;
			}
		}
		
		return parent;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static Node search(Node root, int num) {
	// I did both solution on my own.
		
		// Iterative
//		while(root != null) {
//			
//			if(root.data == num) break;
//			else if(root.data > num) root = root.left;
//			else if(root.data < num) root = root.right;
//			
//		}
//		
//		return root;
		
		// Recursive
		if(root == null) return null;
		if(root.data == num) return root;
		return root.data > num ? search(root.left, num) : search(root.right, num);
		
	}
	
	/* ------------------------------------------------------------------ */


}
