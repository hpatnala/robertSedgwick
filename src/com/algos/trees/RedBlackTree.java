package com.algos.trees;

public class RedBlackTree {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root = null;
	
	public class Node{
		char key;
		int value;
		Node left;
		Node right;
		int count;
		boolean color;
		
		public Node(char key, int value, boolean color, int count) {
			this.key = key;
			this.value = value;
			this.color = color;
			this.count = count;
		}	
	}
	
	public static void main(String[] args) {
		RedBlackTree rbTree = new RedBlackTree();
		rbTree.put('S', 2);
		rbTree.put('R', 5);
		rbTree.put('A', 1);
		rbTree.put('B', 3);
		rbTree.put('C', 6);
		rbTree.put('E', 8);
		rbTree.put('X', 9);
		rbTree.put('Z', 4);
		rbTree.put('B', 7);
		
		print(rbTree.root);
	}
	
	public void put(char key, int value) {
		root = put(root, key, value);
	}
	
	public static void print(Node x) {
		if(x== null) return;
		System.out.println(x.key + " " + x.value);
		print(x.right);
		print(x.left);
	}

	private Node put(Node x, char key, int value) {
		if(x==null) return new Node(key, value, RED, 1);
		else if((int)x.key > key)
			 x.left = put(x.left, key, value);
		else if((int)x.key < key)
			 x.right = put(x.right, key, value);
		else
			x.value = value;
		
		if(isRed(x.right) && !isRed(x.left)) 
			x = rotateLeft(x);
		else if(isRed(x.right) && isRed(x.left.left))
			x = rotateRight(x);
		else if(isRed(x.right) && isRed(x.left))
			x = flipColors(x);		
		x.count = 1 + size(x.right) + size(x.left);
		
		return x;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x == null) return 0;
		return x.count;
	}

	private Node flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
		return h;
	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private Node rotateLeft(Node x) {
		Node h = x.right;
		x.right = h.left;
		h.left = x;
		h.color = x.color;
		x.color = RED;	
		return h;
	}

	private boolean isRed(Node h) {	
		if(h==null) return false;
		return h.color == RED;
	}

}
