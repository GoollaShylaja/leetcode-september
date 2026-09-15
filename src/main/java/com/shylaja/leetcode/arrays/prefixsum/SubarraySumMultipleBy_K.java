package com.shylaja.leetcode.arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

//523. Continuous Subarray Sum is good subarray when its length is at least two & the sum of the elements of the subarray is a multiple of k
// ->Prefix Sum + HashMap
/* 
1. Keep a prefixSum.
2. Calculate remainder = prefixSum % k.
3. Store the first index where each remainder appears.
4. If the same remainder appears again, calculate:
    currentIndex - firstIndex
5. If the length is ≥ 2, return true.
6. If the remainder is new, store it.
7. Initialise map.put(0, -1) to handle subarrays starting from index 0.
8. If no valid subarray is found, return false.
*/
public class SubarraySumMultipleBy_K {

    public static void main(String[] args) {
		
		int[] nums={23,2,4,6,7};
		int k=6;
		System.out.println(checkSubarraySum(nums,k));
	}

    public static boolean checkSubarraySum(int[] nums, int k) {
        
        int preFixSum=0;
        Map<Integer,Integer> data= new HashMap<>();
        data.put(0,-1);
        for(int right=0;right<nums.length;right++)
        {
            preFixSum+=nums[right];
            int reminder = preFixSum%k;
            if(data.containsKey(reminder))
            {
                if(right-data.get(reminder)>=2)
                {
                     return true;
                }
            }
            else
            {
                data.put(reminder,right);
            }
        }
        return false;
    }
}
