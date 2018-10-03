package com.placement.bvrit;

public class BerlandUnivStud {
	
	public static int studentCooking(int[] a, int[] b) {
		int n=0;
		for(int i=0, j=1;i<a.length-1 && j<b.length;i++, j++) {
			if(a[i] + b[j] <= a[i+1]) {
				n++;
			}
		}
		return n;
	}
	
	public static void main(String[] args) {
		int[] a = {0, 10, 20, 30};
		int[] b = {0, 15, 5, 20};
		
		int[] a1 = {0, 88, 77, 66};
		int[] b1 = {0, 15, 25, 35};
		
		int[] a2 = {0, 1, 10, 15};
		int[] b2 = {0, 1, 10, 3};
		
		System.out.println(studentCooking(a, b));
		System.out.println(studentCooking(a1, b1));
		System.out.println(studentCooking(a2, b2));
	}

}
