package com.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

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
		
	//	bst.print(root, "root");
	//	bst.inorder(root);
		
	//	System.out.println();
	//	System.out.println("Sum of left node: " + bst.sum);
	//	System.out.println();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(8);
		
		TreeNode t3 = new TreeNode(1);
		t3.left = new TreeNode(3);
		t3.right = new TreeNode(2);
		t3.left.left = new TreeNode(8);
		
		TreeNode t4 = new TreeNode(1);
		t4.left = new TreeNode(2);
		t4.right = new TreeNode(3);
		bst.findTilt(t4);
		System.out.println(bst.sum1);
		System.out.println(bst.isSameTree(t1, t3));
		System.out.println();
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(4);
		t2.left.right = new TreeNode(5);
		t2.right.right = new TreeNode(7);
		t2.right.right.right = new TreeNode(8);
		t2.right.right.right.right = new TreeNode(10);
		t2.right.right.right.right.right = new TreeNode(11);
	//	System.out.println(bst.hasPathSum(t2, 8));
	//	System.out.println(bst.pathSum);
		System.out.println();
		System.out.println("Start");
		System.out.println("is Balanced: " + bst.isBalanced(t2));
		System.out.println("is Balanced Test: " + bst.isBalancedTest(t2));
		System.out.println("Maximum Depth of Tree Node");
		System.out.println(bst.maxDepth(t2));
		
		TreeNode t5 = new TreeNode(2);
		t5.left = new TreeNode(1);
		t5.right = new TreeNode(4);
		t5.left.right = new TreeNode(5);
		t5.right.right = new TreeNode(7);
		System.out.println("Merge trees");
		mergeTrees(t1, t5);
		bst.print(t1, "root");
		
		TreeNode t6 = new TreeNode(3);
		t6.left = new TreeNode(9);
		t6.right = new TreeNode(20);
		t6.right.left = new TreeNode(15);
		t6.right.right = new TreeNode(7);
		System.out.println("Average at levels");
		System.out.println(bst.averageOfLevels(t6).toString());
	}
	
	/**
	 * 
	 * 			2
	 * 	1				4
	 * 		5				7
	 * 							8
	 * 								9
	 */
		
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null)	return t2;
		if(t2 == null)	return t1;
		t1.value = t1.value + t2.value;	
		System.out.println(t1.value);
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}
	
	private boolean isSame = true; 
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return isSame;
		if((p == null && q != null) || (p != null && q == null) ) return isSame = false;
		if(p.value != q.value)  return isSame = false;	
		isSameTree(p.left, q.left); 
		isSameTree(p.right, q.right); 
		return isSame;
	}
	
	private int sum1 = 0;
	public void findTilt(TreeNode x) {
		if(x == null) return;	
		int left = x.left == null?0 :x.left.value;
		int right = x.right == null?0:x.right.value;
		int diff = Math.abs(left - right);
		System.out.println("Tree tilt " + x.value + " : " + diff);
		sum1 = sum1 + diff;
		findTilt(x.left);
		findTilt(x.right);
	}	
	
	private boolean hasPath;
	private int pathSum =0;
	public boolean hasPathSum(TreeNode x, int sum) {
		if(x==null) return hasPath;	
		hasPathSum(x.left, sum);
		hasPathSum(x.right, sum);
		pathSum = pathSum + x.value;
		if(sum == pathSum) hasPath = true;
		if(sum < pathSum) pathSum = pathSum - x.value;
		if(x.right == null && x.left == null && sum != pathSum) pathSum = x.value;
		System.out.println(pathSum);
		return hasPath;
	}
	
	public List<String> binaryTreePaths(TreeNode x){
		return null;
	}
	
	private boolean isBalTree = false;
	public boolean isBalanced(TreeNode x) {
		if(x == null) return isBalTree;
		System.out.println(height(x));
		if(Math.abs(height(x.left) - height(x.right)) <= 1) {isBalTree = true; return isBalTree;}
		isBalanced(x.right);
		isBalanced(x.left);
		return isBalTree;
	}
	
	boolean isBalTreeTest = false;
	public boolean isBalancedTest(TreeNode x) {
		if(x == null) return isBalTreeTest;
		System.out.println("Left height : " + height(x.left) + " Right Height: " + height(x.right));
		if(Math.abs(height(x.left) - height(x.right)) <=1) { isBalTreeTest = true; return isBalTreeTest;}
		isBalancedTest(x.left);
		isBalancedTest(x.right);
		return false;
	}
	
	public int height(TreeNode x) {
	    if(x==null) return 0;
	    return Math.max(height(x.left), height(x.right)) + 1;
	}
	
	public List<Double> averageOfLevels(TreeNode x){
		List<Double> list = new ArrayList<Double>();
		int height = height(x);
		for(int i=0;i<height;i++) {			
				list.add((getAverage(x, i)) * multiply(i));	
		}
		return list;
	}
	
	public double getAverage(TreeNode x, int level) {
		if(x == null) return 0;
		if(level == 0) return x.value;
		if(level > 0) {
			double left = getAverage(x.left, level-1);
			double right = getAverage(x.right, level-1);
			double average = (left + right )/2;
			return average;
		}
		return 0;
	}

	private double multiply(int originalLevel) {
		int two = 1;
		for(int i=1; i<originalLevel;i++) {
			two = two * 2;
		}
		return two;
	}
	
	public int maxDepth(TreeNode x) {
		if(x == null) return 0;
		return Math.max(maxDepth(x.left), maxDepth(x.right)) + 1;
	}
	
	
}
