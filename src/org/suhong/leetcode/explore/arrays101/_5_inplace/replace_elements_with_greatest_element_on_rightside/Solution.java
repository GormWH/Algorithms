package org.suhong.leetcode.explore.arrays101._5_inplace.replace_elements_with_greatest_element_on_rightside;

import java.util.Arrays;

public class Solution {

    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        int greatest = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = greatest;
            if (arr[i] > greatest) greatest = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {17,18,5,4,6,1};

        System.out.println(Arrays.toString(solution.replaceElements(nums1)));
    }
}
