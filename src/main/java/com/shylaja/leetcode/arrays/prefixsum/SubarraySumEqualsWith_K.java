package com.shylaja.leetcode.arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

//LeetCode 560. Subarray Sum Equals K - Prefix Sum + HashMap Approach
/*
1. Keep a running prefix sum.
2. Store previous prefix sums in a HashMap (prefix sum → frequency (how many times that prefix sum has occurred).
3. For every current sum:
   target = currentSum - k
4. If target exists in the map:
   count += frequency of target
5. Store currentSum in the map.
*/

//Time: O(N)
//Space: O(N)
public class SubarraySumEqualsWith_K {

    public static void main(String[] args) {
		
		int[] nums={1,1,1};
		int k=2;
		System.out.println(subarraySum(nums,k));
	}

    public static int subarraySum(int[] nums,int k)
    {
        int prefixSum=0;
        int count=0;
        Map<Integer,Integer> data= new HashMap<>();
        data.put(0,1); // It represents an empty prefix before the array. This allows us to count a valid subarray that starts from index 0.
        for(int right=0;right<nums.length;right++)
        {
            prefixSum=prefixSum+nums[right];
            int target=prefixSum-k;
            if(data.containsKey(target))
            {
                count=count+data.get(target);
            }
            data.put(prefixSum,data.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }

}
