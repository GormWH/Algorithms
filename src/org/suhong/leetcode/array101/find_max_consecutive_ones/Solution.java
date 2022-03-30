package org.suhong.leetcode.array101.find_max_consecutive_ones;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;
        for (int num : nums) {
            if (num == 0) {
                currentMax = 0;
                continue;
            }

            currentMax++;
            if (currentMax > max) {
                max = currentMax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,1,0,1,1,1};
        int[] nums2 = {1,0,1,1,0,1};
        System.out.println(solution.findMaxConsecutiveOnes(nums1));
        System.out.println(solution.findMaxConsecutiveOnes(nums2));
    }
}
