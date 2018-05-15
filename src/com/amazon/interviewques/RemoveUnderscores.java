package com.amazon.interviewques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveUnderscores {
	
	//Using extra data structure
	public static void removeUnderScoresInArrayWithDS(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != '_') {
				list.add(arr[i]);
			}
		}
		System.out.println(list.toString());
	}
	
	//similar to quick sort
	public static void removeUnderScoresInArrayWithoutDS(int[] arr, int lo, int hi) {
		if(hi<=lo) return;
		removeUnderScoresInArray(arr, lo, hi);
		System.out.println(Arrays.toString(arr));
	}
	
	private static int removeUnderScoresInArray(int[] arr, int lo, int hi) {
		int i= lo;
		int j= hi;
		while(true) {
			while(arr[i] != '_') {
				i++;
			}
			while(arr[j] == '_') {
				j--;
			}
			if(i>=j) break;
			swap(arr, i, j);
		}	
		return i;
	}
	
	private static void swap(int[] arr, int i, int j) {
		arr[i]=arr[j];
		arr[j]='_';
	}
	
	//without using extra data structure
	public static void removeUnderScoresInArrayWithoutDSSingleFor(char[] arr) {
		int j = arr.length -1;
		for(int i=0;i<arr.length;i++) {
			if(i>=j) break;
			if(arr[j] == '_') j--;
			if(arr[i] == '_') swap(arr, i, j);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private static void swap(char[] arr, int i, int j) {
		arr[i]=arr[j];
		arr[j]='_';
	}
	
	public static void main(String[] args) {
		int[] arr = {2, '_', 3,'_', 7, 8, '_', '_', 8, 9, '_' };
		char[] charArr =  {'2', '_', '3','_', '7', '8', '_', '_', '8', '9', '_' };
		removeUnderScoresInArrayWithDS(arr);
		removeUnderScoresInArrayWithoutDS(arr, 0, arr.length-1);
		removeUnderScoresInArrayWithoutDSSingleFor(charArr);
	}

}
