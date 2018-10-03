package com.begin.coding;

import java.util.Arrays;

/**Question
* Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
* For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
* 10 = max(10, 5, 2)
* 7 = max(5, 2, 7)
* 8 = max(2, 7, 8)
* 8 = max(7, 8, 7)
* Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */

/**Solution
 * {10, 5, 2, 7, 8, 7} 
 * k = 3
 * load the O(k) space with the numbers in the array
 * pointer i=0 
 * load 
 * find max from the load
 * and repeat until i+2 <length
 */

public class IntegerArray {
	
	public static void arrayOfInt(int[] arr, int k) {
		if(arr == null || arr.length == 0 )
			throw new IllegalArgumentException();
		if(k==0 || k>arr.length)
			throw new IllegalArgumentException();
		
		int[] temArr = new int[arr.length];
		int i=0;
		int w=0;
		while(i+k-1<arr.length) {
			int max = temArr[i];
			int init = 0;
			for(int j=i;j<temArr.length;j++) {
				++init;
				if(max < arr[j])
					max = arr[j];
				if(init == k) 
					break;
			}
			temArr[w++] = max;
			i++;
		}	
		System.out.println(Arrays.toString(temArr));	
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 5, 2, 7, 8, 7};
		arrayOfInt(arr, 3);	
	}

}
