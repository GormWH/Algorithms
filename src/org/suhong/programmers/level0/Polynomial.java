package org.suhong.programmers.level0;

import java.util.Arrays;

public class Polynomial {

    public static void main(String[] args) {
        Polynomial s = new Polynomial();
        System.out.println(s.solution("3x + 7 + x"));
    }

    public String solution(String polynomial) {
        String splitter = " \\+ ";
        String[] split = polynomial.split(splitter);
        System.out.println(Arrays.toString(split));
        int[] coefficient = new int[]{0, 0}; // x의 (1차항, 0차항) 의 계수

        for (int i = 0; i < split.length; i++) {

            boolean x = split[i].charAt(split[i].length() - 1) == 'x';
            if (x) {
                if (split[i].length() == 1) {
                    coefficient[0] += 1;
                } else {
                    coefficient[0] += Integer.parseInt(split[i].substring(0,split[i].length() - 1));
                }
            } else {
                coefficient[1] += Integer.parseInt(split[i]);
            }
        }

        return String.format("%dx + %d",coefficient[0], coefficient[1]);
    }
}
