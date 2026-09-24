package com.shylaja.leetcode.strings;

//LeetCode 5. Longest Palindromic Substring -> Two Pointers Approach
/*
Start from each character in the string.
Consider that character as the centre of a palindrome.
Expand to the left and right while characters are equal.
Also check the even-length case using two adjacent characters as the centre.
Find the length of both palindromes.
Keep the longest palindrome found so far.
Store its start and end positions.
After checking all characters, return the substring between start and end.
*/

//Time  → O(n²)
//Space → O(1)
public class LongestPalindrome
{

    public static void main(String[] args) {
		System.out.println("Hello World");
		String s="cbbd";
		System.out.println(longestPalindrome(s));
	}
    
    public static String longestPalindrome(String s) {

        int start=0;
        int end=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len > (end-start))
            {
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public static int expand(String s, int left,int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return right-left-1;
    }
}
