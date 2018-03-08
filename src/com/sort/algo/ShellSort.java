package com.sort.algo;

import java.time.Duration;
import java.time.Instant;

public class ShellSort {
	int[] array = new int[8];
	
	public static void main(String[] args) {
		ShellSort shellSort = new ShellSort();
		try {
			shellSort.loadData();
			System.out.println("Before Sort");
			shellSort.println();
			System.out.println();
			Instant start = Instant.now();
			shellSort.sort();
			Instant end = Instant.now();	
			System.out.println("Time taken: " + Duration.between(start, end));	
			System.out.println("After Sort");
			shellSort.println();
		}catch(Exception ex) {
			throw ex;
		}
			
	}
	
	private void loadData() {
		int count = 8;
		for(int i=0; i<array.length;i++) {
			array[i] = count;
			count = count-1;
		}
	}
	
	private void println() {
		for(int i=0;i<array.length;i++) {
		}
	}
	
	private void sort(){
		int N = array.length;
		int h = 1;
		while(h > N/3) h = 3*h+1;
		
		while( h > 0) {
			for(int i=h;i<array.length;i++) {
				for(int j=i;j >0;j--) {
					if(array[j] < array[j-h]) {
						int temp = array[j-h];
						array[j-h] = array[j];
						array[j] = temp;				
					}
					
				}
			}
			h = h/3;
		}
	}

}
