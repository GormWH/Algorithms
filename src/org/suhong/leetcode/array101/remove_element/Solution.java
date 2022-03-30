package org.suhong.leetcode.array101.remove_element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int originalSize = nums.length;
        int size = originalSize;

        int writingPointer = 0;
        for (int i = 0; i < originalSize; i++) {
            if (nums[i] == val) {
                size--;
            } else {
                nums[writingPointer++] = nums[i];
            }
        }

        return size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
