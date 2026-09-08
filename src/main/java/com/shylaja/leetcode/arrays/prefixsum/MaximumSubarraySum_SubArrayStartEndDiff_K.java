package com.shylaja.leetcode.arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

//LeetCode 3026: Maximum Good Subarray Sum-> Prefix Sum + HashMap Approach

/*
Map stores: number -> minimum prefix sum before that number
1. Traverse each number.
2. Check if num + k or num - k
   appeared previously.
3. If found:
   subarraySum =
   prefixSum + num - storedPrefixSum
4. Update maxSum.
5. Store the minimum prefixSum for current num.
6. Add num to prefixSum.
*/

//Time Complexity: O(n)
//Space Complexity: O(n)
public class MaximumSubarraySum_SubArrayStartEndDiff_K {

    public static void main(String[] args) {

		int[] nums={-1,3,2,4,5};
		int k=3;
		System.out.println(maxSubArraySumWith_StartEndDifference_K(nums,k));
	}

        public static long maxSubArraySumWith_StartEndDifference_K(int[] nums, int k)
        {
            long maxSum=Long.MIN_VALUE;
            long prefixSum=0;
            Map<Long,Long> map= new HashMap<>(); // prevous prefixSum before the current num
            for(long num:nums)
            {
                
                if(map.containsKey(num+k))
                {
                    maxSum=Math.max(maxSum,prefixSum+num-map.get(num+k));
                }
                if(map.containsKey(num-k))
                {
                    maxSum=Math.max(maxSum,prefixSum+num-map.get(num-k));
                }
                // prevous prefixSum before the current num
                map.put(num,Math.min(prefixSum,map.getOrDefault(num,Long.MAX_VALUE)));
                prefixSum+=num;
            }
            return maxSum==Long.MIN_VALUE?0:maxSum;
        }
}
