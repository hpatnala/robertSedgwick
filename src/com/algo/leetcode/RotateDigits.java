package com.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RotateDigits {
	
	public  int rotateDigits(int N) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(8, 8);
		map.put(2, 5);
		map.put(5, 2);
		map.put(6, 9);
		map.put(9, 6);
		
		for(int i=1;i<=N;i++) {
			int number = i; //24
			int newNumber = 0;
			int m=1;
			while(number > 0) {
				int digit = number % 10; //4
				if(map.containsKey(digit)) {
					newNumber = map.get(digit) * m + newNumber;
					number = number /10; //2
					m = m*10;
				}else {
					break;
				}
			}
			
			if(number==0 && i != newNumber) {
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		RotateDigits rt = new RotateDigits();
		System.out.println(rt.rotateDigits(25));
	}

}
