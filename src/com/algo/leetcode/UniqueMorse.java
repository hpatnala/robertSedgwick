package com.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorse {
	
	public static int uniqueMorseRepresentation(String[] words) {
		String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....",
				"..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
				"...","-","..-","...-",".--","-..-","-.--","--.."};
	
		Set<String> set = new HashSet<String>();
		for(int i=0;i<words.length;i++) {
			String word = words[i];
			int k=0;
			StringBuilder sb = new StringBuilder();
			while(k < word.length()) {
				sb.append(morse[word.charAt(k) - 'a']);
				k++;
			}
			set.add(sb.toString());
		}
		return set.size();
	}
	
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentation(words));
	}

}
