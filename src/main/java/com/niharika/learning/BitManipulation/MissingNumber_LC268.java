package com.niharika.learning.BitManipulation;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber_LC268 {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing number is: " + missingNumber(nums));
        System.out.println("Missing number using XOR is: " + missingNumberXOR(nums));
        System.out.println("Missing number using HashSet is: " + missingNumberHash(nums));
    }

    // Brute Force Approach using Sum Formula
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int missingNumber(int[] nums) {
        int n = nums.length;
        int nSum = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : nums) {
            arrSum += num;
        }
        int missingNumber = nSum - arrSum;
        return missingNumber;

    }

    // Optimal Approach using XOR
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static  int missingNumberXOR(int[] nums) {
        int n = nums.length;
        int xorr = n;
        for (int i = 0; i < n; i++) {
            xorr ^= i ^ nums[i];
        }
        return xorr;
    }


    public static int missingNumberHash(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
