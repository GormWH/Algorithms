package org.suhong.leetcode.problems.p561;

import java.util.Arrays;

// https://leetcode.com/problems/array-partition-i/
class Solution {
    public int arrayPairSum(int[] nums) {
        int result = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1,4,3,2};
        int[] nums2 = {6,2,6,5,1,2};

        System.out.println(s.arrayPairSum(nums1)); // 4
        System.out.println(s.arrayPairSum(nums2)); // 9
    }
}