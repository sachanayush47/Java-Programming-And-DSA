package trie;

public class ImplementTrie {

	private static Node root;
	
	public static void main(String[] args) {

		root = new Node();
		
		
	}
	
	// TC:	O(s.length)	
	public static void insert(String s) {
		Node node = root;
		
		for(int i = 0; i < s.length(); ++i) {
			if(!node.containsKey(s.charAt(i))) {
				node.put(s.charAt(i), new Node());
			}
			
			node = node.get(s.charAt(i));
		}
		
		node.setEnd();
	}

	// TC:	O(s.length)
	public static boolean search(String s) {
		Node node = root;
		
		for(int i = 0; i < s.length(); ++i) {
			if(!node.containsKey(s.charAt(i))) return false;
			node = node.get(s.charAt(i));
		}
		
		if(node.isEnd() == true) return true;
		return false;
	}
	
	// TC:	O(s.length)
	public static boolean startsWith(String prefix) {
		Node node = root;
		
		for(int i = 0; i < prefix.length(); ++i) {
			if(!node.containsKey(prefix.charAt(i))) return false;
			node = node.get(prefix.charAt(i));
		}
		
		return true;
	}
	

}

class Node {
	
	private Node links[] = new Node[26];
	private boolean flag = false;
	
	Node() {
		
	}
	
	boolean containsKey(char ch) {
		return (links[ch - 'a'] != null);
	}
	
	Node get(char ch) {
		return links[ch - 'a'];
	}
	
	void put(char ch, Node node) {
		links[ch - 'a'] = node;
	}
	
	void setEnd() {
		flag = true;
	}
	
	boolean isEnd() {
		return flag;
	}
	
}
