package graph;

public class DisjointSet {

	static int parent[] = new int[(int)1e5];
	static int rank[] = new int[(int)1e5];
	
	public static void main(String[] args) {
		makeSet();
	}

	public static void makeSet() {
		for(int i = 1; i <= parent.length; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	public static int findParent(int node) {
		if(parent[node] == node) return node;
		
		// Path compression is also performed here as well.
		return parent[node] = findParent(parent[node]);
	}
	
	public static void union(int u, int v) {
		u = findParent(u);
		v = findParent(v);
		
		if(rank[u] < rank[v]) parent[u] = v;
		else if(rank[u] > rank[v]) parent[v] = u;
		else {
			parent[v] = u;
			++rank[u];
		}
	}
	
}
