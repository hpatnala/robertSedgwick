package com.dynamic.programming;

public class LongestPath {
	
	int M = 3, N = 3;
	
	public void longestPath(int[][] mat) {
		int[][] dp = new int[M][N];
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				dp[i][j] = -1;
		
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				if(dp[i][j] != -1)	findLongestPath(i, j, mat, dp);
	}
	
	private int findLongestPath(int i, int j, int[][] mat, int[][] dp) {
		if(i<0 || j < 0 || i>=M || j>=N)	return 0;
		if(dp[i][j] != -1) return dp[i][j];
		//if(i<M-1 &&  )
		return 0;
	}

	public static void main(String[] args) {
		
	}

}
