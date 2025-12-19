package com.niharika.learning.arrays;

/*
LEETCODE PROBLEM 53: MAXIMUM SUBARRAY
https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarray_LC53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayBruteForce(nums));
    }
    public static int maxSubArrayBruteForce(int[] nums) {

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            int sum = 0; // -2
            for(int j = i ; j < nums.length ; j++){
                sum = sum + nums[j]; //-2 +1
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        System.out.println("Max sum is " + maxSum);
         return maxSum;
    }

    // Optimal solution using Kadane's Algorithm
    // Time complexity : O(n)
    // Space complexity : O(1)
    // Kadane's Algorithm is used to find the maximum sum of a contiguous subarray in an array of integers.
    // It works by iterating through the array and keeping track of the current sum of the subarray.
    // If the current sum becomes negative, it is reset to zero.
    // The maximum sum is updated whenever the current sum exceeds the previous maximum sum.
    // This approach ensures that we consider all possible subarrays while maintaining an efficient time complexity.
    // Kadane's Algorithm is particularly effective for problems involving contiguous subarrays, making it a popular choice for solving maximum subarray problems.

    public static int maxSubArrayOptimal(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i =1 ; i < nums.length ; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
