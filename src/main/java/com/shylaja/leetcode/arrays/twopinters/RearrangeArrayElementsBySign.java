package com.shylaja.leetcode.arrays.twopinters;

import java.util.Arrays;

// Two pointers - positive and negative and alternate between them

// Two pointers - positive and negative
// positive = index 0, then 2, then 4...
// negative = index 1, then 3, then 5...

// If nums[i] > 0:
//     put nums[i] at positive index
//     positive += 2

// If nums[i] < 0:
//     put nums[i] at negative index
//     negative += 2

// Repeat until the end of the array

// time complexity: O(n)
// space complexity: O(n)

public class RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = rearrangeArray(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] rearrangeArray(int[] nums) {

        int[] res= new int[nums.length];
        int postiveIndex=0;
         int negativeIndex=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                res[postiveIndex]=nums[i];
                postiveIndex+=2;
            }
            else
            {
                res[negativeIndex]=nums[i];
                negativeIndex+=2;
            }
        }
        return res;
    }

}
