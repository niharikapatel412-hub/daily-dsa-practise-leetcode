package com.niharika.learning.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_LC217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));

    }

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for(int i =0 ; i < nums.length; i++){

            if(numSet.contains(nums[i])){
                return true;
            }
            numSet.add(nums[i]);
        }
        return false;
    }
}
