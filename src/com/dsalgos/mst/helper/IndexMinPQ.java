package com.dsalgos.mst.helper;

import java.util.Iterator;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
	
	private int maxN;
	private int n;
	private int[] pq;
	private int[] qp;
	private Key[] keys;
	
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int maxN) {
		if(maxN < 0) throw new IllegalArgumentException();
		this.setMaxN(maxN);
		n=0;
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		keys = (Key[])new Comparable[maxN + 1];
		for(int i=0;i<maxN;i++) {
			qp[i] = -1;
		}
	}
	
	public boolean contains(int i) {
		return qp[i] != -1;
	}
	
	public int size() {
		return n;
	}
	
	public void insert(int i, Key key) {
		n++;
		qp[i] = n;
		pq[n] = i;
		keys[n] = key;
		swim(n);
	}

	private void swim(int k) {
		while(k > 0 && greater(k/2 ,k)) {
			exch(k/2, k);
			k = k/2;
		}
	}

	private boolean greater(int i, int k) {
		return keys[pq[i]].compareTo(keys[pq[k]]) > 0;
	}

	public boolean isEmpty() {		
		return n==0;
	}
	
	public int minIndex() {
		return pq[1];
	}
	
	public Key minKey() {
		return keys[pq[1]];
	}

	public int delMin() {		
		if(pq.length == 0) throw new IllegalArgumentException();
		int min = pq[n];
		exch(1, n--);
		sink(1);
		qp[n] = -1;
		pq[n+1] = -1;
		keys[n+1] = null;
		return min;
	}

	private void exch(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	private void sink(int k) {
		if(n >0) {
			while(2*k <= n) {
				int j = 2*k;
				if(j < n && greater(j, j+1)) j++;
				if(greater(j, k)) break;
				exch(j, k);
				k = j;
			}
		}
	}
	
	public Key keyOf(int i) {
		return keys[i];
	}
	
	public void changeKey(int i, Key key) {
		keys[i] = key;
		swim(qp[i]);
		sink(qp[i]);
	}
	
	public void change(int i, Key key) {
		changeKey(i, key);
	}
	
	public void decreaseKey(int i, Key key) {
		keys[i] = key;
		swim(qp[i]);
	}
	
	public void increaseKey(int i, Key key) {
		keys[i] = key;
		sink(qp[i]);
	}
	
	public void delete(int i) {
		int index = qp[i];
		exch(index, n--);
		swim(index);
		sink(index);
		qp[i] = -1;
		keys[i] = null;		
	}

	@Override
	public Iterator<Integer> iterator() {
		return null;
	}
	
	public static void main(String[] args) {
		
	}

	public int getMaxN() {
		return maxN;
	}

	public void setMaxN(int maxN) {
		this.maxN = maxN;
	}

}
