package com.dsalgos.graphs;

public class ConnectedComponent {
	
	private boolean[] marked;
	private int[] id;
	private int count;
	
	
	public ConnectedComponent(Graph G) {
		marked = new boolean[G.numberOfVertices()];
		id = new int[G.numberOfVertices()];
		for(int i=0;i<G.numberOfVertices();i++) {
			if(!marked[i]) {
				dfs(G, i);
				count++;
			}
		}
	}
	
	public int noOfCC() {
		return count;
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public boolean sameComponent(int v, int u) {
		return id[v] == id[u];
	}
	
	private void dfs(Graph g, int v) {
		marked[v] = true;
		id[v] = count;
		for(Integer u : g.adj(v)) {
			if(!marked[u]) {
				dfs(g, u);		
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(6, 7);
	//	graph.printGraph(graph);
		ConnectedComponent cc = new ConnectedComponent(graph);
		System.out.println(cc.id(6));
		System.out.println(cc.noOfCC());
	}

}
