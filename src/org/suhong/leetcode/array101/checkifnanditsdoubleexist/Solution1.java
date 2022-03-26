package org.suhong.leetcode.array101.checkifnanditsdoubleexist;

// 2022.03.26
// Brute force
class Solution1 {
    /*
     * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
     * More formally check if there exists two indices i and j such that :
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     */
    public boolean checkIfExist(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int current = arr[i];
            for (int j = i + 1; j < length; j++) {
                int target = arr[j];
                if (current * 2 == target || target * 2 == current) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

    }
}
