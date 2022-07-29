package org.suhong.leetcode.explore.arrays101._3_deletion.remove_element;

import java.util.Arrays;

class Solution {

    // one-pointer
    public int removeElement1(int[] nums, int val) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[size++] = nums[i];
            }
        }
        return size;
    }

    // two-pointer
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                if (nums[right] != val) {
                    nums[left++] = nums[right--];
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {3,2,2,3}; int target1 = 3;
        int[] nums2 = {0,1,2,2,3,0,4,2}; int target2 = 2;
        int[] nums3 = {1}; int target3 = 1;

        System.out.println(s.removeElement(nums1, target1)); // 2
        System.out.println(Arrays.toString(nums1)); // [2,2,_,_]

        System.out.println(s.removeElement(nums2, target2)); // 5
        System.out.println(Arrays.toString(nums2)); // [0,1,4,0,3,_,_,_]

        System.out.println(s.removeElement(nums3, target3)); // 0
        System.out.println(Arrays.toString(nums3)); // [_]


    }
}
