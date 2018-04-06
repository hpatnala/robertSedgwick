package com.dsalgo.recursion;

public class Fibonacci {
	private int a;
	private int b;
	
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		fib.setA(0);
		fib.setB(1);
		System.out.print(fib.getA() + " ");
		fib.fibonacci(10);
		System.out.println();
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
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

}
