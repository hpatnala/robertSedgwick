package com.algo.leetcode;

public class RobHouse1 {
	
	public int robHouseAdj(int[] a) {
		int res[] = robH(a, 0, a.length);
		return Math.max(res[0], res[1]);
	}

	private int[] robH(int[] a, int i, int j) {
		if(i+2 > j)	return null;
		int odd[] = robH(a, i+2, j);
		i++;
		int even[] = robH(a, i+2, j);
		return odd;
	}

	private int robHFor(int[] a) {
		if(a.length == 0) 	return 0;
		if(a.length == 1)	return a[0];
		int max = 0;
		for(int i=0;i<a.length;i++) {
			if(i-3>=0) {
				a[i] += Math.max(a[i-2], a[i-3]);
			}else if(i-2>=0) {
				a[i] += a[i-2];
			}
			
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	public void robH2(int[] nums) {
		int max = 0;
		boolean start = false, end = false;
		for(int i=0;i<nums.length;i++) {
			if(i-3 >=0) {
				nums[i] += Math.max(nums[i-2], nums[i-3]);
				if(i == 2 && nums[i-2] > nums[i-3])	start = true;
				else if(i == 3 && nums[i-3] > nums[i-2])	start = true;
				else if(i ==  nums.length-1) 	end = true;
				
				if(start && end) {
					nums[i] -= Math.min(nums[0], nums[nums.length-1]);
				}
			}else if(i-2 >=0) {
				nums[i] += nums[i-2];
				if(i == 2)	start = true;
				else if(i ==  nums.length-1) 	end = true;
				if(start && end) {
					nums[i] -= Math.min(nums[0], nums[nums.length-1]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		RobHouse1 ro = new RobHouse1();
		int[] a = {1,2,3,1};
		int[] b = {2,7,9,3,1};
		int[] c = {2,1,1,2};
		System.out.println(ro.robHFor(a));
		System.out.println(ro.robHFor(b));
		System.out.println(ro.robHFor(c));
	}

}
