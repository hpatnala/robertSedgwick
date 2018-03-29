package com.sort.algo;

import java.util.Arrays;

public class HeapSort {
	
	
	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		int[] a = {0, 5, 3, 8, 4, 1, 9, 7, 2, 6, 5};
		heapSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	private void sort(int[] a) {
		if(a!= null && a.length > 0) {
			//creates a balanced tree >> parent greater than children
			int N= a.length-1;
			for(int k= (N/2); k >=1; k-- ) {
				sink(a, k, N);
			}
			System.out.println("Inside Sort: " + Arrays.toString(a));
			//sorts the tree by exchanging and balancing the tree
			while(N>1) {
				exch(a, 1, N--);
				sink(a, 1, N);
			}
		}
	}

	private void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void sink(int[] a, int k, int N) {
		try {
			if(a!= null && a.length > 0) {
				while(2 *k <=N) {
					int j = 2*k;
					if(j<N && less(a, j, j+1)) j = j+1;
					if(!less(a, k, j)) return;
					exch(a, k, j);	
					k = j;
				}
			}
		}catch(Exception ex) {
			throw ex;
		}
	}

	private boolean less(int[] a, int j, int i) {
		return a[j] < a[i];
	}
}
