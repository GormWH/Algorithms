package org.suhong.leetcode.explore.arrays101._5_inplace.replace_elements_with_greatest_element_on_rightside;

import java.util.Arrays;

public class Solution {

    public int[] replaceElements(int[] arr) {
        int greatest = arr[arr.length-1];

        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = greatest;
            if (temp > greatest) {
                greatest = temp;
            }
        }

        arr[arr.length-1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {17,18,5,4,6,1};

        System.out.println(Arrays.toString(solution.replaceElements(nums1)));
    }
}
