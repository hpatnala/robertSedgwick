package com.algos.geeks.graphs;

import com.dsalgos.graphs.Graph;

public class BridgesInGraph {	
	int time;

	public void findBridges(Graph G) {
		boolean ap[] = new boolean[G.numberOfVertices()];
		int low[] = new int[G.numberOfVertices()];
		int disc[] = new int[G.numberOfVertices()];
		boolean visited[] = new boolean[G.numberOfVertices()];
		int parent[] = new int[G.numberOfVertices()];
		
		for(int i=0;i<G.numberOfVertices();i++) {
			visited[i] = false;
			parent[i] = -1;
			ap[i] = false;
		}
			
		for(int i=0;i<G.numberOfVertices();i++) {
			if(!visited[i])		bridges(G, i, visited, low, disc, ap, parent);
		}
		
		for(int i=0;i<G.numberOfVertices();i++) {
			if(ap[i])	System.out.println(i);
		}
	}
	
	private void bridges(Graph G, int u, boolean[] visited, int[] low, int[] disc, boolean[] ap, int[] parent) {
		int children=0;
		visited[u] = true;
		disc[u] = low[u] = ++time;
		
		for(Integer v : G.adj(u)) {		
			if(!visited[v]) {
				children++;
				parent[v] = u;
				bridges(G, v, visited, low, disc, ap, parent);
				low[u] = Math.min(low[v], low[u]);		
				if(parent[u] == -1 && low[v] > disc[u]) {
					System.out.println(u + "->" + v);
					ap[u] = true;
				}
				System.out.println(children);
				if(parent[u] == -1 && children > 1) {
					System.out.println(u + "c->" + v);
					ap[u] = true;
				}
			}
			else if(v != parent[u]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Articulation points in first graph ");
		BridgesInGraph  bridgesInGraph = new BridgesInGraph();
		Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        bridgesInGraph.findBridges(g1);
        System.out.println();
 
        System.out.println("Articulation points in Second graph");
        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        bridgesInGraph.findBridges(g2);
        System.out.println();
 
        System.out.println("Articulation points in Third graph ");
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        bridgesInGraph.findBridges(g3);
	}

}
