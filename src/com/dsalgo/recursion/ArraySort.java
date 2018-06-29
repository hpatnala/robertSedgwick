package com.dsalgo.recursion;

import java.util.HashMap;
import java.util.Map;

public class ArraySort {
	
	public void sort(int[] arr) {
		if(arr != null && arr.length > 0) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int i=0;i<arr.length;i++) {
				if(!map.containsKey(arr[i])) {
					map.put(arr[i], 1);
				}else {
					map.put(arr[i], map.get(arr[i]));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
