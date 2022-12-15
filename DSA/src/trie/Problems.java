package trie;

public class Problems {

	private static Node root;
	
	public static void main(String[] args) {
		root = new Node();
		
		String arr[] = new String[] {"n", "ninga", "ni", "nin", "ninj", "ninja"};
		System.out.println(completeString(arr));
		
	}

	// Longest word with all prefixes.
	public static String completeString(String arr[]) {
		
		Node node = root;
		
		for(int i = 0; i < arr.length; ++i) {
			String s = arr[i];
			node = root;
			
			for(int j = 0; j < s.length(); ++j) {
				if(!node.containsKey(s.charAt(j))) {
					node.put(s.charAt(j), new Node());
				}
				
				node = node.get(s.charAt(j));
			}
			
			node.setEnd();
		}
		
		String ans = "";
		for(int i = 0; i < arr.length; ++i) {
			String s = arr[i];
			node = root;
			
			for(int j = 0; j < s.length(); ++j) {
				node = node.get(s.charAt(j));
				
				if(node.isEnd()) {
					if(ans.length() == s.substring(0, j + 1).length() && s.compareTo(ans) < 0) {
						ans = s.substring(0, j + 1);
					} else {
						ans = ans.length() < s.substring(0, j + 1).length()
								? s.substring(0, j + 1) : ans;
					}
				} else break;
			}
		}
		
		return ans;
	}
}
