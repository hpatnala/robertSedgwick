package com.dsalgos.mst.helper;

public class UnionFind {
		
	private int[] parent;
	private byte[] rank;
	private int count;
	
	public UnionFind(int n) {
		if(n<0) throw new IllegalArgumentException();
		parent = new int[n];
		rank = new byte[n];
		count = n;
		for(int i=0;i<parent.length;i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	public int find(int p) {
		validate(p);
		while(p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}
	 
	
	private void validate(int p) {
		if(p<0) throw new IllegalArgumentException();
	}

	public void quickFindUnion(int p, int q) {
		int pid = parent[p];
		int qid = parent[q];
		for(int i=0;i<parent.length;i++) {
			if(parent[i] == pid) parent[i] = qid;
		}	
	}
	
	public void quickUnion(int p, int q) {	
		int rootP = root(p);
		int rootQ = root(q);
		parent[rootP] = rootQ;
	}
	
	public int root(int i) {
		while(i != parent[i]) i = parent[i];
		return i;
	}
	
	public int rootPathCompression(int p) {
		while(p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}
	
	public int rank(int p) {
		return rank[p];
	}
	
	public void weightedQuickUnion(int p, int q) {
		int rootP = rootPathCompression(p);
		int rootQ = rootPathCompression(q);
		if(rank(p) > rank(q)) {
			parent[rootQ] = rootP;
			rank[rootQ] +=rank[rootP];
		}else {
			parent[rootP] = rootQ;
			rank[rootP] +=rank[rootQ];
		}
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if(rootP == rootQ) return;
		if(rank(rootP) > rank(rootQ)) parent[rootQ] = rootP;
		else if(rank(rootP) < rank(rootQ)) parent[rootP] = rootQ;
		else {	parent[rootQ] = rootP; rank[rootP]++;	}
		count--;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int countOfComponents() {
		return count;
	}
	
	public static void main(String[] args) {
		
	}

}
