package com.niharika.learning.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates time complexity differences between
 * a brute-force O(n^2) and a hash-based O(n) solution
 * to the Two Sum problem, using worst-case inputs.
 * Credits to ChatGPT-4 for the initial version of this code.
 */
public class TwoSumComplexityDemo {


//    Columns: N | brute(ms) | brute/ms_per_n2 | hash(ms) | hash/ms_per_n
//---------------------------------------------------------------------
//    N=500    | 0.283     | 0.000001132    | 0.058    | 0.000116550
//    N=1000   | 0.140     | 0.000000140    | 0.100    | 0.000100059
//    N=2000   | 0.455     | 0.000000114    | 0.193    | 0.000096513
//    N=4000   | 1.742     | 0.000000109    | 0.381    | 0.000095233
//    N=8000   | 7.396     | 0.000000116    | 0.293    | 0.000036638

    // O(n^2) time, O(1) extra space
    static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    // O(n) average time, O(n) space
    static int[] twoSumHash(int[] nums, int target) {
        // pre-size to reduce rehashing noise
        Map<Integer, Integer> numMap = new HashMap<>((int) (nums.length / 0.75f) + 1);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer idx = numMap.get(complement); // get() is enough (no need containsKey+get)
            if (idx != null) return new int[]{idx, i};
            numMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // Worst-case generator: all even numbers, so target=odd is impossible -> no early exit.
    static int[] worstCaseEvenArray(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = 2 * (i - n / 2);
        return nums;
    }

    static double timeMs(Runnable r, int warmup, int runs) {
        for (int i = 0; i < warmup; i++) r.run();  // JIT warmup

        long total = 0;
        for (int i = 0; i < runs; i++) {
            long t0 = System.nanoTime();
            r.run();
            long t1 = System.nanoTime();
            total += (t1 - t0);
        }
        return (total / 1e6) / runs;
    }

    public static void main(String[] args) {
        int[] sizes = {500, 1000, 2000, 4000, 8000}; // brute force will get slow beyond this
        int target = 1; // odd => impossible with even array

        System.out.println("Worst-case demo: all nums even, target odd => no solution (full scan).");
        System.out.println("Columns: N | brute(ms) | brute/ms_per_n2 | hash(ms) | hash/ms_per_n");
        System.out.println("---------------------------------------------------------------------");

        for (int n : sizes) {
            int[] nums = worstCaseEvenArray(n);

            double bruteMs = timeMs(() -> twoSumBruteForce(nums, target), 2, 5);
            double hashMs  = timeMs(() -> twoSumHash(nums, target),      2, 5);

            double brutePerN2 = bruteMs / (n * (double) n); // should be ~flat for O(n^2)
            double hashPerN   = hashMs / n;                  // should be ~flat for O(n)

            System.out.printf(
                    "N=%-6d | %-9.3f | %-14.9f | %-8.3f | %-12.9f%n",
                    n, bruteMs, brutePerN2, hashMs, hashPerN
            );
        }
    }
}
