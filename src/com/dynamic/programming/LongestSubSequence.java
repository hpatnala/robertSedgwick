package com.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class LongestSubSequence {
	
	StringBuilder str = new StringBuilder();
	Map<Character, Integer> mapSeq1 = new HashMap<Character, Integer>();
	Map<Character, Integer> mapSeq2 = new HashMap<Character, Integer>();
	
	//Dynamic Way
	public int findLongestCommonSeq(char[] A, char[] B, int m, int n) {	
		int[][] L = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)		L[i][j] = 0;
				else if(A[i-1] == B[j-1]) {	
					L[i][j] = 1 + L[i-1][j-1];
					str.append(A[i-1]);
				}else {
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}	
		return L[m][n];
	}
	
	//My Way
	public String findSequence(String str1, String str2) {
		if(str1 == null || str2 == null) {
			throw new NullPointerException();
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str1.length();i++) {
			if(!mapSeq1.containsKey(str1.charAt(i)))	mapSeq1.put(str1.charAt(i), 1);
			else mapSeq1.put(str1.charAt(i), mapSeq1.get(str1.charAt(i)) + 1);
		}
		for(int i=0;i<str2.length();i++) {
			if(!mapSeq2.containsKey(str2.charAt(i))) {
				mapSeq2.put(str2.charAt(i), 1);
				checkForSeq(sb, str2, i);			
			}
			else {
				mapSeq2.put(str2.charAt(i), mapSeq2.get(str2.charAt(i)) + 1);
				checkForSeq(sb, str2, i);	
			}
		}
		return sb.toString();
	}
	
	public void checkForSeq(StringBuilder sb, String str1, int i) {
		if(mapSeq1.containsKey(str1.charAt(i))) {
			sb.append(str1.charAt(i));
			if(mapSeq1.get(str1.charAt(i)) == 1) {
				mapSeq1.remove(str1.charAt(i));
			}else {
				mapSeq1.put(str1.charAt(i), mapSeq1.get(str1.charAt(i)) -1);
			}
		}	
	}
	
	public static void main(String[] args) {
		LongestSubSequence longSubSeq = new LongestSubSequence();
		long start = System.nanoTime();
		String str = longSubSeq.findSequence("bfee", "befe");
		System.out.println("String is : " + str + " \nThe length is " + str.length());
		long end = System.nanoTime();
		 
		System.out.println(end - start);
		System.out.println();
		System.out.println("Dynamic Way");
		 start = System.nanoTime();
		String S = "bfe";
		String T = "bef";
		char[] A = S.toCharArray();
		char[] B = T.toCharArray();
		System.out.println(longSubSeq.findLongestCommonSeq(A, B, A.length, B.length));
		System.out.println(longSubSeq.str);
		 end = System.nanoTime();
		System.out.println(end-start);
		
	}

}
