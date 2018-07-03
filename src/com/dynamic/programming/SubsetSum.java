package com.dynamic.programming;

public class SubsetSum {
	
	//Recursive solution
	public static boolean isSubSetSum(int[] arr, int n, int sum) {
		if(sum == 0)
			return true;
		else if(n == 0)
			return false;
		else if(arr[n-1] > sum) 
			return isSubSetSum(arr, n-1, sum);
		return isSubSetSum(arr, n-1, sum - arr[n-1]) || isSubSetSum(arr, n-1, sum);
	}
	
	//Dynamic way
	public static boolean isSubSetSumDp(int[] arr, int n, int sum) {
		boolean subSet[][] = new boolean[n+1][sum+1];
		
		for(int i=0;i<=n;i++)
			subSet[i][0] = true;
		
		for(int j=1;j<=sum;j++)
			subSet[0][j] = false;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(arr[i-1] <= j)
					subSet[i][j] = subSet[i-1][j-arr[i-1]] || subSet[i-1][j];
				else subSet[i][j] = subSet[i-1][j];
			}
		}	
		return subSet[n][sum];
	}
	
	public static void main(String[] args) {
		int arr[] = {3, 34, 4, 12, 5, 2}; 
		int sum = 9;
		System.out.println(isSubSetSum(arr, arr.length, sum));
		System.out.println(isSubSetSumDp(arr, arr.length, sum));
	}

}
