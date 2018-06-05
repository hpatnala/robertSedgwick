package com.dsalgos.shortpath;

import com.dsalgos.graphs.Topological;

import edu.princeton.cs.algs4.Stack;

public class AcyclicSP {
	
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	
	public AcyclicSP(EdgeWeightedDiGraph G, int s) {
		edgeTo = (DirectedEdge[]) new Object[G.V()];
		distTo = new double[G.V()];
		
		for(int i=0;i<G.V();i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0;
		Topological sort = new Topological(G);
		for(int v : sort.order()) {
			for(DirectedEdge e : G.adj(v)) {
				relax(e);
			}
		}
	}
	
	private void relax(DirectedEdge e) {
		int w = e.from();
		int v = e.to();
		if(distTo[v] > distTo[w] + e.weight()) {
			distTo[v] = distTo[w] + e.weight();
			edgeTo[v] = e;
		}
	}
	
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		validateVertex(v);
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v];e!=null;e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}

	private void validateVertex(int v) {
		if(v<0 || v > distTo.length) {
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {
		
	}

}
