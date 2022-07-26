package recursion;

public class LeetCoding {

	public static void main(String[] args) {
		
		
	}
	
	//	-------------------------------------------------------------------------
	//	-------------------------------------------------------------------------
	//	-------------------------------------------------------------------------
	//	-------------------------------------------------------------------------
	
								// 200. Number of islands.
	
	public static int numIslands(char[][] grid) {
        
		int m = grid.length;
		int n = grid[0].length;
		
		int ans = 0;
		
		for(int i = 0; i < m; ++i) {
			 for(int j = 0; j < n; ++j) {
				 if(grid[i][j] == '1') {
					++ans;
					numIslandsHelper(i, j, grid);
				 }
			 }
		}
		
		return ans;
    }
	
	public static void numIslandsHelper(int i, int j, char[][] grid) {
		
		if(i >= grid.length || j >= grid[0].length || j < 0 || i < 0) return;
		
		if(grid[i][j] == '0') return;
		
		grid[i][j] = '0';
        numIslandsHelper(i, j + 1, grid);
        numIslandsHelper(i - 1, j, grid);
        numIslandsHelper(i, j - 1, grid);
		numIslandsHelper(i + 1, j, grid);
	}
	
	//	-------------------------------------------------------------------------
	
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
	


}
