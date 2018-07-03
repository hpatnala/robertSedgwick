package com.dynamic.programming;

import java.util.Arrays;

public class CatalanNumbers {
	
	long[] catNum = new long[100];
	
	public CatalanNumbers() {
		catNum[0] = 1;
		for(int i=1;i<catNum.length;i++) {
			catNum[i] = -1;
		}
	}
	
	public long findCatalanNum(int n) {
		if(catNum[n] != -1) 	return catNum[n];
		for(int j=0;j<=n;j++) {
			if(catNum[j] == -1) {
				int sum = 0;
				for(int i=0;i<j;i++) {
					sum += catNum[i] * catNum[j-i-1];
				}
				catNum[j] = sum;
			}	
		}
		return catNum[n];
	}
	
	public static void main(String[] args) {
		CatalanNumbers catN = new CatalanNumbers();
		System.out.println(catN.findCatalanNum(8));
		System.out.println(Arrays.toString(catN.catNum));
		System.out.println(catN.findCatalanNum(31));
		System.out.println(Arrays.toString(catN.catNum));
	}

}
