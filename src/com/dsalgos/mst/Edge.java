package com.dsalgos.mst;

public class Edge implements Comparable<Edge>{
	private int v;
	private int w;
	private final double weight;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() {
		return v;
	}
	
	public double weight() {
		return weight;
	}
	
	public int compareTo(Edge that) {
		return Double.compare(this.weight(), that.weight());
	}
	
	public int other(int vertex) {
		if(vertex == v) return w;
		else return v;
	}
}
