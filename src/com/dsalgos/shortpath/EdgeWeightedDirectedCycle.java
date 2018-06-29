package com.dsalgos.shortpath;

import edu.princeton.cs.algs4.Stack;

public class EdgeWeightedDirectedCycle {
	
	private Stack<DirectedEdge> cycle;
	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] inStack;
	
	
	public EdgeWeightedDirectedCycle(EdgeWeightedDiGraph G) {
		marked = new boolean[G.V()];
		inStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for(int v=0;v<G.V();v++) {
			dfs(G, v);
		}
	}

	private void dfs(EdgeWeightedDiGraph G, int v) {
		marked[v] = true;
		inStack[v] = true;
		for(DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(!marked[w]) {
				dfs(G, w);
				edgeTo[w] = v;
			}
			
			else if(inStack[w]) {
				cycle = new Stack<DirectedEdge>();
				int x = v;
				DirectedEdge u = e;
				while(x != w) {
					cycle.push(e);
					x = edgeTo[u.from()];
				}
			}
		}
		inStack[v] = false;
	}
	
	public Iterable<DirectedEdge> cycle(){
		return cycle;
	}

	public boolean hasCycle() {		
		return cycle == null;
	}

	public static void main(String[] args) {
		
	}
}
