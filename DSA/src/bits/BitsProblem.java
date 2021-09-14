package bits;

public class BitsProblem {

	public static void main(String[] args) {

	}
	
	public static int xorOperation(int n, int start) {
    // https://leetcode.com/problems/xor-operation-in-an-array
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            ans = ans ^ (start + 2*i);
        }
        return ans;
    }
	

}
