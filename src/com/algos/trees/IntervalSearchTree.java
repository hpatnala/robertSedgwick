package com.algos.trees;

import edu.princeton.cs.algs4.Queue;

public class IntervalSearchTree {
	
	private Node root;
	
	public class Node{
		int leftkey;
		int rightval;
		Node left;
		Node right;
		int maxEndPoint;
		
		public Node(int leftPt, int rightPt) {
			leftkey = leftPt;
			rightval = rightPt;
			maxEndPoint = rightPt;
		}
		
		public boolean intersects(int lpoint, int rpoint) {
			return lpoint < leftkey || rpoint < rightval || lpoint < rightval;
		}
	}
	
	public void put(int leftPt, int rightPt) {
		root = put(root, leftPt, rightPt);
		getMaxEndPt(root);
	}

	public Node put(Node x, int leftPt, int rightPt) {
		if(x == null) return new Node(leftPt, rightPt);		
		
		if(x.leftkey < leftPt) {
			x.right = put(x.right, leftPt, rightPt);
		}	
		if(x.leftkey > leftPt) {
			x.left = put(x.left, leftPt, rightPt);
		}
		
		int maxRight =0;
		if(x.right != null) 	maxRight = x.right.rightval;
		int maxLeft = 0;
		if(x.left != null) 	maxLeft = x.left.rightval;	
		x.maxEndPoint = Math.max(Math.max(maxRight, maxLeft), x.maxEndPoint);						
		
		return x;
	}
	
	public void getMaxEndPt(Node x) {
		if(x == null) return;		
		getMaxEndPt(x.right);
		getMaxEndPt(x.left);
		int maxRight =0;
		if(x!= null) {
			if(x.right != null) 	maxRight = x.right.rightval;
			int maxLeft = 0;
			if(x.left != null) 	maxLeft = x.left.rightval;	
			x.maxEndPoint = Math.max(Math.max(maxRight, maxLeft), x.maxEndPoint);	
		}
		
	}
	
	private void getMaxEndPoint() {
		Queue<Node> que = new Queue<Node>();
		getMaxEndPoint(root, que);
	}

	private void getMaxEndPoint(Node current, Queue<Node> que) {
		Node x = current;
		que.enqueue(x);
		while(!que.isEmpty()) {
			int count = que.size();
			while(count-- > 0) {
				Node ch = que.dequeue();
				int maxRight = 0;
				if(ch.right != null) {
					que.enqueue(ch.right); 
					maxRight = ch.right.rightval;
				}
				int maxLeft = 0;
				if(ch.left != null) {
					que.enqueue(ch.left); 
					maxLeft = ch.left.rightval;
				}
				int maxEndPt = Math.max(maxRight, maxLeft);
				if(ch.maxEndPoint == 0)
					ch.maxEndPoint = Math.max(maxEndPt, ch.rightval);
				else
					ch.maxEndPoint = Math.max(maxEndPt, ch.maxEndPoint);
			}
		}
	}
	
	public static void printTree(String dir, Node x) {
		if(x==null) return;	
		System.out.println(dir + " " + x.leftkey + " " + x.rightval + " " + x.maxEndPoint);
		printTree("left", x.left);
		printTree("right", x.right);
	}
	
	public void searchInterval(int leftPt, int rightPt) {
		searchInterval(root, leftPt, rightPt);
		searchIntervalNoRec(root, leftPt, rightPt);
	}
	
	//With Recursion
	private void searchInterval(Node x, int leftPt, int rightPt) {
		if(x==null) return;
		if(x.intersects(leftPt, rightPt)) System.out.println(x.leftkey + ", " + x.rightval);
		if(x.leftkey > leftPt) searchInterval(x.left, leftPt, rightPt);
		if(x.leftkey < leftPt)  searchInterval(x.right, leftPt, rightPt);
		if(x.maxEndPoint < leftPt) searchInterval(x.right, leftPt, rightPt);	
	}
	
	//Optimized
	private void searchIntervalNoRec(Node current, int leftPt, int rightPt) {
		Node x = current;
		while(x!= null) {
			if(x.intersects(leftPt, rightPt)) System.out.println(x.leftkey + ", " + x.rightval);
			if(x.left == null) x= x.right;
			else if(x.left.maxEndPoint < leftPt) x = x.right;
			else x=x.left;
		}
	}

	public static void main(String[] args) {
		IntervalSearchTree inSrchTree = new IntervalSearchTree();
		inSrchTree.put(17, 19);
		inSrchTree.put(21, 20);
		inSrchTree.put(5, 8);
		inSrchTree.put(15, 18);
		inSrchTree.put(4, 8);
		inSrchTree.put(7, 10);
		inSrchTree.put(16, 22);
		printTree("root", inSrchTree.root);
		inSrchTree.searchInterval(23, 25);
		System.out.println(Integer.hashCode(34));
	}
}
