package org.suhong.leetcode.problems.p724;

// https://leetcode.com/problems/find-pivot-index/
class Solution {
    public int pivotIndex(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        int total = sums[sums.length-1];
        for (int i = 0; i < sums.length; i++) {
            int left = sums[i] - nums[i];
            int right = total - sums[i];
            if (left == right) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1,7,3,6,5,6};
        int[] nums2 = {1,2,3};
        int[] nums3 = {2,1,-1};

        System.out.println(s.pivotIndex(nums1)); // 3
        System.out.println(s.pivotIndex(nums2)); // -1
        System.out.println(s.pivotIndex(nums3)); // 0
    }
}
