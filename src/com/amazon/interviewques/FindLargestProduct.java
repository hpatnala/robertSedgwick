package com.amazon.interviewques;

public class FindLargestProduct {
	
	public static int largestProduct(int[] arr) {
		int max = 0, minmax =  0;
		for(Integer ele : arr) {
			if(ele>max) {
				minmax = max;
				max = ele;
			}
		}
		return max*minmax;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 2, 6, 8, 3, 4, 9, 2};
		System.out.println(largestProduct(arr));
	}

}
