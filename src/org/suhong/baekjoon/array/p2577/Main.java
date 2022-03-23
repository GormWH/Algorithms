package org.suhong.baekjoon.array.p2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int mul = a * b * c;
        int[] nums = new int[10];

        while (mul > 0) {
            int res = mul % 10;
            nums[res]++;
            mul = mul / 10;
        }

        for (int num : nums) {
            System.out.println(num);
        }

    }
}
