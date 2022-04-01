package org.suhong.leetcode.array101.sort_array_by_parity;

import java.util.Arrays;

// 2022.04.01
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length-1;
        while (true) {
            for (; i < j; i++) {
                if (nums[i] % 2 != 0) {
                    break;
                }
            }
            for (; i < j; j--) {
                if (nums[j] % 2 == 0) {
                    break;
                }
            }
            if (i >= j) break;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3,1,2,4};
        System.out.println(Arrays.toString(solution.sortArrayByParity(nums1)));
    }
}
