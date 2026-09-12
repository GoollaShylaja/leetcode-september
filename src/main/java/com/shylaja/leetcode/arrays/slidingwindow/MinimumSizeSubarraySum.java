package com.shylaja.leetcode.arrays.slidingwindow;

//LeetCode 209. Minimum Size Subarray Sum - Sliding Window Approach
/*
Expand → Check → Shrink → Update minimum

Start left = 0, sum = 0.
Move right through the array.
Add nums[right] to sum.
While sum >= target:
Update the minimum window length.
Remove nums[left].
Move left++.
If no valid window exists, return 0.
 
Time: O(n)
Space: O(1)
*/

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
		
		int[] nums={2,3,1,2,4,3};
		int target=7;
		System.out.println(minSubArrayLen(target,nums));
	}
    public static int minSubArrayLen(int target, int[] nums) {

        int left=0;
        int sum=0;
        int minLength=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++)
        {
            sum=sum+nums[right];
            if(nums[right]>=target)
            {
                minLength=1;
                break;
            }
            while(sum>=target)
            {
                minLength=Math.min(minLength,right-left+1);
                sum=sum-nums[left];
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}
