package com.dynamic.programming;

public class CuttingRod {
	
	public static int cutRod(int[] len, int[] val, int price, int n) {
		int[][] R = new int[n+1][price + 1];
		for(int i=0;i<=n;i++) {
			for(int p=0;p<=price;p++) {
				if(i==0 || p==0)
					R[i][p] = 0;
				else if(len[i-1] <=p)
					R[i][p] = Math.max(val[i-1] + R[i][p-len[i-1]], R[i-1][p]);
				else
					R[i][p] = R[i-1][p];
			}
		}
		return R[n][price];
	}
	
	public static void main(String[] args) {
		int[] val = {1, 5, 8, 9, 10, 17, 17, 20};
		int[] len = { 1,   2 ,  3,   4 ,  5,   6 ,  7 ,  8};
		int price = 8;
		int n = 8;
		System.out.println(cutRod(len, val, price, n));
	}

}
