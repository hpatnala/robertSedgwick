package com.algo.leetcode;

public class HouseRobber {
	
	public int rob(int[] nums){
		if(nums.length == 0)	return 0;
		if(nums.length == 1)	return nums[0];
		//including 1st element 
		for(int i=1;i<nums.length;i++){
			if(i-3>=2)
				nums[i] = nums[i] + Math.max(nums[i-2],nums[i-3]);
			if(i-2>=1)
				nums[i] = nums[i] + nums[i-2];
		}
		//including last element
		for(int i=nums.length-2;i>=0;i--){
			 if(i+3 <nums.length-1)
				 nums[i] = nums[i] + Math.max(nums[i+2],nums[i+3]);
			 if(i+2<nums.length-1)
				 nums[i] = nums[i] + nums[i+2];
		}
		return Math.max(nums[0], nums[nums.length-1]);	
	}
	
	
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int[] a = {1,2,3,1};
		int[] b = {2,7,9,3,1};
		int[] c = {2,1,1,2};
		System.out.println(hr.rob(b));
	}

}
