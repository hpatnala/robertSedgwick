package com.algo.leetcode;

import java.util.StringTokenizer;

public class ReverseWords {
	
	public static String reverseWords(String words) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(words);
		while(st.hasMoreTokens()) {
			String word = st.nextToken();
			sb.append(reverseString(word));
			sb.append(" ");
		}
		return sb.toString();
	}
	
	private static String reverseString(String word) {
		if(word == null) throw new NullPointerException();
		StringBuilder sb = new StringBuilder();
		for(int i=word.length()-1;i>=0;i--) {
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

}
