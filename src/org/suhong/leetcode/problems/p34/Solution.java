package org.suhong.leetcode.problems.p34;

import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstFoundIndex = Arrays.binarySearch(nums, target);
        if (firstFoundIndex < 0) {
            return new int[]{-1, -1};
        }

        return new int[]{firstIndex(nums, firstFoundIndex), lastIndex(nums, firstFoundIndex)};
    }

    private int firstIndex(int[] nums, int end) {
        int target = nums[end];
        int start = 0;
        int mid = start + (end - start) / 2;
        do {
            if (nums[mid] == target) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        } while (start < end);
        return start;
    }

    private int lastIndex(int[] nums, int start) {
        int target = nums[start];
        int end = nums.length;
        int mid = start + (end - start) / 2;
        do {
            if (nums[mid] != target) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        } while (start < end);
        return start - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {5,7,7,8,8,10};
        int[] nums2 = {5,7,7,8,8,10};
        int[] nums3 = {};

        System.out.println(Arrays.toString(s.searchRange(nums1, 8))); // 3, 4
        System.out.println(Arrays.toString(s.searchRange(nums2, 6))); // -1, -1
        System.out.println(Arrays.toString(s.searchRange(nums3, 0))); // -1, -1
    }
}
