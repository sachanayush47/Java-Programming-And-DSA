package recursion;

public class LeetCoding {

	public static void main(String[] args) {
		
//		char c[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		char c[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//		char c[][] = {{'a','b'}};
		
		System.out.println(exist(c, "ABCB"));
		
	}
	
	// Did some memory optimizations.
	public static boolean exist(char[][] board, String word) {
        
    	int m = board.length;
    	int n = board[0].length;
    	
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(word.charAt(0) == board[i][j]) {
                	if(existHelper(i, j, 1, board, word)) return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean existHelper
    	(int i, int j, int s, char[][] board, String word) {
        if(s == word.length()) {
        	return true;
        }
        
        if(i == board.length || j == board[0].length) return false;
        
        // Up
        if(i > 0 && board[i - 1][j] == word.charAt(s)) {
        	char temp = board[i][j];
        	board[i][j] = '*';
        	if(existHelper(i - 1, j, s + 1, board, word)) return true;
        	else board[i][j] = temp;
        }
        
        // Down
        if(i < board.length - 1 && board[i + 1][j] == word.charAt(s)) {
        	char temp = board[i][j];
        	board[i][j] = '*';
        	if(existHelper(i + 1, j, s + 1, board, word)) return true;
        	else board[i][j] = temp;
        }
        
        // Left
        if(j > 0 && board[i][j - 1] == word.charAt(s)) {
        	char temp = board[i][j];
        	board[i][j] = '*';
        	if(existHelper(i, j - 1, s + 1, board, word)) return true;
        	else board[i][j] = temp;
        }
        
        // Right
        if(j < board[0].length -1 && board[i][j + 1] == word.charAt(s)) {
        	char temp = board[i][j];
        	board[i][j] = '*';
        	if(existHelper(i, j + 1, s + 1, board, word)) return true;
        	else board[i][j] = temp;
        }
        
        return false;
    }
	
//    public static boolean exist(char[][] board, String word) {
//        
//    	int m = board.length;
//    	int n = board[0].length;
//    	
//        for(int i = 0; i < m; ++i) {
//            for(int j = 0; j < n; ++j) {
//                if(word.charAt(0) == board[i][j]) {
//                	boolean isUsed[][] = new boolean[m][n];
//                	isUsed[i][j] = true;
//                	if(existHelper(i, j, 1, board, word, isUsed)) return true;
//                }
//            }
//        }
//        
//        return false;
//    }
//    
//    public static boolean existHelper
//    	(int i, int j, int s, char[][] board, String word, boolean isUsed[][]) {
//        if(s == word.length()) {
//        	return true;
//        }
//        
//        if(i == board.length || j == board[0].length) return false;
//        
//        // Up
//        if(i > 0 && board[i - 1][j] == word.charAt(s) && isUsed[i - 1][j] == false) {
//        	isUsed[i - 1][j] = true;
//        	if(existHelper(i - 1, j, s + 1, board, word, isUsed)) return true;
//        	else isUsed[i - 1][j] = false;
//        }
//        
//        // Down
//        if(i < board.length - 1 && board[i + 1][j] == word.charAt(s) && isUsed[i + 1][j] == false) {
//        	isUsed[i + 1][j] = true;
//        	if(existHelper(i + 1, j, s + 1, board, word, isUsed)) return true;
//        	else isUsed[i + 1][j] = false;
//        }
//        
//        // Left
//        if(j > 0 && board[i][j - 1] == word.charAt(s) && isUsed[i][j - 1] == false) {
//        	isUsed[i][j - 1] = true;
//        	if(existHelper(i, j - 1, s + 1, board, word, isUsed)) return true;
//        	else isUsed[i][j - 1] = false;
//        }
//        
//        // Right
//        if(j < board[0].length -1 && board[i][j + 1] == word.charAt(s) && isUsed[i][j + 1] == false) {
//        	isUsed[i][j + 1] = true;
//        	if(existHelper(i, j + 1, s + 1, board, word, isUsed)) return true;
//        	else isUsed[i][j + 1] = false;
//        }
//        
//        return false;
//    }

}
