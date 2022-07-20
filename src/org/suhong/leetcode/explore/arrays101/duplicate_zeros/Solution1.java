package org.suhong.leetcode.explore.arrays101.duplicate_zeros;

import java.util.Arrays;

// using additional memory
class Solution1 {
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int[] copy = Arrays.copyOf(arr, length);
        int writingIdx = 0;
        for (int i = 0; writingIdx < length; i++) {
            int current = copy[i];
            arr[writingIdx++] = current;
            if (current == 0 && writingIdx < length) {
                arr[writingIdx++] = current;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] arr1 = {1, 0, 0, 3, 4};
        int[] arr2 = {1, 1, 0, 3, 4, 0};

        System.out.println("before: " + Arrays.toString(arr1));
        solution1.duplicateZeros(arr1);
        System.out.println(" after: " + Arrays.toString(arr1));

        System.out.println("before: " + Arrays.toString(arr2));
        solution1.duplicateZeros(arr2);
        System.out.println(" after: " + Arrays.toString(arr2));
    }
}
