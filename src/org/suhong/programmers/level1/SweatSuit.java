package org.suhong.programmers.level1;

import java.util.Arrays;

public class SweatSuit {
    public static void main(String[] args) {
        SweatSuit s = new SweatSuit();

        // s.solution(5, new int[]{2,4}, new int[]{1,3,5});
        System.out.println(s.solution(5, new int[]{3}, new int[]{1,3,5})); // 5
        System.out.println(s.solution(5, new int[]{2,4}, new int[]{3})); // 4
        System.out.println(s.solution(3, new int[]{3}, new int[]{1})); // 2
    }

    public int solution(int n, int[] lost, int[] extra) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(extra);

        int lostPointer = 0;
        int extraPointer = 0;
        int lostSize = 0;
        int extraSize = 0;
        while (lostPointer < lost.length || extraPointer < extra.length) {
            if (extraPointer == extra.length) {
                lost[lostSize++] = lost[lostPointer++];
            } else if (lostPointer == lost.length) {
                extra[extraSize++] = extra[extraPointer++];
            } else if (lost[lostPointer] < extra[extraPointer]) {
                lost[lostSize++] = lost[lostPointer++];
            } else if (lost[lostPointer] > extra[extraPointer]) {
                extra[extraSize++] = extra[extraPointer++];
            } else { // lost[lostPointer] == extra[extraPointer]
                extraPointer++;
                lostPointer++;
                answer++;
            }
        }

        int bound = 0;
        for (int i = 0; i < extraSize; i++) {
            int small = Arrays.binarySearch(lost, bound, lostSize, extra[i]-1);
            if (small >= 0) {
                answer++;
                bound = small + 1;
                continue;
            }
            int big = Arrays.binarySearch(lost, bound, lostSize, extra[i]+1);
            if (big >= 0) {
                answer++;
                bound = big + 1;
            }
        }
        System.out.println(Arrays.toString(lost) + "size = " + lostSize);
        System.out.println(Arrays.toString(extra) + "size = " + extraSize);

        return n - (lost.length - answer);
    }
}
