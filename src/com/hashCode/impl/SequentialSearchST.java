package com.hashCode.impl;

import edu.princeton.cs.algs4.Queue;

public class SequentialSearchST<Key, Value> {
	
	Node head; //head
	private int m; //number of key value pairs
	
	public class Node{
		Node next;
		Key key;
		Value value;
		
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		
	}

	public void put(Key key, Value value) {	
		for(Node x=head; x != null; x = x.next) {
			if(x.key.equals(key)) {
				x.value = value;
				return;
			}	
		}
		head = new Node(key, value, head);	
	}

	public Value get(Key key) {
		if(head == null) return null;
		for(Node x=head; x != null; x = x.next) {
			if(x.key.equals(key)) {
				return x.value;
			}
		}
		return null;	
	}
	
	public Iterable<Key> keys(){
		Queue<Key> que = new Queue<Key>();
		
		for(Node x = head; x!=null;x = x.next) {
			que.enqueue(x.key);
		}
		return que;
	}

}
