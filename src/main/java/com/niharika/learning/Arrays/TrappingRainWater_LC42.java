package com.niharika.learning.Arrays;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/
 */
public class TrappingRainWater_LC42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapBruteForce(height));
        System.out.println(trapWaterOptimal(height));
    }

    private static int trapBruteForce(int[] height) {
        int total = 0;
        int leftMax = 0;

        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);

            int rightMax = 0;
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int water = Math.min(leftMax, rightMax) - height[i];
            if (water > 0) total += water;
        }

        return total;
    }

    private static int trapWaterOptimal(int[] height) {
        int totalWaterTrapped = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWaterTrapped += leftMax - height[left];

                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWaterTrapped += rightMax - height[right];
                }
                right--;
            }

        }

        return totalWaterTrapped;

    }
}



