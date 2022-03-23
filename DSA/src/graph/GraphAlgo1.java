package graph;

import java.util.*;

public class GraphAlgo1 {

	public static void main(String[] args) {
		System.out.println(detectCycleInGraphBFS(11, createAdjList()));
	}

	/* ------------------------------------------------------------------ */
	
	// Directed
	public static boolean Dir_detectCycleInGraphDFS(int V, ArrayList<ArrayList<Integer>> adj) {
		
		boolean visited[] = new boolean[V + 1];
		boolean dfsVisited[] = new boolean[V + 1];
		
		for(int i = 1; i <= V; ++i) {
			if(visited[i] == false) {
				if(Dir_detectCycleInGraphDFSHelper(i, adj, visited, dfsVisited)) return true;
			}
		}
		
		return false;
	}
	
	public static boolean Dir_detectCycleInGraphDFSHelper(
			int i, ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean dfsVisited[]) {
		
		dfsVisited[i] = true;
		visited[i] = true;
		
		for(int it : adj.get(i)) {
			if(visited[it] == false) {
				if(Dir_detectCycleInGraphDFSHelper(it, adj, visited, dfsVisited)) return true;
			} else if(dfsVisited[it] == true) return true; 
		}
		
		dfsVisited[i] = false;
		return false;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static boolean checkBipartiteDFS(int V, ArrayList<ArrayList<Integer>> adj) {
	// I did this on my own. Instead of using recursive DFS, I used iterative DFS.
	
		int colors[] = new int[V + 1];
		
		for(int i = 1; i <= V; ++i) {
			if(colors[i] == 0) {
				
				Stack<Integer> s = new Stack<>();
				s.push(i);
				colors[i] = 1;
				
				while(!s.isEmpty()) {
					int node = s.pop();
					int nodeColor = colors[node];
					
					for(int it : adj.get(node)) {
						if(colors[it] == 0) {
							s.push(it);
							colors[it] = nodeColor == 1 ? -1 : 1;
						} else if(colors[it] == nodeColor) return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static boolean checkBipartiteBFS(int V, ArrayList<ArrayList<Integer>> adj) {
	// I coded this on my own.
		
		// -1 and +1 Colored, 0 not colored yet.
		int colors[] = new int[V + 1];
		
		for(int i = 1; i <= V; ++i) {
			if(colors[i] == 0) {
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				colors[i] = 1;
			
				while(!q.isEmpty()) {
					int node = q.poll();
					int nodeColor = colors[node];
					
					for(int it : adj.get(node)) {
						if(colors[it] == 0) {
							q.offer(it);
							colors[it] = nodeColor == 1 ? -1 : 1;
						} else if(colors[it] == nodeColor) return false;
					}
				}
			}
		}
		
		return true;
	}

	/* ------------------------------------------------------------------ */
	// Undirected
	public static boolean detectCycleInGraphDFS(int V, ArrayList<ArrayList<Integer>> adj) {
	// I did this on my own. Instead of using recursive DFS, I used iterative DFS.
		boolean visited[] = new boolean[V + 1];

		for(int i = 1; i <= V; ++i) {
			if(visited[i] == false) {
				Stack<Pair> s = new Stack<>();
				s.push(new Pair(i, -1));
				visited[i] = true;

				while(!s.isEmpty()) {

					Pair p = s.pop();
					int node = p.num1;
					int parent = p.num2;

					for(Integer it : adj.get(node)) {
						if(visited[it] == false) {
							s.push(new Pair(it, node));
							visited[it] = true;
						} else if(it != parent) {
							return true;
						}
					}
				}
			}

		}
		
		return false;
	}

	/* ------------------------------------------------------------------ */

	public static boolean detectCycleInGraphBFS(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean visited[] = new boolean[V + 1];

		for(int i = 1; i <= V; ++i) {
			if(visited[i] == false) {
				// Pair = Node, Parent
				Queue<Pair> q = new LinkedList<>();
				q.offer(new Pair(i, -1));
				visited[i] = true;

				while(!q.isEmpty()) {

					Pair p = q.poll();
					int node = p.num1;
					int parent = p.num2;

					for(Integer it : adj.get(node)) {
						if(visited[it] == false) {
							q.offer(new Pair(it, node));
							visited[it] = true;
						} else if(it != parent)
							return true;
					}
				}
			}
		}

		return false;
	}

	/* ------------------------------------------------------------------ */

	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		ArrayList<Integer> dfs = new ArrayList<>();
		boolean visited[] = new boolean[V + 1];

		for(int i = 1; i <= V; ++i) {
			if(visited[i] == false)
				dfsOfGraphHelper(i, adj, dfs, visited);
		}

		return dfs;
	}

	public static void dfsOfGraphHelper(int V, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs,
			boolean visited[]) {

		dfs.add(V);
		visited[V] = true;

		for(Integer i : adj.get(V)) {
			if(visited[i] == false) {
				dfsOfGraphHelper(i, adj, dfs, visited);
			}
		}
	}

	/* ------------------------------------------------------------------ */

	public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		ArrayList<Integer> bfs = new ArrayList<>();

		// V + 1, if indexing of graph starts from 1.
		// V, if indexing of graph starts from 0.
		boolean visited[] = new boolean[V + 1];

		// i = 1 & i <= V, if indexing of graph starts from 1.
		// i = 0 & i < V, if indexing of graph starts from 0.
		for(int i = 1; i <= V; ++i) {
			if(visited[i] == false) {
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				visited[i] = true;

				while(!q.isEmpty()) {
					Integer node = q.poll();
					bfs.add(node);

					for(Integer it : adj.get(node)) {
						if(visited[it] == false) {
							q.offer(it);
							visited[it] = true;
						}
					}
				}
			}
		}

		return bfs;
	}

	/*
	 * ------------------------Helper methods for self help------------------------
	 */

	public static ArrayList<ArrayList<Integer>> createAdjList() {
		// If indexing of graph starts from 1.

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for(int i = 0; i <= V; ++i)
			adj.add(new ArrayList<>());

		int n = 1;
		while (n <= V) {
			int num = sc.nextInt();
			if(num == -1)
				++n;
			else
				adj.get(n).add(num);
		}
		sc.close();
		System.out.println(adj);
		return adj;
	}

	public static void inputGraph() {

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		// i < V, if indexing of graph starts from 0.
		// i <= V, if indexing of graph starts from 1.
		for(int i = 0; i < V; ++i)
			adj.add(new ArrayList<>());

		// i = 1 & i <= V, if indexing of graph starts from 1.
		// i = 0 & i < V, if indexing of graph starts from 1.
		for(int i = 0; i < V; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj.get(u).add(v);

			// Comment this line, if directed graph. Keep this line if undirected graph.
			adj.get(v).add(u);
		}

		sc.close();
		System.out.println(bfsOfGraph(V, adj));

	}

}

class Pair {
	int num1;
	int num2;

	public Pair(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
}
