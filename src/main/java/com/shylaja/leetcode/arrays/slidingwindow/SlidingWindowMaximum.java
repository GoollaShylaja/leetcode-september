package com.shylaja.leetcode.arrays.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// LeetCode 239. Sliding Window Maximum -> (Deque) + Sliding Window Approach
/*
Use a deque to store indexes of useful elements.

1. Remove indexes that are outside the current window.

2. Remove smaller elements from the back,
    because they can never be the maximum.

3. Add the current index.

4. Once the window size reaches k,
        the front of the deque contains the maximum.

Time: O(n)
Space: O(k)
*/

public class SlidingWindowMaximum {

    public static void main(String[] args) {
		
		int[] nums={1,3,-1,-3,5,3,6,7};
		int k=3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
	}

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] res= new int[nums.length-k+1];
        Deque<Integer> deque= new LinkedList<>();
        for(int right=0;right<nums.length;right++)
        {
            // remove elements which not part of current window which added first
            while(!deque.isEmpty()&& deque.peekFirst()<=right-k)
            {
                deque.pollFirst();
            }
             // remove elements which are less then the current value , as those not give any meaning
            while(!deque.isEmpty()&& nums[deque.peekLast()]<nums[right])
            {
                deque.pollLast();
            }
            deque.addLast(right);
            // if right reached to current window add element to res
            if(right>=k-1)
            {
                res[right-k+1]=nums[deque.peekFirst()];
            }
        }
        return res;   
    }

}
