package com.dsalgos.strings;

import java.util.Arrays;

public class KeyIndexedCounting {

	public static void main(String[] args) {
		String x = "dafghadabdehldcdfc";	
		char a[] = x.toCharArray();
		int N = a.length;
		char aux[] = new char[N];
		int R = 256;
		int count[] = new int[R+1];

		//incrementing the counter as the 
		for(int i=0;i<N;i++) {
			count[a[i]+1]++;
		}
		
		//Cumulative
		for(int r=0;r<R;r++) {
			count[r+1] +=count[r];
		}
		
		//copying the content in the auxiliary array
		for(int i=0;i<N;i++) {
			aux[count[a[i]]]= a[i];
			count[a[i]]++;
		}
		
		//copying the elements back to the aux array
		for(int i=0;i<N;i++) {
			a[i] = aux[i];
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	

}
