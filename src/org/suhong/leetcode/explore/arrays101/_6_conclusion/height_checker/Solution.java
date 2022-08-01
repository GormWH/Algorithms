package org.suhong.leetcode.explore.arrays101._6_conclusion.height_checker;

import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int[] heightCount = new int[101];
        for (int height: heights) {
            heightCount[height]++;
        }

        int result = 0;
        int currentHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heightCount[currentHeight] == 0) {
                currentHeight++;
            }
            if (currentHeight != heights[i]) result++;
            heightCount[currentHeight]--;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,4,2,1,3};
        System.out.println(solution.heightChecker(nums));
    }
}
