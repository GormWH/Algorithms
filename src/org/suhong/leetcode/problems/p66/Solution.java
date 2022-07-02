package org.suhong.leetcode.problems.p66;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++; // plus one
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i != 0 && digits[i] > 9) {
                digits[i] = 0;
                digits[i-1]++;
            }
        }
        if (digits[0] > 9) {
            digits[0] = 0;
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newArray[i + 1] = digits[i];
            }
            return newArray;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1,2,3};
        int[] nums2 = {4,3,2,1};
        int[] nums3 = {9,9,9,9,9};

        System.out.println(Arrays.toString(s.plusOne(nums1))); // 1 2 4
        System.out.println(Arrays.toString(s.plusOne(nums2))); // 4 3 2 2
        System.out.println(Arrays.toString(s.plusOne(nums3))); // 4 3 2 2
    }
}