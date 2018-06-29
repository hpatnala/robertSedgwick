package com.dsalgos.graphs;

import edu.princeton.cs.algs4.Bag;

public class Graph {
	private int V;
	private int E;
	Bag<Integer>[] bags;
	
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		bags = (Bag<Integer>[]) new Bag[V];
		for(int i=0;i< bags.length;i++) {
			bags[i] = new Bag<Integer>();
		}
	}
	
	public int numberOfVertices() {
		return V;
	}
	
	public int numberOfEdges() {
		return E;
	}
	
	
	public void addEdge(int u, int v) {
		validateVertex(u);
		validateVertex(v);
		E++;
		bags[u].add(v);
		bags[v].add(u);
	}
	
	private void validateVertex(int u) {
		if(u<0 || u >=V) {
			throw new IllegalArgumentException();
		}	
	}
	
	
	//no of edges for each vertex
	private int degree(int u) {
		validateVertex(u);
		return bags[u].size();
	}
	
	public Iterable<Integer> adj(int u){
		validateVertex(u);
		return bags[u];
	}
	
	private int maxDegree() {
		int max = 0;
		for(int i=0; i< bags.length-1;i++) {
			max = Math.max(bags[i].size(), bags[i+1].size());
		}
		return max;
	}

	public void printGraph(Graph graph) {
		System.out.println("No. of vertices: " + numberOfVertices()  + "\nNo. of edges: " + numberOfEdges());
		for(int i=1;i<graph.bags.length;i++) {
			System.out.println("Degree of " + i + " is " + degree(i));
			for(Integer v : bags[i]) {
				System.out.println(i + ", "+ v);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);
		System.out.println("Max degree: " + graph.maxDegree());
		graph.printGraph(graph);
	}

}
