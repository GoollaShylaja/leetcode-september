package com.shylaja.leetcode.arrays.slidingwindow;

//Leetcode 485. Max Consecutive Ones

/*
windowCount → counts the current consecutive 1s.
When we find 0 → update maxCount and reset windowCount.
The final Math.max(maxCount, windowCount) is important because the array might end with 1s. 
*/
public class MaxConsecutiveOnes {

    public static void main(String[] args) {

		int[] nums = {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(nums));
		
	}
    public static int findMaxConsecutiveOnes(int[] nums) {

        int maxCount = 0;
        int windowCount = 0;
    
        for (int n : nums) {
            if (n == 1) {
                windowCount++;
            } else {
                maxCount = Math.max(maxCount, windowCount);
                windowCount = 0;
            }
        }
        return Math.max(maxCount, windowCount);
    }
}
