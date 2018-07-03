package com.strings.tries;

import edu.princeton.cs.algs4.Queue;

public class TernarySearchTries<Value> {
	
	Node root;
	int n;
	
	private class Node{
		private Value val;
		private char c;
		private Node left, mid, right;
	}
	
	public static void main(String[] args) {
		TernarySearchTries<Integer> tst = new TernarySearchTries<Integer>();
		tst.put("car", 3);
		tst.put("apple", 6);
		tst.put("appeal", 4);
		tst.put("ask", 2);
		tst.put("cab", 1);
		tst.put("babe", 8);
		tst.put("cabbage", 10);
		tst.put("cableways", 12);
		tst.put("cap", 13);
		
		 if (tst.size() < 100) {
	            System.out.println("keys(\"\"):");
	            for (String key : tst.keys()) {
	                System.out.println(key + " " + tst.get(key));
	            }
	            System.out.println();
	     }	 
		 
		 if (tst.size() < 100) {
	            System.out.println("keys(\"\"):");
	            for (String key : tst.keysThatMatch(".p...")) {
	                System.out.println(key + " " + tst.get(key));
	            }
	            System.out.println();
	     }	 
		 
	}
	
	 public Iterable<String> keysThatMatch(String pattern) {
	        Queue<String> queue = new Queue<String>();
	        collect(root, new StringBuilder(), 0, pattern, queue);
	        return queue;
	    }
	 
	    private void collect(Node x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
	        if (x == null) return;
	        char c = pattern.charAt(i);
	        if (c == '.' || c < x.c) collect(x.left, prefix, i, pattern, queue);
	        if (c == '.' || c == x.c) {
	            if (i == pattern.length() - 1 && x.val != null) queue.enqueue(prefix.toString() + x.c);
	            if (i < pattern.length() - 1) {
	                collect(x.mid, prefix.append(x.c), i+1, pattern, queue);
	                prefix.deleteCharAt(prefix.length() - 1);
	            }
	        }
	        if (c == '.' || c > x.c) collect(x.right, prefix, i, pattern, queue);
	    }

	
	private Iterable<String> keys() {
		Queue<String> que = new Queue<String>();
		collect(root, new StringBuilder(), que);
		return que;
	}

	private void collect(Node x, StringBuilder prefix, Queue<String> que) {
		if(x == null) return;
		collect(x.left, prefix, que);
		if(x.val != null)	que.enqueue(prefix.toString() + x.c);
		collect(x.mid, prefix.append(x.c), que);
		prefix.deleteCharAt(prefix.length() -1);
		collect(x.right, prefix, que);
	}

	private int size() {
		return n;
	}

	public void put(String key, Value val) {
		if(!contains(key)) n++;
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		char c= key.charAt(d);
		if(x== null) {x= new Node(); x.c=c;}	
		if(c < x.c) x.left = put(x.left, key, val, d);
		else if(c > x.c) x.right = put(x.right, key, val, d);
		else if(d < key.length()-1) x.mid = put(x.mid, key, val, d+1);
		else x.val = val;
		return x;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}

	public Value get(String key) {
		Node x = get(root, key, 0);
		if(x==null) return null;
		return x.val;
	}

	private Node get(Node x, String key, int d) {
		if(x== null) return null;
		char c = key.charAt(d);
		if(c<x.c) return get(x.left, key, d);
		else if(c>x.c) return get(x.right, key, d);
		else if(d < key.length() -1) return get(x.mid, key, d+1);
		else return x;
	}

}
