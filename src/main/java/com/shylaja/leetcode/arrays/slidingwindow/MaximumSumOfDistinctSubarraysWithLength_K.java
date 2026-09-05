package com.shylaja.leetcode.arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// Leetcode problem: 2461. Maximum Sum of Distinct Subarrays With Length K with Slidingwindow Approach

/* Sliding Window + HashMap
1. Keep windowSum, maxSum, and a frequency map.
2. Add each element to the window.
3. If window size exceeds k, remove the left element.
4. If window size is k and all elements are distinct (map.size() == k), update maxSum.
5. Repeat until the end and return maxSum.
*/

public class MaximumSumOfDistinctSubarraysWithLength_K {
    public static void main(String[] args) {

		int[] nums = {1,5,4,2,9,9,9};
		int k = 3;
		System.out.println(maxSubArray(nums,k));
		
	}
	public static int maxSubArray(int[] nums, int k)
	{
	    int maxSum=0;
	    int windowSum=0;
	    Map<Integer,Integer> frequency= new HashMap<>();
	    for(int i=0;i<nums.length;i++)
	    {
	        windowSum+=nums[i];
	        frequency.put(nums[i],frequency.getOrDefault(nums[i],0)+1);
	        if(i>=k)
	        {
	            windowSum-=nums[i-k];
	            frequency.put(nums[i-k],frequency.getOrDefault(nums[i-k],0)-1);
	            if(frequency.get(nums[i-k])==0)
	            {
	                frequency.remove(nums[i-k]);
	            }
	        }
	        if(i>=k-1 && frequency.size()==k)
	        {
	            maxSum=Math.max(windowSum,maxSum);
	        }
	    }
	    return maxSum;
	}
}
