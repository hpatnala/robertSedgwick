package com.dynamic.programming;

public class BellNumbers {
	
	private int M = 20;
	private int N = 20;
	long[][] B;
	long prev;
	
	public BellNumbers() {
		B = new long[M][N];
		B[0][0] = 1;
		prev = B[0][0];
	}
	
	public long findBellNum(int n) {	
		if(n==0)
			return 1;
		for(int i=1;i<n;i++) {
			B[i][0] = prev;
			findBell(i, 1);
			/*for(int j=1;j<=i;j++) {
				B[i][j] = B[i][j-1] + B[i-1][j-1];
				prev = B[i][j];
			}*/
		}
		return B[n-1][0];
	}
	
	private void findBell(int i, int j) {
		if(j>i) 	return;
		B[i][j] = B[i][j-1] + B[i-1][j-1];
		prev = B[i][j];
		findBell(i, ++j);
	}
	
	public static void main(String[] args) {
		BellNumbers bellN = new BellNumbers();
		System.out.println(bellN.findBellNum(2));
	}

}
