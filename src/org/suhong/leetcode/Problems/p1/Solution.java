package org.suhong.leetcode.Problems.p1;

import java.util.*;

class Solution {
  // brute force
  public int[] twoSum1(int[] nums, int target) {
    int[] result = new int[2];
    int length = nums.length;
    outer:
    for (int i = 0; i < length; i++) {
      int first = nums[i];
      for (int j = i + 1; j < length; j++) {
        if (first + nums[j] == target) {
          result[0] = i;
          result[1] = j;
          break outer;
        }
      }
    }
    return result;
  }

  // faster solution
  public int[] twoSum2(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> integerMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      integerMap.put(target - nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      Integer pairIndex = integerMap.get(nums[i]);
      if (pairIndex != null && pairIndex != i) {
        result[0] = i;
        result[1] = integerMap.get(nums[i]);
        break;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums1 = {3,2,4};
    int target1 = 6;
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.twoSum2(nums1, target1)));
  }
}