package binaryTree;

public class Practice {

	public static void main(String[] args) {
		
//		Node root = new Node(1);
//		root.left = new Node(2);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right = new Node(3);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);
		
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);
		
		
		System.out.println(leftLeaf(root));
		
	}
	
	public static int leftLeaf(Node root) {
		if(root == null) return 0;
		if(isLeaf(root)) return root.data;
		int arr[] = new int[1];
		leftLeafSum(root, arr);
		return arr[0];
		
	}
	
	public static void leftLeafSum(Node root, int arr[]) {
		if(root == null) return;
		
		if(root.left != null && isLeaf(root.left)) {
			
			arr[0] = arr[0] + root.left.data;
			System.out.println(root.left.data);
		}
		leftLeafSum(root.left, arr);
		leftLeafSum(root.right, arr);
	}
	
	public static boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}

}
