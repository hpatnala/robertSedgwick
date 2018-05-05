package com.dsalgos.strings;

import java.util.Arrays;

//disadvantage - as it uses extra space of count

public class MSDRadixSort {
	
	private static int R = 256;
	
	public static void main(String[] args) {
		String a[] = {"asdfggh", "asdfg"};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(String[] a) {
		String aux[] = new String[a.length];
		sort(a, aux, 0, a.length-1, 0);
	}
	
	private static void sort(String[] a, String[] aux, int lo, int hi, int d) {
		if(hi<=lo) return;
		int count[] = new int[R+2];
		for(int i=lo;i<=hi;i++) {
			count[charAt(a[i], d) +2]++;
		}
		for(int r=0;r<R+1;r++) {
			count[r+1] +=count[r];
		}
		for(int i=lo;i<=hi;i++) {
			aux[count[charAt(a[i], d)+1]] = a[i];
			count[charAt(a[i], d)+1]++;
		}
		for(int i=lo;i<=hi;i++) {
			a[i] = aux[i-lo];
		}
		
		for(int r=0; r<R;r++) {
			sort(a, aux, lo+count[r], lo+count[r+1]-1, d+1);
		}
			
	}
	
	public static int charAt(String s, int d) {
		if(d<s.length()) return s.charAt(d);
		return -1;
	}

}
