package com.dsalgos.graphs;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstSearch {
	
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean marked[];
	private int edgeTo[];
	private int distTo[];
	private int s;
	
	public BreadthFirstSearch(Graph G, int s) {
		marked = new boolean[G.numberOfVertices()];
		edgeTo = new int[G.numberOfVertices()];
		distTo = new int[G.numberOfVertices()];
		this.s = s;
		bfs(G, s);
	}
		
	private void bfs(Graph G, int s) {
		Queue<Integer> que = new Queue<Integer>();
		for(int i=0;i<distTo.length;i++) {
			distTo[i] = INFINITY;
		}
		que.enqueue(s);
		distTo[s] = 0;	
		marked[s] = true;
		while(!que.isEmpty()) {
			int w = que.dequeue();
			for(Integer v : G.bags[w]) {
				if(!marked[v]) {
					que.enqueue(v);
					marked[v] = true;
					distTo[v] = distTo[w] + 1;
					edgeTo[v] = w;
				}
			}
		}
	}
	
	public int distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}
	
	public boolean hasPathTo(int v){
		validateVertex(v);
		return marked[v];
	}
	
	private void validateVertex(int v) {
		if(v < 0 || v > marked.length) {
			throw new IllegalArgumentException();
		}
		
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
	//	graph.printGraph(graph);
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
		Iterable<Integer> path = bfs.pathTo(4);
		System.out.println("Distance from source to the point 4 is " + bfs.distTo(4));
		for(Integer i : path) {
			System.out.println(i);
		}
	}

}
