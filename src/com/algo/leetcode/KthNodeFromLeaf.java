package com.algo.leetcode;

public class KthNodeFromLeaf {
	
	Node root;
	
	public class Node{
		char key;
		int value;
		Node left;
		Node right;
		
		public Node(char key, int value) {
			this.key = key;
			this.value = value;
		}
	}
		
	public void kthNode(Node x, int y, int k) {
		if(k < 0 || k >heightOfTree(root)) {
			throw new IllegalArgumentException();
		}
		
		if(x != null) {
			if(y==k) {
				System.out.println(x.key);		
			}
			kthNode(x.left, y+1, k);
			kthNode(x.right, y+1, k);
		}
	}
	
	public void kthNodeFromRoot(Node x, int y, int k) {
		if(k < 0 || k >heightOfTree(root)) {
			throw new IllegalArgumentException();
		}
		
		if(x != null) {
			if(y== heightOfTree(root) - k) {
				System.out.println(x.key);		
			}
			kthNode(x.left, y+1, k);
			kthNode(x.right, y+1, k);
		}
	}
	
	public void put(char key, int value) {
		root = put(root, key, value);
	}
	
	private Node put(Node x, char key, int value) {
		if(x == null) x = new Node(key, value);
		else if(x.key > key) x.left = put(x.left, key, value);
		else if(x.key < key) x.right = put(x.right, key, value);
		else x.value = value;
		return x;
	}
	
	public void print(Node x) {
		if(x == null) return;
		System.out.println(x.key + " - " + x.value);
		print(x.left);
		print(x.right);
	}
	
	public int heightOfTree(Node x) {
		if (x==null) return 0;
		return Math.max(heightOfTree(x.right), heightOfTree(x.left) + 1);
	}

	/**
	 * 						T
	 * 				R				X
	 * 		B			S				Z
	 * 			C
	 * @param args
	 */
	
	public static void main(String[] args) {
		KthNodeFromLeaf bst = new KthNodeFromLeaf();
		bst.put('T', 2);
		bst.put('R', 5);
		bst.put('B', 3);
		bst.put('X', 1);	
		bst.put('S', 2);
		bst.put('C', 6);
		bst.put('Z', 4);
		bst.print(bst.root); 
		System.out.println(bst.heightOfTree(bst.root));
		bst.kthNode(bst.root, 0, 2);
		System.out.println();
		bst.kthNodeFromRoot(bst.root, 1, 2);
	}

}
