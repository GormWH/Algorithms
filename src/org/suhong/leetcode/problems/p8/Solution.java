package org.suhong.leetcode.problems.p8;

// https://leetcode.com/problems/string-to-integer-atoi/
class Solution {
    public int myAtoi(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int startIdx = -1;
        for (int i = 0; i < chars.length; i++) {
            char current = s.charAt(i);
            if (isDigit(current) || isPlusOrMinus(current)) {
                startIdx = i;
                builder.append(current);
                break;
            } else if (current != ' ') {
                return 0;
            }
        }

        for (int i = startIdx + 1; i < chars.length; i++) {
            char current = chars[i];
            if (isDigit(current)) {
                builder.append(current);
            } else {
                break;
            }
        }

        int result = 0;
        try {
            result = Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            if (builder.length() > 1) {
                if (builder.charAt(0) == '-') {
                    result = Integer.MIN_VALUE;
                } else {
                    result = Integer.MAX_VALUE;
                }
            }
        }
        return result;
    }

    private boolean isPlusOrMinus(char c) {
        return c == '+' || c == '-';
    }

    private boolean isDigit(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String str1 = "42";
        String str2 = "   -42";
        String str3 = "4193 with words";
        String str4 = "+-12";

        System.out.println(s.myAtoi(str1)); // 42
        System.out.println(s.myAtoi(str2)); // -42
        System.out.println(s.myAtoi(str3)); // 4193

    }
}
