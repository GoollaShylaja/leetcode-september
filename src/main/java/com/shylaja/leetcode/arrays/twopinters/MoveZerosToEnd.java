package com.shylaja.leetcode.arrays.twopinters;

import java.util.Arrays;
// Two pointers - left and right
// left: pointer to the first index 0 and take care of non-zero element position to swap with zero
// right: pointer to the first index of 0
// if nums[right]!=0, swap nums[left] and nums[right], increment left
// increment right
// repeat until right>=nums.length

// time complexity: O(n)
// space complexity: O(1)
public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public static void moveZeroes(int[] nums)
    {
        int left=0;
        for(int right=0;right<nums.length;right++)
        {
            if(nums[right]!=0)
            {
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
            }
        }
    }

}
