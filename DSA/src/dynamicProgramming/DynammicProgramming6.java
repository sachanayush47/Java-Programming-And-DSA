package dynamicProgramming;

import java.util.Arrays;

// Tabulation (without dp[][] matrix optimization i.e do till 0.3 only) is enough 
// for interviews. even the interviewers is happy with memoziation solution in this part

public class DynammicProgramming6 {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	/* ------------------------------------------------------------------ */
	
	// 49.2
	public int minCost2(int n, int[] cuts) {
        int l = cuts.length;
        int newCuts[] = new int[l + 2];
        
        for(int i = 0; i < l; ++i)
            newCuts[i + 1] = cuts[i];
        
        newCuts[l + 1] = n;
        Arrays.sort(newCuts);
        
        int dp[][] = new int[l + 1][l + 1];
        
        for(int it[] : dp) {
            Arrays.fill(it, -1);
        }
        
        return minCostHelper2(1, l, newCuts, dp);
    }
    
    public int minCostHelper2(int i, int j, int[] cuts, int dp[][]) {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        
        int min = (int)1e9;
        
        for(int k = i; k <= j; ++k) {
            int cost = cuts[j + 1] - cuts[i - 1] 
                + minCostHelper2(i, k - 1, cuts, dp) 
                + minCostHelper2(k + 1, j, cuts, dp);
            
            min = Math.min(min, cost);
        }
        
        return dp[i][j] = min;
    }
    
    // 49.3		This solution is not working even after brainstorming.
//    public int minCost3(int n, int[] cuts) {
//    	
//        int l = cuts.length;
//        int newCuts[] = new int[l + 2];
//        
//        for(int i = 0; i < l; ++i)
//            newCuts[i + 1] = cuts[i];
//        
//        newCuts[l + 1] = n;
//        Arrays.sort(newCuts);
//        
//        int dp[][] = new int[l + 1][l + 1];
//        
//        for(int i = l; i > 0; --i) {
//        	for(int j = i + 1; j <= l; ++j) {
//                int min = (int)1e9;
//                
//                for(int k = i; k <= j; ++k) {
//                    int cost = newCuts[j + 1] - newCuts[i - 1] + dp[i][k - 1] + dp[k + 1][j];
//                    min = Math.min(min, cost);
//                }
//                
//                dp[i][j] = min;
//        	}
//        }
//    	
//        return dp[1][l];
//    }
	
	/* ------------------------------------------------------------------ */
	
	// 48.1
	public static int mcm1(int[] arr , int N) {
		return mcm1Helper(1, N - 1, arr);
	}
    
    public static int mcm1Helper(int i, int j, int arr[]) {
        if(i == j) return 0;
        
        int min = (int)1e9;
        
        for(int k = i; k < j; ++k) {
            int steps = arr[i - 1] * arr[k] * arr[j] + 
            		mcm1Helper(i, k, arr) + mcm1Helper(k + 1, j, arr);
        
            min = Math.min(min, steps);
        }        
        
        return min;
    }
    
    
    // 48.2
	public static int mcm2(int[] arr , int N) {
		int dp[][] = new int[N][N];
		
		for(int it[] : dp) {
			Arrays.fill(it, -1);
		}
		
		return mcm2Helper(1, N - 1, arr, dp);
	}
    
    public static int mcm2Helper(int i, int j, int arr[], int dp[][]) {
        if(i == j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = (int)1e9;
        
        for(int k = i; k < j; ++k) {
            int steps = arr[i - 1] * arr[k] * arr[j] + 
            		mcm2Helper(i, k, arr, dp) + mcm2Helper(k + 1, j, arr, dp);
        
            min = Math.min(min, steps);
        }        
        
        return dp[i][j] = min;
    }
    
    // 49
	public static int mcm3(int[] arr , int N) {
		int dp[][] = new int[N][N];
		
		for(int i = N - 1; i > 0; --i) {
			for(int j = i + 1; j < N; ++j) {

				int min = (int)1e9;
		        for(int k = i; k < j; ++k) {
		            int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
		            min = Math.min(min, steps);
		        }
		        
		        dp[i][j] = min;
			}
		}
		
		return dp[1][N - 1];
	}
}
