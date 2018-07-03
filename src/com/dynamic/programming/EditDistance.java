package com.dynamic.programming;

public class EditDistance {
	
	public static int editDistance(String str1, String str2, int m, int n) {
		int[][] L = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0) 	
					L[i][j] = j;
				else if(j==0)	    
					L[i][j] = i;
				else if(str1.charAt(i-1) == str2.charAt(j-1))		
					L[i][j] = L[i-1][j-1];
				else		
					L[i][j] = 1+min(L[i][j-1], L[i-1][j], L[i-1][j-1]);
			}
		}	
		return L[m][n];
	}
	
	private static int min(int i, int j, int k) {
		if(i<=j && i<=k)	return i;
		if(j<=i && j<=k) 		return j;
		else return k;
	}

	public static void main(String[] args) {	
		System.out.println(editDistance("sunday", "saturday", 6, 8));
	}

}
