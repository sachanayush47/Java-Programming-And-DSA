package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_944A {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		FastReader sc = new FastReader();
		
		int n = sc.nextInt();
		String prev = sc.nextLine();
		int res = 1;
		
		for(int i = 0; i < n-1; ++i) {
			String magnet = sc.nextLine();
			if(!magnet.equals(prev)) {
				prev = magnet;
				++res;
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
