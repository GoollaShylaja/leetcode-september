package com.shylaja.leetcode.arrays.twopinters;

import java.util.Arrays;

//LeetCode 167: Two Sum II – Input Array Is Sorted - Two Pointers approach.

/*
Because the array is sorted:
    Start left at the beginning.
    Start right at the end.
    Iterate while left < right
    Calculate the sum of nums[left]+nums[right].
    If sum == target → return the indices.
    If sum < target → move left++ to get a bigger sum.
    If sum > target → move right-- to get a smaller sum.
 */
// time complexity: O(n)
// space complexity: O(1)
public class TwoSum2InputArraySorted {

    public static void main(String[] args) {
		
		int[] nums={2,7,11,15};
		int target=9;
		System.out.println(Arrays.toString(twoSum(nums,target)));
	}


    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } 
            else if (sum < target) {
                left++;
            } 
            else {
                right--;
            }
        }
        return new int[] {0};
    }
}
