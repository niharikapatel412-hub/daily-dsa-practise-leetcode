package com.niharika.learning.arrays;

import java.util.*;

/**
 * LEETCODE PROBLEM 49: GROUP ANAGRAMS
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagrams {
    public static void main(String[] args) {

      String [] strs = {"eat","tea","tan","ate","nat","bat"};

      System.out.println("group anagrams " +groupAnagrams(strs));
      System.out.println("Optimal group anagrams "+groupAnagramsOptimal(strs));

    }

    public  static  List<List<String>> groupAnagrams(String[] strs) {

            String[] keys = new String[strs.length];

            for (int i = 0; i < strs.length; i++) {
                char[] charArray = strs[i].toCharArray();
                Arrays.sort(charArray);

                String sortedKey = new String(charArray);
                keys[i] = sortedKey;

                System.out.println("Sorted key for " + strs[i] + " => " + sortedKey);
            }


            HashMap<String, List<String>> map = new HashMap<>();

            for (int i = 0; i < strs.length; i++) {
                String key = keys[i];
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(strs[i]);
            }

            return new ArrayList<>(map.values());
        }



    public static List<List<String>> groupAnagramsOptimal(String[] strs) {

            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);

                map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            }

            return new ArrayList<>(map.values());
        }
    }
