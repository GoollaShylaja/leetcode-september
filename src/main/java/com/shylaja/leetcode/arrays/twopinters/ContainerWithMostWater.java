package com.shylaja.leetcode.arrays.twopinters;
// Leetcode problem: 11 - Container With Most Water

    // Two pointers - left and right
    // left: pointer to the first index of the array
    // right: pointer to the last index of the array
    // minHeight: the minimum height between the two pointers
    // weidth: the width between the two pointers
    // area: the area between the two pointers
    // maxArea: the maximum area between the two pointers
    // if the height at the left pointer is less than or equal to the height at the right pointer, increment the left pointer
    // else decrement the right pointer
    // repeat until the left pointer is greater than the right pointer

// time complexity: O(n)
// space complexity: O(1)

public class ContainerWithMostWater {

    public static void main(String[] args) {
		System.out.println("Hello World");
		int[] height={1,8,6,2,5,4,8,3,7};
		System.out.println("MaxArea="+maxArea(height));
		
	}
	public static int maxArea(int[] height)
	{
	    int left=0;
	    int right=height.length-1;
	    int maxArea=0;
	    while(left<right)
	    {
	        int minHeight=Math.min(height[left],height[right]);
	        int weidth=right-left;
	        int area=minHeight*weidth;
	        maxArea=Math.max(maxArea,area);
	        if(height[left]<=height[right])
	        {
	            left++;
	        }
	        else
	        {
	            right--;
	        }
	    }
	    return maxArea;
	}
}
