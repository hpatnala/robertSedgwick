package com.dsalgo.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	private int a;
	private int b;
	
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		fib.setA(0);
		fib.setB(1);
		System.out.print(fib.getA() + " ");
		fib.fibonacci(20);
		System.out.println();
		System.out.println();
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println();
		System.out.println(fibonacci1(10));
		
	}
	
	private int getA() {
		return a;
	}

	private void setA(int a) {
		this.a = a;
	}

	private void setB(int b) {
		this.b = b;
	}

	private void fibonacci(int n) {
		if(n<=1) {		
			return;
		}
		int temp = b;
		b=a+b;
		a=temp;
		n=n-1;
		System.out.print(a + " ");
		fibonacci(n);	
	}
	
	private static int fib(int n) {
		if(n<=1) {		
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static int fibonacci1(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return fibonacci(n, map);
	}
	
	private static int fibonacci(int n, Map<Integer, Integer> map) {
		if(n == 0 || n==1) {
			return n;
		}
		else if(!map.containsKey(n)) {
			map.put(n, fibonacci(n-1, map) + fibonacci(n-2, map));
		}
		return map.get(n);
	}

}
