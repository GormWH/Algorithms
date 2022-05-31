package org.suhong.nadong.c3;

public class Solution {

    public int biggestNum(int row, int col, int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] currentRow : matrix) {
            int minOfRow = smallestElement(currentRow);
            if (minOfRow > max) max = minOfRow;
        }
        return max;
    }

    private int smallestElement(int[] rowArr) {
        int min = Integer.MAX_VALUE;
        for (int element : rowArr) {
            if (element < min) min = element;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int row1 = 3;
        int col1 = 3;
        int[][] matrix1 = {
                {3, 1, 2},
                {4, 1, 4},
                {3, 2, 5}
        };

        int row2 = 4;
        int col2 = 3;
        int[][] matrix2 = {
                {3, 1, 2},
                {4, 1, 4},
                {3, 2, 5},
                {3, 7, 4}
        };

        System.out.println(s.biggestNum(row1, col1, matrix1)); // 2
        System.out.println(s.biggestNum(row2, col2, matrix2)); // 3

    }

}
