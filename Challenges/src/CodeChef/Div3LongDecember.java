package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Div3LongDecember {
	
	

	public static void main(String[] args) {
		
	//	UTKPLC();
	//	LISTLIST();
	//	VANDH();
		
	//	ROPASCI();
		CHECKMATE();
	}
	
	// Unaccepted
	public static void CHECKMATE() {
		FastReader sc = new FastReader();
		
		int t = sc.nextInt();
		StringBuilder res = new StringBuilder();
		
		while(t-- > 0) {
			// King
			int xk = sc.nextInt();
			int yk = sc.nextInt();
			
			// Rock 1
			int xr1 = sc.nextInt();
			int yr1 = sc.nextInt();
			
			
			// Rock 2
			int xr2 = sc.nextInt();
			int yr2 = sc.nextInt();
			
			if(xk == 1 && yk == 1) {
			
				if((xr1 == 2 && yr1 == 2) || (xr2 == 2 && yr2 == 2)) {
					res.append("NO");
				} else if(xr1 == 2 || xr2 == 2) {
					if(yr1 == yr2) res.append("NO");
					else res.append("YES");
				} else if(yr1 == 2 || yr2 == 2) {
					if(xr1 == xr2) res.append("NO");
					else res.append("YES");
				} else res.append("NO");
			
			} else if(xk != 1 && yk != 8) {
				
				if((xr1 == 2 && yr1 == 7) || (xr2 == 2 && yr2 == 7)) {
					res.append("NO");
				} else if(xr1 == 2 || xr2 == 2) {
					if(yr1 == yr2) res.append("NO");
					else res.append("YES");
				} else if(yr1 == 7 || yr2 == 7) {
					if(xr1 == xr2) res.append("NO");
					else res.append("YES");
				} else res.append("NO");
				
			} else if(xk != 8 && yk != 1) {
				
				if((xr1 == 7 && yr1 == 2) || (xr2 == 7 && yr2 == 2)) {
					res.append("NO");
				} else if(xr1 == 7 || xr2 == 7) {
					if(yr1 == yr2) res.append("NO");
					else res.append("YES");
				} else if(yr1 == 2 || yr2 == 2) {
					if(xr1 == xr2) res.append("NO");
					else res.append("YES");
				} else res.append("NO");
				
			} else if(xk != 8 && yk != 8) {
				
				if((xr1 == 7 && yr1 == 7) || (xr2 == 7 && yr2 == 7)) {
					res.append("NO");
				} else if(xr1 == 7 || xr2 == 7) {
					if(yr1 == yr2) res.append("NO");
					else res.append("YES");
				} else if(yr1 == 7 || yr2 == 7) {
					if(xr1 == xr2) res.append("NO");
					else res.append("YES");
				} else res.append("NO");
			
			} else res.append("NO");		
		}
		
		System.out.println(res.toString());
	}
	
	// Unaccepted
	public static void ROPASCI() {
		Scanner sc = new Scanner(System.in);
		StringBuilder res = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int player = sc.nextInt();
			sc.nextLine();
			String moves = sc.nextLine();
			char last = moves.charAt(player-1);
			for(int i = 0; i < player; ++i) {
				char curr = moves.charAt(i);
				boolean won = true;
				if(curr == 'R' && last == 'P') {
					res.append(last);
					won = false;
				} else if(curr == 'P' && last == 'S') {
					res.append(last);
					won = false;
				} else if(curr == 'S' && last == 'R') {
					res.append(last);
					won = false;
				}
				
				if(won) res.append(curr);
			}
			res.append("\n");
		}
		sc.close();
		System.out.println(res.toString());

	}
	
	public static void VANDH() {
		Scanner sc = new Scanner(System.in);
		StringBuilder OP = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int hills = sc.nextInt();
			int valleys = sc.nextInt();
			
			String s1 = "01";
			String s2 = "10";
			String s3 = "010";
			String s4 = "101";
			
			String res = "";
			
			if(hills == valleys) {
				for(int i = 0; i <= hills; ++i) res = res + s1;
				res = res + "\n";
			} else if(hills > valleys) {
				for(int i = 0; i < valleys; ++i) res = res + s1;
				for(int i = 0; i < hills-valleys; ++i) res = res + s3;
				res = res + "\n";
			} else if(hills < valleys) {
				for(int i = 0; i < hills; ++i) res = res + s2;
				for(int i = 0; i < valleys-hills; ++i) res = res + s4;
				res = res + "\n";
			}
			OP.append(res.length()-1+"\n"); // Because to remove the last ENTER.
			OP.append(res);
		}
		sc.close();
		System.out.println(OP.toString());
	}
	
	public static void LISTLIST() {
		Scanner sc = new Scanner(System.in);
		StringBuilder res = new StringBuilder();
		
		int t = sc.nextInt();
		while(t-- > 0) {
			int l = sc.nextInt();
			if(l == 1) {
				res.append(0+"\n");
				sc.nextInt();
			} else {
				HashMap<Integer, Integer> freq = new HashMap<>();
				int freqCount = 0;
				
				for(int i = 0; i < l; ++i) {
					int num = sc.nextInt();
					
					if(freq.containsKey(num)) freq.put(num, freq.get(num)+1);
					else freq.put(num, 1);
				}
				
				for(Integer i : freq.keySet()) {
					if(freq.get(i) > freqCount) freqCount = freq.get(i);
				}
				
				if(freqCount == 1) res.append(-1+"\n");
				else if(freqCount == l) res.append(0+"\n");
				else res.append(l-freqCount+1+"\n");
			} 
		}
		sc.close();
		System.out.println(res.toString());
	}
	
	public static void UTKPLC() {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			char compPref[] = sc.nextLine().replaceAll(" ", "").toCharArray();
			char offersRec[] = sc.nextLine().replaceAll(" ", "").toCharArray();
			
			
			if(compPref[0] == offersRec[0] || compPref[0] == offersRec[1]) {
				sb.append(compPref[0]+"\n");
			} else {
				sb.append(compPref[1]+"\n");
			}
			
		}
		sc.close();
		System.out.println(sb.toString());
	}
	
	static class FastReader {
	    BufferedReader br;
	    StringTokenizer st;

	    public FastReader() {
	        br = new BufferedReader(new InputStreamReader(System.in));
	    }

	    String next() {
	        while (st == null || !st.hasMoreElements()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return st.nextToken();
	    }

	    int nextInt() {
	    	return Integer.parseInt(next());
	    }

	    long nextLong() {
	    	return Long.parseLong(next());
	    }

	    double nextDouble() {
	        return Double.parseDouble(next());
	    }

	    String nextLine() {
	        String str = "";
	        try {
	            str = br.readLine();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        return str;
	    }
	}
}
