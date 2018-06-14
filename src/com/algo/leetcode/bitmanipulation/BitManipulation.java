package com.algo.leetcode.bitmanipulation;

public class BitManipulation {
	
	public static int hammingDistance(int x, int y) {
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));
		int z = x ^ y;
		System.out.println("Initial z: " + z);
		int r = 0;
		for(;z>0;z>>=1) {
			r += z & 1;
			System.out.println("After r : " + r);
		}
		return r;
	}
	
	public static int findComplement(int num) {
        int index = Integer.toBinaryString(num).length();
        int powerOfTwo = (int)Math.pow(2, index) - 1;
        int comOfNum = num ^ powerOfTwo;
		return comOfNum;
    }
	
	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
		System.out.println(findComplement(5));
	}

}
