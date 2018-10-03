package com.begin.coding;

public class SerializeNode {
	
	static Node root;
	
	public class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	public void put(int val) {
		root = put(root, val);
	}
	
	private Node put(Node x, int val) {
		if(x == null)
			x = new Node(val);
		else if(val > x.val)
			x.right = put(x.right, val);
		else if(val < x.val)
			x.left = put(x.left, val);
		return x;
	}

	public static String serialize(Node root) {
		StringBuilder str = new StringBuilder();
		serialize(root, str);
		return str.toString();
	}
	
	private static void serialize(Node x, StringBuilder str) {
		if(x == null)
			return;
		serialize(x.left, str);
		str.append(x.val);
		serialize(x.right, str);
	}

	public Node deserialize(String s) {
		for(int i=0;i<s.length();i++)
			put(Integer.parseInt(s.charAt(i) + ""));
		return root;
	}
	
	public static void main(String[] args) {
		SerializeNode node = new SerializeNode();
		node.put(4);
		node.put(5);
		node.put(6);
		node.put(7);
		node.put(8);
		node.put(1);
		node.put(2);
		System.out.println(serialize(root));
		root = null;
		node.deserialize("6547823");
		System.out.println("Root: " + root.val);
		print(root);
	}

	private static void print(Node x) {
		if(x == null)
			return;
		print(x.left);
		System.out.print(x.val);
		print(x.right);
	}

}
