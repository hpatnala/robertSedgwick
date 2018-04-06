package com.algos.trees;

import java.util.Iterator;

import com.robertSedgewick.assignment.RandomizedQueue;

public class BinarySearchTree {
	
	Node root = null;

	public class Node {
		private char key;
		private int value;
		private Node left;
		private Node right;
		private int count;
		
		public Node(char key, int value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.put('S', 2);
		bst.put('R', 5);
		bst.put('A', 1);
		bst.put('B', 3);
		bst.put('C', 6);
		bst.put('E', 8);
		bst.put('X', 9);
		bst.put('Z', 4);
		bst.put('B', 7);
		bst.print(bst.root);
		
		System.out.println("Floor: " + bst.floor('F'));
		System.out.println("Ceiling: " + bst.ceiling('Y'));
		System.out.println("Size: " + bst.size());
		System.out.println("Rank: " + bst.rank('Y'));
		System.out.println("Leaf Nodes: ");
		bst.printLeaf(bst.root);
		System.out.println("In Order Nodes: ");
		Iterator<Character> iterator = bst.keySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
	}
	
	public void print(Node x) {
		if(x== null) return;
		System.out.println(x.key + " " + x.value);
		print(x.right);
		print(x.left);
	}
	
	public void put(char key, int value) {
		root = put(root, key, value);	
	}

	public Node put(Node x, char key, int value) {
		if(x== null) return new Node(key, value, 1);
		else if((int)key > (int)x.key) 
			x.right = put(x.right, key, value);
		else if((int)key < (int)x.key) 
			x.left = put(x.left, key, value);
		else	
			x.value = value;
		x.count = 1 + size(x.right) + size(x.left);//root + right sub tree + left sub tree
		return x;
	}
	
	//SIZE
	public int size() {
		return size(root);
	}

	public int size(Node x) {
		if(x==null)
			return 0;
		return x.count;
	}

	public int get(char key) {
		Node current = root;
		while(current!=null) {
			if((int)current.key > (int)key) 
				current = current.left;
			else if((int)current.key < (int)key) 
				current = current.right;
			else 
				return current.value;
		}
		return 0;
	}
	
	//FLOOR
	public Character floor(char key) {
		Node x = floor(root, key);
		if(x == null) return null;
		return x.key;
	}

	public Node floor(Node x, char key) {
		if(x == null) 
			return null;
		else if((int)key < (int)x.key) 
			return floor(x.left, key);
		else if((int)key == (int)x.key) 
			return x;		
		Node t = floor(x.right, key);
		if(t != null) 
			return t;
		else 
			return x;
	}
	
	//CEILING
	public Character ceiling(char key) {
		Node x = ceiling(root, key);
		if(x == null) return null;
		return x.key;
	}
	
	private Node ceiling(Node x, char key) {
		if(x==null) 
			return null;
		else if((int)x.key < (int)key)
			return ceiling(x.right, key);
		else if((int)x.key == key)
			return x;
		Node t = ceiling(x.left, key);
		if(t != null)
			return t;
		else
			return x;
	}
	
	//RANK
	public int rank(char key) {
		if(root == null) return 0;
		return rank(root, key);
	}

	public int rank(Node x, char key) {
		if(x==null) return 0;
		else if((int)x.key > key) return rank(x.left, key);
		else if((int)x.key < key) return 1+size(x.left)+rank(x.right, key);
		else return size(x.left);
	}
	
	//ITERABLE
	public Iterable<Character> keySet() {
		RandomizedQueue<Character> que = new RandomizedQueue<Character>();
		inorder(root, que);
		return que;
	}

	private void inorder(Node x, RandomizedQueue<Character> que) {
		if(x == null) return;
		inorder(x.left, que);
		que.enqueue(x.key);
		inorder(x.right, que);
	}
	
	public void printLeaf(Node x) {
		if(x==null)
			return;		
		if(x.left == null && x.right == null) {
			System.out.println(x.key);
		}
		printLeaf(x.left);
		printLeaf(x.right);
	}
}
