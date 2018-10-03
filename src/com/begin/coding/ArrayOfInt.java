package com.begin.coding;

import java.util.Arrays;

/**Question
 * Given an array of integers, return a new array such that each element at index i 
 * of the new array is the product of all the numbers in the original array except the one at i.
 * 
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. 
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */

/**Solution
 */

public class ArrayOfInt {
	
	public static int[] arrayOfInt(int[] oldArr) {
		int[] newArr = new int[oldArr.length];
		
		int multi = 1;
		for(int i=0;i<oldArr.length;i++)
			multi = multi * oldArr[i];
		
		for(int j=0;j<newArr.length;j++)
			newArr[j] = multi / oldArr[j];
		
		return newArr;
	}
	
	public static int[] arrayOfInt1(int[] oldArr) { // 1 2 3 4
		int[] newArr = new int[oldArr.length];
		int temp =1;
		for(int i=0;i<newArr.length;i++) 
			newArr[i] = 1;
		
		for(int i=1;i<newArr.length;i++) {
			temp = temp * oldArr[i-1]; //1 //2 //6
			newArr[i] = temp;//1 //2 //6
		}	
		temp =1;
		for(int i=newArr.length-1;i>=0;i--) {
			newArr[i] *= temp; //6 //8 //12 //24
			temp *= oldArr[i]; //4 //12 //24
		}
		return newArr;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayOfInt(new int[]{1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(arrayOfInt1(new int[]{1, 2, 3, 4, 5})));
	}
	
	
}
