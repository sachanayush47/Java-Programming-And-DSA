package binaryTree;

public class BinaryTreeProblems {
	
	static int ans = 0;
	public static void main(String[] args) {
		
		Node temp = null;
		int low = 5, high = 10;
		Solution s = new Solution();
		s.rangeSumBST(temp, low, high);
		

	}
	
	static class Solution {
    public int rangeSumBST(Node root, int low, int high) {
        if(root != null) {
            rangeSumBST(root.left, low, high);
            if(low <= root.data && root.data <= high ) ans = ans + root.data;
            rangeSumBST(root.right, low, high);
        }
        return ans;
	}  }  
}



