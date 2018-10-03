package com.dynamic.programming;

public class SubsetSumSpaceOpt {
	
	public static boolean isSubsetSum(int[] arr, int n, int sum) {
		boolean[][] L = new boolean[2][sum+1];
		for(int i=0;i<=n;i++) {
			L[i%2][0] = true;
		}
		return L[1][sum];
	}
	
	public static void main(String[] args) {
		
	}

}
