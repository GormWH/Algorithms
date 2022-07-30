package org.suhong.leetcode.explore.arrays101._4_search.check_if_n_and_its_double_exist;

import java.util.HashSet;
import java.util.Set;

// 2022.03.26
// Brute force
class Solution {
    /*
     * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
     * More formally check if there exists two indices i and j such that :
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     */
    public boolean checkIfExist(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                if (numSet.contains(num / 2)) {
                    return true;
                }
            }
            if (numSet.contains(num * 2)) {
                return true;
            }
            numSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr1 = {10,2,5,3};
        int[] arr2 = {7,1,14,11};
        int[] arr3 = {3,1,7,11};

        System.out.println(s.checkIfExist(arr1));
        System.out.println(s.checkIfExist(arr2));
        System.out.println(s.checkIfExist(arr3));

    }
}
