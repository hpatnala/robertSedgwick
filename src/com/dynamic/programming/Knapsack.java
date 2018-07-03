package com.dynamic.programming;

public class Knapsack {
	
	public static int findMaxKnapSack(int[] wt, int[] val, int W, int n) { //W total capacity of knapsack
	//Initialize the K matrix with n elements in the weight matrix and W
		int[][] K = new int[n+1][W+1]; 
		
		for(int i=0;i<=n;i++) {
			for(int w=0;w<=W;w++) {
				//Base case when n = 0 or W = 0
				if(i==0 || w == 0)	K[i][w] = 0;		
			//Maximum of (reduce the no. of elements and reduce the last item weight from the total
			//weight add the reduced element value , and reduce the last item from the capacity)
				else if(wt[i-1] <= w)
					K[i][w] = Math.max(K[i-1][w-wt[i-1]] + val[i-1], K[i-1][w]);
			//if the last item weight is more than w then ignore that item
				else
					K[i][w] = K[i-1][w];
			}
		}
		return K[n][W];
	}
	
	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(findMaxKnapSack(wt, val, W, n));
	}

}
