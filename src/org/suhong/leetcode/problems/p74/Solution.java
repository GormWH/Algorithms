package org.suhong.leetcode.problems.p74;

// https://leetcode.com/problems/search-a-2d-matrix/
class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int cols = matrix[0].length;
    /*
    1차원 배열의 인덱스 = 2차원 배열의 (    한행의 길이    * 행) + 열
                                matrix[i].length * i  +  j
     */

    int start = 0;
    int end = matrix.length * matrix[0].length;
    int mid = (start + end) / 2;
    while (start < end) {
      int current = matrix[mid/cols][mid%cols];
      if (current < target) {
        start = mid + 1;
      } else if (current > target) {
        end = mid;
      } else {
        return true;
      }
      mid = (start + end) / 2;
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
    };
    Solution s = new Solution();
    s.searchMatrix(matrix, 5);

  }

}
