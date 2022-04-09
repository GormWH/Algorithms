package org.suhong.programmers.level1;

import java.util.Arrays;

class GetKthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] subarray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(subarray);
            answer[i] = subarray[commands[i][2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        GetKthNumber getKthNumber = new GetKthNumber();
        int[] array1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    }
}