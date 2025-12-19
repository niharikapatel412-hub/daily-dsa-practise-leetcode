package com.niharika.learning.BitManipulation;

public class MissingNumber_LC268 {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing number is: " + missingNumber(nums));
    }

    private static String missingNumber(int[] nums) {
        int n = nums.length;
        int nSum = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : nums) {
            arrSum += num;
        }
        int missingNumber = nSum - arrSum;
        return String.valueOf(missingNumber);

    }
}
