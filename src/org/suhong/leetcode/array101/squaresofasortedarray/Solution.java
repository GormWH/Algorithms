package org.suhong.leetcode.array101.squaresofasortedarray;

public class Solution {
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
        Solution solution = new Solution();

    }
}
