package com.shylaja.leetcode.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//LeetCode 76. Minimum Window Substring -> Sliding Window + HashMap Approach

/*
Put every character from t into the map with its required frequency.
Use left and right to create a window in s.
Move right and include characters in the window.
When a required character is found, decrease its count in the map.
count tells us how many characters from t are still missing.
When count == 0, the current window contains all characters of t.
Now move left forward to make the window as small as possible.
Keep updating the smallest valid window.
Return the smallest window.
 */

//Time: O(s.length + t.length)
//Space: O(number of unique characters in t)
public class MinimumWindowSubstring {
    
    public static void main(String[] args) {
		
		String s="ADOBECODEBANC";
		String t="ABC";
		String res=minWindow(s, t);
		System.out.println(res);
	}

    public static String minWindow(String s, String t) {

        Map<Character,Integer> map=new HashMap<>();
        for(Character ch: t.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int left=0;
        int count=t.length();
        int minLen=Integer.MAX_VALUE;
        String ans="";
        for(int right=0;right<s.length();right++)
        {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c) - 1);
            }
            while(count==0)
            {
                if (right - left + 1<minLen) {
                    minLen=right - left + 1;
                    ans=s.substring(left,right+1);
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
        return ans;
    }
}
