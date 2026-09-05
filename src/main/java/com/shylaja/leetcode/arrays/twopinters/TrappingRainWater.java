package com.shylaja.leetcode.arrays.twopinters;

// Leetcode problem: 42 - Trapping Rain Water - Two Pointers Approach
// Two pointers - left and right
// left: pointer start at index 0 of the array
// right: pointer start at the end of the array
// left_max: the maximum height between left pointer and the current index
// right_max: the maximum height between current index and right pointer
// water: the amount of water trapped
// repeat until the left pointer is greater than the right pointer
// if left_max is less than right_max, increment left pointer and update left_max and calculate the water trapped
// else decrement right pointer and update right_max and calculate the water trapped
// return the total amount of water trapped at the end of the array

// time complexity: O(n)
// space complexity: O(1)
public class TrappingRainWater {
    public static void main(String[] args) {

		int[] height={4,2,0,3,2,5};
		System.out.println(trap(height));
        
	}
	public static int trap(int[] height) {

        int left=0, right=height.length-1;
        int left_max=height[left],right_max=height[right];
        int water=0;
        while(left<right)
        {
            if(left_max<right_max)
            {
                left++;
                left_max=Math.max(left_max,height[left]);
                water+=left_max-height[left];
            }
            else
            {
                right--;
                right_max=Math.max(right_max,height[right]);
                water+=right_max-height[right];
                
            }
        }
        return water;
    }
}
