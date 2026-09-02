package com.shylaja.leetcode.arrays.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {

        int[] arr={ 2, 7, 11, 15 };
        int target=9;

        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(arr , target);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}
