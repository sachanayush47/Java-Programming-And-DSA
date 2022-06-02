package SheetSDE;

import java.util.*;

public class Day10 {

	public static void main(String[] args) {

		int m[][] = {{0, 1, 1, 1}, {1, 1, 1, 0}, {1, 0, 1, 1}, {0, 0, 1, 1}};
		System.out.println(findPath(new int[][] {{1, 1}, {1, 1}}, 2));
		
	}
	
	/* ------------------------------------------------------------------ */
	
								// Rat in a maze
	
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        if(m[0][0] == 0) return res;
        boolean check[][] = new boolean[n][n];
        check[0][0] = true;
    	findPathHelper("", m, 0, 0, res, check);
    	return res;
    }
    
    public static void findPathHelper
    	(String s, int[][] m, int r, int c, ArrayList<String> res, boolean[][] check) {
        
    	if(r == m.length - 1 && c == m.length - 1) {
    		res.add(s);
    		return;
    	}
    	
    	if(r > 0 && check[r - 1][c] == false && m[r - 1][c] == 1) {
    		// Up
    		check[r - 1][c] = true;
    		findPathHelper(s + "U", m, r - 1, c, res, check);
    		check[r - 1][c] = false;
    	}
    	
    	if(r < m.length - 1 && check[r + 1][c] == false && m[r + 1][c] == 1) {
    		// Down
    		check[r + 1][c] = true;
    		findPathHelper(s + "D", m, r + 1, c, res, check);
    		check[r + 1][c] = false;
    	}
    	
    	if(c > 0 && check[r][c - 1] == false && m[r][c - 1] == 1) {
    		// Left
    		check[r][c - 1] = true;
    		findPathHelper(s + "L", m, r, c - 1, res, check);
    		check[r][c - 1] = false;
    	}
    	
    	if(c < m.length - 1 && check[r][c + 1] == false && m[r][c + 1] == 1) {
    		// Right
    		check[r][c + 1] = true;
    		findPathHelper(s + "R", m, r, c + 1, res, check);
    		check[r][c + 1] = false;
    	}
    	
    }
	
	/* ------------------------------------------------------------------ */
	
								// Sudoku Solver
	
	public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
	
	public static boolean solveSudokuHelper(char[][] board) {
        
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				if(board[i][j] == '.') {
					
					for(int k = 1; k <= 9; ++k) {
						if(isValid(i, j, k, board)) {
							board[i][j] = (char)k;
							if(solveSudokuHelper(board)) return true;
							else board[i][j] = '.';
						}
					}
					
					return false;
				}
			}
		}
		
		return true;
    }
	
	public static boolean isValid(int i, int j, int k, char[][] board) {
		
		for(int a = 0; a < 9; ++a) {
			if(board[i][a] == k) return false;
			if(board[a][j] == k) return false;
		}
		
		// Box check
		int startRow = (int)(i / 3) * 3;
		int endRow = startRow + 2;
		
		int startCol = (int)(j / 3) * 3;
		int endCol = startCol + 2;
		for(int a = startRow; a <= endRow; ++a) {
			for(int b = startCol; b <= endCol; ++b) {
				if(board[a][b] == k) return false;
			}
		}
		
		return true;
	}
	
	/* ------------------------------------------------------------------ */
	
								// N - Queens
	
	// Approach 2 : "isSafe" method optimised using hash array.
	
/**
    public static List < List < String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }
	
    static void solve(int col, char[][] board, List < List < String >> res, 
    						int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 
            				&& upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
*/
	
	// Approach 1 : "isSafe" method is not optimised.
    public static List<List<String>> solveNQueens(int n) {
        
    	List<List<String>> res = new ArrayList<>();
    	char board[][] = new char[n][n];
    	for(int i = 0; i < n; ++i) {
    		for(int j = 0; j < n; ++j) {
    			board[i][j] = '.';
    		}
    	}
    	
    	solve(0, board, res);
    	return res;
    }
    
    public static void solve(int col, char board[][], List<List<String>> res) {
    	
    	if(col >= board.length) {
    		res.add(construct(board));
    		return;
    	}
    	
    	for(int i = 0; i < board.length; ++i) {
    		if(isSafe(i, col, board)) {
    			board[i][col] = 'Q';
    			solve(col + 1, board, res);
    			board[i][col] = '.';
    		}
    	}
    	
    }
    
    public static boolean isSafe(int row, int col, char board[][]) {
    	
    	int dupRow = row;
    	int dupCol = col;
    	
    	// Row check
    	while(dupCol >= 0) {
    		if(board[row][dupCol] == 'Q') return false;
    		--dupCol;
    	}
    	
    	// Upper diagonal check
    	dupCol = col;
    	while(dupRow >= 0 && dupCol >= 0) {
    		if(board[dupRow][dupCol] == 'Q') return false;
    		--dupRow;
    		--dupCol;
    	}
    	
    	// Lower diagonal check
    	dupRow = row;
    	dupCol = col;
    	while(dupRow < board.length && dupCol >= 0) {
    		if(board[dupRow][dupCol] == 'Q') return false;
    		++dupRow;
    		--dupCol;
    	}
    	
    	return true;
    }
    
    public static List<String> construct(char board[][]) {
    	List<String> ans = new ArrayList<>();
    	
    	for(int i = 0; i < board.length; ++i) {
   			String s = new String(board[i]);
   			ans.add(s);
    	}
    	
    	return ans;
    }
	
	/* ------------------------------------------------------------------ */
	
								// Permutaions
	
    public static List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
        
    }
    
    public static void permuteHelper
    	(int[] nums, List<Integer> ds, List<List<Integer>> res, boolean[] freq) {
        
        if(ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = 0; i < nums.length; ++i) {
            if(freq[i] == false) {
                ds.add(nums[i]);
                freq[i] = true;
                permuteHelper(nums, ds, res, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

}
