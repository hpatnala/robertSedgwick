package com.algos.geeks.graphs;

public class Boggle {
	private String[] dictionary = {"GEEKS", "QUIZ", "SEEK", "GUESQ", "FOR"};
	private int M = 3;
	private int N = 3;
	
	private boolean isWord(String str) {
		for(int i=0;i<dictionary.length;i++) 	if(dictionary[i].equals(str))	return true;
		return false;
	}
		
	private void findAdjWords(char[][] boggle, int i, int j, String str, boolean[][] visited) {
		visited[i][j] = true;
		str = str + boggle[i][j]; 
		if(isWord(str))	System.out.println(str); 
		for(int k=i-1;k<=i+1 && k<M;k++) {
			for(int l=j-1;l<=j+1 && l<N;l++) {
				if(k>=0 && l>=0 && !visited[k][l])	
					findAdjWords(boggle, k, l, str, visited);
			}
		}
		if(str.length()-1 >0)	str = (String) str.substring(0, str.length()-2);
		else str = "";
		visited[i][j] = false;	
	}
	
	public void findWords(char[][] boggle) {
		boolean visited[][] = {{false, false, false},
				{false, false, false},
				{false, false, false}};
		String str = "";	
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				findAdjWords(boggle, i, j, str, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Boggle bog = new Boggle();
		char boggle[][] =  {{'G', 'I', 'Z'}, 
						   {'U', 'E', 'K'}, 
						   {'Q', 'S', 'E'}}; 
		bog.findWords(boggle);
		
	}
}
