package com.dsalgos.mst;

import com.dsalgos.mst.helper.MinPriorityQueue;

import edu.princeton.cs.algs4.Queue;

public class LazyPrimsAlgorithm {
	
	private boolean[] marked;
	private Queue<Edge> mst = new Queue<Edge>();
	private MinPriorityQueue<Edge> pq ;
	
	public LazyPrimsAlgorithm(EdgeWeightedGraph G) {
		pq = new MinPriorityQueue<>(G.V());
		marked = new boolean[G.V()];
		for(Edge e : G.edges()) {
			pq.insert(e);
		}
		visit(G, 0);
		while(!pq.isEmpty() && mst.size() < G.V()-1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w]) continue;
			mst.enqueue(e);
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
	}
		
	private void visit(EdgeWeightedGraph G, int u) {	
		marked[u] = true;
		for(Edge e : G.adj(u)) {
			if(!marked[e.other(u)])	pq.insert(e);
		}
	}
	
	public Iterable<Edge> mst(){
		return mst;
	}

	public static void main(String[] args) {

	}

}
