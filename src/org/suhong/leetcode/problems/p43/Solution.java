package org.suhong.leetcode.problems.p43;

// https://leetcode.com/problems/multiply-strings/
class Solution {
    public String multiply(String num1, String num2) {
        /* ex
         *   num1 = 165236
         * x num2 =    356
         *=================
         *      165236 x 6
         *    + 165236 x 50
         *    + 165236 x 300
         */
        char[] numArr1 = num1.toCharArray();
        int length1 = numArr1.length;
        char[] numArr2 = num2.toCharArray();
        int length2 = numArr2.length;


        return "";
    }
    // Required sub methods...
    /*
     * private int charToInt(char chr)
     * private String addString(String str1, String str2): or use StringBuilder instead of String
     * private String multiplyOneDigitString(String str1, int position1, String str2, int position2)
     */

    private int charToInt(char chr) {
        return chr - 48;
    }

    private void addString(StringBuilder main, StringBuilder sub) {
        for (int i = main.length() - 1; i >= 0; i--) {

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] nums1 = {"2","3"};
        String[] nums2 = {"123","456"};

        System.out.println(s.multiply(nums1[0], nums1[1])); // 6
        System.out.println(s.multiply(nums2[0], nums2[1])); // 56088
    }
}
