package com.algos.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.robertSedgewick.assignment.Deque;
import com.robertSedgewick.assignment.RandomizedQueue;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BinarySearchTree {
	
	Node root = null;

	public class Node {
		private char key;
		private int value;
		public Node left;
		private Node right;
		private int count;
		private int sumOfNode;
		private boolean isFlag;
		
		public Node(char key, int value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}
	}
	
	public int sumOfLeafNodes(Node x, int sum) {
		if(x == null) return sum;			
		if(x.left == null && x.right == null)	return sum + x.value;
		return (sumOfLeafNodes(x.left, sum) + sumOfLeafNodes(x.right, sum));
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.put('T', 2);
		bst.put('R', 5);
		bst.put('B', 3);
		bst.put('X', 1);	
		bst.put('S', 2);
		bst.put('C', 6);
	//	bst.put('E', 8);
	//	bst.put('X', 9);
		bst.put('Z', 4);
	//	bst.put('B', 7);
	//	bst.put('D', 8);
	//	bst.put('F', 11);
		bst.print(bst.root); 
		
		BinarySearchTree bstSub = new BinarySearchTree();
		bstSub.put('R', 7);
		bstSub.put('B', 3);
		bstSub.put('X', 10);	
		bstSub.put('S', 8);
		bstSub.put('C', 6);
		bstSub.put('A', 2);
		System.out.println("BST SUB: ");
		bstSub.print(bstSub.root);
		System.out.println("level Order Bottom");
		System.out.println(bstSub.levelOrderBottom(bstSub.root).toString());	
		System.out.println("Diameter Of Binary Tree");
		System.out.println(bstSub.diameterOfBinaryTree(bstSub.root));
//		System.out.println("convert bst");
	//	bstSub.convertBST(bstSub.root);
		System.out.println();
		bstSub.convertBSTTraversal(bstSub.root);
		bstSub.print(bstSub.root);
		System.out.println();
		bstSub.invertTree(bstSub.root);
		bstSub.print(bstSub.root);
		System.out.println("While");
		bstSub.inverTreeWhile(bstSub.root);
		bstSub.print(bstSub.root);
		System.out.println("Find Target Test - MA");
		System.out.println(bstSub.findTargetTest(bstSub.root, 5));
		System.out.println("Find Target - MA");
		System.out.println(bstSub.findTargetNrml(bstSub.root, 5));
		System.out.println();
		System.out.println("Find Target");
		System.out.println(bstSub.findTarget(bstSub.root, 5));
		System.out.println("Tree to String");
		System.out.println(bstSub.tree2str(bstSub.root));
		System.out.println();
		
		System.out.println("Floor: " + bst.floor('F'));
		System.out.println("Ceiling: " + bst.ceiling('Y'));
		System.out.println("Size: " + bst.size());
		System.out.println("Rank: " + bst.rank('Y'));
		System.out.println("Leaf Nodes: ");
		bst.printLeaf(bst.root);
		System.out.println("Range Count: " + bst.rangeCount('D', 'X'));
		bst.rangeSearch(bst.root, 'D', 'Z');
		System.out.println();
		bst.rangeSearchOptimized(bst.root, 'B', 'X');
		System.out.println();
		System.out.println("In Order Nodes: ");
		System.out.println("Height: " + heightOfTreeDin(bst.root));
		System.out.println("BFS");
		bst.breadthFirstSearch();
		System.out.println();
		System.out.println("Is full Binary tree: " + bst.treerec(bst.root));
		System.out.println("Min Depth: " + minDepth(bst.root));
		System.out.println("Zig Zag Level" + bst.zigzagLevelOrder(bst.root).toString());
		System.out.println("Maximum Width with recursion: " + bst.getMaxWidth(bst.root));
		System.out.println("Maximum Width without recursion: " + bst.getMaxWidthWithoutRec(bst.root));
		System.out.println("Maximum Width Recursion Pre-Order: " + bst.getMaxWidthPreOrder(bst.root));
		System.out.println("Nodes: ");
		System.out.println(bst.sumOfTree(bst.root));
		System.out.println("Sum of Leaf Nodes: " + bst.sumOfLeafNodes(bst.root, 0));
		
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
	
	public boolean contains(char key) {
		return get(key) > 0;
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
	
	//Range Search 
	public void rangeSearchOptimized(Node x, char lo, char hi) {
		if(x==null) return;
		if((int)x.key > hi && (int)x.key >lo)	return;
		
		if((int)x.key < (int)lo) {
			rangeSearch(x.right, lo, hi);
		}else if((int)x.key < hi) {
			System.out.println(x.key);
			rangeSearch(x.left, lo, hi);
			rangeSearch(x.right, lo, hi);
		}else if((int)x.key > (int)lo && (int)x.key < (int)hi) {
			System.out.println(x.key);
			rangeSearch(x.right, lo, hi);
		}else if((int)x.key == (int)hi) {
			System.out.println(x.key);
		}
	}
	
	public void rangeSearch(Node x, char lo, char hi) {
		if(x==null) return;
		if(((int)x.key > (int)lo && (int)x.key < (int)hi) || (int)x.key == hi) System.out.println(x.key);
		rangeSearch(x.left, lo, hi);
		rangeSearch(x.right, lo, hi);
	}
	
	//Range Count
	public int rangeCount(char lo, char hi) {
		return (contains(hi))?rank(hi) - rank(lo) + 1:rank(hi) - rank(lo);
		/*
		if(contains(hi)) 	
			return rank(hi) - rank(lo) + 1;
		else 
			return rank(hi) - rank(lo);*/
	}
	
	//Height of a tree
	public static int heightOfTreeDin(Node x) {
		return x==null?0:Math.max(heightOfTreeDin(x.right), heightOfTreeDin(x.left))  + 1;
	}
	
	public static int heightOfTreeHari(Node x) {
		if(x == null) return 0;	
		return Math.max(heightOfTreeHari(x.right), heightOfTreeHari(x.left))  + 1;
	}
	
	public void breadthFirstSearch() {
		Queue<Node> que = new Queue<Node>();
	//	RandomizedQueue que = new RandomizedQueue();
		que.enqueue(root);
		breadthFirstSearchQueue(root, que);
	//	breadthFirstSearchQue(root, que);
	//	breadthFirstSearch(root, que);
		
	}
	
	public void breadthFirstSearch(Node x, RandomizedQueue<Character> que) {
		if(x==null) return;
		if(!que.contains(x.key)) {
			que.enqueue(x.key);
			System.out.println(x.key);
		}
		if(x.left != null) {// && !que.contains(x.left.key)) {
			que.enqueue(x.left.key);
			System.out.println(x.left.key);
		}
		if(x.right != null) {//&& !que.contains(x.right.key)) {
			que.enqueue(x.right.key);
			System.out.println(x.right.key);
		}	
		breadthFirstSearch(x.left, que);
		breadthFirstSearch(x.right, que);		
	}
	
	public void breadthFirstSearchQue(Node current, Queue<Node> que) {
		Node x = current;
		que.enqueue(x);
		while(!que.isEmpty()) {
			Node ch = (Node)que.dequeue();
			if(ch != null)	System.out.print("	"+ch.key);
			if(ch.left != null) 	que.enqueue(ch.left);
			if(ch.right != null) 	que.enqueue(ch.right);
			if(x.left != null)	x=x.left;
		}
	}
	
	/**
	 * 					T
	 * 			R				X
	 * 		B		S				Z
	 * 	A		C					
	 * 				E
	 */
	
	/**
	 * 
	 * 				6
	 * 		4			7
	 * 3			5			8
	 */
	
	
	public void breadthFirstSearchQueue(Node current, Queue<Node> que) {
		if(que.isEmpty()) return;
		Node ch = (Node) que.dequeue();
		if(ch != null)	System.out.print("	"+ch.key);
		if(ch.left != null) 	que.enqueue(ch.left);
		if(ch.right != null) 	que.enqueue(ch.right);
		if(current.left != null)		breadthFirstSearchQueue(current.left, que);
		if(current.right != null)	breadthFirstSearchQueue(current.right, que);
	}
	
	public int getMaxWidth(Node x) {
		int heightOfTree = heightOfTreeHari(x);
		int maxWidth = 0;
		for(int i=1; i<=heightOfTree;i++) {
			int width = getWidth(x, i);
			if(width > maxWidth) {
				maxWidth = width;
			}
		}
		return maxWidth;
	}

	private int getWidth(Node x, int level) {
		if(x == null) return 0;
		if(level == 1) return 1;
		if(level > 1) {
			return getWidth(x.left, level-1) + getWidth(x.right, level-1);
		}
		return 0;
	}
	
	public int getMaxWidthWithoutRec(Node x) {
		int maxWidth =0;
		Queue<Node> que = new Queue<Node>();
		que.enqueue(x); //T
		while(!que.isEmpty()) {
			int count = que.size();  //2 //3 //2
			maxWidth = Math.max(maxWidth, count); 
			while(count-- > 0) {
				Node ch = que.dequeue(); // T //R  //X   //B   //S  //Z
				if(ch.left != null) {
					que.enqueue(ch.left); //R //B	    //A  
				}
				if(ch.right != null) {
					que.enqueue(ch.right); //X //S //Z   //C
				}
			}	
		}	
		return maxWidth;
	}
	
	public int getMaxWidthPreOrder(Node x) {
		int maxWidth = 0;
		int h = heightOfTreeHari(x);
		int count[] = new int[h];
		int level = 0;
		getMaxWidthWithRec(x, count, level);	
		for(int i=0; i < h;i++) {
			maxWidth = Math.max(count[i], maxWidth);
		}
		return maxWidth;
	}

	private void getMaxWidthWithRec(Node x, int[] count, int level) {
		if(x != null) {
			count[level]++;
			getMaxWidthWithRec(x.left, count, level+1);
			getMaxWidthWithRec(x.right, count, level+1);
		}		
	}
	
	 public List<List<Character>> zigzagLevelOrder(Node current) {
		 Node x = current;
		 List<List<Character>> list = new ArrayList<List<Character>>();
		 Deque<Node> deq = new Deque<Node>();
		 deq.addFirst(x);
		 int level = 0;
		 System.out.println();
		 List<Character> inList = new ArrayList<Character>(); 
		 while(!deq.isEmpty()) {	 
			 int count = deq.size(); //1
			 boolean isOddFlag = (level % 2 == 0)?false:true;
			 while(count-- > 0) {
				 Node ch = null; //T		 
				 if(isOddFlag) {
					 ch = deq.removeLast();
					 inList.add(ch.key);
				 }else{
					 ch = deq.removeFirst();
					 inList.add(ch.key);
				 }
				 if(isOddFlag) {	 
					 if(ch.right != null) {
						 deq.addFirst(ch.right); 		 	 
					 }
					 if(ch.left!= null) {
						 deq.addFirst(ch.left); 		 
					 }
				 }else {
					 if(ch.left != null) {
						 deq.addLast(ch.left); 			 
					 }
					 if(ch.right != null) {
						 deq.addLast(ch.right); 
						 	 
					 }
				 }
			 }
			level++;			
		 }
		 list.add(inList);
	     return list;
	 }
	  
	 public int sumOfTree(Node x) {
		return  (x == null)?0:x.value + sumOfTree(x.left) + sumOfTree(x.right); 
	 }
	 
	 public int sumOfTreedModified(Node x) {
		if(x == null) return 0;
		int old_val = x.value;
		x.sumOfNode = sumOfTree(x.left) + sumOfTree(x.right); 
		return old_val + x.sumOfNode;
	}
	 
	private static int minDepth(Node x) {
		if(x == null) return 0;	
		if(x.right == null && x.left == null) return 1;
		if(x.right == null) return minDepth(x.left)+1;
		if(x.left == null) return minDepth(x.right)+1;
		return Math.min(minDepth(x.right), minDepth(x.left))  + 1;
	}
	
	
	private boolean treerec(Node x) {
		if(x == null) return true;
		if(x.right == null && x.left == null) return true;
		if(x.right != null && x.left != null) return treerec(x.right) && treerec(x.left);
		return false;
	}
	
	private void findBinarySubTree() {
		
	}
	
	public Node invertTree(Node x) {
 		if(x == null) return x;
		Node right = invertTree(x.right);
		Node left = invertTree(x.left);
		x.left = right;
		x.right = left;
		return x;
	}	
	
	public Node inverTreeWhile(Node x) {
		if(x == null) return x;
		Queue<Node> que = new Queue<Node>();
		que.enqueue(x);
		Node current = null;
		while(!que.isEmpty()) {
			current = que.dequeue();
			Node temp = current.right;
			current.right = current.left;
			current.left = temp;
			if(current.right != null)	que.enqueue(current.right);
			if(current.left != null)		que.enqueue(current.left);
		}
		return x;
	}
	
	
	//My Attempts Begin
	boolean isExist = false;
	boolean isExists = false;
	public boolean findTargetNrml(Node x, int k) {
		if(x == null) return isExist;
		if(k<0) {k = k+x.value;return findTargetNrml(x.left, k);}
		if(k==0) {isExist = true;return isExist;}
		findTargetNrml(x.left, k);
		int y = x.value;
		k = k-y;
		System.out.println(k);
		findTargetNrml(x.right, k);
		return isExist;
	}
	
	public boolean findTargetTest(Node x, int k) {
		if(x == null) return isExists;
		findTargetTest(x.left, k);
		
		findTargetTest(x.right, k);	
		int val = x.value;
		System.out.println("Left: " + val);
		k = k - val;
		return isExists;
	}	
	//My Attempts End
	
	public boolean findTarget(Node x, int k) {
		Set<Integer> set = new HashSet<Integer>();
		return find(x, k, set);
	}

	private boolean find(Node x, int k, Set<Integer> set) {
		if(x == null)	return false;
		if(set.contains(k - x.value))	return true;
		set.add(x.value);
		System.out.println(set.toString());
		return find(x.left, k, set) || find(x.right, k, set);
	}
	
	public String tree2str(Node x) {
		StringBuilder str = new StringBuilder();
		StringBuilder str1 = new StringBuilder();
		tree2str(x, str1);
		String str2 = str1.toString();
		System.out.println("Before: " + str2);
		for(int i=0;i<str2.length();i++) {
			if(i < str2.length()-1 && (str2.charAt(i) == '(' && str2.charAt(i+1) == ')')) {
				i =i+1;
				continue;
			}else {
				str.append(str2.charAt(i));
			}
		}
		return str.toString();	
	}

	private void tree2str(Node x, StringBuilder str) {
		if(x == null) {str.append("(").append(")");return;}
		str.append(x.value);
		str.append("(");
		tree2str(x.left, str);
		tree2str(x.right, str);
		str.append(")");
	}
	
	//My Attempts
	public Node convertBST(Node x) {
		if(x == null) return x;	
		Node right = convertBST(x.right);
		Node left = convertBST(x.left);
		int leftval = left != null?left.value:0;
		int rightval = right != null?right.value:0;
		int curr = x.value;
		if(left != null) left.value = leftval + curr + rightval;
		x.value = curr + rightval;
		return x;
	}
	
	public Node convertBstQueue(Node x) {
		if(x == null) return x;
		Queue<Node> que = new Queue<Node>();
		que.enqueue(x);
		while(!que.isEmpty()) {
			Node current = que.dequeue();
			if(current != null) {
				int left = current.left != null?current.left.value:0;
				int right = current.right != null?current.right.value:0;
				if(current.left != null) {que.enqueue(current.left);current.left.value = left + current.value + right; }
				current.value = current.value + right;	
				que.enqueue(current.right);
			}
		}
		return x;
	}
	//
	private int sum;
	public Node convertBSTTraversal(Node x) {
		if(x != null) {
			convertBSTTraversal(x.right);
			sum = sum + x.value;
			x.value = sum;
			convertBSTTraversal(x.right);
		}
		return x;
	}
	
	public Node convertBSTStack(Node x) {
		if(x != null) {
			convertBSTTraversal(x.right);
			sum = sum + x.value;
			x.value = sum;
			convertBSTTraversal(x.right);
		}
		return x;
	}
	
	public List<List<Integer>> levelOrderBottom(Node x) {
		if(x == null) return null;
        Queue<Node> que = new Queue<Node>();
        Stack<List<Integer>> stackOfEle = new Stack<List<Integer>>();
        List<List<Integer>> listOfEle = new ArrayList<List<Integer>>();
        que.enqueue(x);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(x.value);
        stackOfEle.push(list1);
        while(!que.isEmpty()) {
        		int count = que.size();
        		List<Integer> list = new ArrayList<Integer>();
        		while(count-- > 0) {
        			Node curr = que.dequeue();
        			if(curr.left != null) {
        				list.add(curr.left.value);
        				que.enqueue(curr.left);
        			}
        			if(curr.right != null) {
        				list.add(curr.right.value);
        				que.enqueue(curr.right);
        			}
        		}
        		stackOfEle.push(list);
        }
        
        for(List<Integer> list : stackOfEle) {
        		listOfEle.add(list);
        }
        return listOfEle;
    }
	private int ans = 0;
	//My Attempt
	public int diameterOfBinaryTree(Node x) {
	    List<Integer> list = new ArrayList<Integer>();
	    int max = 0;
	    diameterOfBinaryTree(x, list, max);
	    depth(x);
	    return ans -1;
	}

	private int diameterOfBinaryTree(Node x, List<Integer> list, int max) {
		if(x == null) return max;	
		diameterOfBinaryTree(x.left, list, max);
		list.add(x.value);
		diameterOfBinaryTree(x.right, list, max);	
		if((list.size()-1) > max) {max = list.size()-1;}
		return max;
	}
	//
	private int depth(Node x) {
		if(x == null) return 0;
		int L = depth(x.left);
		int R = depth(x.right);
		ans = Math.max(ans, L + R + 1);
		return Math.max(L, R) + 1;
	}
	
	public Node sortedArrayToBST(int[] nums) {
		
		return root;     
    }
}
