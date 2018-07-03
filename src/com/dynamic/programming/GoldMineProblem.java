package com.dynamic.programming;

public class GoldMineProblem {
	
	private static final int M = 4, N = 4;
	int[][] goldTable = new int[M][N];
	int max = 0;
	int sum;
	
	//Dynamic Way
	public int findMaxGold(int[][]mat) {
		goldTable = mat;
		int rightUp = 0;
		int rightDown = 0;
		int right = 0;
		for(int col=N-1;col>=0;col--) {
			for(int row=0;row<M;row++) {
				right = (col == N-1)?0:goldTable[row][col+1];
				rightUp = (col==N-1 || row == 0)?0:goldTable[row-1][col+1];
				rightDown = (col==N-1 || row == N-1)?0:goldTable[row+1][col+1];
				
				goldTable[row][col] = goldTable[row][col] + Math.max(right, Math.max(rightUp, rightDown));
			}
		}
		
		int max = 0;
		for(int row=0;row<M;row++) {
			if(max<goldTable[row][0])	max = goldTable[row][0];
		}
		
		return max;
	}
	
	//My Way
	public void maxGoldMine(int[][] mat, int i, int j) {
		if(j==N-1) {
			return;
		}
		int row = i;
		int col = j;
		int max = 0;
		if(i-1 >= 0 && j+1 < N) {
			if(max < mat[i-1][j+1]) {
				max = mat[i-1][j+1];
				row = i-1;
				col = j+1;
			}
		}
		if(j+1 < N) {
			if(max < mat[i][j+1]) {
				max = mat[i][j+1];
				row = i;
				col = j+1;
			}
		}
		if(i+1 < M && j+1 < N) {
			if(max < mat[i+1][j+1]) {
				max = mat[i+1][j+1];
				row = i+1;
				col = j+1;
			}
		}
		sum = sum + mat[row][col];
		maxGoldMine(mat, row, col);
	}
	
	public int findMaxGoldMine(int[][] mat) {
		
		for(int i=0;i<M;i++) {
			sum = mat[i][0];
			maxGoldMine(mat, i, 0);
			if(max < sum)	max = sum;
		}
		return max;
	}
	
	public static void main(String[] args) {
		GoldMineProblem gmp = new GoldMineProblem();
		int[][] mat = {{10, 33, 13, 15},
                		   {22, 21, 04, 1},
                		   {5, 0, 2, 3},
                		   {0, 6, 14, 2}};
		long start = System.nanoTime();
		System.out.println(gmp.findMaxGoldMine(mat));
		long end = System.nanoTime();
		System.out.println(end-start);
		System.out.println();
		
		System.out.println("Dynamic Way");
		
		System.out.println();
		start = System.nanoTime();
		System.out.println(gmp.findMaxGold(mat));
		end = System.nanoTime();
		System.out.println(end-start);
	}

}
