package org.suhong.programmers.level1;

import java.util.Arrays;

public class HallOfHonor {

    public static void main(String[] args) {
        HallOfHonor s = new HallOfHonor();
        System.out.println(Arrays.toString(s.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}))); // [10, 10, 10, 20, 20, 100, 100]
        System.out.println(Arrays.toString(s.solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}))); // [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
    }
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        HonorChart chart = new HonorChart(k);
        for (int i = 0; i < score.length; i++) {
            int current = score[i];
            chart.insert(current);
            answer[i] = chart.getMinHonorScore();
        }

        return answer;
    }
}

class HonorChart {

    private int[] array;
    private int size;
    private final int maxSize;

    public HonorChart(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public void insert(int score) {
        int start = 0;
        int end = maxSize-1;
        int mid = 0;
        while (true) {
            mid = (start + end) / 2;
            if (array[mid] < score) {
                start = mid + 1;
                if (start > end) {
                    break;
                }
            } else if (array[mid] > score) {
                end = mid - 1;
                if (start > end) {
                    mid = mid - 1;
                    break;
                }
            } else { // array[mid] == score
                break;
            }
        }

        for (int i = 0; i < mid; i++) {
            array[i] = array[i+1];
        }
        if (mid >= 0) array[mid] = score;

        size = Math.min(maxSize, size+1);
    }

    public int getMinHonorScore() {
        return size < maxSize ? array[maxSize - size] : array[0];
    }

}