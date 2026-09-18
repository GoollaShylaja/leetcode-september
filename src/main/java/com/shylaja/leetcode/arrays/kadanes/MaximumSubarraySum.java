package com.shylaja.leetcode.arrays.kadanes;

//LeetCode 53. Maximum Subarray -> Kadane's Approach

/* 
1. Keep currentSum for the current subarray.
2. Add each number to currentSum.
3. Update maxSum with the largest sum seen so far.
4. If currentSum < 0, reset it to 0 because a negative sum will only reduce any future subarray sum.
*/

//time: O(n)
// space: O(1)
public class MaximumSubarraySum {

    public static void main(String[] args) {
	
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

    public static int maxSubArray(int[] nums) {

        int maxSum=nums[0];
        int currentSum=0;
        for(int num:nums)
        {
            currentSum=currentSum+num;
            maxSum=Math.max(currentSum,maxSum);
            if(currentSum<0) // kadane's Approach if current is negative update to 0.
            {
                currentSum=0;
            }
        }
        return maxSum;  
    }

}
