package com.algo.leetcode;

public class BinaryHeapTrim {
	
	public static class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int value) {
			this.val = value;
		}		
	}
	
	public TreeNode trimBST(TreeNode x, int L, int R) {
		if(x!= null && (!isLowerBound(x.val, L) || !isUpperBound(x.val, R)))	sink(x, x);
		if(x != null)	trimBST(x.left, L, R);
		if(x != null)	trimBST(x.right, L, R);
        return x;
    }
	
	private void sink(TreeNode x, TreeNode mainX) {
		if(x == null) return;
		sink(x.left,  mainX);
		sink(x.right,  mainX);
//		if(x.left == null && x.right == null) {swap(mainX, x); mainX = null;  makeNullSink(x);}
	}
	
	public TreeNode trimBSTTest(TreeNode x, int L, int R) {
		if(x == null) return x;
		if(x.val > R) {System.out.print("left ");	return trimBSTTest(x.left, L, R);}
		if(x.val < L) {System.out.print("right "); return trimBSTTest(x.right, L, R);}
		System.out.println(x.val);
		System.out.println();
		x.left = trimBSTTest(x.left, L, R);
		x.right = trimBSTTest(x.right, L, R);
		return x;
	}

	private boolean isLowerBound(int x, int L) {
		if(x >= L) return true;
		return false;
	}
	
	private boolean isUpperBound(int x, int R) {
		if(x <= R) return true;
		return false;
	}
	
	private void print(TreeNode x, String level) {
		if(x==null) return;
		System.out.println(x.val + " " + level);
		print(x.left, "left");
		print(x.right, "right");
	}
	
	/**
	 * 					3
	 * 			0				4
	 * 		5		2
	 * 			1
	 * @param args
	 */
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(0);
		t1.left.left = new TreeNode(5);
		t1.right = new TreeNode(4);
		t1.left.right = new TreeNode(2);
		t1.left.right.left = new TreeNode(1);
		BinaryHeapTrim trim = new BinaryHeapTrim();
		trim.trimBSTTest(t1, 1, 6);
		trim.print(t1, "root");
	}

}
