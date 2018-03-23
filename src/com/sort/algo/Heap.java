package com.sort.algo;

import java.util.Arrays;

public class Heap {

	public int[] getA() {
		return a;
	}

	public void setA(int[] a) {
		this.a = a;
	}

	int[] a = new int[9];
	int N  = 0;
	
	int count = 0;
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(2);
		heap.insert(6);
		heap.insert(5);
		heap.insert(7);
		heap.insert(1);
		heap.insert(3);
		heap.insert(9);
		heap.insert(8);
		System.out.println(Arrays.toString(heap.getA()));
		System.out.println(heap.delMax());
		System.out.println(heap.delMax());
		System.out.println(heap.delMax());
	}
	
	private void swim(int k) {
		while(k >1 && less(k/2, k)) {
			exchange(k, k/2);		
			k= k/2;
		}
	}
		
	private boolean less(int k, int j) {
		return a[k] < a[j];
	}
	
	private void insert(int x) {
		a[++N]  = x;
		swim(N);
	}
	
	private int delMax() {
		int max = a[1];
		exchange(1, N--);	
		sink(1);
		a[N+1] = 0;
		return max;
	}

	private void sink(int k) {	
		while(2*k <= N) {
			int j = 2*k;
			if(j > N && less(j, j+1))
				j++;
			if(!less(k, j)) 
				break; 
			exchange(k, j);	
			k=j;
		}
	}

	private void exchange(int k, int j) {
		int temp = a[k]; 
		a[k] =  a[j];
		a[j] = temp;
	}
	
}
