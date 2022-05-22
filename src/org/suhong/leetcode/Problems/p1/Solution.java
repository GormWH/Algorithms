package org.suhong.leetcode.Problems.p1;

import java.util.Arrays;

class Solution {
  // brute force
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    // x + y = target -> y = target - x
    //
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      int first = nums[i];
      for (int j = i + 1; j < length; j++) {
        if (first + nums[j] == target) {
          result[0] = i;
          result[1] = j;
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums1 = {2,7,11,15};
    int target1 = 9;
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.twoSum(nums1, target1)));
  }
}