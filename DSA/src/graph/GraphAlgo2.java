package graph;

import java.util.*;

public class GraphAlgo2 {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
	// Shortest path in undirected graph with weighted edges: Dijkstra's algorithm
	
														// Pair = Node - Weight(Distance)
	public static int[] dijkstraAlgorithm(int V, ArrayList<ArrayList<Pair>> adj, int src) {
		
		// Pair = Distance - Node,		Minimum distance pops out first.
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.num1 - o2.num1);
		
		int dist[] = new int[V + 1];
		
		for(int i = 0; i <= V; ++i) dist[i] = Integer.MAX_VALUE;
		
		dist[src] = 0;
		pq.offer(new Pair(0, src));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int d = p.num1;
			int n = p.num2;
			
			for(Pair it : adj.get(n)) {
				if(dist[it.num1] > it.num2 + d) {
					pq.offer(new Pair(it.num2 + d, it.num1));
				}
			}
 		}
		
		return dist;
	}
	
	/* ------------------------------------------------------------------ */
	
	// Shortest path in directed graph in with weighted edges.
	
	public static int[] shortestPath2(int V, ArrayList<ArrayList<Pair>> adj, int src) {
	// Pair = Value, weight.
		
		Stack<Integer> s = new Stack<>();
		boolean visited[] = new boolean[V + 1];
		for(int i = 1; i <= V; ++i) {
			if(!visited[i]) topologicalSortUtil(i, adj, visited, s);;
		}
		
		int dist[] = new int[V + 1];
		for(int i = 0; i < V; ++i) dist[i] = Integer.MAX_VALUE;
		
		dist[src] = 0;
		
		while(!s.isEmpty()) {
			int node = s.pop();
			
			if(dist[node] != Integer.MAX_VALUE) {
				for(Pair it : adj.get(node)) {
					if(dist[node] + it.num2 < dist[it.num1]) 
						dist[it.num1] = dist[node] + it.num2;
				}
			}
		}
		
		return dist;
	}
	
	public static void topologicalSortUtil(
			int i, ArrayList<ArrayList<Pair>> adj, boolean visited[], Stack<Integer> s) {
		
		visited[i] = true;
		
		for(Pair it : adj.get(i)) {
			if(!visited[it.num1]) topologicalSortUtil(it.num1, adj, visited, s);
		}
		
		s.push(i);
	}
	
	/* ------------------------------------------------------------------ */
	
	// Shortest path in undirected graph with unit weights.
	public static int[] shortestPath1(int V, ArrayList<ArrayList<Integer>> adj, int src) {
		
		int dist[] = new int[V + 1];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i <= V; ++i) dist[i] = Integer.MAX_VALUE;
		
		q.offer(src);
		dist[src] = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int it : adj.get(node)) {
				if(dist[node] + 1 <  dist[it]) {
					dist[it] = dist[node] + 1;
					q.offer(it);
				}
			}
		}
		
		return dist;
	}
	
	/* ------------------------------------------------------------------ */
	
	// Detect cycle in a directed graph using BFS(lecture 14). Samajh nhi aaya.
	
	/* ------------------------------------------------------------------ */
	
	public static int[] topologicalSortBFS(int V, ArrayList<ArrayList<Integer>> adj) {
	// Kahn's Algorithm	
		int res[] = new int[V];
		int indegree[] = new int[V + 1];
		
		// To find indegree of each node.
		for(int i = 1; i <= V; ++i) {
			for(int it : adj.get(i)) {
				++indegree[it];
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= V; ++i) {
			if(indegree[i] == 0) q.offer(i);
		}
		
		int ind = 0;
		while(!q.isEmpty()) {
			int node = q.poll();
			res[ind++] = node;
			
			for(int it : adj.get(node)) {
				--indegree[it];
				if(indegree[it] == 0) q.offer(it);
			}
		}
		
		return res;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int[] topologicalSortDFS(int V, ArrayList<ArrayList<Integer>> adj) {
		
		Stack<Integer> s = new Stack<>();
		boolean visited[] = new boolean[V + 1];
		int res[] = new int[V];
		
		for(int i = 1; i <= V; ++i) {
			if(visited[i] == false) {
				topologicalSortDFSHelper(i, adj, visited, s);
			}
		}
		
		int i = 0;
		while(!s.isEmpty()) {
			res[i++] = s.pop();
		}
		
		return res;
	}
	
	public static void topologicalSortDFSHelper(
			int i, ArrayList<ArrayList<Integer>> adj, boolean visited[], Stack<Integer> s) {
		
		visited[i] = true;
		
		for(int it : adj.get(i)) {
			if(visited[it] == false) topologicalSortDFSHelper(it, adj, visited, s);
		}
		
		s.push(i);
	}

}
