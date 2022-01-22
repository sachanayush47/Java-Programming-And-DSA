package CodeChef;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lunchtime103C {

	public static void main(String[] args) throws IOException {
		RMNTREV();
	}
	
	/* ------------------------------------------------------------------ */
	
	public static void RMNTREV() throws IOException {
		FastReader sc = new FastReader();
		StringBuilder res = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int sLength = sc.nextInt()-1;
			int rev = sc.nextInt();
			
			String s = sc.nextLine();
			
			String temp = "";
			
			int i = 0;
			int j = sLength;
			
			while(i <= j) {
				if(j < rev) {
					if(i == j) {
						temp = String.valueOf(s.charAt(i)) + temp;
					} else {
						temp = String.valueOf(s.charAt(j)) + String.valueOf(s.charAt(i)) + temp;
					}
					++i;
					--j;
				} else {
					temp = String.valueOf(s.charAt(j)) + temp;
					--j;
				}
			}
			res.append(temp + "\n");
		}
		
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		output.write(res.toString());
		
		output.flush();
	}
	
	/* ------------------------------------------------------------------ */
	
	public static void MXMTRIO() {
		FastReader sc = new FastReader();
		StringBuilder res = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			
			for(int i = 0; i < n; ++i) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			BigInteger largest = new BigInteger(String.valueOf(arr[n-1]));
			BigInteger largest2 = new BigInteger(String.valueOf(arr[n-2]));
			BigInteger smallest = new BigInteger(String.valueOf(arr[0]));
			
			largest = largest.subtract(smallest);
			largest = largest.multiply(largest2);
			
			res.append(largest.toString() + "\n");
		}
		
		System.out.println(res.toString());
	}
	
	/* ------------------------------------------------------------------ */
	
	public static void CHEF1010() {
		FastReader sc = new FastReader();
		StringBuilder res = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int size = sc.nextInt();
			String s = sc.nextLine();
			
			int count0 = 0;
			int count1 = 0;
			
			for(int i = 0; i < size; ++i) {
				if(s.charAt(i) == '0') ++count0;
				else ++count1;
			}
			
			int occur = Math.min(count0, count1);
			--occur;
			if(occur < 0) occur = 0;
			res.append(occur + "\n");
		}
		
		System.out.println(res.toString());
	}
	
	/* ------------------------------------------------------------------ */
	
	public static void CHEFTRANS() {
		
		FastReader sc = new FastReader();
		StringBuilder res = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
				
			if((x+y) == z) res.append("EQUAL\n");
			else if((x+y) > z) res.append("TRAIN\n");
			else res.append("PLANEBUS\n");
			
		}
		
		System.out.println(res.toString());
		
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
