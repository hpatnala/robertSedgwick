package com.dsalgos.mst;

import com.dsalgos.mst.helper.MinPriorityQueue;
import com.dsalgos.mst.helper.UnionFind;
import edu.princeton.cs.algs4.Queue;

public class KruskalMST {
	
	private double weight;
	private Queue<Edge> mst = new Queue<Edge>();
	
	public KruskalMST(EdgeWeightedGraph G) {
		MinPriorityQueue<Edge> pq = new MinPriorityQueue<Edge>(G.V());
		for(Edge e : G.edges())	pq.insert(e);
		UnionFind uf = new UnionFind(G.V());
		while(!pq.isEmpty() && mst.size() < G.V() -1 ) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(!uf.connected(v, w)) {
				uf.union(v, w);
				mst.enqueue(e);
				weight += e.weight();
			}
		}
	}
	
	public double weight() {
		return weight;
	}
	
	public static void main(String[] args) {
		
	}

}
