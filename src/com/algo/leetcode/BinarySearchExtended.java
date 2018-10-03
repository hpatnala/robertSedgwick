package com.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchExtended {
	Node root = null;
	
	public class Node {
		public int value;
		public Node left;
		public Node right;
		public int count;
		
		public Node(int value, int depth) {
			this.value = value;
			this.count = depth;
		}
	}
	
	public void print(Node x) {
		if(x== null) return;
		System.out.println(x.value + " ");
		print(x.left);
		print(x.right);
	}
	
	public void put(int value) {
		root = put(root, value);	
	}

	public Node put(Node x, int value) {
		if(x== null) return new Node(value, 1);
		else if((int)value > (int)x.value) 
			x.right = put(x.right, value);
		else if((int)value < (int)x.value) 
			x.left = put(x.left, value);
		else	
			x.value = value;
		x.count = 1 + size(x.right) + size(x.left);//root + right sub tree + left sub tree
		return x;
	}
	
	public void put2(int value) {
		root = put2(root, value);	
	}
	
	public Node put2(Node x, int value) {
		if(x== null) return new Node(value, 1);
		else if((int) value <= (int)x.value) 
			x.right = put2(x.right, value);
		else if((int) value >= (int)x.value) 
			x.left = put2(x.left, value);
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
	
	public Node sortedArrayToBST(int[] nums) {
		BinarySearchExtended bst = new BinarySearchExtended();
		int k = nums.length/2;
		bst.put(nums[k]);
		sortedArray(nums, 0, k-1, bst);
		sortedArray(nums, k+1, nums.length -1, bst);
		return bst.root;
    }
	
	private void sortedArray(int[] nums, int lo, int hi, BinarySearchExtended x) {		
		if(hi<lo) return;
		int mid = lo +(hi-lo)/2;
		sortedArray(nums, lo, mid-1, x);
		sortedArray(nums, mid+1, hi, x);	
		x.put(nums[mid]);
	}
	
	//Maximum Binary Tree
	public Node constructMaximumBinaryTree(int[] nums) {
		BinarySearchExtended bst = new BinarySearchExtended();
		int maxIndex = findMax(nums, 0, nums.length-1);
		bst.put(nums[maxIndex]);
		maxBinaryTree(nums, 0, maxIndex -1, bst);
		maxBinaryTree(nums, maxIndex + 1, nums.length -1, bst);
		return bst.root;
	}
	 
	private void maxBinaryTree(int[] nums, int lo, int hi, BinarySearchExtended bst) {
		if(hi<lo) return;
		int i = findMax(nums, lo, hi);
		bst.put(nums[i]);
		maxBinaryTree(nums, lo, i-1, bst);
		maxBinaryTree(nums, i+1, hi, bst);	
	}

	private int findMax(int[] nums, int lo, int hi) {
		if(nums.length < 1) throw new IllegalArgumentException();
		int i, max = lo;
		for(i=lo;i<=hi;i++) {
			if(nums[max] < nums[i]) {
				max = i;
			}
		}
		return max;
	}

	private int secMin = -1;
	private int min = 0;
	public int findSecondMinimumValue(Node x) {
		min = x.value;
		dfs(x);
		return secMin;
	}
	
	private void dfs(Node x) {
		if(x== null) return;
		if(min < x.value)  secMin = x.value;
		else if (min == x.value) {
			dfs(x.right);
			dfs(x.left);
		}
	}
	
	public List<String> binaryTreePaths(Node x) {
	   if(x == null) return null;
	   List<String> list = new ArrayList<String>();
	   StringBuilder str = new StringBuilder();
	   int[] path = new int[8]; 
	   int pathLen = 0;
	   binaryTreePaths(x, path, list, pathLen);
//	   binaryTreePaths(x, str, list);
	   return  list;
	}
	
	private void binaryTreePaths(Node x, int[] path, List<String> list, int pathLen){
		if(x == null) return;
		path[pathLen] = x.value;
		pathLen++;
		if(x.left == null && x.right == null) {
			listOfPaths(list, path, pathLen);
			return;
		}
		binaryTreePaths(x.left, path, list, pathLen);
		binaryTreePaths(x.right, path, list, pathLen);
	}
	
	private void listOfPaths(List<String> list, int[] path, int pathLen) {
		int[] pathTo = new int[path.length];
		for(int i=0; i<pathLen;i++) {
			pathTo[i] = path[i];
		}
		list.add(Arrays.toString(pathTo));
	}

	private int pathSum = 0;
	private boolean hasPathSum = false;
	public boolean pathSum(Node x, int sum) {
        if(x == null) return hasPathSum;
        int[] path = new int[8]; 
 	   	int pathLen = 0;
        pathSum(x, path, pathLen, sum);
        return hasPathSum;
    }
	
	private void pathSum(Node x, int[] path, int pathLen, int sum) {
		if(x == null) return;
		path[pathLen] = x.value;
		pathLen++;
		if(x.left == null && x.right == null) {
			pathSums(x, path, pathLen, sum);
		}
		pathSum(x.left, path, pathLen, sum);
		pathSum(x.right, path, pathLen, sum);
	}

	private boolean pathSums(Node x, int[] path, int pathLen, int sum) {
		int sum1 = 0;
		int[] pathTo = new int[path.length];
		for(int i=0;i<pathLen;i++) {
			pathTo[i] = path[i];
			sum1 = sum1 + pathTo[i];
		}
		
		if(sum1 == sum) {
			hasPathSum = true;
		}
		return hasPathSum;
	}
	
	//public Node lowestCommonAncestor(Node root, Node p, Node q) {
        
   // }

	public boolean isSubtree(Node s, Node t) {
		if(s == null || t == null) return false;
		Queue<Node> que = new Queue<Node>();
		que.enqueue(s);
		boolean isIdentical = false;
		while(!que.isEmpty()) {
			int count = que.size();
			while(count-- > 0) {
				Node curr = que.dequeue();
				if(curr.value == t.value)	isIdentical = isIdentical(curr, t);
				if(curr.left != null) 	que.enqueue(curr.left);
				if(curr.right != null)	que.enqueue(curr.right);
			}
		}
		return isIdentical;
    }
	
	private boolean isIdentical(Node s, Node t) {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		return s.value == t.value && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
	}

	//My Attempt
	private int count = 0;
	public void binaryTreePaths(Node x, StringBuilder str, List<String> list){
		if(x == null) return;
		str.append(x.value);
		count++;
		if(x.left == null && x.right == null) {
			list.add(str.toString());
			str.replace(count, str.length()-1, " ");
			return;
		}
		binaryTreePaths(x.left, str, list);	
		binaryTreePaths(x.right, str, list);
	}
	
	private int min1=0;
	private int minX=0;
	public int closestTreeValue(Node x, int target) {	
		if(x==null)	return 0;		
		closestTreeValue(x.left, target);
		closestTreeValue(x.right, target);		
		if(Math.abs(min1) > (target - x.value))	{min1 = target - x.value;minX = x.value;}
		return minX;
	}
	
	public boolean isSymmetry(Node x) {
		if(x == null) return false;
		return isMirror(x, x);
	}
	
	private boolean isMirror(Node t1, Node t2) {
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		return t1.value == t2.value && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
	}
	
	public boolean isBalanced(Node x) {
        if(x == null) return false;
        heightOfTree(x);       
        if(Math.abs(ans) > 1) return false;
        return true;
    }
	private int ans = 0;
	private int heightOfTree(Node x) {
		if(x == null) return 0;
		int L = heightOfTree(x.left);
		int R = heightOfTree(x.right);
		ans = L-R;
		return Math.max(L, R) + 1;
	}
	
	public int[] findMode(Node x) {
       int[] mode = new int[10];
       int[] mode1 = new int[mode.length];
       int pathLen = 0;
       findMode(x, mode,pathLen, mode1);
       return mode1;
    }

	private void findMode(Node x, int[] mode, int pathLen, int[] mode1) {
		if(x == null) return;
		mode[pathLen] = x.value;
		pathLen++;
		isEqual(mode, pathLen, mode1);
		findMode(x.left, mode, pathLen, mode1);
		findMode(x.right, mode, pathLen, mode1);
	}
	
	private int count1 = 0;	
	private void isEqual(int[] mode, int pathLen, int[] mode1) {	
		for(int i=0;i<pathLen-1;i++) {
			if(mode[i] == mode[i+1])		mode1[count1++] = mode[i];	
		}
	}
	
	public Node addOneRow(Node root, int v, int d) {
        Queue<Node> que = new Queue<Node>();
        que.enqueue(root);
        int dOfPrnt = 0;
        Node rootNode = null;
        if(d == 1) {
        		Node tempRoot = new Node(v, 1);
        		tempRoot.left = root;
        		return tempRoot;
        }
        while(!que.isEmpty()) {
        		int count = que.size();
        		while(count-- >0) {
        			rootNode = que.dequeue();
        			if(rootNode.left != null)	que.enqueue(rootNode.left);
        			if(rootNode.right != null)	que.enqueue(rootNode.right);
        		}
        		++dOfPrnt;
        		if(dOfPrnt == d-2)	break;    		
        }
        if(!que.isEmpty()) {
        		Node node = que.dequeue();
	        Node tempLeft = node.left;
	        Node tempRight = node.right;
	        node.left = new Node(v, 1);
	        node.right = new Node(v, 1);
	        node.left.left = tempLeft;
	        node.right.right = tempRight;
        }
        return root;
    }
	
	public int minDepth(Node x) {
		if(x == null) return 0;
        return Math.min(minDepth(x.left), minDepth(x.right)) + 1;
    }
	
	public int houseRobber(Node x) {
		if(x == null) return 0;
		Queue<Node> que = new Queue<Node>();
		int odd = 0;
		int even = 0;
		int level = 1;
		que.enqueue(x);
		while(!que.isEmpty()) {
			int count = que.size(); //2 //2
			while(count-- >0) { //1 //0 //1 //0
				Node t = que.dequeue();
				if(level % 2 == 1) 	odd +=t.value; //3 //6 //7
				else 	even += t.value; //2 //5
				if(t.left != null)	que.enqueue(t.left);
				if(t.right != null)	que.enqueue(t.right);
			}
			level++; //2 //3
		}
		System.out.println(level);
		return Math.max(odd, even);
	}
	
	public int rob(Node root) {
        return Math.max(vals(root)[0], vals(root)[1]);
    }
    public int[] vals(Node root){
        if(root== null){
            return new int[]{0,0};
        }
        else{
            int[] left = vals(root.left);
            int[] right = vals(root.right);
            int excl = left[0] + right[0];
            int incl = Math.max(excl, left[1] + right[1] + root.value);
            return new int[]{incl,excl};
        }
    }
    
    public int rob1(Node root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(Node root) {
        if (root == null) return new int[2];
        
        int[] left = robSub(root.left);
        System.out.println("left: " + Arrays.toString(left));
        int[] right = robSub(root.right);
        System.out.println("right: " + Arrays.toString(right));
        int[] res = new int[2];
        
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.value + left[0] + right[0]; 
        System.out.println("res: " + Arrays.toString(res));
        return res;
    }
    
    
	

	/**
	 * 			5
	 * 		3		7
	 * 	 2	  4	 6     8
	 * 
	 */

	public static void main(String[] args) {
		BinarySearchExtended bst = new BinarySearchExtended();
		int[] nums = {-10,-3,0,5,9};
		bst.print(bst.sortedArrayToBST(nums));
		System.out.println();
		int[] nums1 = {3,2,1,6,0,5};
		bst.print(bst.constructMaximumBinaryTree(nums1));
		bst.put(5);
		bst.put(3);
	//	bst.put(10);
		bst.put(4);	
		bst.put(2);	
		bst.put(6);
		bst.put(7);
	//	bst.put(8);
		System.out.println("House Robbery");
	 	System.out.println("Hello " + bst.houseRobber(bst.root));
		System.out.println(bst.rob(bst.root));
		System.out.println(bst.rob1(bst.root));
		bst.addOneRow(bst.root, 1, 4);
		System.out.println("Add one row");
		bst.print(bst.root);
		
		BinarySearchExtended bstSub = new BinarySearchExtended();
		bstSub.put(3);
		bstSub.put(4);
		bstSub.put(2);
		System.out.println();
		System.out.println(bst.findSecondMinimumValue(bst.root));
		System.out.println(bst.binaryTreePaths(bst.root));
		System.out.println("Balanced: " + bst.isBalanced(bst.root));
		System.out.println("path Sum: " + bst.pathSum(bst.root, 18));
		System.out.println(bst.count);
		int target = 10;	
		bst.min1 = target - bst.root.value;
		System.out.println(bst.closestTreeValue(bst.root, target));
		System.out.println(bst.isSubtree(bst.root, bstSub.root));
		Node rep = bst.new Node(1, 1);
		rep.right = bst.new Node(2, 1);
		rep.right.left = bst.new Node(2, 1);	
		rep.right.right = bst.new Node(3, 1);	
		rep.right.right.left = bst.new Node(3, 1);	
		bst.print(rep);
		System.out.println(Arrays.toString(bst.findMode(rep)));
		System.out.println("Minimum Depth: " + bst.minDepth(bst.root));
	}

}
