package com.dsalgos.shortpath;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BellmanFordSP {
	
	private Queue<Integer> queue;
	private boolean[] onQueue;
	private int cost;
	private Iterable<DirectedEdge> cycle;
	private double[] distTo;
	private DirectedEdge[] edgeTo; 
	
	public BellmanFordSP(EdgeWeightedDiGraph G, int s) {
		queue = new Queue<Integer>();
		onQueue = new boolean[G.V()];
		distTo = new double[G.V()];
		edgeTo = (DirectedEdge[]) new Object[G.V()];
		for(int i=0;i<G.V();i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}	
		
		distTo[s] = 0;
		queue.enqueue(s);
		onQueue[s] = true;
		while(!queue.isEmpty() && !hasNegativeCycle()) {
			int w = queue.dequeue();
			onQueue[w] = false;
			relax(G, w);
		}
	}
	
	private void relax(EdgeWeightedDiGraph G, int v) {
		for(DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
			
			if(!onQueue[w]) {
				queue.enqueue(w);
				onQueue[w] = true;
			}
			
			if(cost++ % G.V() == 0) {
				findNegativeCycle();
				if(hasNegativeCycle()) return;
			}
		}
	}

	private void findNegativeCycle() {
		int V = distTo.length;
		EdgeWeightedDiGraph spt = new EdgeWeightedDiGraph(V);
		for(int v=0;v< V;v++) {
			if(edgeTo[v] != null) {
				spt.addEdge(edgeTo[v]);
			}
		}
		EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
		cycle = finder.cycle();
	}

	public boolean hasNegativeCycle() {
		return cycle != null;
	}
	
	public Iterable<DirectedEdge> negativeCycle(){
		return cycle;
	}
	
	public double distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}

	private void validateVertex(int v) {
		if(v < 0 || v > distTo.length) {
			throw new IllegalArgumentException();
		}
	}
	
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		validateVertex(v);
		if(hasNegativeCycle()) {
			throw new IllegalArgumentException("Negative cost cycle exists");
		}
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e=edgeTo[v];e != null ;e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}
	

	public static void main(String[] args) {
		
	}

}
