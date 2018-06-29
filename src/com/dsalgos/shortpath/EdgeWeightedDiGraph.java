package com.dsalgos.shortpath;

import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedDiGraph {
	
	private Bag<DirectedEdge>[] adj;
	private int V;
	private int E;
	private int[] indegree;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDiGraph(int V) {
		this.V = V;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		indegree = new int[V];
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		validateVertex(v);
		validateVertex(w);
		adj[v].add(e);
		indegree[w]++;
		E++;
	}
	
	public int indegree(int v) {
		validateVertex(v);
		return indegree[v];
	}
	
	public int outdegree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	private void validateVertex(int u) {
		if(u<0 || u > adj.length) throw new IllegalArgumentException();
	}
	
	public Iterable<DirectedEdge> adj(int v){
		validateVertex(v);
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> list = new Bag<DirectedEdge>();
		for(int v=0; v < V();v++) {
			for(DirectedEdge e : adj[v]) {			
				list.add(e);
			}
		}
		return list;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V).append(", ").append(E).append("\n");
		for(int v=0;v<V();v++) {
			sb.append(V).append(" : ");
			for(DirectedEdge e : adj[v]) {
				sb.append(e + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		
	}

}
