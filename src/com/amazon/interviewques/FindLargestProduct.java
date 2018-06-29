package com.amazon.interviewques;

public class FindLargestProduct {
	
	public static int largestProduct(int[] arr) {
		int max = 0, minmax =  0;
		int nmax = 0, nminmax = 0;
		for(Integer ele : arr) {
			if(ele>max) {
				minmax = max;
				max = ele;
			}
			
			if(ele < 0 && Math.abs(ele) > max) {
				nminmax = nmax;
				nmax = ele;
			}
			
		}
		return Math.max(max*minmax, nmax*nminmax);
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 2, 6, 8, 3, 4, 9, 2, -11, -14};
		System.out.println(largestProduct(arr));
	}

}
