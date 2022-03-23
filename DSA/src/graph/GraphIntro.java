package graph;

import java.util.*;

/**
 * @author Ayush
 * A graph is a non linear DS consisting of nodes and egdes. The node are sometimes
 * also referred to as vertices and the edges are lines or arcs that connect any two nodes in the
 * graph. More formaly a grapg can be defined as:
 * 		A graph consists of a finite set of vertices (or nodes) and set of edges which
 * 		connect a pair of nodes.
 */

public class GraphIntro {

	public static void main(String[] args) {
		
		int n = 3;		// Number of nodes in a graph.
		int m = 3;		// Number of edges in a graph.
		// Method of storing a graph:
		
		// Method 1: Adjacency matrix.
		int adjMatrix[][] = new int[n+1][n+1];
		
		// 'm' lines follows -
		
		// Edge 1 -- 2
		adjMatrix[1][2] = 1;
		adjMatrix[2][1] = 1;
		
		// 2 -- 3
		adjMatrix[2][3] = 1;
		adjMatrix[3][2] = 1;

		// 1 -- 3
		adjMatrix[1][3] = 1;
		adjMatrix[3][1] = 1;

		
		// Method 2: Adjacency matrix.
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		
		// Adding 'm' ArrayList inside ArrayList.
		for(int i = 0; i < m; ++i) adjList.add(new ArrayList<>());
		
		// 'm' lines follows -
		
		// Edge 1 -- 2
		adjList.get(1).add(2);
		adjList.get(2).add(1);
		
		// 2 -- 3
		adjList.get(2).add(3);
		adjList.get(3).add(2);

		// 1 -- 3
		adjList.get(1).add(3);
		adjList.get(3).add(1);
		
		
	}

}
