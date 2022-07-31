package org.suhong.leetcode.explore.arrays101._5_inplace.sort_array_by_pairity;

import java.util.Arrays;

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0) {
                left++;
            } else {
                if (nums[right] % 2 != 0) {
                    right--;
                } else {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {3,1,2,4};

        System.out.println(Arrays.toString(s.sortArrayByParity(nums1))); // {2,4,1,3}
    }
}
