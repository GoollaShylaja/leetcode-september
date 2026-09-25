package com.shylaja.leetcode.strings;

//Leetcode 647. Palindromic Substrings -> Two Pointers Approach

/*
Start count = 0.
Take each character as the middle.
Check characters on the left and right.
If they are the same, it is a palindrome. Increase count.
Keep moving left and right until they are different or reach the end.
Also check between two characters for even-length palindromes.
Return count.
*/

//Time  → O(n²)
//Space → O(1)

public class CountPalindromeSubStrings {

    public static void main(String[] args) {

		String s="aaa";
		System.out.println(countSubstrings(s));
	}

    public static int countSubstrings(String s) {

        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            count+=isPalindrome(s,i,i);
            count+=isPalindrome(s,i,i+1);
        }
        return count;
    }
    public static int isPalindrome(String s, int left,int right)
    {
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
            count++;
        }
        return count;
    }

}
