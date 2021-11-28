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
		 * 				 /	   \
		 * 				2	    3
		 * 			   / \	   / \	
		 * 			  4   5  100 200
		 * 			     / \
		 * 			    6   7
		 * 					 \
		 * 				     69
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
		
		Node root2 = new Node(10);
		
		root2.left = new Node(5);
		root2.left.right = new Node(8);
		root2.left.right.left = new Node(7);
		root2.left.left = new Node(3);
		
		root2.right = new Node(20);
		root2.right.left = new Node(18);
		root2.right.right = new Node(25);
		
		
		//System.out.println(balancedBinaryTree(root));

		System.out.println(boundaryTraversal(root2));
		
	}
	
	/* ------------------------------------------------------------------ */
	// Below 4 method is for boundary traversal.
	
	// I coded this whole on my own. Best thing is I did it using recursion.
//	public static ArrayList<Integer> boundaryTraversal(Node root) {
//		ArrayList<Integer> res = new ArrayList<Integer>();
//		if(root == null) return res;
//		
//		res.add(root.data);
//		
//		leftBoundary(root.left, res);
//		leafBoundary(root, res);
//		
//		int size = res.size();
//		rightBoundary(root.right, res, size);
//		
//		return res;
//	}
//	
//	public static void leftBoundary(Node root, ArrayList<Integer> res) {
//		
//		if(root == null) return;
//		if(root.left == null && root.right == null) return;
//		if(root.left == null) {
//			res.add(root.data);
//			leftBoundary(root.right, res);
//		} else {
//			res.add(root.data);
//			leftBoundary(root.left, res);
//		}
//	}
//	
//	public static void rightBoundary(Node root, ArrayList<Integer> res, int size) {
//		
//		if(root == null) return;
//		if(root.left == null && root.right == null) return;
//		if(root.right == null) {
//			res.add(size, root.data);
//			rightBoundary(root.left, res, size);
//		} else {
//			res.add(size, root.data);
//			rightBoundary(root.right, res, size);
//		}
//	}
//
//	public static void leafBoundary(Node root, ArrayList<Integer> res) {
//		
//		if(root == null) return;
//		
//		if(root.left == null && root.right == null) {
//			res.add(root.data);
//			return;
//		}
//		
//		leafBoundary(root.left, res);
//		leafBoundary(root.right, res);
//		
//	}
	
	// This is solution by RVA. It is more readability, clean and understandble.
    public static ArrayList <Integer> boundaryTraversal(Node root) {
	    ArrayList<Integer> ans = new ArrayList<Integer>(); 
	    ans.add(root.data);
	    
	    addLeftBoundary(root, ans); 
	    addLeaves(root, ans); 
	    addRightBoundary(root, ans); 
	    return ans;
	}
    
    public static Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }
    
    public static void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    public static void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }

        for (int i = tmp.size()-1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }
    
    public static void addLeaves(Node root, ArrayList<Integer> res) {
        if(root == null) return;
    	
    	if(isLeaf(root)) {
            res.add(root.data);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }
	
	/* ------------------------------------------------------------------ */
	
	public static List<List<Integer>> zigZagTraversal(Node root) {
	// I did both solution 1 and 2 on my own.
		
		// Solution 1 ---------------------------
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		ArrayDeque<Node> ad = new ArrayDeque<Node>();
//		
//		if(root == null) return res;
//		ad.offerFirst(root);
//		
//		boolean flip = false;
//		
//		while(!ad.isEmpty()) {
//			ArrayList<Integer> zigZag = new ArrayList<Integer>();
//			int size = ad.size();
//			
//			for(int i = 0; i < size; ++i) {
//				if(flip == true) {
//					if(ad.peekLast().right != null) ad.offerFirst(ad.peekLast().right);
//					if(ad.peekLast().left != null) ad.offerFirst(ad.peekLast().left);
//				} else if(flip == false){
//					if(ad.peekFirst().left != null) ad.offerLast(ad.peekFirst().left);
//					if(ad.peekFirst().right != null) ad.offerLast(ad.peekFirst().right);
//				}
//				
//				if(flip) zigZag.add(ad.pollLast().data);
//				else zigZag.add(ad.pollFirst().data);
//			}
//			flip = !flip;
//			res.add(zigZag);
//		}
//		return res;
		
		// Solution 2 ---------------------------
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(root == null) return res;
		
		boolean flip = false;
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		while(!q.isEmpty()) {
			ArrayList<Integer> zigZag = new ArrayList<Integer>();
			int size = q.size();
			
			for(int i = 0; i < size; ++i) {
				if(q.peek().left != null) q.offer(q.peek().left);
				if(q.peek().right != null) q.offer(q.peek().right);
				
				if(flip) zigZag.add(0, q.poll().data);
				else zigZag.add(q.poll().data);
			}
			flip = !flip;
			res.add(zigZag);
		}
		
		return res;
	}
	
	/* ------------------------------------------------------------------ */
	
	// This is completly written by own my thinking process having same time complexity than
	// the below ones but taking more memory and very long code in comparison.
	
//	public static boolean isSameTree(Node root1, Node root2) {
//		
//		boolean res[] = new boolean[1];
//		res[0] = true;
//		identicalTrees(root1, root2, res);
//		
//		return res[0];
//	}
//	
//	public static void identicalTrees(Node root1, Node root2, boolean isIdentical[]) {
//		
//		if(root1 == null && root2 == null) return;
//		if(root1 == null || root2 == null) {
//			isIdentical[0] = false;
//			return;
//		}
//	
//		if(root1.data != root2.data) isIdentical[0] = false;
//		identicalTrees(root1.left, root2.left, isIdentical);
//		identicalTrees(root1.right, root2.right, isIdentical);
//		
//	}
	
	// Copied
	public static boolean isSameTree2(Node root1, Node root2) {
		if(root1 == null || root2 == null) {
			return root1==root2;
		}
		
		return (root1.data==root2.data) &&
				isSameTree2(root1.left, root2.left) && isSameTree2(root1.right, root2.right);
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int maxPathSum(Node root) {
		
		int maxSum[] = new int[1];
		maxSum[0] = Integer.MIN_VALUE;
		
		getPathSum(root, maxSum);
		
		return maxSum[0];
		
	}

	public static int getPathSum(Node root, int maxSum[]) {
		if(root == null) return 0;
		
		int maxL = Math.max(0, getPathSum(root.left, maxSum));
		int maxR = Math.max(0, getPathSum(root.right, maxSum));
		
		maxSum[0] = Math.max(maxSum[0], root.data + maxL + maxR);
		
		return root.data + maxL + maxR;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int diameterOfAbinaryTree(Node root) {
		
		int diameter[] = new int[1];
		depth(root, diameter);
		
		return diameter[0];
	}
	
	public static int depth(Node root, int diameter[]) {
		if(root == null) return 0;
		
		int lh = depth(root.left, diameter);
		int rh = depth(root.right, diameter);
		
		diameter[0] = Math.max(diameter[0], lh+rh);
		
		return Math.max(lh, rh) + 1;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static boolean balancedBinaryTree(Node root) {
	// If at any level, |(lh-rh > 1)| then tree is not balanced.

		int height = height(root);
		
		if(height == -1) return false;
		return true;
	}
	// This function is a part of method "balancedBinaryTree".
	public static int height(Node root) {
		
		if(root == null) return 0;
		
		int lh = height(root.left);
		if(lh == -1) return -1;
		int rh = height(root.right);
		if(rh == -1) return -1;
		
		if(Math.abs(rh-lh) > 1) return -1;
		
		return 1+Math.max(lh, rh);
		
	}
	
	/* ------------------------------------------------------------------ */
	
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
	
	/* ------------------------------------------------------------------ */
	
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













