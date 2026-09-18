package com.shylaja.leetcode.arrays.prefixsum.suffixsum;

import java.util.Arrays;

//LeetCode 238. Product of Array Except Self - Prefix/Suffix Product Approach

/*
Create an answer array.
Left → Right: store the product of all elements before each index.
* Start with answer[0] = 1.
Right → Left: maintain rightProduct.
* Multiply answer[i] by rightProduct.
* Then update rightProduct *= nums[i].
Return answer.
*/

//Time: O(n)
//Extra space: O(1) excluding the output array.

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

		int[] nums={1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        
        int[] answer= new int[nums.length];
        answer[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            answer[i]=nums[i-1]*answer[i-1];           
        }
        int rightProduct=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            answer[i]=rightProduct*answer[i];
            rightProduct=rightProduct*nums[i];
        }
        return answer;
    }

}
