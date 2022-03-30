package org.suhong.leetcode.array101.merge_sorted_array;

import java.util.Arrays;

public class Solution {

    // num1 = [1,2,3,0,0,0], num2 = [2,5,6]
    // => num1 = [1,2,2,3,5,6]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;

        for (int i = nums1.length - 1; i >= 0; i--) {
            if (pointer1 < 0) nums1[i] = nums2[pointer2--];
            else if (pointer2 < 0) nums1[i] = nums1[pointer1--];
            else if(nums2[pointer2] < nums1[pointer1]) nums1[i] = nums1[pointer1--];
            else nums1[i] = nums2[pointer2--];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
