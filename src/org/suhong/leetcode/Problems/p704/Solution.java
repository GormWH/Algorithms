package org.suhong.leetcode.Problems.p704;

// https://leetcode.com/problems/binary-search/
public class Solution {

  public int searchBrute(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) return i;
    }
    return -1;
  }

  public int search(int[] nums, int target) {
    // return searchRange(nums, target, 0, nums.length);
    int start = 0, end = nums.length;
    int mid = (start + end) / 2;
    while (start < end) {
      int current = nums[mid];
      if (target < current) {
        end = mid;
      } else if (current < target) {
        start = mid + 1;
      } else { // current == target
        return mid;
      }
      mid = (start + end) / 2;
    }
    return -1;
  }

  private int searchRange(int[] nums, int target, int start, int end) {
    if (start >= end) return -1;
    if (end - start == 1) {
      if (nums[start] == target) {
        return start;
      } else {
        return -1;
      }
    }

    int mid = (start + end) / 2;

    if (target < nums[mid]) {
      return searchRange(nums, target, start, mid);
    } else if (nums[mid] < target) {
      return searchRange(nums, target, mid + 1, end);
    } else { // nums[mid] == target
      return mid;
    }

  }

  public static void main(String[] args) {
//    start = 5, end = 7, mid = 6 -> start = 5, end = 6, half = 0, mid = 5
//            -> start = 6, end = 6
    Solution s = new Solution();
    int[] nums = {0, 1, 2, 3, 4, 5, 6, 7 , 8, 9, 10}; // len = 11, mid = 5 target = 6
    System.out.println(s.search(nums, 9)); // expect 9

  }
}

// 1 1
// 2 2
// 3 2
// 4 3
// 5 3
// 6 3
// 7 3
// 8 4
// 16(=2^4) 5
// 32(=2^5) 6
// 64(=2^6) 7
// N -> log_2(n) + 1
// O(logN)