package org.suhong.baekjoon.bruteforce.p7568;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[][] person = new int[num][2];
        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            person[i][0] = Integer.parseInt(input[0]);
            person[i][1] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < num; i++) {
            int count = 0;
            for (int j = 0; j < num; j++) {
                if (i == j) continue;
                if (person[i][0] < person[j][0] && person[i][1] < person[j][1]) count++;
            }
            System.out.print((count + 1) + " ");
        }

    }


}


