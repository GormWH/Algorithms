package org.suhong.baekjoon.io.p10926;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String joonas = "joonas";
        String str = scanner.nextLine();

        if (joonas.equals(str)) {
            str = str + "??!";
        }

        System.out.println(str);
    }
}
