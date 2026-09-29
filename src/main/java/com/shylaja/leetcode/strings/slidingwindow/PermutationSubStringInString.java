package com.shylaja.leetcode.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//Leetcode 567. Permutation in String -> Sliding Window + HashMap Approach

/* 
Create a HashMap to store the frequency of each character in s1.
Use two pointers, left and right, to create a sliding window in s2.
Move right and add the current character to the window.
If the character exists in the map, decrease its required count.
Keep the window size equal to s1.length().
When the window becomes bigger, move left and restore the character count.
Keep track of how many characters are still required.
If required == 0, the current window contains a permutation of s1, so return true.
If we finish the string without finding a match, return false.
*/

//O(n)
//Space: O(k) where k is the number of distinct characters in s1.

public class PermutationSubStringInString {

    public static void main(String[] args) {
		
		String s1="ab";
		String s2="eidboaoo";
		System.out.println(checkInclusion( s1, s2));
	}
    
    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int count = s1.length();
        for (int right = 0; right < s2.length(); right++) {

            char c = s2.charAt(right);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c) - 1);
            }
            if (right - left + 1 > s1.length()) {

                char leftChar = s2.charAt(left);
                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
            if (count== 0) {
                return true;
            }
        }
        return false;
    }
}
