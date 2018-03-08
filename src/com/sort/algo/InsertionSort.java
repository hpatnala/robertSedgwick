//Insertion sort has better performance for half sorted array - less exchanges and comparisons

package com.sort.algo;

import java.time.Duration;
import java.time.Instant;

public class InsertionSort {
	int array[] = new int[6];
	
	public static void main(String[] args) {
		InsertionSort insertSort = new InsertionSort();
		try {
			insertSort.loadData();
			System.out.println("Before Sort");
			insertSort.println();
			System.out.println();
			Instant start = Instant.now();
			insertSort.sort();
			Instant end = Instant.now();	
			System.out.println("Time taken: " + Duration.between(start, end));	
			System.out.println("After Sort");
			insertSort.println();
		}catch(Exception ex) {
			throw ex;
		}
	}
	

	private void loadData() {
		int count = 7;
		for(int i=0; i<array.length;i++) {
			array[i] = count;
			count = count-1;
		}
	}
	
	private void println() {
		for(int i=0;i<array.length;i++) {
			System.out.print(" " + array[i]);
		}
	}
	
	private void sort() {
		if(array != null && array.length > 0) {
			for(int i=0;i < array.length;i++) {
				for(int j=i;j>0;j--) {
					if(array[j] < array[j-1]) {
						int temp = array[j];
						array[j] = array[j-1];
						array[j-1] = temp;
					}
				}
			}
		}
	}

}
