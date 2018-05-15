package com.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class StringLiterature {
	
	public static List<String> retrieveMostlyUsed(String literatureText, List<String> wordsToExclude){
		literatureText.replace(".", " ");
		literatureText.replace("'", " ");
		String[] literature = literatureText.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> listOfStrings = Arrays.asList(literature);
		for(int i=0; i< listOfStrings.size();i++) {
			String temp = listOfStrings.get(i);
			if(wordsToExclude.contains(temp)) {
				continue;
			}else {
				if(!map.containsKey(temp)) {
					map.put(temp.toLowerCase(), 1);
				}else {
					map.put(temp, map.get(temp) + 1);
				}
			}
		}
		
		int max = 0;
		for(String s : map.keySet()) {
			if(max < map.get(s)) {
				max = map.get(s);
			}
		}
		
		for(String s : map.keySet()) {
			if(max == map.get(s)) {
				System.out.println(s);
			}
		}
		
		System.out.println();
		return null;
	}
	
	public static List<String> retrieveMostlyUsedStringToken(String literatureText, List<String> wordsToExclude){
		StringTokenizer tokens = new StringTokenizer(literatureText, " ");
		Map<String, Integer> map = new HashMap<String, Integer>();	
		while(tokens.hasMoreTokens()) {
			boolean isRegex = false;
			String temp = tokens.nextToken();
			
			if(wordsToExclude.contains(temp.toLowerCase())) {
				isRegex = true;
			}
			
			if(temp.charAt(temp.length() -1) == '.') {
				temp = temp.substring(0, temp.length() -1);
			}	
			if(temp.charAt(temp.length() - 2) == '\'') {
				isRegex = true;
				temp = temp.replace("'", " ");
				StringTokenizer token = new StringTokenizer(temp, " ");
				while(token.hasMoreTokens()) {
					String temp1 = token.nextToken();
					if(wordsToExclude.contains(temp1.toLowerCase())) {
						isRegex = false;
					}
					if(isRegex) {
						if(!map.containsKey(temp1.toLowerCase())) {
							map.put(temp1.toLowerCase(), 1);
						}else {
							map.put(temp1.toLowerCase(), map.get(temp1.toLowerCase()) + 1);
						}
					}
					isRegex = true;
				}
			}
			System.out.println(temp);
			if(!isRegex) {
				if(!map.containsKey(temp.toLowerCase())) {
					map.put(temp.toLowerCase(), 1);
				}else {
					map.put(temp.toLowerCase(), map.get(temp.toLowerCase()) + 1);
				}
			}
		}		
		int max = 0;
		for(String s : map.keySet()) {
			if(max < map.get(s)) {
				max = map.get(s);
			}
		}
		System.out.println();
		for(String s : map.keySet()) {
			if(max == map.get(s)) {
				System.out.println(s);
			}
		}
		System.out.println(map.toString());
		return null;	
	}
	
	public static void main(String[] args) {
		String literature = "Rose is a flower. Red rose is a flower";
		String literature1 = "Jack and Jill went to the market to buy bread and cheese. "
				+ "Cheese is Jack's and Jill's favorite food";
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		list.add("is");
		list.add("are");
		list.add("a");
		list.add("and");
		list.add("to");
		list.add("the");
	//	list.add("jack");
	//	list.add("jill");
	//	retrieveMostlyUsed(literature, list);
		retrieveMostlyUsedStringToken(literature1, list);
	}

}
