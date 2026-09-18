package com.shylaja.leetcode.arrays.prefixsum.suffixsum;

//LeetCode 152. Maximum Product Subarray → Prefix + Suffix products Approach

/*
For product subarray, a negative number can change the result significantly. Instead of tracking only the current maximum, we calculate products from both directions.
1. Maintain prefixProduct from left → right.
2. Maintain suffixProduct from right → left.
3. If either product becomes 0, reset it to 1.
4. At every position, update maxProduct with the larger of prefix and suffix.
5. The maximum found is the answer.
*/

//Time: O(n)
//Space: O(1)
public class SubarrayMaxProduct {

    public static void main(String[] args) {
	
		int[] nums={2,3,-2,4};
		System.out.println(maxProduct(nums));
	}
    public static int maxProduct(int[] nums) {

        int maxProduct=Integer.MIN_VALUE;
        int prefiXProduc=1;
        int suffixProduc=1;
        int len=nums.length;

        for(int i=0;i<len;i++)
        {
            if(prefiXProduc==0)
            {
                prefiXProduc=1;
            }
            if(suffixProduc==0)
            {
                suffixProduc=1;
            }
            prefiXProduc=prefiXProduc*nums[i];
            suffixProduc=suffixProduc*nums[len-i-1];
            maxProduct=Math.max(maxProduct,Math.max(prefiXProduc,suffixProduc));
        }
        return maxProduct;
    }

}
