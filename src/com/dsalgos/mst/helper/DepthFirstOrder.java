package com.dsalgos.mst.helper;

import com.dsalgos.graphs.DiGraph;
import com.dsalgos.shortpath.DirectedEdge;
import com.dsalgos.shortpath.EdgeWeightedDiGraph;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {
	
	private boolean[] marked;
	private int[] pre;
	private int[] post;
	private int preCounter;
	private int postCounter;
	private Queue<Integer> preOrder;
	private Queue<Integer> postOrder;
	
	public DepthFirstOrder(EdgeWeightedDiGraph G) {
		marked = new boolean[G.V()];
		pre = new int[G.V()];
		post = new int[G.V()];
		preOrder = new Queue<Integer>();
		postOrder = new Queue<Integer>();
		for(int v=0;v<G.V();v++) {
			if(!marked[v]) {
				dfs(G, v);
			}
		}
	}
	
	private void dfs(EdgeWeightedDiGraph G, int v) {
		marked[v] = true;
		preOrder.enqueue(v);
		pre[v] = preCounter++;
		for(DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if(!marked[w]) {
				dfs(G, w);
			}
		}
		postOrder.enqueue(v);
		post[v] = postCounter++;
	}
	
	public void dfs(DiGraph G, int v) {
		marked[v] = true;
		preOrder.enqueue(v);
		pre[v] = preCounter++;
		for(Integer w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
		postOrder.enqueue(v);
		post[v] = postCounter++;
	}
	
	public int pre(int v){
		validateVertex(v);
		return pre[v];
	}
	
	public int post(int v) {
		validateVertex(v);
		return post[v];
	}

	private void validateVertex(int v) {
		if(v<0 || v > pre.length) {
			throw new IllegalArgumentException();
		}
	}
	
	public Iterable<Integer> pre(){
		return preOrder;
	}
	
	public Iterable<Integer> post(){
		return postOrder;
	}
	
	public Iterable<Integer> reversePost(){
		Stack<Integer> reverse = new Stack<Integer>();
		for(Integer w : postOrder) {
			reverse.push(w);
		}		
		return reverse;
	}
	
	public static void main(String[] args) {

	}

}
