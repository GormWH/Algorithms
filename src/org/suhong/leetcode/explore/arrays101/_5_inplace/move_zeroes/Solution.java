package org.suhong.leetcode.explore.arrays101._5_inplace.move_zeroes;

import java.util.Arrays;

// 2022.03.30
public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int writer = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[writer++] = nums[i];
            }
        }
        for (;writer < length; writer++) {
            nums[writer] = 0;
        }

    }

    public static void main(String[] args) {
        Solution solution1 = new Solution();

        int[] nums1 = {0,1,0,3,12};
        solution1.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
