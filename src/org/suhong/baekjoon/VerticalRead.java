package org.suhong.baekjoon;

import java.util.Scanner;

// 세로 읽기
// https://www.acmicpc.net/problem/10798
public class VerticalRead {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    char[][] inputs = new char[5][];
    for (int i = 0; i < 5; i++) {
      String[] line = scanner.nextLine().split("");
      for (int j = 0; j < line.length; j++) {
        inputs[i][j] = line[j].charAt(0);
      }
    }

    for (int j = 0; j < 15; j++) {
      for (int i = 0; i < 5; i++) {
        if (inputs[i].length > j) {
          System.out.print(inputs[i][j]);
        }
      }
    }
  }
}
