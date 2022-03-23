package Random;
import java.util.*;
public class tq {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine().trim());
        
        List<Integer> Arr = new ArrayList<>(N);
        for(int j=0; j<N; j++) {
            Arr.add(Integer.parseInt(scan.nextLine().trim()));
        }
    
        int result = LVS(N, Arr);
    
        System.out.println(result);
	}
	
	public static int LVS(int n, List<Integer> arr) {
        
        boolean isPrime[] = soe(20000);
        
        int l = 1;
        int max = 1;
        
        for(int i = 0; i < arr.size(); ++i) {
            int lastPicked = arr.get(i);
            
            for(int j = i+1; j < arr.size(); ++j) {
                boolean prime = isPrime[lastPicked];    
                if(prime && (arr.get(j) % lastPicked == 0)) {
                    ++l;
                    lastPicked = arr.get(j);
                } else if(!prime) {
                    if(isPrime[arr.get(j)] && lastPicked % arr.get(j) == 0) {
                        ++l;
                        lastPicked = arr.get(j);
                    }
                }
            }
            
            max = Math.max(max, l);
            l = 1;
        }
        
        return max;
    }
    
    public static boolean[] soe(int n) {
        
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int p = 2; p*p <=n; p++) {
            if(isPrime[p] == true) {
                for(int i = p*p; i <= n; i += p)
                	isPrime[i] = false;
            }
        }
        
        return isPrime;
    }

}
