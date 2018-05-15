package com.amazon.interviewques;

public class SumOfLeafNodes {
	
	private Node root;
	private static int sum = 0;
	
	public class Node{
		private char key;
		private int value;
		private Node left;
		private Node right;
		
		public Node(char key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public void put(char key, int value) {
		root = put(root, key, value);
	}
	
	private Node put(Node x, char key, int value) {
		if(x == null) x = new Node(key, value);
		else if((int)x.key > (int)key) x.left = put(x.left, key, value);
		else if((int)x.key < (int)key) x.right = put(x.right, key, value);
		else x.value = value;
		return x;
	}
	
	//My Method
	public static int sumOfLeafNodes(Node x, int sum) {
		if(x==null) return sum;
		if(x.left == null && x.right == null) return sum + x.value;
		return sumOfLeafNodes(x.left, sum) + sumOfLeafNodes(x.right, sum);
	}
	
	//Dinesh method
	public static void sumOfLeafNodes(Node x) {
		if(x==null) return;
		if(x.left == null && x.right == null) sum = sum + x.value;
		sum = sumOfLeafNodes(x.left, sum) + sumOfLeafNodes(x.right, sum);
	}
	
	private void print(Node x, String str) {
		if(x == null) return;
		System.out.println(str + " : " + x.key + " , " + x.value );
		print(x.left, "left");
		print(x.right, "right");
	}

	public static void main(String[] args) {
		SumOfLeafNodes bst = new SumOfLeafNodes();
		bst.put('T', 2);
		bst.put('R', 5);
		bst.put('B', 3);
		bst.put('X', 1);	
		bst.put('S', 2);
		bst.put('C', 6);
		bst.put('Z', 4);
		bst.print(bst.root, "root"); 
		System.out.println("Sum Of Leaf Nodes: "+ sumOfLeafNodes(bst.root, 0)); //12
		sumOfLeafNodes(bst.root);
		System.out.println(sum);
	}	

}
