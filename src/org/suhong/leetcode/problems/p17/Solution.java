package org.suhong.leetcode.problems.p17;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) {
            StringBuilder builder = new StringBuilder(digits);
            buildStringAndAdd(result, builder, digits, 0);
        }
        return result;
    }

    private void buildStringAndAdd(List<String> result, StringBuilder builder, String digits, int current) {
        String letters = getLetters(digits.charAt(current));
        if (current == digits.length() - 1) {
            for (char letter: letters.toCharArray()) {
                builder.setCharAt(current, letter);
                result.add(builder.toString());
            }
        } else {
            for (char letter: letters.toCharArray()) {
                builder.setCharAt(current, letter);
                buildStringAndAdd(result, builder, digits, current + 1);
            }
        }
    }


    private String getLetters(char digit) {
        switch (digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            default: // case '9':
                return "wxyz";
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String digits1 = "23";
        String digits2 = "";
        String digits3 = "2";

        System.out.println(s.letterCombinations(digits1)); // "ad","ae","af","bd","be","bf","cd","ce","cf"
        System.out.println(s.letterCombinations(digits2)); //
        System.out.println(s.letterCombinations(digits3)); // "a","b","c"
    }
}