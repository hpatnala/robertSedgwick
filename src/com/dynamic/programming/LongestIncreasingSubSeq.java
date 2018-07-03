package com.dynamic.programming;

public class LongestIncreasingSubSeq {
	int count=1, max, prevCount = count;
	
	//Dynamic Way
	public int findIncreasingSubSeq(int[] ar) {
		int max = 0;
		int[] lis = new int[ar.length];
		
		for(int i=0;i<lis.length;i++) {
			lis[i] = 1;
		}
		
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<i;j++) {
				if(ar[i] > ar[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
					if(max < lis[i])		max = lis[i];
				}
			}
		}	
		return max;	
	}
	
	
	//My Way
	public int findIncreasingSubSeq(int[] a, int i) {
		if(i==a.length)	return count;
		if(max < a[i]) {
			++count;
			max = a[i];	
		}	
		return findIncreasingSubSeq(a, ++i);
	}
	
	public int findLongIncSubSeq(int[] a) {
		prevCount = 0;
		for(int i=0;i<a.length;i++) {
			max=a[i];	
			findIncreasingSubSeq(a, i);
			if(prevCount < count) {
				prevCount = count;
			}
			count = 1;
		}
		return prevCount;
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubSeq lis = new LongestIncreasingSubSeq();
		int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
		int ar[] = {50, 3, 10, 7, 40, 80};
		long start = System.nanoTime();
		System.out.println(lis.findLongIncSubSeq(arr));
		long end = System.nanoTime();
		System.out.println(end - start);
		System.out.println(lis.findLongIncSubSeq(ar));
		System.out.println("Dynamic Way");
		start = System.nanoTime();
		System.out.println(lis.findIncreasingSubSeq(ar));
		end = System.nanoTime();
		System.out.println(end - start);
	}

}
