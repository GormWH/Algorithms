package org.suhong.programmers.sort.biggestnum;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        int length = numbers.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strings, new CustomComparator());
        if ("0".equals(strings[length - 1])) return "0";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]);
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers1 = {6, 10, 2};
        System.out.println(solution.solution(numbers1));
        int[] numbers2 = {3, 30, 34, 5, 9};
        System.out.println(solution.solution(numbers2));
    }
}

class CustomComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int min = Math.min(length1, length2);
        for (int i = 0; i < min; i++) {
            if (chars1[i] > chars2[i]) return 1;
            if (chars1[i] < chars2[i]) return -1;
        }
        if (length1 < length2) {
            return compare(s1, s2.substring(length1));
        } else if (length1 > length2) {
            return compare(s1.substring(length2), s2);
        }
        return 0;
    }
}