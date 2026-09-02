package com.shylaja.leetcode.arrays.greedy;

// Track the minimum price and the maximum profit
// We iterate through the prices array and find current profit by subtracting the minimum price from the current price
// update maximum profit 
// update minimum price 
// Then return the maximum profit


// Time Complexity: O(n)
// Space Complexity: O(1)

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
	    
	    int maxProfit=0;
	    int minPrice=prices[0];
	    for(int i=1;i<prices.length;i++)
	    {
	        int profit=prices[i]-minPrice;
	        maxProfit=Math.max(maxProfit,profit);
	        minPrice=Math.min(prices[i],minPrice);
	    }
	    return maxProfit;
	}

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println("Max profit: " + result);
    }
}
