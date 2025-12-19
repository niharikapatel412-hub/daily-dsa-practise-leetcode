package com.niharika.learning.arrays;

public class RotatedArraySearch_LC33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(searchBruteForce(nums, target));
        System.out.println(searchOptimal(nums, target));
    }

    private static int searchBruteForce(int[] nums, int target) {
        for(int i =0 ; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;

    }

    private static int searchOptimal(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right){

            int mid = left + (right - left)/2;

            if ((nums[mid] == target)) {
                return mid;
            }else if(nums[left] <=nums[mid]){
                //left side is sorted
                if(target >= nums[left] && target < nums[mid]){
                    right = mid -1;
                } else {
                    left = mid +1;
                }
            } else {
                //right side is sorted
                if(target > nums[mid] && target <= nums[right]){
                    left = mid +1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
