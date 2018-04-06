package com.dsalgo.recursion;

public class FactorialOfN {
	private double N;
	
	public static void main(String[] args) {
		FactorialOfN factOfN = new FactorialOfN();
		factOfN.setN(1);
		factOfN.factorial(5);
		System.out.println(factOfN.getN());
	}
	
	private double getN() {
		return N;
	}

	private void setN(int n) {
		N = n;
	}

	private void factorial(int n) {
		if(n<=1) {
			return;
		}
		N = N*(n);
		factorial(n-1);		
	}

}
