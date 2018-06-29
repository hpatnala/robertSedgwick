package com.dsalgos.shortpath;

import com.dsalgos.mst.helper.IndexMinPQ;

import edu.princeton.cs.algs4.Stack;

public class DijkstraAlgo {
	
	private double[] distTo;
	private boolean[] marked;
	private DirectedEdge[] edgeTo;
	private IndexMinPQ<Double> pq;
	private int V;
	private int E;
		
	public DijkstraAlgo(EdgeWeightedDiGraph G, int s) {
		this.V = G.V();
		marked = new boolean[V];
		distTo = new double[V];
		edgeTo = new DirectedEdge[V];
		for(int i=0; i<G.V();i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0;
		pq = new IndexMinPQ<Double>(8);
		pq.insert(s, distTo[s]);
		while(!pq.isEmpty()) {
			int v = pq.delMin();
			for(DirectedEdge w : G.adj(v)) {
				relax(w);
			}
		}
	}
	
	private void relax(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		if(distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}
		if(pq.contains(w))  pq.decreaseKey(w, distTo[w]);
		else pq.insert(w, distTo[w]);
	}

	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public double distTo(int v) {
		return distTo[v];
	}
	
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		validateVertex(v);
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}
	
	private void validateVertex(int v) {
		if(v < 0 || v>= V) throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		
	}

}
