package Chegg;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Test {

	
	public static void main(String[] args) throws Exception {
		
		
		
	}
	
	
	public static void solve() throws Exception {
	    
	    FastReader sc = new FastReader();
	    StringBuilder sb = new StringBuilder();
	    
	    int t = sc.nextInt();
	    while(t-- > 0) {
	    	
	    	int T = sc.nextInt();
	    	int n = sc.nextInt();
	    	int sum = sc.nextInt();
	    	
	    	int totalIterations = 0;
	    	
	    	while(T-- != 0 && sum != 0) {
	    		if(sum >= n) {
	    			totalIterations += n * n;
	    			sum -= n;
	    		} else {
	    			totalIterations += sum * sum;
	    			sum = 0;
	    		}
	    	}

	    	sb.append(totalIterations + "\n");
	    }
	    
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
	
	
	// Fast output.
	static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
	
}
