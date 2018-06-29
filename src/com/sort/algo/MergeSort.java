package com.sort.algo;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = {1, 6, 2, 9, 3, 4, 5};
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	private static void sort(int[] a) {
		int aux[] = new int[a.length];
		sort(a, aux, 0, a.length-1);
	}

	private static void sort(int[] a, int[] aux, int lo, int hi) {
		if(hi<=lo)	return;
		int mid= lo+(hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux,mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
	try {
		for(int k=lo;k<=hi;k++) {
			aux[k] = a[k];
		}
		int i=lo;
		int j=mid+1;
		
		for(int k=lo;k<=hi;k++) {
			if(i>mid)	{	
				a[k] = aux[j++]; 
			}else if(j>hi) {
				a[k] = aux[i++];
			}else if(aux[i] < aux[j]) {
				a[k] = aux[i++];
			}else {
				a[k] = aux[j++];
			}
			}
		}catch(Exception ex) {
		throw ex;
	}
}

	public <T> void sort(Comparable<T>[] a, Comparable<T>[] aux, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	@SuppressWarnings("unchecked")
	public <T> void sort(Comparable<T>[] a) {
		Comparable<T>[] aux = (Comparable<T>[])new Object[a.length];
		sort(a, aux, 0, a.length);
	}
	
	
	private <T> void merge(Comparable<T>[] a, Comparable<T>[] aux, int lo, int mid, int hi) {
		for(int i=0;i<aux.length;i++) {
			aux[i] = a[i];
		}
		int k= lo;
		int m = mid+1;
		
		for(int j=0; j<aux.length;j++) {
			if(k > mid) {
				a[j] = aux[m++];			
			}else if(m > hi){
				a[j] = aux[k++];
			}else if(less(aux[k], aux[m])) {
				a[j] = aux[k++];
			}else {
				a[j] = aux[m++];
			}
		}
	}

	private <T> boolean less(T comparable, T comparable2) {
		// TODO Auto-generated method stub
		return false;
	}

}
