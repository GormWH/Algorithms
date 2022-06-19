package org.suhong.leetcode.problems.p88;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1; // nums1 pointer
        int j = n - 1; // nums2 pointer
        while (k >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            } else if (j < 0) {
                nums1[k--] = nums1[i--];
            }
            else if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }

    // 1234
    // 5678



    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums11 = {1,2,3,0,0,0};
        int m1 = 3;
        int[] nums12 = {2,5,6};
        int n1 = 3;

        int[] nums21 = {1};
        int m2 = 1;
        int[] nums22 = {};
        int n2 = 0;

        s.merge(nums11, m1, nums12, n1);
        s.merge(nums21, m2, nums22, n2);
        System.out.println(Arrays.toString(nums11)); // 1,2,2,3,5,6
        System.out.println(Arrays.toString(nums21)); // 1

    }
}
