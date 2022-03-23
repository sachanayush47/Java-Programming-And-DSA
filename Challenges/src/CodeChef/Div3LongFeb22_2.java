package CodeChef;

import java.io.*;
import java.util.*;

public class Div3LongFeb22_2 {

	public static void main(String[] args) {
		XORPAL();
	}
	
	public static void XORPAL() {
		
		FastReader sc = new FastReader();
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int n = sc.nextInt();
			String s = sc.nextLine();
			
			int zero = 0;
			int one = 0;
			
			for(int i = 0; i < n; ++i) {
				if(s.charAt(i) == '0') ++zero;
				else ++one;
			}
			
			int modOne = one % 2;
			int modZero = zero % 2;
			
			if(one == zero) sb.append("YES\n");
			else if(modOne == 0 && modZero == 0) sb.append("YES\n");
			else if(modOne == 1 && modZero == 1) sb.append("NO\n");
			else if((modOne == 0 && modZero == 1) || (modOne == 1 && modZero == 0)) sb.append("YES\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void NOFIX() {
		
		FastReader sc = new FastReader();
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int n = sc.nextInt();
			int shift = 0;
			
			for(int i = 1; i <= n; ++i) {
				int num = sc.nextInt();
				if(num == (i + shift)) ++shift;
			}
			
			sb.append(shift + "\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void WCC() {
		
		FastReader sc = new FastReader();
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int x = sc.nextInt();
			String s = sc.nextLine();
			
			int carl = 0;
			int chef = 0;
			
			for(int i = 0; i < 14; ++i) {
				if(s.charAt(i) == 'C') carl += 2;
				else if(s.charAt(i) == 'N') chef += 2;
				else {
					++carl;
					++chef;
				}
			}
			
			if(carl > chef) sb.append(x*60);
			else if(carl < chef) sb.append(x*40);
			else sb.append(x*55);
			
		}
		
		System.out.println(sb.toString());
	}
	
	public static void HELIUM3() {
		
		FastReader sc = new FastReader();
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(a*b <= x*y) sb.append("YES\n");
			else sb.append("NO");
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

}
