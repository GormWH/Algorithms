package org.suhong.leetcode.problems.p43;

// https://leetcode.com/problems/multiply-strings/
class Solution {
    public String multiply(String num1, String num2) {
        char[] numArr1 = num1.toCharArray();
        int length1 = numArr1.length;
        char[] numArr2 = num2.toCharArray();
        int length2 = numArr2.length;

        /* ex
         *   num1 = 165236
         * x num2 =    356
         *=================
         */
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length2; i++) {
            int digit2 = charToInt(numArr2[length2 - 1 - i]);
            for (int j = 0; j < length1; j++) {
                int digit1 = charToInt(numArr1[length1 - 1 - j]);
                int multiply = digit1 * digit2; // 1 ~ 81

            }
        }


        return "";
    }

    private int charToInt(char chr) {
        return chr - 48;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        String[] nums1 = {"2","3"};
        String[] nums2 = {"123","456"};

        System.out.println(s.multiply(nums1[0], nums1[1])); // 6
        System.out.println(s.multiply(nums2[0], nums2[1])); // 56088
    }
}
