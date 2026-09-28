package com.shylaja.leetcode.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/* Longest Substring with K Unique Chars -> Sliding Window + HashMap Approach

Use a sliding window with two pointers: left and right.
Use a HashMap to store each character and its frequency in the current window.
Move right from left to right and add the current character to the map.
If the map has more than K distinct characters, move left forward and decrease the character count.
If a character's count becomes 0, remove it from the map.
Whenever the map has exactly K distinct characters, calculate the current window length.
Keep updating maxLen with the longest window found.
Return maxLen. If there is no substring with exactly K distinct characters, return -1.

*/
//Time: O(n)
//Space: O(k)

public class LongestSubstringWithK_UniquesChars {
    
    public static void main(String[] args) {
		
		int k=3;
		String s="aabacbebebe";
		System.out.println(longestKSubstr(s,k));
	}
    public static int longestKSubstr(String s, int k) {
      
        int maxLen=-1;
        int left=0;
        Map<Character,Integer> data= new HashMap<>();
        for(int right=0;right<s.length();right++)
        {
            data.put(s.charAt(right),data.getOrDefault(s.charAt(right),0)+1);
            while(data.size()>k)
            {
                data.put(s.charAt(left),data.get(s.charAt(left))-1);
                if(data.get(s.charAt(left))==0)
                {
                    data.remove(s.charAt(left));
                }
                left++;
            }
            if(data.size()==k)
            {
                 maxLen=Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }
}
