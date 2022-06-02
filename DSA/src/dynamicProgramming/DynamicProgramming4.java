package dynamicProgramming;

import java.util.*;

public class DynamicProgramming4 {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
					// Buy and Sell Stocks With Transaction Fee
	
	// 6.2
	public static int maximumProfit2(int n, int fee, int[] price) {
		Integer dp[][] = new Integer[n][2];
		return maximumProfit2Helper(0, 1, price, fee, dp);
	}
	
	public static int maximumProfit2Helper(int i, int canBuy, int[] price, int fee, Integer dp[][]) {
		
		if(i >= price.length) return 0;
		
		if(dp[i][canBuy] != null) return dp[i][canBuy];
		
		int profit = 0;
		if(canBuy == 1) {
			profit = Math.max(-price[i] + maximumProfit2Helper(i + 1, 0, price, fee, dp),
					0 + maximumProfit2Helper(i + 1, 1, price, fee, dp));
		} else if(canBuy == 0) {
			profit = Math.max(price[i] - fee + maximumProfit2Helper(i + 1, 1, price, fee, dp),
					0 + maximumProfit2Helper(i + 1, 0, price, fee, dp));
		}
		
		return dp[i][canBuy] = profit;
	}
	
	// 6.4
	public static int maximumProfit4(int n, int fee, int[] price) {
		
		int prev[] = new int[2];
		
		for(int i = n - 1; i >= 0; --i) {
			int curr[] = new int[2];
			
			for(int j = 0; j <= 1; ++j) {
				int profit = 0;
				if(j == 1) {
					profit = Math.max(-price[i] + prev[0], 0 + prev[1]);
				} else if(j == 0) {
					profit = Math.max(price[i] - fee + prev[1], 0 + prev[0]);
				}
				
				curr[j] = profit;
			}
			
			prev = curr;
		}
		
		return prev[1];
	}
	
	/* ------------------------------------------------------------------ */
	
						// Buy and Sell Stocks With Cooldown
	
	// 5.2
	public static int stockProfit2(int[] prices) {
		int n = prices.length;
		Integer dp[][] = new Integer[n][2];
		return stockProfit2Helper(0, 1, prices, dp);
	}
	
	public static int stockProfit2Helper(int i, int canBuy, int[] prices, Integer dp[][]) {
		
		if(i >= prices.length) return 0;
		
		if(dp[i][canBuy] != null) return dp[i][canBuy];
		
		int profit = 0;
		if(canBuy == 1) {
			profit = Math.max(-prices[i] + stockProfit2Helper(i + 1, 0, prices, dp),
					0 + stockProfit2Helper(i + 1, 1, prices, dp));
		} else if(canBuy == 0) {
			profit = Math.max(prices[i] + stockProfit2Helper(i + 2, 1, prices, dp),
					0 + stockProfit2Helper(i + 1, 0, prices, dp));
		}
		
		return dp[i][canBuy] = profit;
	}
	
	// 5.3
	public static int stockProfit3(int[] prices) {
		
		int n = prices.length;
		int dp[][] = new int[n + 2][2];
		
		for(int i = n - 1; i >= 0; --i) {
			for(int j = 0; j <= 1; ++j) {
				int profit = 0;
				if(j == 1) {
					profit = Math.max(-prices[i] + dp[i + 1][0], 0 + dp[i + 1][1]);
				} else if(j == 0) {
					profit = Math.max(prices[i] + dp[i + 2][1], 0 + dp[i + 1][0]);
				}
				
				dp[i][j] = profit;
			}
		}
		
		return dp[0][1];
	}
	
	// 5.3
	public static int stockProfit4(int[] prices) {
		
		int n = prices.length;
		int prev1[] = new int[2];
		int prev2[] = new int[2];
		
		for(int i = n - 1; i >= 0; --i) {
			int curr[] = new int[2];
			
			for(int j = 0; j <= 1; ++j) {
				int profit = 0;
				if(j == 1) {
					profit = Math.max(-prices[i] + prev1[0], 0 + prev1[1]);
				} else if(j == 0) {
					profit = Math.max(prices[i] + prev2[1], 0 + prev1[0]);
				}
				
				curr[j] = profit;
			}
			
			prev2 = prev1;
			prev1 = curr;
		}
		
		return prev1[1];
	}
	
	/* ------------------------------------------------------------------ */
	
							// Buy and Sell Stocks IV
	
	// 4.2
	public static int maximumProfit2(int[] price, int n, int k) {
		Integer dp[][][] = new Integer[n][2][k];
		return maximumProfit2Helper(0, 1, k, price, dp);
	}
	
	public static int maximumProfit2Helper(int i, int canBuy, int k, int[] price, Integer dp[][][]) {
		
		if(i == price.length || k == 0) return 0;
		
		if(dp[i][canBuy][k] != null) return dp[i][canBuy][k];
		
		int profit = 0;
		if(canBuy == 1) {
			profit = Math.max(-price[i] + maximumProfit2Helper(i + 1, 0, k, price, dp),
					0 + maximumProfit2Helper(i + 1, 1, k, price, dp));
		} else if(canBuy == 0) {
			profit = Math.max(price[i] + maximumProfit2Helper(i + 1, 1, k - 1, price, dp),
					0 + maximumProfit2Helper(i + 1, 0, k, price, dp));
		}
		
		return dp[i][canBuy][k] = profit;
	}
	
	// 4.4
	public static int maximumProfit4(int[] price, int n, int k) {
		
		int prev[][] = new int[2][k + 1];
		
		for(int i = n - 1; i >= 0; --i) {
			int curr[][] = new int[2][k + 1];
			
			for(int j = 0; j <= 1; ++j) {
				for(int transNo = k; transNo >= 1; --transNo) {
					int profit = 0;
					if(j == 1) {
						profit = Math.max(-price[i] + prev[0][transNo], 0 + prev[1][transNo]);
					} else if(j == 0) {
						profit = Math.max(price[i] + prev[1][transNo - 1], 0 + prev[0][transNo]);
					}
					
					curr[j][transNo] = profit;
				}
			}
			
			prev = curr;
		}
		
		return prev[1][k];
	}
	
	
	
	/* ------------------------------------------------------------------ */
	
							// Buy and Sell Stocks III
	
	// 3.1
	public static int maxProfit1(ArrayList<Integer> prices, int n) {
		return maxProfit1Helper(0, 1, 2, prices);
	}
	
	public static int maxProfit1Helper(int i, int canBuy, int trans, ArrayList<Integer> prices) {

		if(i == prices.size() || trans == 0) return 0;
		
		int profit = 0;
		if(canBuy == 1) {
			profit = Math.max(-prices.get(i) + maxProfit1Helper(i + 1, 0, trans, prices), 
					0 + maxProfit1Helper(i + 1, 1, trans, prices));
		} else if(canBuy == 0) {
			profit = Math.max(prices.get(i) + maxProfit1Helper(i + 1, 1, trans - 1, prices), 
					0 + maxProfit1Helper(i + 1, 0, trans, prices));
		}
		
		return profit;
	}
	
	// 3.2
	public static int maxProfit2(ArrayList<Integer> prices, int n) {
		Integer dp[][][] = new Integer[n][2][3];
		return maxProfit2Helper(0, 1, 2, prices, dp);
	}
	
	public static int maxProfit2Helper(int i, int canBuy, int trans, 
			ArrayList<Integer> prices, Integer dp[][][]) {

		if(i == prices.size() || trans == 0) return 0;
		
		if(dp[i][canBuy][trans] != null) return dp[i][canBuy][trans];
		
		int profit = 0;
		if(canBuy == 1) {
			profit = Math.max(-prices.get(i) + maxProfit2Helper(i + 1, 0, trans, prices, dp), 
					0 + maxProfit2Helper(i + 1, 1, trans, prices, dp));
		} else if(canBuy == 0) {
			profit = Math.max(prices.get(i) + maxProfit2Helper(i + 1, 1, trans - 1, prices, dp), 
					0 + maxProfit2Helper(i + 1, 0, trans, prices, dp));
		}
		
		return dp[i][canBuy][trans] = profit;
	}
	
	// 3.3
	public static int maxProfit3(ArrayList<Integer> prices, int n) {
		
		int dp[][][] = new int[n + 1][2][3];
		
		for(int i = n - 1; i >= 0; --i) {
			for(int j = 0; j <= 1; ++j) {
				for(int k = 1; k <= 2; ++k) {
					int profit = 0;
					if(j == 1) {
						profit = Math.max(-prices.get(i) + dp[i + 1][0][k], 
								0 + dp[i + 1][1][k]);
					} else if(j == 0) {
						profit = Math.max(prices.get(i) + dp[i + 1][1][k - 1], 
								0 + dp[i + 1][0][k]);
					}
					
					dp[i][j][k] = profit;
				}
			}
		}
		
		return dp[0][1][2];
	}
	
	// 3.4
	public static int maxProfit4(ArrayList<Integer> prices, int n) {
		
		int prev[][] = new int[2][3];
		
		for(int i = n - 1; i >= 0; --i) {
			int curr[][] = new int[2][3];
			
			for(int j = 0; j <= 1; ++j) {
				for(int k = 1; k <= 2; ++k) {
					int profit = 0;
					if(j == 1) {
						profit = Math.max(-prices.get(i) + prev[0][k], 
								0 + prev[1][k]);
					} else if(j == 0) {
						profit = Math.max(prices.get(i) + prev[1][k - 1], 
								0 + prev[0][k]);
					}
					
					curr[j][k] = profit;
				}
			}
			
			prev = curr;
		}
		
		return prev[1][2];
	}
	
	/* ------------------------------------------------------------------ */
	
							// Buy and Sell Stock - II
	
	// 2.1
	public static long getMaximumProfit1(int n, long[] values) {
		
		return getMaximumProfitHelper1(0, 1, values);
		
	}
	
	public static long getMaximumProfitHelper1(int i, int canBuy, long[] values) {
		
		if(i == values.length) return 0;
		
		long profit = 0;
		if(canBuy == 1) {
			profit = Math.max(-values[i] + getMaximumProfitHelper1(i + 1, 0, values),
					0 + getMaximumProfitHelper1(i + 1, 1, values));
		} else if(canBuy == 0) {
			profit = Math.max(values[i] + getMaximumProfitHelper1(i + 1, 1, values),
					0 + getMaximumProfitHelper1(i + 1, 0, values));
		}
		
		return profit;
	}
	
	// 2.2
	public static long getMaximumProfit2(int n, long[] values) {
		Long dp[][] = new Long[n][2];
		return getMaximumProfitHelper2(0, 1, values, dp);
	}
	
	public static long getMaximumProfitHelper2(int i, int canBuy, long[] values, Long dp[][]) {
		
		if(i == values.length) return 0;
		
		if(dp[i][canBuy] != null) return dp[i][canBuy];
		
		long profit = 0;
		if(canBuy == 1) {
			profit = Math.max(-values[i] + getMaximumProfitHelper2(i + 1, 0, values, dp),
					0 + getMaximumProfitHelper2(i + 1, 1, values, dp));
		} else if(canBuy == 0) {
			profit = Math.max(values[i] + getMaximumProfitHelper2(i + 1, 1, values, dp),
					0 + getMaximumProfitHelper2(i + 1, 0, values, dp));
		}
		
		return dp[i][canBuy] = profit;
	}
	
	// 2.3
	public static long getMaximumProfit3(int n, long[] values) {
		
		long dp[][] = new long[n + 1][2];
		
//		dp[n][0] = dp[n][1] = 0;		Not required
		
		for(int i = n - 1; i >= 0; --i) {
			for(int j = 0; j <= 1; ++j) {
				long profit = 0;
				if(j == 1) {
					profit = Math.max(-values[i] + dp[i + 1][0], 0 + dp[i + 1][1]);
				} else if(j == 0) {
					profit = Math.max(values[i] + dp[i + 1][1], 0 + dp[i + 1][0]);
				}
				
				dp[i][j] = profit;
			}
		}
		
		return dp[0][1];
	}
	
	// 2.4
	public static long getMaximumProfit4(int n, long[] values) {
		
		long prev[] = new long[2];
		
//		prev[0] = prev[1] = 0;		Not required
		
		for(int i = n - 1; i >= 0; --i) {
			
			long curr[] = new long[2];
			for(int j = 0; j <= 1; ++j) {
				long profit = 0;
				if(j == 1) {
					profit = Math.max(-values[i] + prev[0], 0 + prev[1]);
				} else if(j == 0) {
					profit = Math.max(values[i] + prev[1], 0 + prev[0]);
				}
				
				curr[j] = profit;
			}
			
			prev = curr;
		}
		
		return prev[1];
	}

}
