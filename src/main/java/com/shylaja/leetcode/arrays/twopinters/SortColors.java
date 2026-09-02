package com.shylaja.leetcode.arrays.twopinters;

import java.util.Arrays;

// Dutch National Flag Algorithm - Three pointers
// low: pointer to the first index of 0 and take care of 0's from 0 to low-1
// mid: pointer to the first index of 0 and take care of 1's from low to mid-1
// high: pointer to the last index of n-1 and take care of 2's from high+1 to n-1
// if nums[mid]==0, swap nums[low] and nums[mid], increment low and mid
// if nums[mid]==1, increment mid
// if nums[mid]==2, swap nums[mid] and nums[high], decrement high
// repeat until mid>high

// time complexity: O(n)
// space complexity: O(1)
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {

        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
               mid++;
            }
            else
            {
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
}
