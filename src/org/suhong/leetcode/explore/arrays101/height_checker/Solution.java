package org.suhong.leetcode.explore.arrays101.height_checker;

import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int result = 0;
        int length = heights.length;
        int[] copy = Arrays.copyOf(heights, length);
        Arrays.sort(copy);
        for (int i = 0; i < length; i++) {
            if (copy[i] != heights[i]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,4,2,1,3};
        System.out.println();
    }
}
