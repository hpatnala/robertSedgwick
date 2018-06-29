package com.dsalgos.graphs;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstDirectedPath {
	
	private static final int INFINITY = Integer.MAX_VALUE;
	
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	
	public BreadthFirstDirectedPath(DiGraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for(int i=0;i<distTo.length;i++) {
			distTo[i] = INFINITY;
		}
		validateVertex(s);
		bfs(G, s);
	}
	
	public BreadthFirstDirectedPath(DiGraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for(int i=0;i<distTo.length;i++) {
			distTo[i] = INFINITY;
		}
		validatedVertices(sources);
		bfs(G, sources);
	}
	
	private void bfs(DiGraph G, Iterable<Integer> sources) {
		Queue<Integer> que = new Queue<Integer>();
		for(Integer s : sources) {
			que.enqueue(s);
			marked[s] = true;
			distTo[s] = 0;
		}		
		while(!que.isEmpty()) {
			int v = que.dequeue();
			for(Integer w : G.adj(v)) {
				que.enqueue(w);
				marked[w] = true;
				distTo[w] = distTo[v] + 1;
				edgeTo[w] = v;
			}
		}
	}

	private void bfs(DiGraph G, int s) {
		Queue<Integer> que = new Queue<Integer>();
		marked[s] = true;
		distTo[s] = 0;
		que.enqueue(s);
		while(!que.isEmpty()) {
			int v = que.dequeue();
			for(Integer w : G.adj(v)) {
				if(!marked[w]) {
					que.enqueue(w);
					marked[w] = true;
					distTo[w] = distTo[v] + 1;
					edgeTo[w] = v;
				}
			}
		}
	}
	
	private void validatedVertices(Iterable<Integer> sources) {
		for(Integer s : sources){if(s < 0 || s >= marked.length) throw new NullPointerException();}
	}

	private void validateVertex(int s) {
		if(s < 0 || s >= marked.length) throw new NullPointerException();
	}
	
	public boolean hasPathTo(int u) {
		validateVertex(u);
		return marked[u];
	}
	
	public Iterable<Integer> pathTo(int u){
		if(!hasPathTo(u)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int v =0;
		for(v=u;distTo[v] !=0;v=edgeTo[v]) {
			path.push(v);
		}
		path.push(v);
		return path;
			
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
		
		int s = 6;
		BreadthFirstDirectedPath bfs = new BreadthFirstDirectedPath(graph, s);
		
		for(int u=0; u< graph.V(); u++) {
			if(bfs.hasPathTo(u)) {
				System.out.println("Distance between " + s + " and " + u + " : " + bfs.distTo[u]);
				for(Integer v : bfs.pathTo(u)) {
					if(v == s) System.out.print(v);
					else System.out.print(" - > " + v);
				}
				System.out.println();
			}else {
				System.out.println(s + " and " + u + " are not connected");
			}
		}
		
	}

}
