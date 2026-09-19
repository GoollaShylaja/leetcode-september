package com.shylaja.leetcode.arrays.kadanes;

//LeetCode 918. Maximum Sum Circular Subarray -> Kadane's Approach
/*
1. Find totalSum
2. Find maxSum using Kadane
3. Find minSum using Kadane
4. If all numbers are negative: return maxSum
5. circularSum = totalSum - minSum
6. answer = max(maxSum, circularSum)
*/
//Time: O(n)
//Space: O(1)
public class CircularSubarrayMaxSum {

    public static void main(String[] args) {
	
		int[] nums={5,-3,5};
		System.out.println(maxSubarraySumCircular(nums));
	}

    public static int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;
        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;
    
        for (int num : nums) {
    
            // Normal Kadane - maximum subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
    
             // Minimum Kadane - minimum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
    
            totalSum += num;
        }
        // All numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }
        int circularSum = totalSum - minSum;
        return Math.max(maxSum, circularSum);
        }

}
