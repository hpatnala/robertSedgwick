package com.sort.algo;

import java.time.Duration;
//Selection sort is better than insertion sort in arranging the complete 
//descending order of an array to ascending order

import java.time.Instant;

public class SelectionSort {
	int array[] = new int[6];
	public static void main(String[] args) {
		SelectionSort selSort = new SelectionSort();
		selSort.loadData();
		System.out.println("Before Sort");
		selSort.println();	
		System.out.println();
		Instant start = Instant.now();
		selSort.sort();
		Instant end = Instant.now();
		System.out.println("Time taken: " + Duration.between(start, end));	
	 	System.out.println("After Sort");
		selSort.println();	
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
	
	private void sort(){
		int min = 0;
		for(int i=0;i<array.length;i++) {
			min = i;
			for(int j=i+1; j<array.length;j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
