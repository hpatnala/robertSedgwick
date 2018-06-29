package com.dsalgos.mst;

import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedGraph {
	Bag<Edge>[] adj;
	int V;
	int E;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V) {
		this.V = V;
		adj = (Bag<Edge>[]) new Bag[V];
		for(int i=0;i<V;i++) {
			adj[i] = new Bag<Edge>();
		}	
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(Edge e) {		
		int v = e.either();
		int w = e.other(v);
		validateVertex(v);
		validateVertex(w);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	public Iterable<Edge> adj(int v){
		validateVertex(v);
		return adj[v];
	}
	
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> list = new Bag<Edge>();
		for(int v=0;v<V;v++) {
			int selfLoop = 0;
			for(Edge e : adj(v)) {
				if(e.other(v) > v) {
					list.add(e);
				}
				else if(e.other(v) == v) {
					if(selfLoop % 2 == 0) list.add(e);
					selfLoop++;
				}
			}
		}
		return list;
	}

	public void validateVertex(int u) {
		if(u<0 || u >= V) throw new IllegalArgumentException();
	}
}
