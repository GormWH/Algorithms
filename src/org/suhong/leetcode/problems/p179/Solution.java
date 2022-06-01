package org.suhong.leetcode.problems.p179;

import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class Solution {

    public String largestNumber(int[] nums) {
        int length = nums.length;
        String[] numStrings = new String[length];
        for (int i = 0; i < length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, (s1, s2) -> {
            String concat1 = s1 + s2;
            String concat2 = s2 + s1;
            return -concat1.compareTo(concat2);
        });
        StringBuilder builder = new StringBuilder();
        for (String str : numStrings) {
            builder.append(str);
        }
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '0' && builder.length() != 1) {
                builder.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {10,2};
        int[] nums2 = {3,30,34,5,9};
        int[] nums3 = {0,0,0};

        System.out.println(s.largestNumber(nums1)); // "210"
        System.out.println(s.largestNumber(nums2)); // "9534330"
        System.out.println(s.largestNumber(nums3)); // "0"
    }
}
