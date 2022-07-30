package org.suhong.leetcode.explore.arrays101._3_deletion.remove_duplicates_from_sorted_array;

import java.util.Arrays;

class Solution {

    public int removeDuplicates(int[] nums) {

        int length = nums.length;
        int numOfInterest = nums[0];
        int writer = 1;

        for (int i = 1; i < length; i++) {
            int current = nums[i];
            if (current != numOfInterest) {
                nums[writer++] = current;
                numOfInterest = current;
            }
        }
        return writer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};

        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums1) + Arrays.toString(nums1));
        System.out.println(solution.removeDuplicates(nums2) + Arrays.toString(nums2));

    }
}
