package org.suhong.leetcode.problems.p1480;

import java.util.Arrays;

// https://leetcode.com/problems/running-sum-of-1d-array/
class Solution {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.runningSum(new int[]{1,2,3,4}))); // [1,3,6,10]
        System.out.println(Arrays.toString(s.runningSum(new int[]{1,1,1,1,1}))); // [1,2,3,4,5]
        System.out.println(Arrays.toString(s.runningSum(new int[]{3,1,2,10,1}))); // [3,4,6,16,17]
    }
}
