package com.dsalgos.graphs;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
	
	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] onStack;
	private Stack<Integer> cycle;
	
	
	public DirectedCycle(DiGraph g) {
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		onStack = new boolean[g.V()];
		for(int v=0;v<g.V();v++) {
			if(!marked[v] && cycle == null) dfs(g, v);
		}
	}
	
	private void dfs(DiGraph g, int v) {
		onStack[v] = true;
		marked[v] = true;
		for(int w : g.adj(v)) { //v= 3 // w = 5
			if(cycle != null) return;
			
			if(!marked[w]) {				
				edgeTo[w] = v;
				dfs(g, w);
			}
			
			else if(onStack[w]) {
				cycle = new Stack<Integer>();
				for(Integer x=v;x!=w;x=edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);			
			}
		}
		onStack[v] = false;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}

	public static void main(String[] args) {
		DiGraph graph = new DiGraph(13);
		graph.addEdge(4, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(6, 0);
		graph.addEdge(0, 1);
		graph.addEdge(2, 0);
		graph.addEdge(11, 12);
		graph.addEdge(12, 9);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(7, 9);
		graph.addEdge(10, 12);
		graph.addEdge(11, 4);
		graph.addEdge(4, 3);
		graph.addEdge(3, 5);
		graph.addEdge(6, 8);
		graph.addEdge(8, 6);
		graph.addEdge(5, 4);
		graph.addEdge(0, 5);
		graph.addEdge(6, 4);
		graph.addEdge(6, 9);
		graph.addEdge(7, 6);
			
		DirectedCycle finder = new DirectedCycle(graph);
		if(finder.hasCycle()) {
			System.out.println("Directed Cycle: ");
			for(Integer v :finder.cycle()) {
				System.out.print(v +" ");
			}
		}
	}

}
