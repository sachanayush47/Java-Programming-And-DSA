package miscellaneous.comparablesAndComparators;

public class OFB {

	public static void main(String[] args) {

		char arr[][] = {
				{'0', 'E', 'W'},
				{'E', '0', 'E'},
				{'0', 'W', '0'},
		};
		
		System.out.println(calcMaxEnemies(arr));
		
	}
	
	// 1. Create a class Quadruple to store all values.
	// 2. Initialize Quadruple matrix to store values.
	// 3. Calculate values
	// 4. Find answer from calculated values.
	public static int calcMaxEnemies(char arr[][]) {
		
		int m = arr.length;
		int n = arr[0].length;
		
		Quadruple calc[][] = new Quadruple[m][n];
		
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				calc[i][j] = new Quadruple(0, 0, 0, 0);
			}
		}
		
		// Calculate prefix
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (arr[i][j] == '0') {
					calc[i][j].pre = j - 1 < 0 ? 0 : calc[i][j - 1].pre;
				} else if (arr[i][j] == 'E') {
					calc[i][j].pre += j - 1 < 0 ? 1 : calc[i][j - 1].pre + 1;
				} else if (arr[i][j] == 'W') {
					calc[i][j].pre = 0; 
				}
			}
		}
		
		// Calculate suffix
		for (int i = 0; i < m; ++i) {
			for (int j = n - 1; j >= 0; --j) {
				if (arr[i][j] == '0') {
					calc[i][j].suff = j + 1 >= n ? 0 : calc[i][j + 1].pre;
				} else if (arr[i][j] == 'E') {
					calc[i][j].suff += j + 1 >= n ? 1 : calc[i][j + 1].pre + 1;
				} else if (arr[i][j] == 'W') {
					calc[i][j].suff = 0; 
				}
			}
		}
		
		// Calculate up to down
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (arr[j][i] == '0') {
					calc[j][i].upToDown = j - 1 < 0 ? 0 : calc[j - 1][i].upToDown;
				} else if (arr[j][i] == 'E') {
					calc[j][i].upToDown += j - 1 < 0 ? 1 : calc[j - 1][i].upToDown + 1;
				} else if (arr[j][i] == 'W') {
					calc[j][i].upToDown = 0; 
				}
			}
		}
		
		// Calculate down to up
		for (int i = 0; i < n; ++i) {
			for (int j = m - 1; j >= 0; --j) {
				if (arr[j][i] == '0') {
					calc[j][i].downToUp = j + 1 >= m ? 0 : calc[j + 1][i].downToUp;
				} else if (arr[j][i] == 'E') {
					calc[j][i].downToUp += j + 1 >= m ? 1 : calc[j + 1][i].downToUp + 1;
				} else if (arr[j][i] == 'W') {
					calc[j][i].downToUp = 0; 
				}
			}
		}
		
		// Final answer
		int maxEnemies = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (arr[i][j] == '0') {
					maxEnemies = Math.max(Math.max(calc[i][j].pre, calc[i][j].suff) 
							+ Math.max(calc[i][j].upToDown, calc[i][j].downToUp), maxEnemies);
				}
			}
		}
		
		return maxEnemies;
	}
}

class Quadruple {
	int pre;
	int suff;
	int upToDown;
	int downToUp;

	public Quadruple(int pre, int suff, int upToDown, int downToUp) {
		this.pre = pre;
		this.suff = suff;
		this.upToDown = upToDown;
		this.downToUp = downToUp;
	}
}


