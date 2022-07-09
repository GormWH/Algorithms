package org.suhong.leetcode.problems.p22;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
class Solution {

    /*
     for n parenthesis there exists 2^(n-1) combinations
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            result.add("()");
            return result;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.generateParenthesis(3)); // ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(s.generateParenthesis(1)); // ["()"]
    }
}
