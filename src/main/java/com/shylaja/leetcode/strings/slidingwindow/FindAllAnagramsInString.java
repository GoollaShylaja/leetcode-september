package com.shylaja.leetcode.strings.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode 438. Find All Anagrams in a String -> Sliding Window + HashMap Approach

/*
Create a HashMap to store the frequency of each character in p.
Use two pointers: left and right to create a sliding window in s.
Move right and add characters to the current window.
Decrease the character frequency in the map.
Keep the window size equal to p.length().
If the current window contains all required characters, it is an anagram, so add left to the result.
Move left forward and restore the frequency of the character that leaves the window.
Continue until right reaches the end of s. 
*/

//Time: O(n)
//Space: O(k) where k = number of different characters in p.
public class FindAllAnagramsInString {

    public static void main(String[] args) {
		
		String s="baa";
		String p="aa";
		List<Integer> res=findAnagrams(s, p);
		System.out.println(res);
	}

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
    
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                if (map.get(rightChar) > 0) {
                    count--;
                }
    
                map.put(rightChar, map.get(rightChar) - 1);
            }
            right++;
            if (right - left == p.length()) {
    
                if (count == 0) {
                    result.add(left);
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
    
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}
