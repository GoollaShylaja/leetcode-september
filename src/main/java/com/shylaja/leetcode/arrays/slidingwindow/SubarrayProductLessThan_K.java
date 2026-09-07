package com.shylaja.leetcode.arrays.slidingwindow;

//LeetCode 713: Subarray Product Less Than K - SlidingWindow Approach

/*
1. Expand the window by adding nums[right] to the product.
2. If product >= k, shrink the window from the left and left++
3. Once product < k:
    All subarrays ending at right are valid.
4. Number of valid subarrays = right - left + 1.
5. Add them to the result.

Time: O(n)
Space: O(1)
 */

public class SubarrayProductLessThan_K {

    public static void main(String[] args) {
		
		int[] nums={10,5,2,6};
		int k=100;
		System.out.println(numSubarrayProductLessThanK(nums,k));
	}
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if (k <= 1) {
            return 0;
        }
        int productCount=0;
        int windowProduct=1;
        int left=0;
        for(int right=0;right<nums.length;right++)
        {
            windowProduct*=nums[right];
            while(windowProduct>=k)
            {
                windowProduct/=nums[left];
                left++;
            }
            productCount+=right-left+1;
        }
        return productCount;
    }
}
