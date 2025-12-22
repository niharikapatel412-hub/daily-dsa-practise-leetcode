package com.niharika.learning.String;

// Longest Common Subsequence - LeetCode 03
// https://leetcode.com/problems/longest-common-subsequence/

import java.io.CharConversionException;
import java.util.HashSet;

public class LongestSubSubsequence_LC03 {
    public static void main(String[] args) {
        String text1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstringBruteForce(text1));
        System.out.println(lengthOfLongestSubstringOptimal(text1));
    }

    private static int lengthOfLongestSubstringBruteForce(String text1) {

        int n = text1.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int counter = 0;
            java.util.HashSet<Character> seen = new java.util.HashSet<>();

            for (int j = i; j < n; j++) {
                char c = text1.charAt(j);

                if (seen.contains(c)) {
                    break;
                } else {
                    seen.add(c);
                    counter++;
                    max = Math.max(max, counter);
                }
            }
        }
        return max;
    }

    //Sliding Window Optimal Approach
    // Time Complexity: O(n)
    private static int lengthOfLongestSubstringOptimal(String text1) {

        int n = text1.length();
        int max = 0;
        int start = 0;
        int end = 0 ;
        HashSet<Character> seen = new HashSet<>();
        for(end=0 ; end < n ; end++){
            char c = text1.charAt(end);
            if(seen.contains(c)){
                while(seen.contains(c)){
                    seen.remove(text1.charAt(start));
                    start++;
                }
            }
            seen.add(c);
            max = Math.max(max, end - start +1);

        }

      return max;

    }

}
