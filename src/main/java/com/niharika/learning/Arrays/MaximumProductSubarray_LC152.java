package com.niharika.learning.Arrays;

/**
 *
 LEETCODE PROBLEM 152: MAXIMUM PRODUCT SUBARRAY
 https://leetcode.com/problems/maximum-product-subarray/description/
 **/
public class MaximumProductSubarray_LC152 {

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProductBruteForce(nums));
    }

    private static int maxProductBruteForce(int[] nums) {

        int currProduct = 1;
        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            currProduct = 1;
            for(int j = i ; j < nums.length ; j++){
                currProduct = currProduct * nums[j];
                if(currProduct > maxProduct){
                    maxProduct = currProduct;
                }

            }
        }
        return maxProduct;
    }

    //TODO : Revisit The apna college video for optimal solution
    private static int maxProductOptimal(int[] nums) {

        return 0;
    }
}
