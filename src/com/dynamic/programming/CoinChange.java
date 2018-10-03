package com.dynamic.programming;

public class CoinChange {
	
	public static int findCoinChange(int[] arr, int n, int N) {
		int[] L = new int[N+1];
		L[0] = 0;
		
		//Iterating through the array L
		for(int i=1;i<=N;i++) {
			int max_val = 0;
			//Iterating through the array
			for(int j=0;j<i;j++) {
				max_val = Math.max(max_val, 1+L[i-j-1]);
			}
			L[i] = max_val;
		}	
		return L[N];
	}
	
	public static int findCoinChangeGeeks(int[] arr, int n, int N) {
		int val[] = new int[N+1];
		val[0] = 1;
		
		for(int i=0;i<n;i++) { //1
			for(int j=arr[i];j<=N;j++) { //5
				val[j] = val[j] + val[j-arr[i]]; //
			}
		}
		
		return val[N];
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int n = arr.length;
		int N = 4;
		System.out.println(findCoinChange(arr, n, N));
		int[] arr1 = {2, 5, 3, 6};
		int n1 = arr.length;
		int N1 = 10;
		System.out.println(findCoinChange(arr1, n1, N1));
		System.out.println(findCoinChangeGeeks(arr1, n1, N1));
	}

}
