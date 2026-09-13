package com.shylaja.leetcode.arrays.prefixsum;
/*

724. Find Pivot Index - Prefix Sum Approach

Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.
*/

/*
1. Find the total sum of the array.
2. Set leftSum = 0.
3. Loop through each index.
4. Calculate:rightSum = totalSum - leftSum - nums[i]
5. If:leftSum == rightSum→ return i.
6. Otherwise, add the current element to leftSum.
7. If no pivot is found, return -1.

*/

//Time: O(n)
//Space: O(1)

public class FindPivotIndexLeftSumEqualsToRightSum {

    public static void main(String[] args) {

		int[] nums={1,7,3,6,5,6};
		System.out.println(pivotIndex(nums));
	}

    public static int pivotIndex(int[] nums) {

        int totalSum=0;
        for(int n:nums)
        {
            totalSum+=n;
        }
        int leftSum=0;
        int pivotIndex=-1;
        for(int left=0;left<nums.length;left++)
        {
            int rightSum=totalSum-leftSum-nums[left];
            if(rightSum==leftSum)
            {
                return left;
            }
            leftSum+=nums[left];
        }
        return pivotIndex; 
    }

}
