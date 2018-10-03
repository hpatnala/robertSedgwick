package com.begin.coding;

import java.util.HashSet;
import java.util.Set;

/**Question
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */

/**Solution
 * Given: Array [10, 15, 3, 7] and k = 17
 * using set - load values to a set
 * loop a for check whether the array[i] exists in the set
 * check whether difference exists in the set
 */

public class ListOfNum {
	
	public static boolean listOfNum(int[] arr, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(set.contains(k-arr[i])) 
				return true;
			else
				set.add(arr[i]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(listOfNum(new int[] {2, 3, 10, 9}, 19));
	}

}
