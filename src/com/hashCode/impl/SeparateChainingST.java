package com.hashCode.impl;

import edu.princeton.cs.algs4.Queue;

public class SeparateChainingST<Key, Value> {

	private int M;
	SequentialSearchST<Key, Value> st[];
	
	@SuppressWarnings("unchecked")
	public SeparateChainingST(int m){
		this.M = m;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
		for(int i=0; i<st.length;i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}
	
	public int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(Key key, Value value) {
		int i = hash(key);
		if(!contains(key)) {
			st[i].put(key, value);
		}	
	}

	private boolean contains(Key key) {
		return get(key) != null;
	}

	private Value get(Key key) {
		int i = hash(key);
		return (Value)st[i].get(key);
	}
	
	private Iterable<Key> keys(){
		Queue<Key> que = new Queue<Key>();
		for(int i=0; i<M;i++) {	
			for(Key key: st[i].keys()) {
				System.out.println(i);
				que.enqueue(key);
			}
		}
		return que;
	}

	public static void main(String[] args) {
		SeparateChainingST<Integer, Character> st = new SeparateChainingST<Integer, Character>(97);
		for(int i=10;i<156;i++) {
			st.put(i, (char)i);
		}
		
		for(Integer in : st.keys()) {
			System.out.println(in + " - " + st.get(in));
		}
	}

}
