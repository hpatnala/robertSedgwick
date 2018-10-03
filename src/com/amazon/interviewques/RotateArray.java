package com.amazon.interviewques;

import java.util.Arrays;

public class RotateArray {
	
	static int M = 3, N = 3;
	
	public static void rotateArrayCodingQues(int[][] R) {
		int midI = M/2;
		int midJ = N/2;
		int x = 1, y = N;
		int z = 1, k = M-2, l=N-2, m=0;
		for(int i=0,j=0;i<midI & j<midJ;i++,j++) {
			int temp = R[i][j];
			int prevX = x;
			while(x<M-1) {
				R[x-1][j] = R[x][j];
				x++;
			}
			x = prevX++;
			prevX = z;
			while(z<N) {
				R[y-1][z-1] = R[y-1][z];
				z++;
			}
			z = prevX++;
			prevX = k;
			while(k>=0) {
				R[k+1][y-1] = R[k][y-1];
				k--;
			}
			k = prevX++;
			prevX = l;
			
			while(l>1) {
				R[m][l+1] = R[m][l];
				l++;
			}
			l=prevX++;
			R[i][j+1] = temp;
		}
	}
	
	/**
	 * 1		 2		3
	 * 4		 5		6
	 * 7		 8		9 
	 */
	
	public static void main(String[] args) {
		int[][] mat = { {1, 2,	3},
				  {4	,	 5,		6},
				  {7	,	 8	,	9} };
		rotateArrayCodingQues(mat);
		System.out.println();
		for(int i=0;i<M;i++) {
			for(int j = 0;j<N;j++) {
				System.out.println(mat[i][j]);
			}
		}
	}

}
