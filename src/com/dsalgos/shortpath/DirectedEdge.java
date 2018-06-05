package com.dsalgos.shortpath;

public class DirectedEdge {
	
	private double weight;
	private int from;
	private int to;
	
	public DirectedEdge(int from, int to, double weight) {
		this.from = from;
		this.to= to;
		this.weight = weight;
	}
		
	public double weight() {
		return weight;
	}
	
	public int from() {
		return from;
	}
	
	public int to() {
		return to;
	}
	
	public String toString() {
		return from + "->" + to + " - " + weight;
	}
	
	public static void main(String[] args) {
		
	}

}
