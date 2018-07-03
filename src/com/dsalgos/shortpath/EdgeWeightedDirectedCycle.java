package com.dsalgos.shortpath;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

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
		// create random DAG with V vertices and E edges; then add F random edges
        int V = 8;
        int E = 16;
        int F = 4;
        EdgeWeightedDiGraph G = new EdgeWeightedDiGraph(V);
        int[] vertices = new int[V];
        for (int i = 0; i < V; i++)
            vertices[i] = i;
        StdRandom.shuffle(vertices);
        for (int i = 0; i < E; i++) {
            int v, w;
            do {
                v = StdRandom.uniform(V);
                w = StdRandom.uniform(V);
            } while (v >= w);
            double weight = StdRandom.uniform();
            G.addEdge(new DirectedEdge(v, w, weight));
        }

        // add F extra edges
        for (int i = 0; i < F; i++) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            double weight = StdRandom.uniform(0.0, 1.0);
            G.addEdge(new DirectedEdge(v, w, weight));
        }

        StdOut.println(G);

        // find a directed cycle
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Cycle: ");
            for (DirectedEdge e : finder.cycle()) {
                StdOut.print(e + " ");
            }
            StdOut.println();
        }

        // or give topologial sort
        else {
            StdOut.println("No directed cycle");
        }
    }
}
