package com.niharika.learning.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_LC01 {
    public static void main(String[] args) {

//        Case 01 - Best case scenario
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        int[] result = twoSumBruteForce(nums, target);
//        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
//        System.out.println("Operation Count in Brute Force: " + countOps(nums, target));

       // Case 02 -Worst casescenario
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = -1;
        int[] result = twoSumBruteForce(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        System.out.println("Operation Count in Brute Force: " + countOps(nums, target));

        //Case 03 - Optimal Approach
      //  int[] resultOptimal = twoSumOptimal(nums, target);
        int[] resultOptimal = {2, 7, 11, 15};
        int targetOptimal = 9;

        System.out.println("Indices (Optimal): [" + resultOptimal[0] + ", " + resultOptimal[1] + "]");



    }

    /**
     * Brute Force Approach
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }

        return new int[]{-1, -1};
    }

    /**
     *  Count operations in Brute Force Approach
     *  Time Complexity Demo and better understanding
     * @param nums
     * @param target
     * @return
     */
    static long countOps(int[] nums, int target) {
        long ops = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ops++; // one pair check
                if (nums[i] + nums[j] == target) return ops;
            }
        }
        return ops;
    }

    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){

            int compliment = target - nums[i];
            if(numMap.containsKey(compliment)){
                return new int[]{numMap.get(compliment), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
