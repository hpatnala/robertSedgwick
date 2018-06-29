package com.dsalgos.strings;

import java.util.Arrays;

public class ThreeWayStrQuickSort {

	public static void main(String[] args) {
		String a[] = {"she", "shells","seashells", "at", "the", "seashore", "sea"};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(String[] a) {
		sort(a, 0, a.length-1, 0);
	}

	private static void sort(String[] a, int lo, int hi, int d) {
		if(hi<=lo) return;
		int i=lo+1;
		int lt=lo;
		int gt=hi;
		int v=charAt(a[lo], d);
		while(gt>=i){
			int t=charAt(a[i], d);
			if(t<v) {
				exch(a, lt++, i++);
				System.out.println("Inside LT:" + Arrays.toString(a));
			}
			else if(t>v) {
				exch(a, i, gt--);
				System.out.println("Inside GT:" + Arrays.toString(a));
			}
			else {
				i++;
			}
		}
		sort(a, lo, lt-1, d);
		if(v>=0) sort(a, lt, gt, d+1);
		sort(a, gt+1, hi, d);
	}

	private static void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int charAt(String s, int d) {
		if(d<s.length()) return s.charAt(d);
		return -1;
	}

}
