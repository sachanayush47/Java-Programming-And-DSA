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
		
	//	1 2 3 4 5 100 200 x x 6 7 x x x x x x 69 70 x x x 700 x x
		
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
		 * 						\
		 * 						700
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
		root1.left.right.right.left = new Node(69);
		root1.left.right.right.right = new Node(70);
		root1.left.right.right.right.right = new Node(700);
		
		/**
		 * 					10
		 * 				  /    \
		 * 				 5	   20
		 * 				/ \    / \
		 * 			   3   8  18  25 
		 * 
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
		
		
		//System.out.println(balancedBinaryTree(root));

		//System.out.println(boundaryTraversal(root2));
		
		//System.out.println(topViewOfBT(root2));
		
//		System.out.println(serializeTree(root1));
//		System.out.println(verticalTraversal(root1));
//		System.out.println(verticalTraversal(deserializeTree(serializeTree(root1))));
		
		System.out.println(bottomView(root2));
		
	}
	/* ------------------------------------------------------------------ */
	
	public static ArrayList<Integer> bottomView(Node root) {
		
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null) return res;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			Node n = p.root;
			int col = p.col;
			
			map.put(col, n.data);
			
			if(n.left != null) q.offer(new Pair(n.left, col-1));
			if(n.right != null) q.offer(new Pair(n.right, col+1));
		}
		
		for(Integer i : map.values()) {
			res.add(i);
		}
		
		return res;
		
	}
	
	// Method 1: Recursive, preferred in interviews.
	public static void flattenBTtoLL1(Node root) {
		Node prev[] = new Node[1];
		prev[0] = null;
		
		flatten1(root, prev);
	}
	
	public static void flatten1(Node root, Node prev[]) {
		if(root == null) return;
		
		flatten1(root.right, prev);
		flatten1(root.left, prev);
		
		root.right = prev[0];
		root.left = null;
		prev[0] = root;
		
	}
	
	// Method 2: Iterative.
	public static void flattenBTtoLL2(Node root) {
		if(root == null) return;
		
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			Node n = s.pop();
			
			if(n.right != null) s.push(n.right);
			if(n.left != null) s.push(n.left);
			
			if(!s.isEmpty()) {
				n.right = s.peek();
			}
			n.left = null;
		}
	}
	
	// Method 3: 
	public static void flattenBTtoLL3(Node root) {
		
	}
	
	
	
	/* ------------------------------------------------------------------ */
	// I coded deserializeTree on my own.
	
	public static String serializeTree(Node root) {
		String res = "";
		if(root == null) return res;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n == null) res += "# ";
			else {
				res += n.data + " ";
				q.offer(n.left);
				q.offer(n.right);
			}
		}
		return res;
	}
	
	public static Node deserializeTree(String s) {
		if(s.length() == 0) return null;
		
		String[] arr = s.split(" ");
		
		Queue<Node> q = new LinkedList<>();
		Node root = new Node(Integer.parseInt(arr[0]));
		q.offer(root);
		
		int i = 1;
		
		while(i < arr.length) {
			Node n = q.poll();
			
			n.left = arr[i].equals("#") ? null : new Node(Integer.parseInt(arr[i]));
			if(n.left != null) q.offer(n.left);
			++i;
			
			n.right = arr[i].equals("#") ? null : new Node(Integer.parseInt(arr[i]));
			if(n.right != null) q.offer(n.right);
			++i;
		}
		return root;
	}
	
	/* ------------------------------------------------------------------ */
	public static List<Integer> morrisTraversal() {
		return null;
	}
	
	/* ------------------------------------------------------------------ */
	public static Node buildTreePost() {
		return null;
	}
	
	/* ------------------------------------------------------------------ */
	public static Node buildTreePre(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inMap = new HashMap<>();
		
		for(int i = 0; i < inorder.length; ++i) {
			inMap.put(inorder[i], i);
		}
		
		return buildPre(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
	}
	
	public static Node buildPre(int preorder[], int preStart, int preEnd,
		int inorder[], int inStart, int inEnd, Map<Integer, Integer> iMap) {
		
		if(preStart > preEnd || inStart > inEnd) return null;
		
		Node root = new Node(preorder[preStart]);
		
		int inRoot = iMap.get(root.data);
		int numsLeft = inRoot - inStart;
		
		root.left = buildPre(preorder, preStart+1, preStart+numsLeft,
				inorder, inStart, inRoot-1, iMap);
		root.right = buildPre(preorder, preStart+numsLeft+1, preEnd,
				inorder, inRoot+1, inEnd, iMap);
		
		return root;
	}
	
	/* ------------------------------------------------------------------ */
	// This solution is almost correct, passes a lot of testcases, cant figure 
	// out where it is failing. Matched with the correct solution, looks everything
	// good. Dont know what is wrong.
	public static int minimumTimeToBurnBT(Node root, int start) {
		HashMap<Node, Node> parent = new HashMap<>();
		Node target = markParent(root, parent, start);
		
		return burnTree(target, parent);
	}
	
	public static int burnTree(Node target, HashMap<Node, Node> parent) {
		int time = 0;
		HashMap<Node, Boolean> visited = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.offer(target);
		visited.put(target, true);
		while(!q.isEmpty()) {

			int size = q.size();
			
			for(int i = 0; i < size; ++i) {
				Node n = q.poll();
				
				if(n.left != null && visited.get(n.left) == null) {
					visited.put(n.left, true);
					q.offer(n.left);
				}
			
				if(n.right != null && visited.get(n.right) == null) {
					visited.put(n.right, true);
					q.offer(n.right);
				}
			
				if(parent.get(n) != null && visited.get(parent.get(n)) == null) {
					visited.put(parent.get(n), true);
					q.offer(parent.get(n));
				}
			}
			
			++time;
		}
		
		return --time;	// When the tree is no more buring, still "time" got increment
		// by one. To fix this, --time;
		
	}
	
	public static Node markParent(Node root, HashMap<Node, Node> parent, int start) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		Node target = new Node(-1);
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.data == start) target = n;
			
			if(n.left != null) {
				q.offer(n.left);
				parent.put(n.left, n);
			}
			
			if(n.right != null) {
				q.offer(n.right);
				parent.put(n.right, n);
			}
		}
		return target;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static List<Integer> distanceK(Node root, Node target, int k ) {
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		
		// Child, Parent
		Map<Node, Node> parentTrack = new HashMap<>();
		markParents(root, parentTrack, target);
		
		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		
		q.offer(target);
		visited.put(target, true);
		int curLevel = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			if(curLevel++ == k) break;
			
			for(int i = 0; i < size; ++i) {
				Node cur = q.poll();
				
				if(cur.left != null && visited.get(cur.left) == null) {
					q.offer(cur.left);
					visited.put(cur.left, true);
				}
				if(cur.right != null && visited.get(cur.right) == null) {
					q.offer(cur.right);
					visited.put(cur.right, true);
				}
				if(parentTrack.get(cur) != null && visited.get(parentTrack.get(cur)) == null) {
					q.offer(parentTrack.get(cur));
					visited.put(parentTrack.get(cur), true);
				}
			}
		}
		
		for(Node i : q) {
			res.add(i.data);
		}
		
		return res;
	}
	
	public static void markParents(Node root, Map<Node, Node> parentTrack, Node target) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.left != null) {
				parentTrack.put(cur.left, cur);
				q.offer(cur.left);
			}
			
			if(cur.right != null) {
				parentTrack.put(cur.right, cur);
				q.offer(cur.right);
			}
		}
	}
	
	/* ------------------------------------------------------------------ */
	
	public static void childrenSumProperty(Node root) {
	// Feeling excited with other 69 PBC because I coded this on my own and best thing
	// is I have done it using recursion.
		if(root == null) return;
		
		int rootData = root.data;
		int leftChildData = 0;
		if(root.left != null) leftChildData = root.left.data;
		int rightChildData = 0;
		if(root.right != null) rightChildData = root.right.data;
		
		if(leftChildData + rightChildData > rootData) {
			root.data = leftChildData + rightChildData;
		} else if(leftChildData + rightChildData < rootData) {
			if(root.left != null) root.left.data = root.data;
			if(root.right != null) root.right.data = root.data;
		}
		
		childrenSumProperty(root.left);
		childrenSumProperty(root.right);
		
		if(root.left != null) leftChildData = root.left.data;
		if(root.right != null) rightChildData = root.right.data;
		
		if(leftChildData + rightChildData > rootData) {
			root.data = leftChildData + rightChildData;
		}
	}
	
	/* ------------------------------------------------------------------ */
	
	public static void maxWidthOfBT(Node root) {
		
	}
	
	/* ------------------------------------------------------------------ */
	// This is completly written by my own thinking process. Only problem is it is using
	// brute force approach.
	
//	public static int lowestCommonAncestor(Node root, Node p, Node q) {
//		
//		Set<Integer> pPath = new LinkedHashSet<Integer>();
//		Set<Integer> qPath = new HashSet<Integer>();
//		getPath(root, p.data, pPath);
//		getPath(root, q.data, qPath);
//		
//		System.out.println(pPath.toString());
//		
//		int res = 0;
//		
//		for(Integer i : pPath) {
//			if(qPath.contains(i)) res = i;
//			else break;
//		}
//		
//		return res;
//	}
//	
//	public static boolean getPath(Node root, int n, Set<Integer> res) {
//		if(root == null) return false;
//		
//		res.add(root.data);
//		if(root.data == n) return true;
//		
//		if(getPath(root.left, n, res) || getPath(root.right, n, res)) {
//			return true;
//		}
//		
//		res.remove(root.data);		// Removing last element.
//		return false;
//	}
	
	public static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if(root == null || root == p || root == q) return root;
		
		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);
		
		if(left == null) return right;
		else if(right == null) return left;
		else return root;
	}
	
	/* ------------------------------------------------------------------ */
	
	
	
	
	/* ------------------------------------------------------------------ */
	// This is completly written by my own thinking process. Only problem is it is using
	// 1 extra parameter.
	
//	public static LinkedList<Integer> rootToNodePath(Node root, int b) {
//		LinkedList<Integer> res = new LinkedList<>();
//		boolean isNodeFounded[] = {false};
//		solve(root, b, res, isNodeFounded);
//		return res;
//		
//	}
//	
//	public static void solve(Node root, int b, LinkedList<Integer> res, boolean isNodeFounded[]) {
//		if(root == null) return;
//		
//		solve(root.left, b, res, isNodeFounded);
//		if(!isNodeFounded[0]) solve(root.right, b, res, isNodeFounded);
//		if(root.data == b || isNodeFounded[0]) {
//			res.add(0, root.data);
//			isNodeFounded[0] = true;
//		}
//	}
	
	public static ArrayList<Integer> rootToNodePath(Node root, int b) {
		ArrayList<Integer> res = new ArrayList<>();
		solve(root, b, res);
		return res;
	}
	
	public static boolean solve(Node root, int b, ArrayList<Integer> res) {
		if(root == null) return false;
		
		res.add(root.data);
		if(root.data == b) return true;
		
		if(solve(root.left, b, res) || solve(root.right, b, res)) {
			return true;
		}
		
		res.remove(res.size() - 1);		// Removing last element.
		return false;
	}
	
	/* ------------------------------------------------------------------ */
	// This is completly written by my own thinking process.
	public static boolean symmetricBT(Node root) {
		if(root == null) return true;
		
		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetric(Node root1, Node root2) {
		if(root1 == null || root2 == null) return root1==root2;
		
		return root1.data == root2.data 
				&& isSymmetric(root1.left, root2.right) 
				&& isSymmetric(root1.right, root2.left);
	}
	
	/* ------------------------------------------------------------------ */
	
	public static List<Integer> rightViewOfBT(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		getRightView(root, res, 0);
		return res;
	}
	
	public static void getRightView(Node root, List<Integer> res, int level) {
		if(root == null) return;
		
		if(level == res.size()) res.add(root.data);
		getRightView(root.right, res, level+1);
		getRightView(root.left, res, level+1);
	}
	
	/* ------------------------------------------------------------------ */
	// This is completly written by my own thinking process.
	
	// Class required for Bottom view and Top view.
	static class Pair {
		Node root;
		int col;
		public Pair(Node _root, int _col) {
			root = _root;
			col = _col;		// Vertical
		}
	}
	
	public static ArrayList<Integer> bottonViewOfBT(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null) return res;
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			Node n = p.root;
			int col = p.col;
			
			map.put(col, n.data);
			
			if(n.left != null) q.offer(new Pair(n.left, col-1));
			if(n.right != null) q.offer(new Pair(n.right, col+1));
		}
		
		for(Integer i : map.values()) {
			res.add(i);
		}
		
		return res;
	}
	
	public static List<Integer> topViewOfBT(Node root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			Node n = p.root;
			int col = p.col;
			
			map.putIfAbsent(col, n.data);
			
			if(n.left != null) q.offer(new Pair(n.left, col-1));
			if(n.right != null) q.offer(new Pair(n.right, col+1));
		}
		
		for(Integer i : map.values()) {
			res.add(i);
		}
		return res;
	}
	
	/* ------------------------------------------------------------------ */
	
	
	// Class required for Vertical Traversal.
	static class Tuple {
		Node root;
		int row;		// Level
		int col;		// Vertical
		public Tuple(Node _root, int _row, int _col) {
			root = _root;
			row = _row;
			col = _col;
		}
	}
	
	public static List<List<Integer>> verticalTraversal(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		
		if(root == null) return res;
		
		// Vertical, Level
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<>();
		q.offer(new Tuple(root, 0, 0));
		
		while(!q.isEmpty()) {
			Tuple t = q.poll();
			Node n = t.root;
			int x = t.row;
			int y = t.col;
			
			map.putIfAbsent(y, new TreeMap<>());	// Adding Vertical if absent.
			map.get(y).putIfAbsent(x, new PriorityQueue<>());	// Adding Level if absent.
			
			map.get(y).get(x).offer(n.data);
			
			if(n.left != null) q.offer(new Tuple(n.left, x+1, y-1));
			if(n.right != null) q.offer(new Tuple(n.right, x+1, y+1));
		}
		
		// Traversing over "map" to add node.data to List.
		for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
			List<Integer> v = new ArrayList<>();
			for(PriorityQueue<Integer> nodes : ys.values()) {
				while(!nodes.isEmpty()) {
					v.add(nodes.poll());
				}
			}
			res.add(v);
		}
		return res;
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
	
	// This solution is by RVA. It has more readability, clean and understandble.
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
		List<List<Integer>> res = new ArrayList<>();
		
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
//		if(root1.data != root2.data) {
//			isIdentical[0] = false;
//			return;
//		}
//		identicalTrees(root1.left, root2.left, isIdentical);
//		identicalTrees(root1.right, root2.right, isIdentical);
//		
//	}
	
	// Solution by RVA.
	public static boolean isSameTree(Node root1, Node root2) {
		if(root1 == null || root2 == null) {
			return root1==root2;
		}
		
		return (root1.data==root2.data) &&
				isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
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
	
	// Using level order traversal. I did this on my own.
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

