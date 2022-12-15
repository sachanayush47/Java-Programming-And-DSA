package trie;

public class ImplementTrieII {

	private static TrieNode root;
	
	public static void main(String[] args) {

		root = new TrieNode();
		
	}
	
	public static void insert(String s) {
		TrieNode node = root;
		for(int i = 0; i < s.length(); ++i) {
			if(!node.containsKey(s.charAt(i))) {
				node.put(s.charAt(i), new TrieNode());
			}
			
			node = node.get(s.charAt(i));
			node.increasePrefix();
		}
		
		node.increaseEnd();
	}
	
	public static int countWordsEqualTo(String s) {
		TrieNode node = root;
		for(int i = 0; i < s.length(); ++i) {
			if(!node.containsKey(s.charAt(i))) return 0;
			
			node = node.get(s.charAt(i));
		}
		
		return node.getEnd();
	}
	
	public static int countWordsStartsingWith(String prefix) {
		TrieNode node = root;
		for(int i = 0; i < prefix.length(); ++i) {
			if(!node.containsKey(prefix.charAt(i))) return 0;
			
			node = node.get(prefix.charAt(i));
		}
		
		return node.getPrefix();
	}
	
	public static void erase(String s) {
	// We are assuming this word exist, since it has been asked to erase.
		
		TrieNode node = root;
		for(int i = 0; i < s.length(); ++i) {
			if(node.containsKey(s.charAt(i))) {
				node = node.get(s.charAt(i));
				node.reducePrefix();
			} else return;		// Means word does not exist.
		}
		
		node.deleteEnd();
	}

}

class TrieNode {
	
	TrieNode links[] = new TrieNode[26];
	int cntPrefix = 0;
	int cntEndWith = 0;
	
	TrieNode() {
		
	}
	
	boolean containsKey(char ch) {
		return (links[ch - 'a'] != null);
	}
	
	TrieNode get(char ch) {
		return links[ch - 'a'];
	}
	
	void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}
	
	void increaseEnd() {
		++cntEndWith;
	}
	
	void increasePrefix() {
		++cntPrefix;
	}
	
	void deleteEnd() {
		--cntEndWith;
	}
	
	void reducePrefix() {
		--cntPrefix;
	}
	
	int getEnd() {
		return cntEndWith;
	}
	
	int getPrefix() {
		return cntPrefix;
	}
	
}