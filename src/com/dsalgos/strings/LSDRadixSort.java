package com.dsalgos.strings;

import java.util.Arrays;

public class LSDRadixSort {
	
	private static int R=256;
	
	public static void main(String[] args) {
		String[] keys = {"cbg", "ghf", "cdfe", "ashhs", "ashaa","deg", "thy", "deh"};
		stringSort(keys);
		System.out.println(Arrays.toString(keys));
	}
	
	public static void stringSort(String[] keys) {
		if(keys == null || keys.length <1) {
			throw new IllegalArgumentException();
		}
		String aux[] = new String[keys.length];
		int W = keys[0].length();
		int M = keys.length;
		for(int d=W-1;d>=0;d--) {
			int count[] = new int[R+1];
			//based on the last digit, the sort starts
			for(int i=0;i<M;i++) {
				count[keys[i].charAt(d)+1]++;
			}
			
			//get the cumulative sum
			for(int r=0;r<R;r++) {
				count[r+1] += count[r];
			}
			
			//copy the elements to the aux array
			for(int i=0;i<M	;i++) {
				aux[count[keys[i].charAt(d)]] = keys[i];
				count[keys[i].charAt(d)]++;
			}
			
			//copy the aux elements back to the main array
			for(int i=0;i<M;i++) {
				keys[i] = aux[i];
			}
		}
		
	}
	
}
