package com.shylaja.leetcode.strings;

//LeetCode 680. Valid Palindrome II -> two pointers Approach

/*
1. Start left at the beginning and right at the end.
2. Compare characters.
3. If they match → move both pointers.
4. If they don't match → we are allowed to delete one character.
5. So skip the left character: left + 1 OR skip the right character: right - 1
6. If either remaining substring is a palindrome → return true.
 */

//Time: O(n)
//Space: O(1)
public class Valid_palindrome_2 {

    public static void main(String[] args) {
		
		String s="cbbcc";
		System.out.println(validPalindrome(s));
	}

    public static boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right)
        { 
            if(s.charAt(left)!=s.charAt(right))
            {
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindrome(String s,int left,int right)
    {
        while(left<right)
        { 
            if(s.charAt(left)!=s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
