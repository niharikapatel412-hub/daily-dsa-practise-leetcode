package com.niharika.learning.arrays;

/**
 * LeetCode 11: Container With Most Water
 *
 */
public class ContainerWithMostWater_LC11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaBruteForce(height));
        System.out.println(maxAreaOptimal(height));
    }

    // Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static int maxAreaBruteForce(int[] height) {

        int maxArea = 0;
        for(int i =0 ; i < height.length; i++){

            for(int j = i +1 ; j <height.length; j++){

                int width = j -i;
                int area = Math.min(height[i], height[j]) * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // Optimal Approach - Two Pointer Technique
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int maxAreaOptimal(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while(left < right){

            int width = right - left;
            int area = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
