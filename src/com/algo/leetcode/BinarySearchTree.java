package com.algo.leetcode;

import com.algo.leetcode.BinarySearchExtended.Node;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchTree {
	
	BinarySearchExtended bst;
	
	public BinarySearchTree() {
		bst = new BinarySearchExtended();
	}
	
	public boolean isValidBST(Node root) {
		Queue<Node> que = new Queue<Node>();
		que.enqueue(root);
		boolean  isValid = true;
		while(!que.isEmpty()) {
			int count = que.size();
			while(count-- > 0) {
				Node x = que.dequeue();
				if(x.left != null && x.value > x.left.value)		que.enqueue(x.left);	
				else	 if(x.left != null && x.value < x.left.value)	isValid = false;
				if(x.right != null && x.value < x.right.value)		que.enqueue(x.right);
				else	 if(x.right != null && x.value > x.right.value)	isValid = false;
			}
			if(!isValid) break;
		}
        return isValid;
    }
	
	public static void main(String[] args) {
		BinarySearchExtended bst = new BinarySearchExtended();
		BinarySearchTree bst1 = new BinarySearchTree();
		bst.put2(7);
		bst.put2(10);	
		bst.put2(5);	
		bst.put2(2);	
		bst.put2(6);
		bst.print(bst.root);
		System.out.println(bst1.isValidBST(bst.root));
	}
	
	
}
