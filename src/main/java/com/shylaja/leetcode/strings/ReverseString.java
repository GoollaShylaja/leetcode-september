package com.shylaja.leetcode.strings;

import java.util.Arrays;

//LeetCode 344. Reverse String -> two pointers Approach

/*
Use two pointers:
    left = 0
    right = s.length - 1
While left <= right:
    Swap s[left] and s[right]
    Move left++
    Move right--
Stop when the pointers meet/cross.
*/

//Time: O(n)
//Space: O(1)
public class ReverseString {

    public static void main(String[] args) {
		
		char[] str={'H','a','n','n','a','h'};
		reverseString(str);
	}
	public static void reverseString(char[] s) {

        int left=0;
        int right=s.length-1;
        while(left<=right)
        {
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }

}
