package com.shylaja.leetcode.arrays.twopinters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LeetCode 15: 3Sum -> Sorting + Two Pointers Approach

/*
1. Sort the array.
2. Fix one element using i.
3. Use two pointers (left and right) for the remaining elements.
4. If sum == 0 → add the triplet.
5. Skip duplicates to avoid duplicate triplets.
6. If sum < 0 → move left.
7. If sum > 0 → move right. */

//Time Complexity:  O(n²)
//Space Complexity: O(1) extra space (excluding the output)
public class III_Sum {

    public static void main(String[] args) {
		
		int[] nums={-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            //duplicate handling: if current value same previous value no need to calcucate again  
            if(i>0 && nums[i]==nums[i-1])
                continue;
            if(nums[i]>0)
                break;
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //This prevents duplicate triplets.
                    while(left<right && nums[left]==nums[left+1])
                        left++;
                    while(left<right && nums[right]==nums[right-1])
                        right--;
                    left++;
                    right--;
                }
                else if(sum<0)
                    left++;
                else
                    right--; 
            }
        }
        return res;
    }

}
