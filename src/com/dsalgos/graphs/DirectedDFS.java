package com.dsalgos.graphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;

public class DirectedDFS {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int V;
	//private final int s;
	private int s;
	private int count;
	private Stack<Integer> reversePost;
	
	public DirectedDFS(DiGraph G, int s) {
		this.V = G.V();
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	public DirectedDFS(DiGraph G) {
		this.V = G.V();
		marked = new boolean[V];
		edgeTo = new int[G.V()];
		reversePost = new Stack<Integer>();
		for(int v=0;v< G.V();v++) {
			if(!marked[v]) depthFirstSearch(G, v);
		}
	}
	
	private void depthFirstSearch(DiGraph G, int v) {
		marked[v] = true;
		for(Integer w : G.adj(v)) {
			if(!marked[w])	{
				depthFirstSearch(G, w);
				edgeTo[w] = v;
			}
		}
		reversePost.push(v);
	}
	
	public Iterable<Integer> reversePost(){
		return reversePost;
	}

	//reachability from multiple sources	
	public DirectedDFS(DiGraph G, Iterable<Integer> sources) {
		this.V = G.V();
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for(Integer w : sources) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	private void dfs(DiGraph G, int s) {
		count++;
		marked[s] = true;
		for(Integer v : G.adj(s)) {
			if(!marked[v]) {
				dfs(G, v);
				edgeTo[v] = s;
			}
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean hasPathTo(int u) {
		validateVertex(u);
		return marked[u];
	}
	
	public Iterable<Integer> pathTo(int u){
		if(!hasPathTo(u)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int v = u; v!=s;v=edgeTo[v]) {
			path.push(v);
		}
		path.push(s);
		return path;
	}

	private void validateVertex(int u) {
		if(u < 0 || u>=V)	throw new NullPointerException();	
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
		int s = 0;
		
		DirectedDFS dfs = new DirectedDFS(graph);
	//	DirectedDFS dfs = new DirectedDFS(graph, s);
		
		for(Integer e : dfs.reversePost()) {
			System.out.println(e);
		}
		
		System.out.println();
		//print out vertices which are reachable from source
		for(int i=0; i< graph.V();i++) {
			if(dfs.hasPathTo(i)) System.out.print(i + " ");
		}
		
		System.out.println();
		for(int v=0;v< graph.V();v++) {
			System.out.print(v + " to " + s + " : ");
			if(dfs.hasPathTo(v)) {
				for(Integer u : dfs.pathTo(v)) {
					if(u == s) System.out.print(u);
					else System.out.print(" - " + u);
				}
				System.out.println();
			}else {
				System.out.println(v + " is not connected to " + s);
			}
		}
		
		Bag<Integer> sources = new Bag<Integer>();
		for(int i=1; i < 2;i++) {
			sources.add(i);
		}
		
		DirectedDFS dfsMultiSources = new DirectedDFS(graph, sources);
		System.out.println();
		for(int i=0; i< graph.V();i++) {
			if(dfsMultiSources.hasPathTo(i)) System.out.print(i + " ");
		}	
		
		
	}

}
