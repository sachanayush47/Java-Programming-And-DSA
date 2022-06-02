package experiment;

import java.util.*;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {
		
//		int arr[] = {1,2,3,8,9,6,0,4};
//		System.out.println(getIndex(arr, 8, arr.length-1));
		
//		Scanner sc = new Scanner(System.in);
//		
//		char c[] = sc.nextLine().replaceAll(" ", "").toCharArray();
//		char cd[] = sc.nextLine().replaceAll(" ", "").toCharArray();
//		System.out.println(Arrays.toString(c));
		
//		String res = "1+2+3";
//		String arr[] = res.split("\\+");
//		
//		System.out.println(Arrays.toString(arr));
		
//		String s[] = new String[3];
//		s[0] = "1";
//		s[1] = "2";
//		s[2] = "3";
//		System.out.println(Arrays.toString(s));
//		System.out.println(s[1] == "2");
		
//		int i = 1;
//		if(++i == 2) {
//			System.out.println(i);
//		}
		
//		List<Integer> ll = new LinkedList<>();
//		ll.add(10);
//		
//		System.out.println(ll.remove(0));
		
//		int arr[] = {Integer.MIN_VALUE};
//		
//		++arr[0];
//		
//		System.out.println(arr[0]);
		
	//	int num = Integer.MAX_VALUE;
	//	System.out.println(num);
		
//		String s = "Ayush";
//		
//		System.out.println(s + s.charAt(2));
//		
//		int n = 4;
//		
//		Math.pow(2, n/2);
//		
//		HashMap<Integer, Integer> v = new HashMap<>();
//		
//		v.putIfAbsent(null, null);
		
		// arrayGenerator();
//		System.err.println(-13 >> 2);
	//	System.out.println((int)(1e9 + 7));
		
		
//		int x = -100;
//		System.out.println(String.valueOf(x));
//		String s = "11111111111111111111111111110101";
//		System.out.println(s.length());
		
		
//		int num = 21;
//		System.out.println(Integer.toBinaryString(num));
//		num = num & (~(1 << (5 - 1)));
//		System.out.println(Integer.toBinaryString(num));
		
//		boolean arr[] = new boolean[2];
//		System.out.println(arr[0]);
		
//		Integer arr[][] = new Integer[5][5];
//		System.out.println(arr[0][0] != null);
//		
//		List<Character> a = new ArrayList<>();
//		a.add('g');
//		a.add('c');
//		
//		System.out.println();
//		int x = '3';
//		
//		System.out.println(x);
//		
//		long now = System.currentTimeMillis();
//	//  slow();
//		for(int i = 0; i < 100000000; ++i) {
//        	
//        }
//        System.out.println("slow elapsed " + (System.currentTimeMillis() - now) + " ms");
//        
//
//        now = System.currentTimeMillis();
//    //  fast();
//        int i = 0;
//        int j = 100000000;
//        while(i <= j) {
//        	++i;
//        	--j;
//        }
//        System.out.println("fast elapsed " + (System.currentTimeMillis() - now) + " ms");
        
//		System.out.println(Math.max(1, 3));
        
//		decToBinary(123);
		
//		subsetsWithDup(new int[] {1, 2, 2});
		
//		Map<Integer, Integer> map = new HashMap<>();
//		map.getOrDefault(2, null);
//		map.containsKey(5);
		
//		findSubsets(null, null, null, 0);
		
//		System.out.println('5' + '5');
		
//		String i = "Ayush";
//		func(i);
//		System.out.println(i);
		System.out.println();
		System.out.println("\tSorted array:");
		System.out.println("\t" + Arrays.toString(new int[] {1, 5, 7, 8, 9, 10}));
	}
	
	public static void func(String i) {
		i = i.substring(2);
	}
	
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        subsetsWithDupHelper(nums.length - 1, temp, res, nums);
//        System.out.println(res);
//        findSubsets(res, nums, temp, 0);
        return res;
    }
	
    public static void subsetsWithDupHelper(int i, List<Integer> temp, List<List<Integer>> res, int[] nums) {
        
        if(i < 0) {
        	System.out.println(temp);
        	res.add(temp);
            return;
        }
        
        subsetsWithDupHelper(i - 1, temp, res, nums);
        temp.add(nums[i]);
        int size = temp.size() - 1;
        subsetsWithDupHelper(i - 1, temp, res, nums);
        temp.remove(size);
    }
    
    public static void findSubsets(List<List<Integer>> subset, int nums[], ArrayList<Integer> output, int index)
    {
      // Base Condition
        if (index == nums.length) {
        	System.out.println(output);
            subset.add(output);
            return;
        }
       
        // Not Including Value which is at Index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
 
        // Including Value which is at Index
        output.add(nums[index]);
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }
	
	
    public static void nextPermutation(int[] nums) {
        
        int l = nums.length;
        int i;
        for(i = l - 2; i >= 0; --i) {
            if(nums[i] < nums[i + 1]) break;
        }
        
        for(int j = l - 1; j >= 0; --j) {
            if(nums[j] > nums[i]) {
                swap(i, j, nums);
                break;
            }
        }
        
        ++i;
        --l;
        while(i < l) {
            swap(i, l, nums);
        }
        }
        
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	
	public static void bfs(ArrayList<ArrayList<Integer>> adj, int V, int src) {
		int color[] = new int[V + 1]; 	// 0 = Unvisited,	1 = Visited
		int d[] = new int[V + 1];
		
		for(int i = 1; i <= V; ++i) d[i] = Integer.MAX_VALUE;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		color[src] = 1;
		d[src] = 0;
		
		while(q.isEmpty() == false) {
			int node = q.poll();

			for(int it : adj.get(node)) {
				if(color[it] == 0) {
					q.offer(it);
					color[it] = 1;
					d[it] = d[node] + 1;
				}
			}
		}
		
	}
	
    static void decToBinary(int n) {
        // array to store binary number
        int[] binaryNum = new int[32];
 
        // counter for binary array
        int i = 0;
        while (n > 0) {
            // storing remainder in binary array
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
 
        // printing binary array in reverse order
        for (int j = i - 1; j >= 0; j--)
            System.out.print(binaryNum[j]);
    }
	
	class Pair<E, F> {
		E obj1;
		F obj2;
		
		Pair(E obj1, F obj2) {
			this.obj1 = obj1;
			this.obj2 = obj2;
		}
	}
	
	private static String fast() {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<100000;i++) s.append("*");
        return s.toString();
    }

    private static String slow() {
        String s = "";
        for(int i=0;i<100000;i++) s+="*";
        return s;
    }
	
	public static void arrayGenerator() {
		
		String s = "[[1,2,5], [3 ,1 ,1] ,[3,3,3] ]";
		
		char c[] = s.toCharArray();
		
		for(int i = 0; i < c.length; ++i) {
			
			if(c[i] == '[') c[i] = '{';
			else if(c[i] == ']') c[i] = '}';
			
		}
		
		System.out.println(new String(c));
		
	}
	
	
//	public static int getIndex(int arr[], int num, int index) {
//		
//		if(num == arr[index]) return index;
//		if(index == 0) return -1;
//		
//		return getIndex(arr, num, --index);
//		
//	}
//	
//	public static void T(boolean arr[], int num) {
//		
//		if(num == 0) {
//			arr[0] = true;
//			return;
//		}
//		
//		T(arr, --num);
//		System.out.println(arr[0]);
//	}
	
	


}

class S {
	static boolean isCorrect = false;
	static void helloJi() {
		System.out.println("Namaste");
	}
}


