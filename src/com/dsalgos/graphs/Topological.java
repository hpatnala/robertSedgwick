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

	}

}
