package CodeChef;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Div3LongFeb22 {
	
	static boolean found = false;
	
	public static void main(String[] args) throws Exception {
		BINBASBASIC();
	}
	
	// APPROACH 2 - AC
	public static void BINBASBASIC() throws Exception {
		
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.nextLine();
			
	        int i = 0, j = s.length() - 1;
	        while (i < j) {
	            if(s.charAt(i) != s.charAt(j)) --k;
	            ++i;
	            --j;
	        }
	        
	        if(n % 2 == 1 && k >= 0) sb.append("YES\n");
	        else if(n % 2 == 0 && k % 2 == 0 && k >= 0) sb.append("YES\n");
	        else sb.append("NO\n");
		}
		
		FastWriter console = new FastWriter();
		console.print(sb.toString());
		console.close();
		
	}
	
	// APPROACH 1 - TLE
//	public static void BINBASBASIC() throws Exception {
//		
//		FastReader sc = new FastReader();
//		int t = sc.nextInt();
//		StringBuilder sb = new StringBuilder();
//		
//		while(t-- > 0) {
//			
//			int n = sc.nextInt();
//			int k = sc.nextInt();
//			
//			String s = sc.nextLine();
//			found = false;
//			doOperation(k, "", s);
//			
//			if(found) sb.append("YES\n");
//			else sb.append("NO\n");
//		}
//		
//		FastWriter console = new FastWriter();
//		console.print(sb.toString());
//		console.close();
//		
//	}
//	
//	public static boolean isPalindrome(String str) {
// 
//        int i = 0, j = str.length() - 1;
// 
//        while (i < j) {
//            if (str.charAt(i) != str.charAt(j)) return false;
//            i++;
//            j--;
//        }
// 
//        return true;
//    }
//	
//	public static void doOperation(int k, String out, String in) {
//		
//		if(k == 0 || in.length() == 0) {
//			if(k == 0) {
//				out += in;
//				if(isPalindrome(out)) {
//					found = true;
//					System.out.println(out);
//				}
//				
//			}
//			return;
//		}
//		
//		if(found) return;
//		
//		String output1 = in.charAt(0) + "";
//		
//		String output2;
//		if(in.charAt(0) == '0') output2 = "1";
//		else output2 = "" + "0";
//		
//		in = in.substring(1);
//		
//		doOperation(k, out + output1, in);
//		doOperation(k-1, out + output2, in);
//		
//	}
	
	public static void EUREKA() throws Exception {
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			
			int n = sc.nextInt();
			
			double raw = Math.pow(0.143*n, n);
			
			int res;
			if(raw % 1 < 0.5) res = (int)raw;
			else res = (int)raw + 1;
			sb.append(res + "\n");
		}
		
		FastWriter console = new FastWriter();
		console.print(sb.toString());
		console.close();
	}
	
	public static void CHEFBARBER() throws Exception {
		
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
		
			sb.append(n*m + "\n");
		}
		
		FastWriter console = new FastWriter();
		console.print(sb.toString());
		console.close();
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
