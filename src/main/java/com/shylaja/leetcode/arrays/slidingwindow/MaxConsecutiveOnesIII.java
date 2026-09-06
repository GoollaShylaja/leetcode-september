package com.shylaja.leetcode.arrays.slidingwindow;

// 1004. Max Consecutive Ones III
/*
Variable Size Sliding Window
Expand right and count zeros
If zeroCount > k, shrink from left
Keep the window containing at most k zeros
*/

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {

		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
		System.out.println(longestOnes(nums,k));
		
	}

    public static int longestOnes(int[] nums, int k) {
        
        int left=0;
        int zeroIndex=0;
        for(int right=0;right<nums.length;right++)
        {
            if(nums[right]==0)
            {
                zeroIndex++;
            }
            if(zeroIndex>k)
            {
                if(nums[left]==0)
                {
                    zeroIndex--;
                }
                left++;
            }
        }
        return nums.length-left;   
    }
}
