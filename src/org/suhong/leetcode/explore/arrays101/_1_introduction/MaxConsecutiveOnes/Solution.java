package org.suhong.leetcode.explore.arrays101._1_introduction.MaxConsecutiveOnes;

public class Solution {
    // brute force
    public int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0;
        int consecutiveCount = 0;
        for (int num : nums) {
            if (num == 0) {
                if (consecutiveCount > max) {
                    max = consecutiveCount;
                }
                consecutiveCount = 0;
                continue;
            }

            consecutiveCount++;
        }
        if (consecutiveCount > max) {
            max = consecutiveCount;
        }
        return max;
    }

    // improved using index
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        int start = -1;
        boolean isCounting = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (!isCounting) {
                    start = i;
                    isCounting = true;
                }
            } else {
                if (isCounting) {
                    if (i - start > max) {
                        max = i - start;
                    }
                    isCounting = false;
                }
            }
        }
        if (isCounting) {
            if (nums.length - start > max) {
                max = nums.length - start;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,1,0,1,1,1};
        int[] nums2 = {1,0,1,1,0,1};
        System.out.println(solution.findMaxConsecutiveOnes(nums1)); // 3
        System.out.println(solution.findMaxConsecutiveOnes(nums2)); // 2
    }
}
