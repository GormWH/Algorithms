package org.suhong.leetcode.explore.arrays101._4_search.valid_mountain_array;

public class Solution1 {
    public boolean validMountainArray(int[] nums) {
        int length = nums.length;
        if (length < 3) return false;

        // at least one step of uphill
        if (nums[0] >= nums[1]) return false;

        int prev = nums[1];
        int summit = -1;
        // uphill
        for (int i = 2; i < length; i++) {
            if (nums[i] < prev) {
                summit = i - 1;
                break;
            } else if (nums[i] == prev) {
                return false;
            }
            prev = nums[i];
        }

        // downhill
        for (int i = summit + 1; i < length; i++) {
            if (nums[i] >= prev) {
                return false;
            }
            prev = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] nums1 = {2,1};
        int[] nums2 = {3,5,5};
        int[] nums3 = {0,3,2,1};
        System.out.println(solution1.validMountainArray(nums1));
        System.out.println(solution1.validMountainArray(nums2));
        System.out.println(solution1.validMountainArray(nums3));
    }
}
