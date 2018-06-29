package com.dsalgos.graphs;

import edu.princeton.cs.algs4.Bag;

public class DiGraph {
	
	private int V;
	private int E;
	private Bag<Integer>[] bags;
	private int[] indegree;
	
	@SuppressWarnings("unchecked")
	public DiGraph(int V) {
		this.V = V;
		bags = (Bag<Integer>[]) new Bag[V];
		indegree = new int[V];
		for(int i=0;i<V;i++) {
			bags[i] = new Bag<Integer>();
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	public void addEdge(int u, int v) {
		validateVertex(u);
		validateVertex(v);	
		bags[u].add(v);
		indegree[v]++;
		E++;
	}
	
	private void validateVertex(int v) {
		if(v < 0 || v >=V) {
			throw new IllegalArgumentException();
		}
	}
	
	public Iterable<Integer> adj(int u) {
		validateVertex(u);
		return bags[u];
	}
	
	public int outdegree(int u) {
		validateVertex(u);
		return bags[u].size();
	}
	
	public int indegree(int u) {
		validateVertex(u);
		return indegree[u];
	}
	
	public DiGraph reverse(DiGraph G) {
		DiGraph reverse = new DiGraph(G.V());
		return reverse;
	}
	
	public void printGraph(DiGraph DG) {
		for(int i=0;i<V;i++) {
			for(Integer u : bags[i]) {
				System.out.println(i +" -> "+ u);
			}
		}
	}
	
	public int maxDegree() {
		int max = 0;
		for(int i=0;i<V;i++) {
			max = Math.max(max, bags[i].size());
		}
		return max;
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
		System.out.println("Max degree: " + graph.maxDegree());
		graph.printGraph(graph);
	}

}
