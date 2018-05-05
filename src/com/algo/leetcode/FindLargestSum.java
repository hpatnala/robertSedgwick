package com.algo.leetcode;

public class FindLargestSum {

	public static void main(String[] args) {
		int[] array = {2, 20, 1, 9, 3, -39, 10, 12, 7, 6, 8, 29, 25, 4, 19, 5, 15, -40};
		System.out.println("Sum: "+findLargeSum(array)); //29+25 = 54
	}
	
	public static int findLargeSum(int[] array) {
		if(array == null)
			throw new NullPointerException();
		
		int maxOne = 0;
		int maxTwo = 0;	
		for(int i=0;i<array.length;i++) {
			if(array[i] > maxOne) {
				int temp = maxOne;
				maxOne = array[i];
				maxTwo = temp;
			}
			if(array[i] != maxOne && array[i] > maxTwo) {
				maxTwo = array[i];
			}
		}
		System.out.println("Max 1: "+maxOne);
		System.out.println("Max 2: "+maxTwo);
		return maxOne+maxTwo;
	}
}
