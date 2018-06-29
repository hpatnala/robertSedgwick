package com.dsalgos.graphs;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstSearch {
	
	private int[] edgeTo;
	private boolean marked[];
	private int s;
	
	public DepthFirstSearch(Graph graph, int s) {
		edgeTo = new int[graph.numberOfVertices()];
		marked = new boolean[graph.numberOfVertices()];
		dfs(graph, s);
	}
	
	public void dfs(Graph graph, int v) {
		marked[v] = true;
		for(int w : graph.bags[v]) {		
			if(!marked[w]) {
				System.out.println("Parent : " + v + " Child : " + w);
				dfs(graph, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int i = v; i != s; i=edgeTo[i]) {
			path.push(i);
		}
		path.push(s);
		return path;
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);
		graph.printGraph(graph);
		DepthFirstSearch dfs = new DepthFirstSearch(graph, 1);
		Iterable<Integer> path = dfs.pathTo(4);
		for(Integer i : path) {
			System.out.println(i);
		}
	}

}
