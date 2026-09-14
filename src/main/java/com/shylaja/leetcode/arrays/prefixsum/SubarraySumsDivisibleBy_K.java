package com.shylaja.leetcode.arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

// LeetCode 974. Subarray Sums Divisible by K - Prefix Sum + HashMap Approach
//Calculate prefix sum → find remainder → check previous same remainder → add frequency → update frequency.

/*
Initialise:
* prefixSum = 0
* count = 0
* HashMap to store remainder → frequency.
Put 0 → 1 in the map to handle subarrays starting from index 0.
Traverse the array:
* Add current element to prefixSum.
* Calculate remainder = prefixSum % k.
* If remainder is negative, add k.
If the remainder already exists in the map:
* Add its frequency to count.
Increase the frequency of the current remainder in the map.
Return count.
*/

//Time: O(n)
//Space: O(k)
public class SubarraySumsDivisibleBy_K {

    public static void main(String[] args) {
		
		int[] nums={4,5,0,-2,-3,1};
		int k=5;
		System.out.println(subarraysDivByK(nums,k));
	}

    public static int subarraysDivByK(int[] nums, int k) {

        int prefixSum=0;
        int count=0;
        Map<Integer,Integer> data= new HashMap<>();
        data.put(0,1);
        for(int right=0;right<nums.length;right++)
        {
            prefixSum=prefixSum+nums[right];
            int remainder=prefixSum%k;
            if(remainder<0)
            {
                remainder+=k;
            }
            if(data.containsKey(remainder))
            {
                 count+=data.get(remainder);
            }
            data.put(remainder,data.getOrDefault(remainder,0)+1);
        }
       return count;
    }
}
