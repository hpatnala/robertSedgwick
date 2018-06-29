package com.sort.algo;

import java.util.Arrays;

public class DupilcatesQuickSort {

	public static void main(String[] args) {
		int[] a = {1, 3, 2, 8, 5, 3, 4, 3, 9, 3};
		System.out.println(Arrays.toString(a));
		sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	private static void sort(int[] a, int lo, int hi) {	
		if(a.length <1) {
			throw new NullPointerException();
		}
		if(hi<=lo) return;
		int i=lo;
		int lt=lo;
		int gt=hi;
		int v = a[lo];
		while(gt>=i) {
			if(a[i] <v) {
				swap(a, lt++, i++);
				System.out.println("Inside LT:" + Arrays.toString(a));
			}else if(v < a[i]) {
				swap(a, i, gt--);
				System.out.println("Inside GT:" + Arrays.toString(a));
			}else {
				i++;
			}
		}
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}

	private static void swap(int[] a, int c, int d) {
		int temp = a[c];
		a[c] = a[d];
		a[d] = temp;
	}

}
