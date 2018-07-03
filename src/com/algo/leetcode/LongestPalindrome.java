package com.algo.leetcode;

public class LongestPalindrome {
	
	public static String longestPalindrome(String word) { //abacd
		int start = 0, end = 0;
		for(int i=0;i<word.length();i++) {
			int len = expandFromCenter(word, i, i);
			int len1 = expandFromCenter(word, i, i+1);
			int max = Math.max(len, len1);
			if(max > end -start) {
				start = i - (max-1)/2;
				end = i + max/2;		
			}
		}
		return word.substring(start, end+1);
	}
	
	private static int expandFromCenter(String word, int left, int right) {
		int  L = left, R = right;
		
		while(L >= 0 && R < word.length() && word.charAt(R) == word.charAt(L)) {
			System.out.println(R + ": R " + L + ": L");
			L--;
			R++;
		}
		System.out.println(R-L-1);
		return R-L-1;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abc"));
	}

}
