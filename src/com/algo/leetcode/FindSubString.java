package com.algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubString {

	public static void main(String[] args) {
		String[] words = {"foo", "bar", "xyz", "def"};
		String s = "barfooxyzdtbarfooxyzdefman";
		subString(s, words);
	}
	
	private static void subString(String s, String[] words) {
		if(words.length == 0 || s.equals(null) || ( s!= null && s.length() == 0)) {
			throw new NullPointerException();
		}
		List<String> listOfWrds = Arrays.asList(words);
		Set<Integer> listOfInts = new HashSet<Integer>();
		if(listOfWrds.size() > 0) {
			int a=0;	
			int lenOfWrd = words[0].length();
			int b=lenOfWrd;	
			while(b < s.length() && a < s.length()) {
				String s1 = s.substring(a, b);
				if(listOfWrds.contains(s1)){
					int count=1;
					int i=b;
					while(i+lenOfWrd< s.length()) {
						if(listOfWrds.contains(s.substring(i, i+lenOfWrd).trim())) {
							++count;
							if(count == listOfWrds.size()) {
								listOfInts.add(a);
								a=i+lenOfWrd;
								b=a+lenOfWrd;
								break;
							}
							i= i+lenOfWrd;
						}else {
							a=i;
							b=i+lenOfWrd;
							break;
						}			
					}
				}else {
					a++;
					b++;
				}				
			}
		}
		System.out.println(listOfInts.toString());
	}
}
