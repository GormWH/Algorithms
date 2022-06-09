package org.suhong.leetcode.problems.p26;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current != nums[i]) {
                current = nums[i];
                nums[unique++] = current;
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(s.removeDuplicates(nums1) + Arrays.toString(nums1)); // 2, [1,2,_]
        System.out.println(s.removeDuplicates(nums2) + Arrays.toString(nums2)); // 5, [0,1,2,3,4,_,_,_,_,_]
    }
}
