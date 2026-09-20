package com.shylaja.leetcode.arrays.kadanes;

//LetCode 1749. Maximum Absolute Sum of Any Subarray -> Kadane's Approach

/*
Initialize currentMaxSum = 0
Initialize currentMinSum = 0
For each num:
Update maximum Kadane
Update minimum Kadane
Track maxSum and minSum
Return Math.max(maxSum, Math.abs(minSum))
*/

//Time: O(n)
//Space: O(1)

public class MaximumAbsoluteSumOfAnySubarray {

    public static void main(String[] args) {
	
		int[] nums={1,-3,2,3,-4};
		System.out.println(maxAbsoluteSum(nums));
	}
    public static int maxAbsoluteSum(int[] nums) {

        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int currentMaxSum=0;
        int currentMinSum=0;
        for(int num:nums)
        {
            // Maximum subarray sum
            currentMaxSum += num;
            currentMaxSum = Math.max(currentMaxSum, 0);
            maxSum = Math.max(maxSum, currentMaxSum);
    
            // Minimum subarray sum
            currentMinSum += num;
            currentMinSum = Math.min(currentMinSum, 0);
            minSum = Math.min(minSum, currentMinSum);
        }
        return Math.max(maxSum,Math.abs(minSum));
    }

}
