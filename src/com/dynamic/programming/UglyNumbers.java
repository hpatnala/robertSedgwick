package com.dynamic.programming;

import java.util.Arrays;

public class UglyNumbers {
		
	int[] uglyNum = new int[200];
	int lastCount;
	
	public UglyNumbers() {
		uglyNum[0]=1;
		for(int i=1;i<uglyNum.length;i++) {
			uglyNum[i] = -1;
		}
		lastCount = 0;
	}
	
	
	public int doDivide(int a, int b) {
		while(a % b == 0) {
			a = a/b;
		}
		return a;
	}
	
	public boolean isUgly(int N) {
		N =	doDivide(N, 2);
		N =	doDivide(N, 3);
		N =	doDivide(N, 5);
		return N==1?true:false;
	}
	
	public int findNthUglyNum(int n) {
		int number = uglyNum[lastCount];
		if(uglyNum[n] == -1) { 
			++number;
			while(n > lastCount) {
				if(isUgly(number)) {
					uglyNum[++lastCount] = number;
					number++;
				}else {
					++number;
				}
			}
		}
		return uglyNum[n-1];
	}
	
	public static void main(String[] args) {
		UglyNumbers un = new UglyNumbers();
		System.out.println(un.findNthUglyNum(20));
		System.out.println(Arrays.toString(un.uglyNum));
		System.out.println(un.findNthUglyNum(31));
		System.out.println(Arrays.toString(un.uglyNum));
	}

}
