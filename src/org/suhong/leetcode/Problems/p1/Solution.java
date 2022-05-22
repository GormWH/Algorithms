package org.suhong.leetcode.Problems.p1;

import java.util.Arrays;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    int i = 0, j = nums.length - 1;
    while (i < j) {
      int sum = i + j;
      if (sum < target) {
        i++;
      } else if (sum > target) {
        j--;
      } else {
        result[0] = i;
        result[1] = j;
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