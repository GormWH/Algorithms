package org.suhong.leetcode.explore.arrays101._6_conclusion.find_disppeared_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int range = nums.length;
        for (int i = 0; i < range; i++) {
            int current = nums[i];
            while (nums[current - 1] != current) {
                int temp = nums[current - 1];
                nums[current - 1] = current;
                nums[i] = temp;
                current = temp;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            if (i != nums[i] - 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {4,3,2,7,8,2,3,1};
        int[] nums2 = {1,1};

        System.out.println(s.findDisappearedNumbers(nums1));
        System.out.println(s.findDisappearedNumbers(nums2));
    }
}
