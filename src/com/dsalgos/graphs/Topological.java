package com.dsalgos.graphs;

import com.dsalgos.mst.helper.DepthFirstOrder;
import com.dsalgos.shortpath.EdgeWeightedDiGraph;
import com.dsalgos.shortpath.EdgeWeightedDirectedCycle;

public class Topological {
	
	private Iterable<Integer> order;
	private int[] rank;
	
	public Topological(DiGraph G) {
		DirectedCycle finder = new DirectedCycle(G);
		if(!finder.hasCycle()) {
			DirectedDFS dfs = new DirectedDFS(G);
			order = dfs.reversePost();
			rank = new int[G.V()];
			int i=0;
			for(Integer v : order) {
				rank[v] = i++;
			}
		}		
	}
	
	public Topological(EdgeWeightedDiGraph G) {
		EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
		if(!finder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
			rank = new int[G.V()];
			int i=0;
			for(Integer v : order) {
				rank[v] = i++;
			}
		}
	}
	
	public Iterable<Integer> order(){
		return order;
	}
	
	public boolean hasOrder() {
		return order != null;
	}
	
	public boolean isDAG() {	
		return hasOrder();
	}
	
	public int rank(int v) {
		if(hasOrder()) return rank[v];
		return -1;
	}
	
	public static void main(String[] args) {
		DiGraph graph = new DiGraph(13);
		graph.addEdge(4, 2);
		graph.addEdge(3, 2);
		graph.addEdge(6, 0);
		graph.addEdge(0, 1);
		graph.addEdge(2, 0);
		graph.addEdge(11, 12);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(7, 9);
		graph.addEdge(10, 12);
		graph.addEdge(11, 4);
		graph.addEdge(4, 3);
		graph.addEdge(3, 5);
		graph.addEdge(6, 8);
		graph.addEdge(0, 5);
		graph.addEdge(6, 4);
		graph.addEdge(6, 9);
		graph.addEdge(7, 6);
		Topological top = new Topological(graph);
		for(Integer e : top.order()) {
			System.out.println(e);
			System.out.println("Rank: " + top.rank(e));
		}
		
		
		
	}

}
