package com.algo.leetcode;

public class BinaryTreeLeetCode {
	private TreeNode root;
	
	public static class TreeNode{
		private int value;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int value) {
			this.value = value;
		}		
	}
	
	public void put( int value) {
		root = put(root, value);
	}
		
	private TreeNode put(TreeNode x, int value) {
		if(x==null)	x = new TreeNode(value);		
		else if(x.value > value)	x.left = put(x.left, value);
		else if(x.value < value) x.right = put(x.right, value);
		return x;
	}

	private void print(TreeNode x, String level) {
		if(x==null) return;
		System.out.println(x.value + " " + level);
		print(x.left, "left");
		print(x.right, "right");
	}
	
	//Sum of left leaves
	private int sum;
	private void inorder(TreeNode x) {
		if(x==null) return;
		inorder(x.left);
		if(x.left != null && isLeaf(x.left)) sum = sum + x.left.value;
		inorder(x.right);
	}
	
	private boolean isLeaf(TreeNode x) {
		if(x.right == null && x.left == null)
			return true;
		return false;
	}

	public static void main(String[] args) {
		BinaryTreeLeetCode bst = new BinaryTreeLeetCode();
		bst.put(3);
		bst.put(20);
		bst.put(9);	
		bst.put(15);
		bst.put(7);
	//	bst.print(bst.root, "root");
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		bst.print(root, "root");
		bst.inorder(root);
		
		System.out.println();
		System.out.println("Sum of left node: " + bst.sum);
		System.out.println();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(8);
			
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(4);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		
		mergeTrees(t1, t2);
		bst.print(t1, "root");
	}
		
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null)	return t2;
		if(t2 == null)	return t1;
		t1.value = t1.value + t2.value;	
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}
}
