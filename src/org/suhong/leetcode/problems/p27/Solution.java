package org.suhong.leetcode.problems.p27;

import java.util.Arrays;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current != val) {
                nums[pointer++] = current;
            }
        }
        return pointer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {3,2,2,3};
        int[] nums2 = {0,1,2,2,3,0,4,2};

        System.out.println(s.removeElement(nums1, 3)); // 2
        System.out.println(Arrays.toString(nums1)); // [2, 2, _, _]
        System.out.println(s.removeElement(nums2, 2)); // 5
        System.out.println(Arrays.toString(nums2)); // [0,1,3,0,4,_,_,_]

    }
}
