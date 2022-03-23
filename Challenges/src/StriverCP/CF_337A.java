package StriverCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_337A {

	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[] = new int[m];
		for(int i = 0; i < m; ++i) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int i = 0;
		int j = n-1;
		
		int res = Integer.MAX_VALUE;
		while(j < m) {
			res = Math.min(res, arr[j] - arr[i]);
			++i;
			++j;
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
