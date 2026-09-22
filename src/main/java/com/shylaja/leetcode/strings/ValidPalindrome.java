package com.shylaja.leetcode.strings;

//LeetCode 125. Valid Palindrome -> Two pointers Approach

/*
Two pointers + skip + compare

    1.left starts at beginning.
    2.right starts at end.
    3.Skip non-letter/digit characters from both sides until valid char
    4.Compare the two characters ignoring case.
    5.If different → return false.
    6.If same → move both pointers.
    7.At the end → return true.
*/

//Time: O(n)
//Space: O(1)

public class ValidPalindrome {

    public static void main(String[] args) {
		
		String str="A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(str));
	}
    public static boolean isPalindrome(String s) {

        int left=0;
        int right=s.length()-1;
        while(left<right)
        {
            while(left<right && !(Character.isLetterOrDigit(s.charAt(left))))
            {
                left++;
            }
            while(left<right && !(Character.isLetterOrDigit(s.charAt(right))))
            {
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!= 
            Character.toLowerCase(s.charAt(right)))
            {
                 return false;
            }
            right--;
            left++;
        }
        return true;
    }

}
