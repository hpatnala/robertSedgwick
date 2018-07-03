package com.dynamic.programming;

import java.util.Arrays;

public class Fibonacci {
	
	int[] fibArr = new int[100];
	
	public Fibonacci() {
		fibArr[0] = 0;
		fibArr[1] = 1;
	}
	
	public int fib(int n) {
		if(n <= 1) {
			return n;
		}else if(fibArr[n] > 0) {
			return fibArr[n];
		}
		return fibArr[n] = fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.fib(4));
		System.out.println(Arrays.toString(fib.fibArr));
	}

}
