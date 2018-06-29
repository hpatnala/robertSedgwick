package com.sort.algo;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = {2, 5, 1, 3, 4, 0};
		System.out.println(Arrays.toString(a));
		quicksort(a);
		System.out.println(Arrays.toString(a));
	}
	
	private static void quicksort(int[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if(hi<=lo) return;
		int j=partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int i=lo;
		int j=hi+1;
		while(true) {
			while(a[++i] < a[lo]) {
				if(i == hi) break;
			}
			
			while(a[lo] < a[--j]) {
				if(j==lo) break;
			}
			
			if(i >= j)	break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}

	private static void swap(int[] a, int c, int d) {
		int temp = a[c];
		a[c] = a[d];
		a[d] = temp;
	}

}
