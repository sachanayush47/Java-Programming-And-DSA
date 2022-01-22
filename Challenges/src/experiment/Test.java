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
		
		arrayGenerator();
		
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


