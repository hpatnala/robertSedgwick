package com.dsalgos.graphs;

import java.util.Stack;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph1 {
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private final int V;	
	private int E;
	private Bag<Integer>[] adj;
	boolean isSuper = false;
	
	@SuppressWarnings("unchecked")
	public Graph1(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		if(!isSuper) {
			for(int i=0; i<V;i++) {
				adj[i] = new Bag<Integer>();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Graph1(In in) {
		this.V = in.readInt();
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i=0; i<V;i++)
			adj[i] = new Bag<Integer>();
		this.E = in.readInt();
		for(int i=0;i<E;i++) {
			int v = in.readInt();
			int w = in.readInt();
			validateVertex(v);
			validateVertex(w);
			addEdge(v, w);
		}
	}
	
	public Graph1(Graph1 G) {
		this(G.V());
		this.E = G.E();
		 
		 for(int v=0; v<G.V();v++) {
			 Stack<Integer> reverse = new Stack<Integer>();
			 for(int w : adj[v]) {
				 reverse.push(w);
			 }
			 
			 for(int w : adj[v]) {
				 adj[v].add(w);
			 }
		 }
	}
	
	private int V() {
		return V;
	}
	
	private int E() {
		return E;
	}

	private void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}

	public Iterable<Integer> adj(int v){
		validateVertex(v);
		return adj[v];
	}

	private void validateVertex(int v) {
		if(v < 0 || v >=V) {
			throw new IllegalArgumentException();
		}
	}
	
	 public String toString() {
	    StringBuilder s = new StringBuilder();
	    s.append(V + " vertices, " + E + " edges " + NEWLINE);
	    for (int v = 0; v < V; v++) {
	       s.append(v + ": ");
	       for (int w : adj[v]) {
	          s.append(w + " ");
	        }
	        s.append(NEWLINE);
	     }
	     return s.toString();
	    }
	
	public static void main(String[] args) {
		Graph1 graph = new Graph1(15);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 6);
		graph.addEdge(0, 5);
//		graph.addEdge(1, 0);
//		graph.addEdge(2, 0);
//		graph.addEdge(3, 5);
		graph.addEdge(3, 4);
//		graph.addEdge(4, 3);
//		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		graph.addEdge(5, 4);
//		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		graph.addEdge(7, 8);
//		graph.addEdge(8, 7);
//		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(9, 12);
		graph.addEdge(10, 9);
		graph.addEdge(11, 3);
		graph.addEdge(11, 12);
//		graph.addEdge(12, 11);
//		graph.addEdge(12, 9);
		graph.isSuper = true;
		Graph1 graph1 = new Graph1(graph);	
		StdOut.print(graph);
		StdOut.print(graph1);
	}
}
