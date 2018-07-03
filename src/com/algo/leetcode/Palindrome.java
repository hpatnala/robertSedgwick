package com.algo.leetcode;

public class Palindrome {
	
	public static boolean verifyPalindrome(String word) {
		boolean isPalindrome = true;
		int i=0, j=word.length()-1;
		while(j>=0) {
			if(i>=j)		break;
			if(word.charAt(i) != word.charAt(j)) {	isPalindrome = false;	break;	}
			i++;
			j--;
		}
		return isPalindrome;
	}
	
	public static void main(String[] args) {
		System.out.println(verifyPalindrome("abacdfg"));
	}

}
