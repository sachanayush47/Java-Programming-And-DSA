package CodeChef;

import java.util.*;

public class April222C {

	public static void main(String[] args) throws Exception {
		solve();
	}
	
	public static void solve() throws Exception {
	    
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(t-- > 0) {
	        int n = sc.nextInt();
	        
	        int pos = 0;
	        int neg = 0;
	        
	        for(int i = 0; i < n; ++i) {
	            int num = sc.nextInt();
	            if(num == 1) ++pos;
	            else ++neg;
	        }
	        System.out.println(pos + " " + neg);
	        if(pos == 0 || neg == 0) sb.append("NO" + "\n");
	        else sb.append("YES" + "\n");
	    }
	    
	    sc.close();
	    System.out.println(sb.toString());
	}

}
