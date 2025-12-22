package com.niharika.learning.BinarySearch;

/**
 * Leetcode Problem 153: Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinimumInRotatedSortedArray_LC153 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMinOptimal(nums));
        System.out.println(findMinBruteForce(nums));
    }

    private static int findMinBruteForce(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    private static int findMinOptimal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left +(right-left)/2;
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

}
