package org.suhong.leetcode.explore.arrays101.valid_mountain_array;

public class Solution1 {
    public boolean validMountainArray(int[] arr) {
        int length = arr.length;

        int summit = -1;
        int prevNum = -1;
        for (int i = 0; i < length; i++) {
            int current = arr[i];
            if (prevNum >= current) {
                summit = i - 1;
                break;
            }
            prevNum = current;
        }

        if (summit == 0) {
            return false;
        }

        for (int i = summit + 1; i < length; i++) {
            int current = arr[i];
            if (prevNum <= current) {
                return false;
            }
            prevNum = current;
        }

        return summit != -1;
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
