package com.dsalgos.mst.helper;

import java.util.Comparator;
import java.util.Iterator;

public class MinPriorityQueue<Key> implements Iterable<Key> {
	private Key[] arr;
	private int count;
	private Comparator<Key> comparator;
	
	@SuppressWarnings("unchecked")
	public MinPriorityQueue(int n) {
		arr = (Key[]) new Object[n+1];
		count = 0;
	}
	
	public void insert(Key v) {
		if(count < arr.length -1) {
			arr[++count] = v;
			swim(count);
		}
	}
	
	private void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			swap(k/2, k);
			k=k/2;
		}
	}

	private void swap(int i, int k) {
		Key temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}

	private boolean less(int i, int j) {
		return comparator.compare(arr[i] , arr[j]) > 1;
	}
	
	public Key delMin() {
		if(count >0) {
			Key min = arr[1];
			swap(1, count--);
			sink(1);
			arr[count+1] = null;
			return min;
		}
		return null;
	}

	private void sink(int k) {
		while(2*k <= count) {
			int j = 2*k;
			if(j < count && less(j, j+1))	j++;
			if(less(j, k))	break;
			swap(j, k);
			k = j;
		}
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public int size() {
		return count;
	}
	
	@Override
	public Iterator<Key> iterator() {
		return new HeapIterator();	
	}
	
	public class HeapIterator implements Iterator<Key>{
		MinPriorityQueue<Key> copy;			
		public HeapIterator() {		
			copy =	new MinPriorityQueue<Key>(size());
			for(int i=0; i<count;i++) {
				copy.insert(arr[i]);
			}
		}
		public boolean hasNext() {return !copy.isEmpty();}
		public Key next() {
			if(!hasNext())	throw new IllegalArgumentException();
			return copy.delMin();		
		}		
	}
	
	public static void main(String[] args) {
		
	}

}
