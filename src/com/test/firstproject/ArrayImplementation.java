//Implement Iterator - hasNext() and next()
package com.test.firstproject;

import java.util.Iterator;

public class ArrayImplementation implements Iterator<Object> {
	static int[] drs = new int[6];
	static int count = 1;
	
	public static void main(String[] args) {
		for(int i=0;i<drs.length;i++) {
			drs[i] = count++;
		}		
	}

	@Override
	public boolean hasNext() {	
		return drs.length > 0;
	}

	@Override
	public Object next() {	
		int N = drs.length;
		return drs[--N];
	}
}
