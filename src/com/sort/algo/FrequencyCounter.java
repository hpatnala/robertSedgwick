package com.sort.algo;

import edu.princeton.cs.algs4.StdIn;

public class FrequencyCounter {

	public static void main(String[] args) {
		SymbolTableBSOrdrdArr st = new SymbolTableBSOrdrdArr();
		System.out.println("Please enter some Characters without spaces");
		System.out.println();
		int max = 0;
		String str = StdIn.readLine();
		char[] chars = str.toCharArray();
		char maxChar = ' ';
		
		//Load the map with the input
		int i=0;
		while(i < chars.length) {
			if(st.contains(chars[i])) {
				st.put(chars[i], st.get(chars[i]) + 1);
			}else {
				st.put(chars[i], 1);
			}
			i++;
		}
		
		//find the max occurrence
		for(Character key : st.keySet()) {
			if(st.get(key) > max) {
				max = st.get(key);
				maxChar = key;
			}
		}
		
		System.out.println("Max Occurrence Character: " + maxChar);
	}
	
		

}
