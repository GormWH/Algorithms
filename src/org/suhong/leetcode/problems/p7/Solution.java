package org.suhong.leetcode.problems.p7;

// https://leetcode.com/problems/reverse-integer/
class Solution {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        // how can I know if an integer goes out of range when reversed?
        // Hmm...
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(isNegative ? -x : x));
        String original = stringBuilder.toString();
        StringBuilder reversedBuilder = stringBuilder.reverse();
        while(reversedBuilder.length() > 0 && reversedBuilder.charAt(0) == '0' ) {
            reversedBuilder.delete(0, 1);
        }
        String reversed = reversedBuilder.toString();
        int reversedInt = reverseInt(isNegative ? -x : x);
        String reversedWithInt = String.valueOf(reversedInt);
        if (reversedWithInt.equals(reversed)) {
            return isNegative ? -reversedInt : reversedInt;
        } else {
            return 0;
        }
    }

    private int reverseInt(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int int1 = 123;
        int int2 = -123;
        int int3 = 120;

        System.out.println(s.reverse(int1)); // 321
        System.out.println(s.reverse(int2)); // -321
        System.out.println(s.reverse(int3)); // 21
    }
}
