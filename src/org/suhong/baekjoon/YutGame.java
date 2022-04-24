package org.suhong.baekjoon;

import java.util.Scanner;

public class YutGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char[] states = new char[3]; // 세줄
    for (int i = 0; i < 3; i++) { // 세줄을 읽는다
      String[] line = scanner.nextLine().split(" ");
      int count = 0;
      for (int j = 0; j < 4; j++) {
        if (line[j].equals("0")) {
          count++;
        }
      }
      switch (count) {
        case 0:
          states[i] = 'E';
          break;
        case 1:
          states[i] = 'A';
          break;
        case 2:
          states[i] = 'B';
          break;
        case 3:
          states[i] = 'C';
          break;
        case 4:
          states[i] = 'D';
          break;
      }
    }

    for (char state : states) {
      System.out.println(state);
    }
  }
}
