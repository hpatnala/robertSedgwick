package com.strings.tries;

public class SubStringSearch {

	public static void main(String[] args) {
	
	}
	
	//can be slow if there a lot of repetitive characters in the input and the pattern
	/**
	 * Pattern - A A A A A A A A B
	 * Input - A A A A A A A A B 
	 */
	public int subStringSearchBruteForce(String pat, String input) {
		int M= pat.length();
		int N= input.length();
		for(int i=0;i<=N-M;i++) {
			for(int j=0;j<M;j++) {
				if(pat.charAt(j) != input.charAt(i+j))
					break;
				if(j==M-1) return i;
			}
		}
		return N;
	}
	
	public int subStringSearchOptimized(String pat, String input) {
		int M= pat.length();
		int N = input.length();
		int i,j;
		for(i=0, j=0;i<N && j<M;i++) {
			if(input.charAt(i) == pat.charAt(j)) {j++;}	
			else		i -=j;
		}
		if(j==M-1) return i-M;
		return N;
	}

}
