package org.suhong.leetcode.explore.arrays101._1_introduction.SquaresOfASortedArray;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int size = nums.length;
        if (size == 1) return new int[]{nums[0] * nums[0]};

        int[] result = new int[size];
        int current = size - 1;

        int left = 0;
        int right = size - 1;
        while (current >= 0 || left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            if (Math.abs(leftNum) < Math.abs(rightNum)) {
                result[current--] = rightNum * rightNum;
                right--;
            } else {
                result[current--] = leftNum * leftNum;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-4,-1,0,3,10}))); // 0,1,9,16,100
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7,-3,2,3,11}))); // 4,9,9,49,121
    }
}
