package com.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		int sum = 0;
		for(int i=0;i<triangle.size();i++) {
			List<Integer> list = triangle.get(i);
			int min = list.get(0);
			minimumTotal(list, 0, min);
		}
		return sum;
	}
	
	public static int minimumTotal(List<Integer> list, int i, int min) {
		if(min < list.get(i)) {min = list.get(i); return min;}
		return minimumTotal(list, i++, min);
	}
	
	/**
	 * [ [2],
   	    [3,4],
       [6,5,7],
      [4,1,8,3] ]
	 */
	
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		lists.add(list);
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		lists.add(list);
		list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(7);
		lists.add(list);
		list = new ArrayList<Integer>();
		list.add(4);
		list.add(1);
		list.add(8);
		list.add(3);
		lists.add(list);
		System.out.println(minimumTotal(lists));
	}

}
