package org.suhong.leetcode.problems.p4;

import java.util.Arrays;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {

    // brute force
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;

        int[] merged = new int[size1 + size2];
        for (int i = 0, j = 0, k = 0; i < size1 || j < size2; k++) {
            if (i >= size1) {
                merged[k] = nums2[j++];
            } else if (j >= size2) {
                merged[k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i++];
            } else {
                merged[k] = nums2[j++];
            }
        }
        System.out.println(Arrays.toString(merged));
        if ((size1 + size2) % 2 == 0) {
            return (merged[(size1 + size2) / 2 - 1] + merged[(size1 + size2) / 2]) / 2.0;
        } else {
            return merged[(size1 + size2) / 2];
        }
    }

    // O(log{m + n}) solution
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0.0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums11 = {1,3};
        int[] nums12 = {2};
        System.out.println(s.findMedianSortedArrays2(nums11, nums12));

        int[] nums21 = {1,2};
        int[] nums22 = {3,4};
        System.out.println(s.findMedianSortedArrays2(nums21, nums22));
    }
}