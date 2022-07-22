package org.suhong.leetcode.explore.arrays101._2_insertion.duplicate_zeros;

import java.util.Arrays;

class Solution {
    public void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length - countZero; i++) {
            if (arr[i] == 0) countZero++;
        }
        System.out.printf("num of zeros: %d\n",countZero);
        int writer = arr.length - 1;
        boolean isAmbiguous = (arr.length - countZero * 2) % 2 != 0;
        for (int i = arr.length - countZero - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[writer--] = 0;
                arr[writer--] = 0;
            } else {
                arr[writer--] = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr1 = {1,0,2,3,0,4,5,0};
        int[] arr2 = {1,2,3};
        int[] arr3 = {8,4,5,0,0,0,0,7};

        s.duplicateZeros(arr1);
        System.out.println(Arrays.toString(arr1)); // 1,0,0,2,3,0,0,4

        s.duplicateZeros(arr2);
        System.out.println(Arrays.toString(arr2)); // 1,2,3

        s.duplicateZeros(arr3);
        System.out.println(Arrays.toString(arr3)); // [8,4,5,0,0,0,0,0]
    }
}
