package org.suhong.leetcode.explore.arrays101._2_insertion.duplicate_zeros;

import java.util.Arrays;

class Solution {
    // brute force
    public void duplicateZeros1(int[] arr) {
        int[] result = new int[arr.length];

        int writer = 0;
        for (int i = 0; writer < arr.length; i++) {
            int num = arr[i];
            if (num == 0) {
                result[writer++] = 0;
                if (writer < arr.length) {
                    result[writer++] = 0;
                }
            } else {
                result[writer++] = num;
            }
        }

        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    // solution solution
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        int length = arr.length - 1;
        for (int i = 0; i <= length - zeros; i++) {
            if (arr[i] == 0) {
                if (i == length - zeros) {
                    arr[length] = 0;
                    length--;
                    break;
                }
                zeros++;
            }
        }

        for (int i = length - zeros; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + zeros--] = 0;
                arr[i + zeros] = 0;
            } else {
                arr[i + zeros] = arr[i];
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
