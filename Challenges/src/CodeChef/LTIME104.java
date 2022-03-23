package CodeChef;

import java.io.*;
import java.util.*;

public class LTIME104 {

	public static void main(String[] args) {
		SUBSTADD();
	}
	
	public static void SUBSTADD() {
		
		FastReader sc = new FastReader();
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int a[] = new int[n];
			for(int i = 0; i < n; ++i) a[i] = sc.nextInt();
			
			int b[] = new int[n];
			for(int i = 0; i < n; ++i) b[i] = sc.nextInt();
			
			boolean exist = true;
			for(int i = 0; i < n; ++i) {
				
				if(a[i] + x != b[i] && a[i] + y != b[i]) {
					sb.append("NO\n");
					exist = false;
					break;
				}
			}
			if(exist) sb.append("YES\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void LOCKDRAW() {
		
		FastReader sc = new FastReader();
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int arr[] = new int[3];
			
			int max = Integer.MIN_VALUE;
			int index = -1;
			
			for(int i = 0; i < 3; ++i) {
				arr[i] = sc.nextInt();
				if(arr[i] > max) {
					max = arr[i];
					index = i;
				}
			}
			
			int sum = 0;
			
			for(int i = 0; i < 3; ++i) {
				if(i == index) continue;
				sum += arr[i];
			}
			
			if(sum == max) sb.append("YES\n");
			else sb.append("NO\n");
			
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
