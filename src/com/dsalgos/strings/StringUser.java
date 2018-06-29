package com.dsalgos.strings;

public class StringUser {
	 
	private char[] value;
	private int offset;
	private int hash;
	private int length;
	
	private StringUser (int offset, int length, char[] value) {
		this.offset = offset;
		this.length = length;
		this.value = value;
	}
	
	public static void main(String[] args) {
		StringUser str = new StringUser(0, 4, new char[]{'a', 's', 'd', 'f'});
		System.out.println(str.reverse(str));
	}
	
	public int lcp(String s, String r) {
		int N = Math.min(s.length(), r.length());
		for(int i=0;i<N;i++) {
			if(s.charAt(i) != r.charAt(i)) {
				return i;
			}
		}
		return N;
	}

	public char charAt(int i) {	
		return value[i+offset];
	}
	
	public int length() {
		return length;
	}
	
	public StringUser subString(int from, int to) {
		return new StringUser(offset + from, to-from, value);
	}
	
	public String reverse(StringUser s) {
		StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1;i>=0;i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}
}
