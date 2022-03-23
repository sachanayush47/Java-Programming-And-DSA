package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphAlgo3 {

	public static void main(String[] args) {

	}
	
	// This is an efficent solution.			// Pair = Node - Weight
	public static int[] primsAlgo2(int N, ArrayList<ArrayList<Pair>> adj) {
		
		// Graph follows 0 based indexing.
		
		int parent[] = new int[N];
		boolean mstSet[] = new boolean[N];
		int key[] = new int[N];
		
		for(int i = 0; i < N; ++i) {
			parent[i] = -1;
			mstSet[i] = false;
			key[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.num2 - o2.num2);
		
		key[0] = 0;
		pq.offer(new Pair(0, key[0]));
		
		for(int i = 0; i < N-1; ++i) {
			int u = pq.poll().num1;
			mstSet[u] = true;
			
			for(Pair it : adj.get(u)) {
				if(mstSet[it.num1] == false && it.num2 < key[it.num1]) {
					parent[it.num1] = u;
					key[it.num1] = it.num2;
					pq.offer(new Pair(it.num1, key[it.num1]));
				}
			}
		}
		
		return parent;
	}
	
	// This is an brute force solution.			// Pair = Node - Weight
	public static int[] primsAlgo1(int N, ArrayList<ArrayList<Pair>> adj) {
		
		// Graph follows 0 based indexing.
		
		int parent[] = new int[N];
		boolean mstSet[] = new boolean[N];
		int key[] = new int[N];
		
		for(int i = 0; i < N; ++i) {
			parent[i] = -1;
			mstSet[i] = false;
			key[i] = Integer.MAX_VALUE;
		}
		
		key[0] = 0;
		
		for(int i = 0; i < N-1; ++i) {
			
			int mini = Integer.MAX_VALUE;
			int u = 0;
			
			for(int v = 0; i < N; ++v) {
				if(mstSet[v] == false && key[v] < mini) {
					mini = key[v];
					u = v;
				}
			}
			
			mstSet[u] = true;
			
			for(Pair it : adj.get(u)) {
				if(mstSet[it.num1] == false && it.num2 < key[it.num1]) {
					parent[it.num1] = u;
					key[it.num1] = it.num2;
				}
			}
		}
		
		return parent;
	}

}
