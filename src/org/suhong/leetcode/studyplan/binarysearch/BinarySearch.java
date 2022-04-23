package org.suhong.leetcode.studyplan.binarysearch;

// 704.Binary Search
// https://leetcode.com/problems/binary-search/
public class BinarySearch {
  public int search(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length, target);
  }

  private int binarySearch(int[] nums, int start, int end, int target) {
//    System.out.println("start, end = " + start + " " + end);
    if (end - start < 2) {
      if (nums[start] == target) {
        return start;
      }
      return -1;
    }
    int mid = (start + end) / 2;
    if (target < nums[mid]) {
      return binarySearch(nums, start, mid, target);
    }
    if (nums[mid] < target) {
      return binarySearch(nums, mid, end, target);
    }
    return mid;
  }
  public static void main(String[] args) {
    BinarySearch s = new BinarySearch();

    int[] nums = {-1,0,3,5,9,12};
    System.out.println("target: 9 -> result: " + s.search(nums, 9));
    System.out.println("target: 2 -> result: " + s.search(nums, 2));
  }
}
