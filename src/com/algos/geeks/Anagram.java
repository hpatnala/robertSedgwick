package com.algos.geeks;

public class Anagram {

	public static void main(String[] args) {
		int[] str1 = {2, 3, 4, 5};
		int[] str2 = {4, 3, 2};
		verifyAnagram(str1, str2);
	}
	
	public static void verifyAnagram(int[] str1, int[] str2) {
		int res_xor = 0;
		for(int i=0; i<str1.length;i++)		
			res_xor = str1[i] ^ res_xor;			
		for(int i=0; i<str2.length;i++)		
			res_xor = str2[i] ^ res_xor;					
		if(res_xor==0) System.out.println("Anagram");
		else System.out.println("Not Anagram");
	}
}
