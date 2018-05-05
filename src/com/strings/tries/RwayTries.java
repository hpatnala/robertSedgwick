package com.strings.tries;

public class RwayTries<Value> {
	
	private Node root;
	private static int R=256;
	
	private static class Node{
		private Object val;		
		private Node next[] = (Node[])new Node[R];
	}
	
	public static void main(String[] args) {
		
	}
	
	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		if(x==null) x = new Node();
		if(d==key.length()) { x.val = val; return x; }
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}

	@SuppressWarnings("unchecked")
	private Value get(String key) {
		Node x = get(root, key, 0);
		if(x==null) return null;
		return (Value)x.val;
	}

	private Node get(Node x, String key, int d) {
		if(x==null) return null;
		if(d==key.length()) return x;
		char c= key.charAt(d);	
		return get(x.next[c], key, d+1);
	}
	
	/*private boolean delete(String key) {
		Node x = delete(root, key, 0);
		return x == null || x.val == null;
	}

	private Node delete(Node x, String key, int d) {
		if(x==null) return null;
		if(d==key.length()) x.val = null;
		char c = key.charAt(d);
		x.next[c] = delete(x.next[c], key, d+1);
		return x;
	}*/

}
