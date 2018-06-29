package com.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int nums[] = {7, 5, 6, 5, 5, 7, 7, 7};	
		int numsNonRepeat[] = {2, 4, 5, 3, 1, 7};
		System.out.println(Arrays.toString(twoSum(numsNonRepeat, 10)));
		System.out.println(twoSumRepeat(nums, 14));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int a[] = new int[2];    
        for(int i=0;i<nums.length;i++) {		
        		if(!map.containsKey(nums[i])) 
        			map.put(nums[i], i);
   
			int diff = target - nums[i];
        		if(map.containsKey(diff)) {
        			a[0] = i;
        			a[1] = map.get(diff);	
        			return a;
        		}
        }
		return a;
    }
	
	public static boolean twoSumRepeat(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i])+1);
			}		
			int diff = target - nums[i];
			if(map.containsKey(diff))
				return true;
		}
		return false;
	}

}
