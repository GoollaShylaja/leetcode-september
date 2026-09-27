package com.shylaja.leetcode.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//LeetCode 3. Longest Substring Without Repeating Characters-> Sliding Window + HashMap Approach

/* 
right moves through the string.
Store each character's latest index in a HashMap.
If we see a duplicate character, move left to lastIndex + 1.
Calculate the maximum window length. 
*/

//Time: O(n)
//Space: O(min(n, character_set)) for the HashMap.
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
	
		String s="dvdf";
		int res=lengthOfLongestSubstring(s);
		System.out.println(res);
	}
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
