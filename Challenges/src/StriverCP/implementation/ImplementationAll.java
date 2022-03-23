package StriverCP.implementation;

import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class ImplementationAll {

	public static void main(String[] args) {
		CF_1030A();
	}
	
	public static void CF_1030A() {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		boolean isHard = false;
		for(int i = 0; i < num; ++i) {
			int response = sc.nextInt();
			if(response == 1) isHard = true;
		}
		sc.close();
		System.out.println(isHard == false ? "EASY" : "HARD");
	}
	
	public static void CF_785A() {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int res = 0;
		
		String temp = sc.nextLine();
		
		for(int i = 0; i < num; ++i) {
			String s = sc.nextLine();
			
			if(s.equals("Tetrahedron")) res += 4;
			else if(s.equals("Cube")) res += 6;
			else if(s.equals("Octahedron")) res += 8;
			else if(s.equals("Dodecahedron")) res += 12;
			else if(s.equals("Icosahedron")) res += 20;
		}

		sc.close();
		System.out.println(res);
	}
	
	public static void CF_510A() {
		
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		boolean rev = false;
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(i % 2 == 0) sb.append('#');
				else {
					if(rev == true) {
						if(j == 0) sb.append('#');
						else sb.append('.');
					} else {
						if(j == m - 1) sb.append('#');
						else sb.append('.');
					}
				}
			}
			if(i % 2 == 1) rev = !rev;
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void CF_1352A() {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int num = sc.nextInt();
			
			List<Integer> temp = new ArrayList<>();
			
			int count = 0;
			while(num > 0) {
				int mod = num % 10;
				if(mod == 0) {
					num = num/10;
				} else {
					temp.add((int)Math.pow(10, count) * mod);
					num = num/10;
				}
				
				++count;
			}
			
			sb.append(temp.size() + "\n");
			for(int i : temp) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}
		
		sc.close();
		System.out.println(sb.toString());
	}
	
	public static void CF_723A() {
		
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		sc.close();
		Arrays.sort(arr);
		System.out.println(arr[1] - arr[0] + arr[2] - arr[1]);
	}
	
	public static void CF_151A() {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int l = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int p = sc.nextInt();
		int nl = sc.nextInt();
		int np = sc.nextInt();
		
		sc.close();
		System.out.println(Math.min(k*l/nl, Math.min(c*d, p/np))/n);
		
	}
	
	public static void CF_282A() {
		
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		
		int res = 0;
		
		for(int i = 0; i < n; ++i) {
			
			String s = sc.nextLine();
			if(s.charAt(1) == '+') ++res;
			else --res;
		}
		
		System.out.println(res);
		
	}
	
	// Fast input class.
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
