package com.begin.coding;

import java.util.Arrays;

/**Question
 * Given an array of integers, find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. 
 * The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * You can modify the input array in-place.
 */

public class MissingNumber {
	//modifying the array elements to in place
	public static int findMissingNumber(int[] arr) {
		Arrays.sort(arr);
		for(int i=1;i<arr.length;i++) {
			if(arr[i] != arr[i-1] + 1 && arr[i-1] + 1 >0)
				return arr[i-1] + 1;
		}
		return arr[arr.length -1] + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(findMissingNumber(new int[] {3, 4, -1, 1}));
		System.out.println(findMissingNumber(new int[] {1, 2, 0}));
	}

}
