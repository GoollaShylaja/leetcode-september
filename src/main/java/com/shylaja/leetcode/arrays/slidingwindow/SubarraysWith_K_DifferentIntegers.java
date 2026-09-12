package com.shylaja.leetcode.arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//LeetCode 992. Subarrays with K Different Integers with Sliding Window Approach

/*
1. Calculate subarrays with at most K distinct numbers.
2. Calculate subarrays with at most K-1 distinct numbers.
3. Subtract both results.

For At Most K:

1. Initialise left = 0 and HashMap.
2. Expand the window using right.
3. Add nums[right] to the HashMap.
4. While distinct elements > K:
   - Remove nums[left]
   - Remove from map if frequency becomes 0
   - Move left++
5. Add right - left + 1 to count.
6. Return count. 
*/
//Time: O(n)
//Space: O(n) worst case

public class SubarraysWith_K_DifferentIntegers {

    public static void main(String[] args) {
		System.out.println("Hello World");
		int[] nums={1,2,1,3,4};
        int k=3;
		// int[] nums={1,2,1,2,3};
		// int k=2;
		System.out.println(subarraysWithKDistinct(nums,k));
	}

    public static int subarraysWithKDistinct(int[] nums, int k) {

        return count(nums,k)-count(nums,k-1);
     }
     public static int count(int[] nums,int k)
     {
          int left=0;
         int count=0;
         Map<Integer,Integer> qunique =new HashMap<>(); 
         for(int right=0;right<nums.length;right++)
         {
             qunique.put(nums[right],qunique.getOrDefault(nums[right],0)+1);
             while(qunique.size()>k)
             {
                 qunique.put(nums[left],qunique.get(nums[left])-1);
                 if(qunique.get(nums[left])==0)
                 {
                    qunique.remove(nums[left]);
                 }
                 left++; 
             }
             count=count+right-left+1;
         }
         return count;
     }

}
