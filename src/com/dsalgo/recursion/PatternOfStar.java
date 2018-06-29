package com.dsalgo.recursion;

public class PatternOfStar {
	private int count = 0;
	
	public static void main(String[] args) {
		PatternOfStar paOfS = new PatternOfStar();
		int countOfStars = 5;
		paOfS.setCount(countOfStars);
		paOfS.starPattern(countOfStars);
	}
	
	private void setCount(int count) {
		this.count = count;
	}

	private void starPattern(int n) {
		if(n<=0) {
			count = count -1;
			return;
		}
		System.out.print("*");
		starPattern(n-1);
		System.out.println();
		starPattern(count);	
	}
}
