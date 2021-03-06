package org.suhong.leetcode.problems.p412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> fizzBuzz1(int n) {
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            if (i % 15 == 14) {
                array[i] = "FizzBuzz";
            } else if (i % 3 == 2) {
                array[i] = "Fizz";
            } else if (i % 5 == 4) {
                array[i] = "Buzz";
            } else {
                array[i] = String.valueOf(i + 1);
            }
        }

        return Arrays.asList(array);
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.fizzBuzz(3).toString());
        System.out.println(s.fizzBuzz(5).toString());
        System.out.println(s.fizzBuzz(15).toString());
    }
}