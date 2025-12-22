package com.niharika.learning.Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_LC121 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelfBruteForce(nums);
        int[] resultOptimal = productExceptSelfOptimal(nums);
       System.out.println("Result "+Arrays.toString(result));
       System.out.println("Result "+Arrays.toString(resultOptimal));

    }

    // Brute Force Approach - Using Division
    //The question specify division is not allowed.However this is
    // the brute force solution that clicks when i start solving this question

    private static int[] productExceptSelfBruteForce(int[] nums) {
        int totalProduct = 1;
        int result[] = new int[nums.length];
        for(int num : nums){
            totalProduct = totalProduct * num;
        }
        for(int i = 0 ; i < nums.length ; i++){
            result[i] = totalProduct / nums[i];
        }

        return result;
    }

    //TODO : Needs some revising, watch apna college video again
    private static int[] productExceptSelfOptimal(int[] nums) {


        return null;
    }

}
