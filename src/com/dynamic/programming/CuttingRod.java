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
	
	static int cutRod(int price[],int n)
    {
        int val[] = new int[n+1];
        val[0] = 0;
 
        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val, 
                                   price[j] + val[i-j-1]);
            val[i] = max_val;
        }
 
        return val[n];
    }
	
	public static void main(String[] args) {
		int[] val = {1, 5, 8, 9, 10, 17, 17, 20};
		int[] len = { 1, 2, 3, 4, 5, 6, 7, 8};
		int price = 8;
		int n = 8;
		System.out.println(cutRod(len, val, price, n));
		System.out.println(cutRod(val, 8));
	}

}
