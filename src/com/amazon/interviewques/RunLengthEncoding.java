package com.amazon.interviewques;

public class RunLengthEncoding {
	
	public static String lengthEncode(String str) {
		if(str == null || "".equals(str.trim())) 		throw new NullPointerException();
		int count = 1;
		StringBuilder strB = new StringBuilder();	
		char prev = str.charAt(0);
		strB.append(prev);
		for(int i=1;i<str.length();i++) {	
			if(str.charAt(i) != prev) {
				strB.append(count);
				prev = str.charAt(i);
				strB.append(prev);
				count = 1;
			}else if(i == str.length()-1){
				count++;
				strB.append(count);
			}else {
				count++;
			}
		}
		return strB.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(lengthEncode("wwwwaaadexxxxxx"));
	}

}
