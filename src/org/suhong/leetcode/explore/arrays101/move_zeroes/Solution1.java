package org.suhong.leetcode.explore.arrays101.move_zeroes;

import java.util.Arrays;

// 2022.03.30
public class Solution1 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int indexOfFirstZero = -1;
        int i = 0;
        for (; i < length; i++) {
            if (nums[i] == 0) {
                indexOfFirstZero = i++;
                break;
            }
        }
        for (; i < length; i++) {

            if (nums[i] != 0) {
                nums[indexOfFirstZero++] = nums[i];
                nums[i] = 0;
            }
        }

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] nums1 = {0,1,0,3,12};
        solution1.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
