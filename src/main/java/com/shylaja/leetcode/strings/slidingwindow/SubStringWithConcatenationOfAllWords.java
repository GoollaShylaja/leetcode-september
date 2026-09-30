package com.shylaja.leetcode.strings.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode 30. Substring with Concatenation of All Words -> Sliding Window + HashMap Approach

/* 
Store each word's required frequency in a HashMap.
Get the length of one word.
Get the total required window size:
wordLength × numberOfWords
Use a sliding window.
Move through s in steps of wordLength.
For each word:
If it is not in the map → reset the window.
If it occurs too many times → move left forward.
If we have all required words → add left to the answer.
Repeat for each possible starting offset:
0, 1, 2, ..., wordLength - 1
*/

//Time Complexity: O(n)
//Space Complexity: O(m)

public class SubStringWithConcatenationOfAllWords {
    
    public static void main(String[] args) {
		
		String s="barfoothefoobarman";
		String[] words= {"foo","bar"};
		System.out.println(findSubstring( s, words));
	}

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        // Required frequency of each word
        Map<String, Integer> required = new HashMap<>();
        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }
        // Try every possible starting offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            Map<String, Integer> current = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // Word is not required
                if (!required.containsKey(word)) {
                    current.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                current.put(word, current.getOrDefault(word, 0) + 1);
                count++;

                // Too many occurrences of this word
                while (current.get(word) > required.get(word)) {

                    String leftWord = s.substring(left, left + wordLen);

                    current.put(leftWord, current.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }

                // All words are present
                if (count == wordCount) {
                    result.add(left);

                    // Move left to look for next window
                    String leftWord = s.substring(left, left + wordLen);
                    current.put(leftWord, current.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }
            }
        }
        return result;
    }
}
