package com.strings.tries;

public class BoyesMoore {
	private String pat = "NEEDLE";
	private int M = pat.length(); 
	private int R = 256;
	private int right[];
	
	public static void main(String[] args) {
		BoyesMoore moore = new BoyesMoore();
		moore.setArray();
		System.out.println();moore.subStringSearch("ABBBCVVFFNEEDLEYHG");
	}

	public int subStringSearch(String key) {
		int N = key.length();
		int skip=0;
		int i;
		for(i=0;i<=N-M;i+=skip) {
			skip=0;
			for(int j=M-1;j>=0;j--) {
				if(pat.charAt(j) != key.charAt(i+j)) {
					skip = Math.max(1, j-right[key.charAt(i+j)]);
					break;
				}
			}
		}	
		if(skip ==0) return i;
		return N;
	}
	
	public void setArray() {
		right = new int[R];
		for(int c=0;c<R;c++) {
			right[c] = -1;
		}	
		for(int j=0;j<M;j++) {
			right[pat.charAt(j)] = j;
		}
	}
}
