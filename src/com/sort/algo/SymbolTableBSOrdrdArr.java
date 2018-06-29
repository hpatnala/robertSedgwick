package com.sort.algo;

import java.util.Arrays;

public class SymbolTableBSOrdrdArr {
	
	private char[] keys = new char[10];
	private int[] vals = new int[10];
	private int count = 0;
	
	public static void main(String[] args) {
		SymbolTableBSOrdrdArr arrMap = new SymbolTableBSOrdrdArr();
		arrMap.put('A', 7);
		arrMap.put('G', 4);
		arrMap.put('C', 6);
		arrMap.put('B', 5);
		arrMap.put('E', 8);
		arrMap.put('I', 1);
		arrMap.put('D', 2);
		arrMap.put('H', 3);
		arrMap.put('F', 9);
		arrMap.put('K', 4);
		arrMap.put('F', 5);
	//	arrMap.put('X', 5);
		System.out.println("Keys: " + Arrays.toString(arrMap.keys));
		System.out.println("Values: " + Arrays.toString(arrMap.vals));
		System.out.println("Value of H: " + arrMap.get('H'));
		System.out.println("Value of D: " + arrMap.get('D'));
		System.out.println("Index: " + arrMap.getIndex('D'));
		System.out.println("Contains: " + arrMap.contains('H'));
	}
	
	public int get(char key) {
		if(isEmpty()) return 0;
		int i = rank(key)	;
		if(i <= count && keys[i] == key) return vals[i];
		return -1;
	}	
	
	public boolean isEmpty() {
		return keys.length == 0;
	}
	
	public int getIndex(char key) {
		if(isEmpty()) return 0;
		int i = rank(key)	;
		if(i <= count && keys[i] == key) return i;
		return -1;
	}	
	
	public int rank(char key) {
		int lo=0;
		int hi=count;
		while(lo < hi) {
			int mid= lo + (hi-lo)/2;
			if((int)keys[mid] > (int)key) hi = mid -1;
			else if((int)keys[mid] < (int)key) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	
	public boolean contains(char key) {
		if(isEmpty()) return false;
		return getIndex(key) > 0;
	}
	
	public void put(char key, int value) {
		if(count == keys.length && getIndex(key) <0 ) {
			throw new IllegalArgumentException();
		}
		
		if(count == 0) {
			keys[count] = key;
			vals[count] = value;
			count++;
		}else if(getIndex(key) > 0) {
				int index = getIndex(key);
				vals[index] = value;
		}else {	
			int index = -1;
			boolean needUpdate = false;
			for(int i=0;i<count;i++) {
				if((int)keys[i] > (int)key) {
					needUpdate = true;
					index = i;
					break;
				}
			}
			if(needUpdate) {
				if(count+1 < keys.length) {
					for(int i=count+1; i>=index;i--) {
						keys[i] = keys[i-1];
						vals[i] = vals[i-1];
					}
					
					keys[index] =  key;
					vals[index] = value;
					count++;
				}else {
					throw new IllegalArgumentException();
				}
			}else {
				keys[count] = key;
				vals[count] = value;
				count++;
			}
		}
	}
	
	public int size() {
		return count;
	}
	
	public char[] keySet() {
		return keys;
	}

}
