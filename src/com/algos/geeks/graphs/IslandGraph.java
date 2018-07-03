package com.algos.geeks.graphs;

public class IslandGraph {
	
	private static int M = 5;
	private static int N = 5;
	private static int count;
	
	public static int countOfIslands() {
		return count;
	}
	
	public static void findIslands(int[][] mat) {
		boolean[][] visited = new boolean[M][N];
		int[][] id = new int[M][N];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(mat[i][j] != 0 && !visited[i][j]) {
					count++;
					countOfIslands(mat, visited, i, j, id, count);
				}
			}
		}
	} 
	
	private static void countOfIslands(int[][] mat, boolean[][] visited, int i, int j, int[][] id, int count) {
		visited[i][j] = true;
		id[i][j] = count;
		for(int row=i-1;row<=i+1 && row<M;row++) {
			for(int col=j-1;col<=j+1 && col<N;col++) {
				if(row >= 0 && col >= 0 && mat[row][col] != 0 && !visited[row][col]) {
					countOfIslands(mat, visited, row, col, id, count);
				}
			}
		}			 
	}

	public static void main(String[] args) {
		int[][] mat = {{1, 1, 0, 0, 0},
                		   {0, 1, 0, 0, 1},
                		   {1, 0, 0, 1, 1},
                		   {1, 0, 0, 0, 0},
                		   {1, 0, 1, 0, 1}};
		findIslands(mat);
		System.out.println("Number of islands: " + countOfIslands());
		
	}

}
