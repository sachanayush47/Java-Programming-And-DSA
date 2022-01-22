package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_914A {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		FastReader sc = new FastReader();
		
		int n = sc.nextInt();
		int res = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; ++i) {
			int num = sc.nextInt();
			
			if(num < 0) {
				if(num > res) res = num;
				continue;
			}
			
			double root = Math.sqrt(num);
			root = (int)root;
			
			if(num != root*root) {
				if(num > res) res = num;
			}
		}
		
		System.out.println(res);
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
