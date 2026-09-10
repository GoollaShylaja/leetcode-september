package com.shylaja.leetcode.arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//Leetcode 904. Fruit Into Baskets with Sliding Window + HashMap Approach
/* 
Start with left = 0.
Move right from left to right.
Add the current fruit to the HashMap.
The map stores fruit type → count.
If there are more than 2 fruit types, shrink the window from the left.
Decrease the count of fruits[left].
If its count becomes 0, remove that fruit type from the map.
Move left++.
Update the maximum window size.
*/

//Time Complexity: O(n)
//Space Complexity: O(1)

public class MaxFruitsInBaskets {
    public static void main(String[] args) {
	
		int[] fruits={3,3,3,1,2,1,1,2,3,3,4};
		System.out.println(totalFruit(fruits));
	}
	public static int totalFruit(int[] fruits) {

        int maxCount=0;
        int left=0;
        Map<Integer,Integer> data=new HashMap<>();
        for(int right=0;right<fruits.length;right++)
        {
            data.put(fruits[right],data.getOrDefault(fruits[right],0)+1);
            while(data.size()>2)
            {
                 data.put(fruits[left],data.get(fruits[left])-1);
                 if(data.get(fruits[left])==0)
                 {
                    data.remove(fruits[left]);
                 }
                 left++;
            }
            maxCount=Math.max(maxCount,right-left+1);
        }
        return maxCount;
    }

}
