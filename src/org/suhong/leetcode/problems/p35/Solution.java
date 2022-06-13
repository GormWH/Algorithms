package org.suhong.leetcode.problems.p35;

// https://leetcode.com/problems/search-insert-position/
class Solution {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = (start + end) / 2;

        while (start < end) {
            int current = nums[mid];
            if (current < target) {
                start = mid + 1;
            } else if (target < current) {
                end = mid;
            } else {
                return mid;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,6};
        int target1 = 5;

        int[] nums2 = {1,3,5,6};
        int target2 = 2;

        int[] nums3 = {1,3,5,6};
        int target3 = 7;

        Solution s = new Solution();
        System.out.println(s.searchInsert(nums1, target1)); // 2
        System.out.println(s.searchInsert(nums2, target2)); // 1
        System.out.println(s.searchInsert(nums3, target3)); // 4
    }

}
