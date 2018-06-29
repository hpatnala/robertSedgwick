package com.sort.algo;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class Selection {

	public static void main(String[] args) {
		//k= 0 : Min ; k=N-1 : Max ; k= N/2 : Median
		int a[] = {2, 4, 1, 8, 3, 7, 6};
		System.out.println(select(a, 4));
	}

	private static int select(int[] a, int k) {
		if(k >= a.length) {
			throw new NoSuchElementException();
		}
		if(a.length >0) {
			StdRandom.shuffle(a);
			int lo=0;
			int hi=a.length-1;
			while(hi > lo) {	
				int j = partition(a, lo, hi);
				if(j < k) 			lo=j+1;
				else if(j > k) 		lo=j-1;
				else		return a[k];
			}
			return a[k];
		}
		return 0;
	}

	private static int partition(int[] a, int lo, int hi) {
		int i=lo;
		int j=hi+1;
		while(true) {
			while(a[++i] < a[lo])
				if(i==hi) break;
			while(a[lo] < a[--j])
				if(j==lo)	break;
			
			if(i >=j) break;
			swap(a, i, j);		
		}
		swap(a, lo, j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
